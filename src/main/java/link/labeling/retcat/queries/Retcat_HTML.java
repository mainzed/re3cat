package link.labeling.retcat.queries;

import link.labeling.retcat.classes.SuggestionItem;
import link.labeling.retcat.exceptions.ResourceNotAvailableException;
import link.labeling.retcat.exceptions.RetcatException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import link.labeling.retcat.utils.RetcatUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Retcat_HTML {

    public static JSONArray query(String url) throws IOException, ResourceNotAvailableException, ParseException {
        JSONArray out = new JSONArray();
        Map<String, SuggestionItem> autosuggests = new HashMap<>();
        SuggestionItem tmpAutosuggest = new SuggestionItem(url);
        String urlEncoded = RetcatUtils.encodeURIUmlaut(url);
        Document doc = Jsoup.connect(urlEncoded).get();
        Elements titleTag = doc.select("title");
        String titleStr = titleTag.text();
        tmpAutosuggest.setLabel(titleStr);
        tmpAutosuggest.setGroup("wayback");
        tmpAutosuggest.setQuality("low");
        tmpAutosuggest.setType("wayback");
        autosuggests.put(url, tmpAutosuggest);
        // fillOutputJSONforQuery
        out = RetcatUtils.fillOutputJSONforQuery(autosuggests, "");
        return out;
    }

    public static JSONObject info(String url) {
        try {
            String outputUrl = url;
            url = RetcatUtils.encodeURIUmlaut(url);
            Document doc = Jsoup.connect(url).get();
            Elements titleTag = doc.select("title");
            JSONObject jsonOut = new JSONObject();
            String out = titleTag.text();
            jsonOut.put("label", out);
            jsonOut.put("lang", "");
            jsonOut.put("type", "wayback");
            jsonOut.put("quality", "low");
            jsonOut.put("group", "wayback");
            jsonOut.put("uri", outputUrl);
            JSONArray broader = new JSONArray();
            JSONArray narrower = new JSONArray();
            jsonOut.put("broaderTerms", broader);
            jsonOut.put("narrowerTerms", narrower);
            jsonOut.put("description", "");
            jsonOut.put("scheme", "");
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
