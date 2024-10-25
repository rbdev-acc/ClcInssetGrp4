package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.PourcentageService;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PourcentageServiceImpl extends RemoteServiceServlet implements
        PourcentageService {
    public Integer DivisionEntier(Integer Dividende, Integer Diviseur) throws IllegalArgumentException {
          if (Diviseur == null || Diviseur <=0 || Diviseur >=3000) {
        throw new IllegalArgumentException("Le diviseur ne peut pas être nul, zéro , négatif ou supérieur à 3000.");
    }else if (Dividende < 0 || Dividende >=3000)
        throw new IllegalArgumentException("Le dividende ne peut pas être négatif ou supérieur à 3000.");
    // Effectue la division entière
    int quotient = Dividende / Diviseur;

    // Retourne le résultat sous forme de chaîne
    return quotient;
    }
    
public String Pourcentage(Integer MontantDepart, Integer Pourcentage) throws IllegalArgumentException{
    
    if (MontantDepart > 3000 || MontantDepart <=0 ) 
            throw new IllegalArgumentException("Le montant de départ ne doit pas dépasser 3000.");
        
        if (Pourcentage < 0 || Pourcentage > 100) 
            throw new IllegalArgumentException("Le pourcentage doit être compris entre 0 et 100.");
        
        Float Montant = MontantDepart.floatValue();
        Float pourcentage = Pourcentage.floatValue();
        
    Float Result = (Montant * (1.0f - pourcentage/100.0f));
    Float Difference = Montant - Result;
    String resultatfinal = "Le resultat de " + MontantDepart + " % " + Pourcentage +" est " + Result + ". La difference est de : "+ Difference; 
            return resultatfinal;
    
    
    
}

}
