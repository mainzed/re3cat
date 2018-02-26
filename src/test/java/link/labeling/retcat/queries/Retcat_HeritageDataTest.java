package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_HeritageDataTest {

    public Retcat_HeritageDataTest() {
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
    public void testQueryHE() throws Exception {
        System.out.println("test Retcat_HeritageData.queryHE() if required elements are not empty and not null");
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
    public void testQueryRCAHMS() throws Exception {
        System.out.println("test Retcat_HeritageData.queryRCAHMS() if required elements are not empty and not null");
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
    public void testQueryRCAHMW() throws Exception {
        System.out.println("test Retcat_HeritageData.queryRCAHMW() if required elements are not empty and not null");
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
    public void testInfoHE() throws Exception {
        System.out.println("test Retcat_HeritageData.info() for Heritage England if required resource is ROMAN");
        JSONObject result = Retcat_HeritageData.info("http://purl.org/heritagedata/schemes/eh_period/concepts/RO");
        assertEquals(10, result.size());
        assertEquals("http://purl.org/heritagedata/schemes/eh_period/concepts/RO", (String) result.get("uri"));
        assertEquals("ROMAN", (String) result.get("label"));
        assertEquals("Historic England Periods", (String) result.get("scheme"));
        assertEquals("heritagedata", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

    @Test
    public void testInfoRCAHMS() throws Exception {
        System.out.println("test Retcat_HeritageData.info() for RCAHMS if required resource is BALUSTER");
        JSONObject result = Retcat_HeritageData.info("http://purl.org/heritagedata/schemes/2/concepts/501158");
        assertEquals(10, result.size());
        assertEquals("http://purl.org/heritagedata/schemes/2/concepts/501158", (String) result.get("uri"));
        assertEquals("BALUSTER", (String) result.get("label"));
        assertEquals("Archaeological Objects Thesaurus (Scotland)", (String) result.get("scheme"));
        assertEquals("heritagedata", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

    @Test
    public void testInfoRCAHMW() throws Exception {
        System.out.println("test Retcat_HeritageData.info() for RCAHMW if required resource is TOLLBOOTH");
        JSONObject result = Retcat_HeritageData.info("http://purl.org/heritagedata/schemes/10/concepts/71390");
        assertEquals(10, result.size());
        assertEquals("http://purl.org/heritagedata/schemes/10/concepts/71390", (String) result.get("uri"));
        assertEquals("TOLLBOOTH", (String) result.get("label"));
        assertEquals("MONUMENT TYPE (WALES)", (String) result.get("scheme"));
        assertEquals("heritagedata", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));
    }

}
