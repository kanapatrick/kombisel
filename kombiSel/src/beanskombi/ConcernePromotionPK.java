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
public class ConcernePromotionPK implements Serializable {
    @Basic(optional = false)
 
    @Column(name = "id_commande_promotion")
    private int idCommandePromotion;
    @Basic(optional = false)
  
    @Column(name = "id_produit_promotion")
    private int idProduitPromotion;

    public ConcernePromotionPK() {
    }

    public ConcernePromotionPK(int idCommandePromotion, int idProduitPromotion) {
        this.idCommandePromotion = idCommandePromotion;
        this.idProduitPromotion = idProduitPromotion;
    }

    public int getIdCommandePromotion() {
        return idCommandePromotion;
    }

    public void setIdCommandePromotion(int idCommandePromotion) {
        this.idCommandePromotion = idCommandePromotion;
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
        hash += (int) idCommandePromotion;
        hash += (int) idProduitPromotion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcernePromotionPK)) {
            return false;
        }
        ConcernePromotionPK other = (ConcernePromotionPK) object;
        if (this.idCommandePromotion != other.idCommandePromotion) {
            return false;
        }
        if (this.idProduitPromotion != other.idProduitPromotion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ConcernePromotionPK[ idCommandePromotion=" + idCommandePromotion + ", idProduitPromotion=" + idProduitPromotion + " ]";
    }
    
}
