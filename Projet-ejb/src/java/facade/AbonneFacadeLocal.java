/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Abonne;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author frukundo
 */
@Local
public interface AbonneFacadeLocal {

    void create(Abonne abonne);

    void edit(Abonne abonne);

    void remove(Abonne abonne);

    Abonne find(Object id);

    List<Abonne> findAll();

    List<Abonne> findRange(int[] range);

    int count();
    
    public void creerAbonne(String nom, String prenom);
}
