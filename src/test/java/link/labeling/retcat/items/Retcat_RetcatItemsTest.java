package link.labeling.retcat.items;

import link.labeling.retcat.classes.RetcatItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class Retcat_RetcatItemsTest {

    public Retcat_RetcatItemsTest() {
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
    public void testGetLabelingSystemItemByName() throws Exception {
        System.out.println("test RetcatItems.getRetcatItemByName() - This Labeling System");
        RetcatItem item = RetcatItems.getRetcatItemByName("This Labeling System");
        assertEquals("This Labeling System", item.getName());
    }
    
    @Test
    public void testGetGettyAATItemByName() throws Exception {
        System.out.println("test RetcatItems.getRetcatItemByName() - Getty AAT");
        RetcatItem item = RetcatItems.getRetcatItemByName("Getty AAT");
        assertEquals("Getty AAT", item.getName());
    }
    
    @Test
    public void testGetHistoricEnglandItemByName() throws Exception {
        System.out.println("test RetcatItems.getRetcatItemByName() - Heritage Data Historic England");
        RetcatItem item = RetcatItems.getRetcatItemByName("Heritage Data Historic England");
        assertEquals("Heritage Data Historic England", item.getName());
    }
    
    @Test
    public void testGetDBpediaItemByName() throws Exception {
        System.out.println("test RetcatItems.getRetcatItemByName() - DBpedia");
        RetcatItem item = RetcatItems.getRetcatItemByName("DBpedia");
        assertEquals("DBpedia", item.getName());
    }

}
