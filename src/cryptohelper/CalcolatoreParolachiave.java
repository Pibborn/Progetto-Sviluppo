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

/**
 *
 * @author glaxy
 */
public class CalcolatoreParolachiave extends CalcolatoreMappatura {

    @Override
    public Mappatura calcola(String chiave, char[] alfabeto) {
        char[] mappa = new char[alfabeto.length];
        int k = 0;
        for(int i = 0; i < chiave.length(); i++) {
            char c = chiave.charAt(i);
            /* se la chiave contiene caratteri doppi verrà considerato solo l'ultimo */
            if(chiave.substring(i+1).indexOf(c) == -1) {
                /* controllo se appartiene all'alfabeto */
                if(/*non è presente nell'alfabeto*/ false) {
                    System.out.println(c + " non fa parte dell'alfabeto");
                }
                mappa[k] = c;
                k++;
            }
        }
        for(int j = 0; j < alfabeto.length; j++) {
            if(chiave.indexOf(alfabeto[j]) == -1) {
                mappa[k] = alfabeto[j];
                k++;
            }
        }
        return new Mappatura(mappa, alfabeto);
    }
    
}
