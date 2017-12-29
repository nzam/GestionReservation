/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import facade.AbonneFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author frukundo
 */
@Stateless
public class AbonneSessionBean implements AbonneSessionBeanLocal {
    @EJB
    private AbonneFacadeLocal abonneFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public void creerAbonne(String nom, String prenom){
        System.out.println("\n\n"
                + "-----------------------------------Dans SessionBean --------------------------------\n\n");
        abonneFacade.creerAbonne(nom, prenom);
    }
}
