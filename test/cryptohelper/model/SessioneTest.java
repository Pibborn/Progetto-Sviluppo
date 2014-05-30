/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptohelper.model;

import java.io.IOException;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mat
 */
public class SessioneTest {

    public SessioneTest() {
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
    public void test() throws SQLException, IOException, ClassNotFoundException {
        AlberoIpotesi albero = new AlberoIpotesi();
        MappaturaImpl a = new MappaturaImpl("a > z, b > w, c > y");

        //  PRIMA ASSUNZIONE
        //  a > z, b > w, c > y
        albero.faiAssunzione(new MappaturaImpl(a));
        MappaturaImpl b = new MappaturaImpl("d > x, e > u");
        albero.faiAssunzione(b);

        MappaturaImpl c = new MappaturaImpl("f > v");
        albero.faiAssunzione(c);

        Sessione sess = new Sessione(Studente.load(1).getUserInfo(), Messaggio.load(1));
        sess.save();
        System.out.println(sess.getId());

        Sessione due = Sessione.load(1);
        System.out.println("test: ");
        due.albero.stampaAlbero();
        System.out.println("Prima mossa: " + due.albero.mosse.get(3).getMappatura());
    }

}
