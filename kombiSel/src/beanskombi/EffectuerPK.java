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
public class EffectuerPK implements Serializable {
    @Basic(optional = false)
   
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
  
    @Column(name = "id_commande_promotion")
    private int idCommandePromotion;

    public EffectuerPK() {
    }

    public EffectuerPK(int idUser, int idCommandePromotion) {
        this.idUser = idUser;
        this.idCommandePromotion = idCommandePromotion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCommandePromotion() {
        return idCommandePromotion;
    }

    public void setIdCommandePromotion(int idCommandePromotion) {
        this.idCommandePromotion = idCommandePromotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idCommandePromotion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EffectuerPK)) {
            return false;
        }
        EffectuerPK other = (EffectuerPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idCommandePromotion != other.idCommandePromotion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.EffectuerPK[ idUser=" + idUser + ", idCommandePromotion=" + idCommandePromotion + " ]";
    }
    
}
