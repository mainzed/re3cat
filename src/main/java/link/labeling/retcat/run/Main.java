package link.labeling.retcat.run;

import link.labeling.retcat.config.POM_retcat;
import link.labeling.retcat.log.Logging;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.Map;
import link.labeling.retcat.exceptions.ResourceNotAvailableException;
import link.labeling.retcat.utils.RetcatUtils;
import link.labeling.retcat.utils.Retcat_Getty;
import link.labeling.retcat.utils.SuggestionItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 * main class
 *
 * @author thiery
 */
public class Main {

    /**
     * main method
     *
     * @param args
     * @throws IOException
     * @throws SQLException
     */
    public static void main(String[] args) throws IOException, SQLException, ResourceNotAvailableException, ParseException {
        String output = "";
        try {
            output = POM_retcat.getInfo().toJSONString() + "\r\n";
        } catch (Exception e) {
            output = Logging.getMessageJSON(e, "link.labeling.retcat.run.Main") + "\r\n";
            System.out.println(Logging.getMessageJSON(e, "link.labeling.retcat.run.Main"));
        }
        try {
            //output = Retcat_Getty.queryAAT("gold").toJSONString()  + "\r\n";
            //output = Retcat_Getty.queryTGN("Mainz").toJSONString()  + "\r\n";
            //output = Retcat_Getty.queryULAN("Dal").toJSONString()  + "\r\n";
            output = Retcat_Getty.info("http://vocab.getty.edu/aat/300266417").toJSONString() + "\r\n";
        } catch (Exception e) {
            output = Logging.getMessageJSON(e, "link.labeling.retcat.run.Main") + "\r\n";
            System.out.println(Logging.getMessageJSON(e, "link.labeling.retcat.run.Main"));
        }
        try {
            File file = new File("main.txt");
            String path = file.getCanonicalPath();
            File filePath = new File(path);
            filePath.delete();
            try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"))) {
                out.append(output).append("\r\n");
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(Logging.getMessageJSON(e, "link.labeling.retcat.run.Main"));
        }
    }

}
