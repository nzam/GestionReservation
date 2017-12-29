/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Abonne;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author frukundo
 */
@Stateless
public class AbonneFacade extends AbstractFacade<Abonne> implements AbonneFacadeLocal {
    @PersistenceContext(unitName = "Projet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonneFacade() {
        super(Abonne.class);
    }
 
    @Override
    public void creerAbonne(String nom, String prenom){
        Abonne abonne = new Abonne();
        abonne.setNom(nom);
        abonne.setPrenom(prenom);  
        System.out.println("\n\n"
                + "-----------------------------------Dans AbonneFacade --------------------------------\n\n");                
        em.persist(abonne);
        //flush em - save to DB
        em.flush();
    }
}
