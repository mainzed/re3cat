package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_LabelingSystemTest {

    public Retcat_LabelingSystemTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testQueryLabelingSystem() throws Exception {
        System.out.println("test Retcat_LabelingSystem.queryLabelingSystem() if required elements are not empty and not null");
        JSONArray result = Retcat_LabelingSystem.query("Spat", "143.93.114.135");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertEquals(13, tmp.size());
            assertNotSame("", (String) tmp.get("uri"));
            assertNotNull((String) tmp.get("uri"));
            assertNotSame("", (String) tmp.get("label"));
            assertNotNull((String) tmp.get("label"));
            assertNotSame("", (String) tmp.get("scheme"));
            assertNotNull((String) tmp.get("scheme"));
            assertNotSame("", (String) tmp.get("type"));
            assertNotNull((String) tmp.get("type"));
            assertNotSame("", (String) tmp.get("quality"));
            assertNotNull((String) tmp.get("quality"));
            assertNotSame("", (String) tmp.get("group"));
            assertNotNull((String) tmp.get("group"));
        }
    }

    @Test
    public void testQueryLabelingSystemVocabulary() throws Exception {
        System.out.println("test Retcat_LabelingSystem.queryLabelingSystemVocabulary() if required elements are not empty and not null");
        JSONArray result = Retcat_LabelingSystem.queryVocabulary("Spat", "143.93.114.135", "aQVlEoPZmj4b");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertEquals(13, tmp.size());
            assertNotSame("", (String) tmp.get("uri"));
            assertNotNull((String) tmp.get("uri"));
            assertNotSame("", (String) tmp.get("label"));
            assertNotNull((String) tmp.get("label"));
            assertNotSame("", (String) tmp.get("scheme"));
            assertNotNull((String) tmp.get("scheme"));
            assertNotSame("", (String) tmp.get("type"));
            assertNotNull((String) tmp.get("type"));
            assertNotSame("", (String) tmp.get("quality"));
            assertNotNull((String) tmp.get("quality"));
            assertNotSame("", (String) tmp.get("group"));
            assertNotNull((String) tmp.get("group"));
        }
    }

    @Test
    public void testInfoLabelingSystem() throws Exception {
        System.out.println("test Retcat_LabelingSystem.info() for Labeling System if required resource is Spatheion 3D");
        JSONObject result = Retcat_LabelingSystem.info("http://143.93.114.135/item/label/Ebdg8RXEOZz0", "143.93.114.135");
        assertEquals(13, result.size());
        assertEquals("http://143.93.114.135/item/label/Ebdg8RXEOZz0", (String) result.get("uri"));
        assertEquals("Spatheion 3D", (String) result.get("label"));
        assertEquals("RAT", (String) result.get("scheme"));
        assertEquals("ls", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

}
