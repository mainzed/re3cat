package link.labeling.retcat.queries;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_LabelingLinkTest {

    public Retcat_LabelingLinkTest() {
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
        System.out.println("TBD - test Retcat_LabelingLink.queryLabelingSystem() if required elements are not empty and not null");
        /*JSONArray result = Retcat_LabelingLink.queryLabelingSystem("?TBD?");
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
        }*/
    }

    @Test
    public void testQueryLabelingSystemVocabulary() throws Exception {
        System.out.println("TBD - test Retcat_LabelingLink.queryLabelingSystemVocabulary() if required elements are not empty and not null");
        /*JSONArray result = Retcat_LabelingLink.queryLabelingSystemVocabulary("?TBD?", "?TBD?");
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
        }*/
    }

    @Test
    public void testInfoLabelingSystem() throws Exception {
        System.out.println("TBD - test Retcat_LabelingLink.info() for Labeling System if required resource is ?TBD?");
        /*JSONObject result = Retcat_LabelingLink.info("http://labeling.link/item/label/?TBD?");
        assertEquals(13, result.size());
        assertEquals("http://labeling.link/item/label/?TBD?", (String) result.get("uri"));
        assertEquals("?TBD?", (String) result.get("label"));
        assertEquals("?TBD?", (String) result.get("scheme"));
        assertEquals("labelinglink", (String) result.get("type"));
        assertEquals("high", (String) result.get("quality"));
        assertEquals("common reference thesauri (CH)", (String) result.get("group"));*/
    }

}
