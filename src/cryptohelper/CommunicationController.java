
package cryptohelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * CommunicationController è il Controller delle comunicazioni tra le classi che si occupano
 * di gestire i messaggi. Dedotto da: DSD_apriMessaggioRicevuto
 * Implementa Singleton.
 * @author Mattia Cerrato, mattia.cerrato[at]studenti.unito[dot]it
 */
public class CommunicationController {
    public static CommunicationController instance = null;
    
    private CommunicationController() {}
    
    public static CommunicationController getInstance() {
        if(instance == null) {
            instance = new CommunicationController();
        }
        return instance;
    }
    
    public Messaggio apriMessaggioRicevuto(int id) throws SQLException {
        Messaggio m = Messaggio.load(id); 
        m.setLetto(true);
        m.save();
        return m;
    }
    
    public ResultSet inviaDecisione(Proposta proposta, String decisione) throws SQLException{
        if(decisione.compareTo("accettata") == 0) {
            Proposta old = Proposta.caricaAttiva(proposta.getProponente().getId(), proposta.getPartner().getId());
            if (old != null) {
                old.setStato("expired");
                ResultSet rs1 = old.save(); //nei DSD non sembra essere usato altrimenti
            }
        }
        proposta.setStato(decisione);
        ResultSet rs2 = proposta.save();
        return rs2;
    }
    
}
