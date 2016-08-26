/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "participer_promotion")
@NamedQueries({
    @NamedQuery(name = "ParticiperPromotion.findAll", query = "SELECT p FROM ParticiperPromotion p")})
public class ParticiperPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ParticiperPromotionPK participerPromotionPK;
    @Basic(optional = false)
    @Column(name = "id_participation")
    private int idParticipation;
    @Basic(optional = false)

    @Column(name = "qte_reserve")
    private int qteReserve;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;
    @JoinColumn(name = "id_produit_promotion", referencedColumnName = "id_produit_promotion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Promotion promotion;

    public ParticiperPromotion() {
    }

    public ParticiperPromotion(ParticiperPromotionPK participerPromotionPK) {
        this.participerPromotionPK = participerPromotionPK;
    }

    public ParticiperPromotion(ParticiperPromotionPK participerPromotionPK, int idParticipation, int qteReserve) {
        this.participerPromotionPK = participerPromotionPK;
        this.idParticipation = idParticipation;
        this.qteReserve = qteReserve;
    }

    public ParticiperPromotion(int idUser, int idProduitPromotion) {
        this.participerPromotionPK = new ParticiperPromotionPK(idUser, idProduitPromotion);
    }

    public ParticiperPromotionPK getParticiperPromotionPK() {
        return participerPromotionPK;
    }

    public void setParticiperPromotionPK(ParticiperPromotionPK participerPromotionPK) {
        this.participerPromotionPK = participerPromotionPK;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public int getQteReserve() {
        return qteReserve;
    }

    public void setQteReserve(int qteReserve) {
        this.qteReserve = qteReserve;
    }

    public KombiUser getKombiUser() {
        return kombiUser;
    }

    public void setKombiUser(KombiUser kombiUser) {
        this.kombiUser = kombiUser;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (participerPromotionPK != null ? participerPromotionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ParticiperPromotion)) {
            return false;
        }
        ParticiperPromotion other = (ParticiperPromotion) object;
        if ((this.participerPromotionPK == null && other.participerPromotionPK != null) || (this.participerPromotionPK != null && !this.participerPromotionPK.equals(other.participerPromotionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ParticiperPromotion[ participerPromotionPK=" + participerPromotionPK + " ]";
    }
    
}
