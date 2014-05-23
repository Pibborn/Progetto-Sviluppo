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
package cryptohelper.controller;

import cryptohelper.model.SistemaCifratura;
import cryptohelper.model.Studente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author glaxy
 */
public class GUIController {

    private static GUIController instance = null;
    private Studente studente = null;

    private GUIController() {
    }

    public static GUIController getInstance() {
        if (instance == null) {
            instance = new GUIController();
        }
        return instance;
    }

    public boolean login(String nickname, String password) throws SQLException {
        studente = Studente.login(nickname, password);
        return studente != null;
    }

    public String[] ottieniMetodiDiCifratura() {
        return new String[]{"parolachiave", "pseudocasuale", "cesare"};
    }

    public List<SistemaCifratura> elencaSistemiCifratura() throws SQLException {
        return SistemaCifratura.caricaSistemiCifratura(studente);
    }

    /* come comportarsi se il sdc è stato proposto?
     la cosa più ragionevole e facile da implementare (già implementata) è cancellare
     tutti i messaggi che usano quel sdc e la proposta che lo ha proposto       
     */
    public boolean eliminaSistemaCifratura(SistemaCifratura sdc) throws SQLException {
        return sdc.elimina();
    }
}
