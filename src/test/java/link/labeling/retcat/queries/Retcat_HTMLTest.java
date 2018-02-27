package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_HTMLTest {

    public Retcat_HTMLTest() {
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
    public void testQueryHTML() throws Exception {
        System.out.println("test Retcat_HTML.query() if required elements are not empty and not null");
        JSONArray result = Retcat_HTML.query("https://de.wikipedia.org/wiki/Deutschland");
        for (Object item : result) {
            JSONObject tmp = (JSONObject) item;
            assertEquals(13, tmp.size());
            assertNotSame("", (String) tmp.get("uri"));
            assertNotNull((String) tmp.get("uri"));
            assertNotSame("", (String) tmp.get("label"));
            assertNotNull((String) tmp.get("label"));
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
    public void testInfoHTML() throws Exception {
        System.out.println("test Retcat_HTML.info() for DBpedia if required resource is Deutschland from Wikipedia");
        JSONObject result = Retcat_HTML.info("https://de.wikipedia.org/wiki/Deutschland");
        assertEquals(10, result.size());
        assertEquals("https://de.wikipedia.org/wiki/Deutschland", (String) result.get("uri"));
        assertEquals("Deutschland – Wikipedia", (String) result.get("label"));
        assertEquals("", (String) result.get("scheme"));
        assertEquals("wayback", (String) result.get("type"));
        assertEquals("low", (String) result.get("quality"));
        assertEquals("wayback", (String) result.get("group"));
    }

}
