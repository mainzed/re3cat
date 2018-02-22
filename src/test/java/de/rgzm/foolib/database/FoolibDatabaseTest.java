package de.rgzm.foolib.database;

import de.rgzm.foorlib.database.FoolibDatabase;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testconfig.TestConfig;

/**
 * Testing Class
 * @author thiery
 */
public class FoolibDatabaseTest {

    public FoolibDatabaseTest() {
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
    public void testOpenAndCloseDatabase() throws Exception {
        org.junit.Assume.assumeTrue(TestConfig.LOCALHOST);
        System.out.println("testOpenAndCloseDatabase");
        FoolibDatabase.open();
        FoolibDatabase.close();
    }

    @Test
    public void testDatabaseNotNull() throws Exception {
        org.junit.Assume.assumeTrue(TestConfig.LOCALHOST);
        System.out.println("testDatabaseNotNull");
        JSONObject db = FoolibDatabase.getTestById(Integer.parseInt("1"));
        assertNotNull(db);
    }

}
