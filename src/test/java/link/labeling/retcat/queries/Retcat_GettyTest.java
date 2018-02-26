package link.labeling.retcat.queries;

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
    public void testQueryTGN() throws Exception {
        System.out.println("test Retcat_Getty.queryTGN() if required elements are not empty and not null");
        JSONArray result = Retcat_Getty.queryTGN("Mainz");
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
    public void testQueryULAN() throws Exception {
        System.out.println("test Retcat_Getty.queryULAN() if required elements are not empty and not null");
        JSONArray result = Retcat_Getty.queryULAN("Dal");
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
    public void testInfoAAT() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is an apple");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/aat/300266417");
        assertEquals(10, result.size());
        assertEquals("http://vocab.getty.edu/aat/300266417", (String) result.get("uri"));
        assertEquals("apple (fruit)", (String) result.get("label"));
        assertEquals("Art and Architecture Thesaurus", (String) result.get("scheme"));
        assertEquals("getty", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

    @Test
    public void testInfoTGN() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is Mainz");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/tgn/7004449");
        assertEquals(10, result.size());
        assertEquals("http://vocab.getty.edu/tgn/7004449", (String) result.get("uri"));
        assertEquals("Mainz", (String) result.get("label"));
        assertEquals("Thesaurus of Geographic Names", (String) result.get("scheme"));
        assertEquals("getty", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

    @Test
    public void testInfoULAN() throws Exception {
        System.out.println("test Retcat_Getty.info() for Getty AAT if required resource is Leonardo da Vinci");
        JSONObject result = Retcat_Getty.info("http://vocab.getty.edu/ulan/500010879");
        assertEquals(10, result.size());
        assertEquals("http://vocab.getty.edu/ulan/500010879", (String) result.get("uri"));
        assertEquals("Leonardo da Vinci", (String) result.get("label"));
        assertEquals("Union List of Artist Names", (String) result.get("scheme"));
        assertEquals("getty", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

}
