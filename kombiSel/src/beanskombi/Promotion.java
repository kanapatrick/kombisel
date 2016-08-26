/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "promotion")
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produit_promotion")
    private Integer idProduitPromotion;
    @Basic(optional = false)
  
    @Column(name = "date_debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Basic(optional = false)
  
    @Column(name = "date_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @Basic(optional = false)
 
    @Column(name = "reduction")
    private int reduction;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    private List<ProduitPromotion> produitPromotionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
    private List<ParticiperPromotion> participerPromotionList;

    public Promotion() {
    }

    public Promotion(Integer idProduitPromotion) {
        this.idProduitPromotion = idProduitPromotion;
    }

    public Promotion(Integer idProduitPromotion, Date dateDebut, Date dateFin, int reduction) {
        this.idProduitPromotion = idProduitPromotion;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reduction = reduction;
    }

    public Integer getIdProduitPromotion() {
        return idProduitPromotion;
    }

    public void setIdProduitPromotion(Integer idProduitPromotion) {
        this.idProduitPromotion = idProduitPromotion;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public List<ProduitPromotion> getProduitPromotionList() {
        return produitPromotionList;
    }

    public void setProduitPromotionList(List<ProduitPromotion> produitPromotionList) {
        this.produitPromotionList = produitPromotionList;
    }

    public List<ParticiperPromotion> getParticiperPromotionList() {
        return participerPromotionList;
    }

    public void setParticiperPromotionList(List<ParticiperPromotion> participerPromotionList) {
        this.participerPromotionList = participerPromotionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduitPromotion != null ? idProduitPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idProduitPromotion == null && other.idProduitPromotion != null) || (this.idProduitPromotion != null && !this.idProduitPromotion.equals(other.idProduitPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.Promotion[ idProduitPromotion=" + idProduitPromotion + " ]";
    }
    
}
