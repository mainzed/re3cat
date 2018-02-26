package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_ChronOntologyTest {

    public Retcat_ChronOntologyTest() {
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
    public void testQueryChronOntology() throws Exception {
        System.out.println("test Retcat_ChronOntology.query() if required elements are not empty and not null");
        JSONArray result = Retcat_ChronOntology.query("roman");
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
    public void testInfoChronOntology() throws Exception {
        System.out.println("test Retcat_ChronOntology.info() for ChronOntology if required resource is Roman");
        JSONObject result = Retcat_ChronOntology.info("http://chronontology.dainst.org/period/KTwRym1w8abB");
        assertEquals(10, result.size());
        assertEquals("http://chronontology.dainst.org/period/KTwRym1w8abB", (String) result.get("uri"));
        assertEquals("Roman", (String) result.get("label"));
        assertEquals("ChronOntology", (String) result.get("scheme"));
        assertEquals("chronontology", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

}
