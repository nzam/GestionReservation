/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Local;

/**
 *
 * @author frukundo
 */
@Local
public interface AbonneSessionBeanLocal {
    public void creerAbonne(String nom, String prenom);
}
