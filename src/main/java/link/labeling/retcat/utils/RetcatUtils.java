package link.labeling.retcat.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import link.labeling.retcat.classes.SuggestionItem;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RetcatUtils {

    public static JSONArray fillOutputJSONforQuery(Map<String, SuggestionItem> autosuggests, String q) {
        JSONArray outArray = new JSONArray();
        for (Map.Entry<String, SuggestionItem> entry : autosuggests.entrySet()) {
            SuggestionItem tmpAS = entry.getValue();
            JSONObject suggestionObject = new JSONObject();
            // url
            suggestionObject.put("uri", tmpAS.getURL());
            // labels
            suggestionObject.put("label", tmpAS.getLabels().iterator().next());
            // scheme
            suggestionObject.put("scheme", tmpAS.getSchemeTitle());
            // creator
            suggestionObject.put("orcid", tmpAS.getOrcid());
            suggestionObject.put("creator", tmpAS.getCreator());
            // descriptions
            if (tmpAS.getDescriptions().size() > 0) {
                suggestionObject.put("description", tmpAS.getDescriptions().iterator().next());
            } else {
                suggestionObject.put("description", "");
            }
            // language
            suggestionObject.put("lang", tmpAS.getLanguage());
            // type
            suggestionObject.put("type", tmpAS.getType());
            // group
            suggestionObject.put("group", tmpAS.getGroup());
            // quality
            suggestionObject.put("quality", tmpAS.getQuality());
            // broader
            Set broaderTerms = tmpAS.getBroaderTerms();
            JSONArray broaderArrayNew = new JSONArray();
            if (broaderTerms.size() > 0) {
                for (Object element : broaderTerms) {
                    Map hm = (Map) element;
                    Iterator entries = hm.entrySet().iterator();
                    while (entries.hasNext()) {
                        Map.Entry thisEntry = (Map.Entry) entries.next();
                        String key = (String) thisEntry.getKey();
                        String value = (String) thisEntry.getValue();
                        JSONObject broaderObjectTmp = new JSONObject();
                        broaderObjectTmp.put("uri", key);
                        broaderObjectTmp.put("label", value);
                        broaderArrayNew.add(broaderObjectTmp);
                    }
                }
            }
            suggestionObject.put("broaderTerms", broaderArrayNew);
            // narrower
            Set narrowerTerms = tmpAS.getNarrowerTerms();
            JSONArray narrowerArrayNew = new JSONArray();
            if (narrowerTerms.size() > 0) {
                for (Object element : narrowerTerms) {
                    Map hm = (Map) element;
                    Iterator entries = hm.entrySet().iterator();
                    while (entries.hasNext()) {
                        Map.Entry thisEntry = (Map.Entry) entries.next();
                        String key = (String) thisEntry.getKey();
                        String value = (String) thisEntry.getValue();
                        JSONObject narrowerObjectTmp = new JSONObject();
                        narrowerObjectTmp.put("uri", key);
                        narrowerObjectTmp.put("label", value);
                        narrowerArrayNew.add(narrowerObjectTmp);
                    }
                }
            }
            suggestionObject.put("narrowerTerms", narrowerArrayNew);
            // add information to output array
            outArray.add(suggestionObject);
        }
        outArray = sortSuggestionsByLevenshtein(outArray, q);
        return outArray;
    }

    public static String encodeURIComponent(String s) {
        String result;
        try {
            result = URLEncoder.encode(s, "UTF-8")
                    .replaceAll("\\+", "%20")
                    .replaceAll("\\%21", "!")
                    .replaceAll("\\%27", "'")
                    .replaceAll("\\%28", "(")
                    .replaceAll("\\%29", ")")
                    .replaceAll("\\%7E", "~");
        } catch (UnsupportedEncodingException e) {
            result = s;
        }
        return result;
    }
    
    public static String encodeURIUmlaut(String s) {
        s = s.replaceAll("Ä", "%C3%84").replaceAll("ä", "%C3%A4");
		return s;
    }

    private static JSONArray sortSuggestionsByLevenshtein(JSONArray in, String q) {
        JSONArray out = new JSONArray();
        Map<Double, JSONObject> unsortMap = new HashMap<>();
        for (Object item : in) {
            JSONObject tmp = (JSONObject) item;
            tmp.put("similarity", StringSimilarity.Levenshtein(q, (String) tmp.get("label")));
            unsortMap.put(StringSimilarity.Levenshtein(q, (String) tmp.get("label")), tmp);
        }
        Map<Double, JSONObject> sortedMap = new TreeMap<>(unsortMap);
        int i = 0;
        for (Map.Entry<Double, JSONObject> entry : sortedMap.entrySet()) {
            if (i < 25) {
                out.add(entry.getValue());
                i++;
            }
        }
        return out;
    }

    public static int resultQueryLimit() {
        return 150;
    }

}
