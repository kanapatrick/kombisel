/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "mettre_en_promotion")
@NamedQueries({
    @NamedQuery(name = "MettreEnPromotion.findAll", query = "SELECT m FROM MettreEnPromotion m")})
public class MettreEnPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mise_en_promotion")
    private Integer idMiseEnPromotion;
    @Basic(optional = false)

    @Column(name = "prix_promotionnel")
    private double prixPromotionnel;
    @Basic(optional = false)
 
    @Column(name = "date_validite")
    @Temporal(TemporalType.DATE)
    private Date dateValidite;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public MettreEnPromotion() {
    }

    public MettreEnPromotion(Integer idMiseEnPromotion) {
        this.idMiseEnPromotion = idMiseEnPromotion;
    }

    public MettreEnPromotion(Integer idMiseEnPromotion, double prixPromotionnel, Date dateValidite) {
        this.idMiseEnPromotion = idMiseEnPromotion;
        this.prixPromotionnel = prixPromotionnel;
        this.dateValidite = dateValidite;
    }

    public Integer getIdMiseEnPromotion() {
        return idMiseEnPromotion;
    }

    public void setIdMiseEnPromotion(Integer idMiseEnPromotion) {
        this.idMiseEnPromotion = idMiseEnPromotion;
    }

    public double getPrixPromotionnel() {
        return prixPromotionnel;
    }

    public void setPrixPromotionnel(double prixPromotionnel) {
        this.prixPromotionnel = prixPromotionnel;
    }

    public Date getDateValidite() {
        return dateValidite;
    }

    public void setDateValidite(Date dateValidite) {
        this.dateValidite = dateValidite;
    }

    public KombiUser getKombiUser() {
        return kombiUser;
    }

    public void setKombiUser(KombiUser kombiUser) {
        this.kombiUser = kombiUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiseEnPromotion != null ? idMiseEnPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MettreEnPromotion)) {
            return false;
        }
        MettreEnPromotion other = (MettreEnPromotion) object;
        if ((this.idMiseEnPromotion == null && other.idMiseEnPromotion != null) || (this.idMiseEnPromotion != null && !this.idMiseEnPromotion.equals(other.idMiseEnPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.MettreEnPromotion[ idMiseEnPromotion=" + idMiseEnPromotion + " ]";
    }
    
}
