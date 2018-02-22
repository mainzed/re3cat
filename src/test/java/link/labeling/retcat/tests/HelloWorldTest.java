package link.labeling.retcat.tests;

import link.labeling.retcat.tests.HelloWorld;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing Class
 * @author thiery
 */
public class HelloWorldTest {
    
    public HelloWorldTest() {
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
    public void testSayHello() {
        System.out.println("testSayHello");
        String result = HelloWorld.sayHello();
        assertNotSame("", result);
    }

    @Test
    public void testWorldIsExisting() {
        System.out.println("testWorldIsExisting");
        boolean result = HelloWorld.worldIsExisting(true);
        assertTrue(result);
    }
    
}
