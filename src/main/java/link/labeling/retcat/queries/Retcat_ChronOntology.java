package link.labeling.retcat.queries;

import link.labeling.retcat.items.RetcatItems;
import link.labeling.retcat.classes.SuggestionItem;
import link.labeling.retcat.classes.RetcatItem;
import link.labeling.retcat.exceptions.ResourceNotAvailableException;
import link.labeling.retcat.exceptions.RetcatException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import link.labeling.retcat.utils.RetcatUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Retcat_ChronOntology {

    public static JSONArray query(String searchword) throws IOException, ResourceNotAvailableException, ParseException {
        JSONArray out = new JSONArray();
        searchword = RetcatUtils.encodeURIComponent(searchword);
        String url_string = "http://chronontology.dainst.org/data/period?q=" + searchword + "&limit=" + RetcatUtils.resultQueryLimit();
        URL url = new URL(url_string);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();
        // fill objects
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.toString());
        JSONArray resultsArray = (JSONArray) jsonObject.get("results");
        Map<String, SuggestionItem> autosuggests = new HashMap<String, SuggestionItem>();
        for (Object element : resultsArray) {
            JSONObject tmpElement = (JSONObject) element;
            JSONObject resourceObject = (JSONObject) tmpElement.get("resource");
            String uriValue = (String) resourceObject.get("id");
            uriValue = "http://chronontology.dainst.org" + uriValue;
            autosuggests.put(uriValue, new SuggestionItem(uriValue));
            SuggestionItem tmpAutosuggest = autosuggests.get(uriValue);
            JSONObject names = (JSONObject) resourceObject.get("names");
            String labelLang = "en";
            JSONArray namesEN = (JSONArray) names.get(labelLang);
            String labelValue = (String) namesEN.get(0);
            String descValue = "";
            tmpAutosuggest.setLabel(labelValue);
            tmpAutosuggest.setLanguage(labelLang);
            tmpAutosuggest.setDescription(descValue);
            tmpAutosuggest.setSchemeTitle("ChronOntology");
            // get retcat info
            String type = "chronontology";
            String quality = "";
            String group = "";
            for (RetcatItem item : RetcatItems.getReferenceThesaurusCatalogue()) {
                if (item.getType().equals(type)) {
                    quality = item.getQuality();
                    group = item.getGroup();
                }
            }
            tmpAutosuggest.setType(type);
            tmpAutosuggest.setQuality(quality);
            tmpAutosuggest.setGroup(group);
        }
        // fillOutputJSONforQuery
        out = RetcatUtils.fillOutputJSONforQuery(autosuggests, searchword);
        return out;
    }

    public static JSONObject info(String url) throws IOException, ResourceNotAvailableException, ParseException, RetcatException {
        try {
            String outputUrl = url;
            url = url.replace("/period", "/data/period");
            // query for json
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            // parse json
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.toString());
            JSONObject resourceObject = (JSONObject) jsonObject.get("resource");
            JSONObject names = (JSONObject) resourceObject.get("names");
            String labelLang = "en";
            JSONArray namesEN = (JSONArray) names.get(labelLang);
            String labelValue = (String) namesEN.get(0);
            String descValue = "";
            // output
            JSONObject jsonOut = new JSONObject();
            jsonOut.put("label", labelValue);
            jsonOut.put("lang", labelLang);
            // get retcat info
            String type = "chronontology";
            String quality = "";
            String group = "";
            for (RetcatItem item : RetcatItems.getReferenceThesaurusCatalogue()) {
                if (item.getType().equals(type)) {
                    quality = item.getQuality();
                    group = item.getGroup();
                }
            }
            jsonOut.put("type", type);
            jsonOut.put("quality", quality);
            jsonOut.put("group", group);
            jsonOut.put("description", descValue);
            jsonOut.put("uri", outputUrl);
            jsonOut.put("scheme", "ChronOntology");
            jsonOut.put("broaderTerms", new JSONArray());
            jsonOut.put("narrowerTerms", new JSONArray());
            if (jsonOut.get("label") != null && !jsonOut.get("label").equals("")) {
                return jsonOut;
            } else {
                throw new RetcatException("no label for this uri available");
            }
        } catch (Exception e) {
            return new JSONObject();
        }
    }

}
