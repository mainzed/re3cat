package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_DBpediaTest {

    public Retcat_DBpediaTest() {
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
    public void testQueryDBpedia() throws Exception {
        System.out.println("test Retcat_DBpedia.query() if required elements are not empty and not null");
        JSONArray result = Retcat_DBpedia.query("Apple");
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
    public void testInfoDBpedia() throws Exception {
        System.out.println("test Retcat_DBpedia.info() for DBpedia if required resource is Apple");
        JSONObject result = Retcat_DBpedia.info("http://dbpedia.org/resource/Apple");
        assertEquals(10, result.size());
        assertEquals("http://dbpedia.org/resource/Apple", (String) result.get("uri"));
        assertEquals("Apple", (String) result.get("label"));
        assertEquals("DBpedia", (String) result.get("scheme"));
        assertEquals("dbpedia", (String) result.get("type"));
        assertEquals("low", (String) result.get("quality"));
        assertEquals("additional information", (String) result.get("group"));
    }

}