/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author kana patrick
 */
@Embeddable
public class PasserCommandePK implements Serializable {
    @Basic(optional = false)
 
    @Column(name = "id_commande")
    private int idCommande;
    @Basic(optional = false)
 
    @Column(name = "id_user")
    private int idUser;

    public PasserCommandePK() {
    }

    public PasserCommandePK(int idCommande, int idUser) {
        this.idCommande = idCommande;
        this.idUser = idUser;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCommande;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasserCommandePK)) {
            return false;
        }
        PasserCommandePK other = (PasserCommandePK) object;
        if (this.idCommande != other.idCommande) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.PasserCommandePK[ idCommande=" + idCommande + ", idUser=" + idUser + " ]";
    }
    
}
