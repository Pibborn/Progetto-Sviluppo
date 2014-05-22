/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper.model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mat
 */
public class MappaturaParzialeTest {
    
    public MappaturaParzialeTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testMappatura() {
        assertEquals(new MappaturaParziale("a > a,b>b, c     > c"), new MappaturaParziale("b>b,c>c,a>a"));
        MappaturaParziale a = new MappaturaParziale("a > z, b > w, c > y");
        MappaturaParziale b = new MappaturaParziale("d > x, e > u");
        a.merge(b);
        assertEquals(a, new MappaturaParziale("a > z, b > w, c > y,d > x, e > u") );
        a = new MappaturaParziale("a>z,b>x");
        b = new MappaturaParziale("a>x,b>z");
        assertFalse(a.equals(b));
        assertTrue(a.conflitto(b));
        a.merge(b);
        assertEquals(a,b);
        a = new MappaturaParziale("a>z,b>x,c>k");
        b = new MappaturaParziale("a>j");
        assertTrue(a.conflitto(b));
        a.merge(b);
        assertEquals(a,new MappaturaParziale("a>j,b>x,c>k"));
        a = new MappaturaParziale("a>z,b>x,c>k");
        b = new MappaturaParziale("j>x");
        assertFalse(a.giaDefinita(b));
        assertTrue(a.giaAssegnata(b));
        assertTrue(a.conflitto(b));
        a.merge(b);
        assertEquals(a,new MappaturaParziale("a>z,j>x,c>k"));
        assertTrue(a.giaDefinita(b));

    }
}
