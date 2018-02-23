package link.labeling.retcat.utils;

import link.labeling.retcat.classes.SuggestionItem;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class RetcatUtils {

    private static final int LIMIT = 20;

    public static JSONArray fillOutputJSONforQuery(Map<String, SuggestionItem> autosuggests) {
        JSONArray outArray = new JSONArray();
        int i = 0;
        for (Map.Entry<String, SuggestionItem> entry : autosuggests.entrySet()) {
            if (i < LIMIT) {
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
                i++;
            }
        }
        return outArray;
    }

}
