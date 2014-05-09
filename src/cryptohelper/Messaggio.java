/*
 * Copyright (C) 2014 glaxy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package cryptohelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author glaxy
 */
public class Messaggio implements MessaggioMittente, MessaggioDestinatario {

    private int id;
    private String testo;
    private String testoCifrato;
    private String lingua;
    private String titolo;
    private boolean bozza;
    private boolean letto;
    
    private Messaggio(ResultSet queryResult) throws SQLException {
        id = queryResult.getInt("Id");
        testo = queryResult.getString("Testo");
        testoCifrato = queryResult.getString("TestoCifrato");
        lingua = queryResult.getString("Lingua");
        titolo = queryResult.getString("Titolo");
        bozza = queryResult.getBoolean("Bozza");
        letto = queryResult.getBoolean("Letto");
    }
    
    public static Messaggio load(int id) throws SQLException {
        DBController dbc = DBController.getInstance();
        ResultSet rs = dbc.execute("SELECT * FROM crypto_user.Messaggi WHERE id = " + id);
        rs.next();
        return new Messaggio(rs);
    }

    public static List<MessaggioMittente> caricaInviati(Studente studente) throws SQLException {
        DBController dbc = DBController.getInstance();
        int studentId = studente.getId();
        ResultSet rs = dbc.execute("SELECT * FROM crypto_user.Messagggi WHERE mittente = " + studentId + " AND bozza = " + false);
        List<MessaggioMittente> listaInviati = new ArrayList<>();
        while(rs.next()) {
            listaInviati.add(new Messaggio(rs));
        }
        return listaInviati;
    }
    
    public static List<MessaggioMittente> caricaBozze(Studente studente) throws SQLException {
        DBController dbc = DBController.getInstance();
        int studentId = studente.getId();
        ResultSet rs = dbc.execute("SELECT * FROM crypto_user.Messaggi WHERE mittente = " + studentId + " AND bozza = " + true);
        List<MessaggioMittente> listaBozze = new ArrayList<>();
        while(rs.next()) {
            listaBozze.add(new Messaggio(rs));
        }
        return listaBozze;
    }
    
    public static List<MessaggioDestinatario> caricaRicevuti(Studente studente) throws SQLException {
        DBController dbc = DBController.getInstance();
        int studentId = studente.getId();
        ResultSet rs = dbc.execute("SELECT * FROM crypto_user.Messaggi WHERE destinatario = " + studentId);
        List<MessaggioDestinatario> listaRicevuti = new ArrayList<>();
        while(rs.next()) {
            listaRicevuti.add(new Messaggio(rs));
        }
        return listaRicevuti;
    }

    @Override
    public boolean isBozza() {
        return bozza;
    }

    @Override
    public boolean save() {
        try {
            DBController dbc = DBController.getInstance();
            dbc.execute(""); //TODO
            return true;
        } catch(SQLException e) {
            return false;
        }
    }

    @Override
    public void cifra() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getTesto() {
        return testo;
    }

    @Override
    public String getTestoCifrato() {
        return testoCifrato;
    }

    @Override
    public String getLingua() {
        return lingua;
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public boolean elimina() {
        DBController dbc = DBController.getInstance();
        try {
            return dbc.executeUpdate("DELETE * FROM crypto_user.Messaggi WHERE id = " + id);
        } catch (SQLException ex) {
            Logger.getLogger(Messaggio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean isLetto() {
        return letto;
    }
    
    @Override
    public void setLetto(boolean letto) {
        this.letto = letto;
    }
    
}
