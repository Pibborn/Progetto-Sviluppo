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
 * NOTE:        !! valutare se i metodi map() e inverseMap() possono essere
 *              affiancati o sostituiti da metodi che invece che lavorare con
 *              i caratteri lavorino con gli indici dei caratteri nell'array:
 *              in questo modo si migliorerebbe di molto l'efficienza evitando
 *              chiamate superflue a metodi ausiliari tipo inAlphabet()
 *              e metodi di conversioni vari
 * 
 *              da aggiungere alla documentazione il metodo inInAlfabet(char c)
 * 
 *              forse l'import di java.lang non è necessaria
 * 
 * 
 * @author mat
 */


public class Mappatura {
    
    private final char[] mappa;
    private final char[] mappaInversa;
    
    public Mappatura(char[] mappa, char[] mappaInversa) {
        if(mappa.length != mappaInversa.length) {
            throw new IllegalArgumentException("Lunghezza mappature non corrispondenti");
        }
        this.mappa = mappa;
        this.mappaInversa = mappaInversa;
    }
    
    public char map(char c) {
        int i = 0;
        for(char k : mappaInversa) {
            if(c == k) {
                return mappa[i];
            }
            ++i;
        }
        throw new IllegalArgumentException(c + " non in alfabeto");
    }
    
    public char inverseMap(char c) {
        int i = 0;
        for(char k : mappa) {
            if(c == k) {
                return mappaInversa[i];
            }
            ++i;
        }
        throw new IllegalArgumentException(c + " non in alfabeto");
    }
    
    public boolean inAlphabet(char c) {
        for(char k : mappaInversa) {
            if(k == c) {
                return true;
            }
        }
        return false;
    }   
    
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < mappa.length; ++i ) {
            s += "["+i+"] "+mappaInversa[i]+" -> "+mappa[i]+" \n";
        }
        return s;
    }
    
}
