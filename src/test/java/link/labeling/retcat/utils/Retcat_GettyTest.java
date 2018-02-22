package link.labeling.retcat.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_GettyTest {

    public Retcat_GettyTest() {
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
    public void testQueryAAT() throws Exception {
        System.out.println("test Retcat_Getty.queryAAT() if required elements are not empty and not null");
        JSONArray result = Retcat_Getty.queryAAT("gold");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertNotSame((String) tmp.get("uri"), "");
            assertNotNull((String) tmp.get("uri"));
            assertNotSame((String) tmp.get("label"), "");
            assertNotNull((String) tmp.get("label"));
            assertNotSame((String) tmp.get("scheme"), "");
            assertNotNull((String) tmp.get("scheme"));
            assertNotSame((String) tmp.get("type"), "");
            assertNotNull((String) tmp.get("type"));
            assertNotSame((String) tmp.get("quality"), "");
            assertNotNull((String) tmp.get("quality"));
            assertNotSame((String) tmp.get("group"), "");
            assertNotNull((String) tmp.get("group"));
        }
    }

    @Test
    public void testQueryTGN() throws Exception {
        System.out.println("test Retcat_Getty.queryTGN() if required elements are not empty and not null");
        JSONArray result = Retcat_Getty.queryTGN("Mainz");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertNotSame((String) tmp.get("uri"), "");
            assertNotNull((String) tmp.get("uri"));
            assertNotSame((String) tmp.get("label"), "");
            assertNotNull((String) tmp.get("label"));
            assertNotSame((String) tmp.get("scheme"), "");
            assertNotNull((String) tmp.get("scheme"));
            assertNotSame((String) tmp.get("type"), "");
            assertNotNull((String) tmp.get("type"));
            assertNotSame((String) tmp.get("quality"), "");
            assertNotNull((String) tmp.get("quality"));
            assertNotSame((String) tmp.get("group"), "");
            assertNotNull((String) tmp.get("group"));
        }
    }

    @Test
    public void testQueryULAN() throws Exception {
        System.out.println("test Retcat_Getty.queryULAN() if required elements are not empty and not null");
        JSONArray result = Retcat_Getty.queryULAN("Dal");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertNotSame((String) tmp.get("uri"), "");
            assertNotNull((String) tmp.get("uri"));
            assertNotSame((String) tmp.get("label"), "");
            assertNotNull((String) tmp.get("label"));
            assertNotSame((String) tmp.get("scheme"), "");
            assertNotNull((String) tmp.get("scheme"));
            assertNotSame((String) tmp.get("type"), "");
            assertNotNull((String) tmp.get("type"));
            assertNotSame((String) tmp.get("quality"), "");
            assertNotNull((String) tmp.get("quality"));
            assertNotSame((String) tmp.get("group"), "");
            assertNotNull((String) tmp.get("group"));
        }
    }

    @Test
    public void testInfoAAT() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is an apple");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/aat/300266417");
        assertEquals((String) result.get("uri"), "http://vocab.getty.edu/aat/300266417");
        assertEquals((String) result.get("label"), "apple (fruit)");
        assertEquals((String) result.get("scheme"), "Art and Architecture Thesaurus");
        assertEquals((String) result.get("type"), "getty");
        assertEquals((String) result.get("quality"), "high");
        assertEquals((String) result.get("group"), "common reference thesauri (CH)");
    }
    
    @Test
    public void testInfoTGN() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is Mainz");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/tgn/7004449");
        assertEquals((String) result.get("uri"), "http://vocab.getty.edu/tgn/7004449");
        assertEquals((String) result.get("label"), "Mainz");
        assertEquals((String) result.get("scheme"), "Thesaurus of Geographic Names");
        assertEquals((String) result.get("type"), "getty");
        assertEquals((String) result.get("quality"), "high");
        assertEquals((String) result.get("group"), "common reference thesauri (CH)");
    }
    
    @Test
    public void testInfoULAN() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is Leonardo da Vinci");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/ulan/500010879");
        assertEquals((String) result.get("uri"), "http://vocab.getty.edu/ulan/500010879");
        assertEquals((String) result.get("label"), "Leonardo da Vinci");
        assertEquals((String) result.get("scheme"), "Union List of Artist Names");
        assertEquals((String) result.get("type"), "getty");
        assertEquals((String) result.get("quality"), "high");
        assertEquals((String) result.get("group"), "common reference thesauri (CH)");
    }

}
