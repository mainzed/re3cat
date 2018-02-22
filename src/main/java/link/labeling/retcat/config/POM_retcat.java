package link.labeling.retcat.config;

import java.io.IOException;
import org.json.simple.JSONObject;

/**
 * Class for POM details
 * @author thiery
 */
public class POM_retcat {
    
    /**
     * get POM info as JSON
     * @return pom JSON
     * @throws IOException 
     */
    public static JSONObject getInfo() throws IOException {
        JSONObject outObj = new JSONObject();
        JSONObject maven = new JSONObject();
        maven.put("modelVersion", RetCatProperties.getPropertyParam("modelVersion"));
        maven.put("mavenCompilerSource", RetCatProperties.getPropertyParam("source"));
        maven.put("mavenCompilerTarget", RetCatProperties.getPropertyParam("target"));
        outObj.put("maven", maven);
        JSONObject project = new JSONObject();
        project.put("buildNumber", RetCatProperties.getPropertyParam("buildNumber"));
        project.put("buildNumberShort", RetCatProperties.getPropertyParam("buildNumber").substring(0, 7));
        project.put("buildRepository", RetCatProperties.getPropertyParam("url").replace(".git", "/tree/" + RetCatProperties.getPropertyParam("buildNumber")));
        project.put("artifactId", RetCatProperties.getPropertyParam("artifactId"));
        project.put("groupId", RetCatProperties.getPropertyParam("groupId"));
        project.put("version", RetCatProperties.getPropertyParam("version"));
        project.put("packaging", RetCatProperties.getPropertyParam("packaging"));
        project.put("name", RetCatProperties.getPropertyParam("name"));
        project.put("description", RetCatProperties.getPropertyParam("description"));
        project.put("url", RetCatProperties.getPropertyParam("url"));
        project.put("encoding", RetCatProperties.getPropertyParam("sourceEncoding"));
        outObj.put("project", project);
        return outObj;
    }

}
