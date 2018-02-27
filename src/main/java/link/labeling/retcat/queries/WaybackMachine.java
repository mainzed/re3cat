package link.labeling.retcat.queries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import link.labeling.retcat.classes.RetcatItem;
import link.labeling.retcat.exceptions.ResourceNotAvailableException;
import link.labeling.retcat.exceptions.WaybacklinkException;
import link.labeling.retcat.items.RetcatItems;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class WaybackMachine {

    public static JSONObject getURI(String url) throws IOException, ResourceNotAvailableException, ParseException, WaybacklinkException {
        JSONObject jsonOut = new JSONObject();
        // check if url is item in retcat
        List<RetcatItem> retcatlist = RetcatItems.getReferenceThesaurusCatalogue();
        for (RetcatItem item : retcatlist) {
            if (url.contains(item.getPrefix())) {
                throw new WaybacklinkException("item match in reference thesaurus catalog");
            }
        }
        // get waybacklink
        String waybackapi = "http://archive.org/wayback/available?url=$url";
        URL obj = new URL(waybackapi.replace("$url", url));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        // init output
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(response.toString());
        JSONObject resultsObject = (JSONObject) jsonObject.get("archived_snapshots");
        JSONObject resultsObject2 = (JSONObject) resultsObject.get("closest");
        String wburi = null;
        try {
            wburi = (String) resultsObject2.get("url");
        } catch (Exception e) {
            throw new WaybacklinkException("no wayback url available");
        }
        jsonOut.put("uri", wburi);
        return jsonOut;
    }

}
