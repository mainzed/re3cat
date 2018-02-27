package link.labeling.retcat.queries;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WaybackMachineTest {

    public WaybackMachineTest() {
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
    public void testQueryWaybackMachine() throws Exception {
        System.out.println("test WaybackMachine.getURI() for DBpedia if required resource is available");
        JSONObject result = WaybackMachine.getURI("http://rgzm.de");
        assertNotNull((String) result.get("uri"));
    }

}
