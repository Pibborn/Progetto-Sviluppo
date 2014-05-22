/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cryptohelper.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author mat
 */
public class Ipotesi {

        public MappaturaParziale map;
        public List<Ipotesi> figli;
        public Ipotesi padre;
        
        public Ipotesi(MappaturaParziale map, Ipotesi padre) {
            this.map = map;
            this.figli = new LinkedList<Ipotesi>();
        }
        
        public Ipotesi aggiungiIpotesi(MappaturaParziale map) {
            Ipotesi ip = new Ipotesi(map, this);
            figli.add(ip);
            return ip;
        }
        
        public Ipotesi raggiunto(MappaturaParziale controllo, MappaturaParziale corrente) {
            MappaturaParziale m = new MappaturaParziale();
            m.merge(corrente);
            m.merge(map);
            if(m.equals(controllo)) {
                return this;
            }
            if(figli.isEmpty()) {
                return null;
            }
            Ipotesi risultato;
            for(Ipotesi i : figli) {
                risultato = i.raggiunto(controllo, m);
                if(risultato != null) {
                    return risultato;
                }
            }
            return null;
        }
        
        public void stampa(int d) {
            for(int i = 0; i <= d; ++i) {
                System.out.print("\t");
            }
            System.out.println(map);

            for(Ipotesi i : figli) {
                if(i!= null) {
                    i.stampa(++d);
                }
            }
        }
}
