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
public class ParticiperPromotionPK implements Serializable {
    @Basic(optional = false)

    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)

    @Column(name = "id_produit_promotion")
    private int idProduitPromotion;

    public ParticiperPromotionPK() {
    }

    public ParticiperPromotionPK(int idUser, int idProduitPromotion) {
        this.idUser = idUser;
        this.idProduitPromotion = idProduitPromotion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProduitPromotion() {
        return idProduitPromotion;
    }

    public void setIdProduitPromotion(int idProduitPromotion) {
        this.idProduitPromotion = idProduitPromotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idProduitPromotion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticiperPromotionPK)) {
            return false;
        }
        ParticiperPromotionPK other = (ParticiperPromotionPK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idProduitPromotion != other.idProduitPromotion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ParticiperPromotionPK[ idUser=" + idUser + ", idProduitPromotion=" + idProduitPromotion + " ]";
    }
    
}
