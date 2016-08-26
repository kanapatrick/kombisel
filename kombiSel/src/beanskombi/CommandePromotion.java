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
@Table(name = "commande_promotion")
@NamedQueries({
    @NamedQuery(name = "CommandePromotion.findAll", query = "SELECT c FROM CommandePromotion c")})
public class CommandePromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_commande_promotion")
    private Integer idCommandePromotion;
    @Basic(optional = false)
  
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
  
    @Column(name = "date_commande_promotion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommandePromotion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandePromotion")
    private List<Effectuer> effectuerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandePromotion")
    private List<ConcernePromotion> concernePromotionList;

    public CommandePromotion() {
    }

    public CommandePromotion(Integer idCommandePromotion) {
        this.idCommandePromotion = idCommandePromotion;
    }

    public CommandePromotion(Integer idCommandePromotion, int idUser, Date dateCommandePromotion) {
        this.idCommandePromotion = idCommandePromotion;
        this.idUser = idUser;
        this.dateCommandePromotion = dateCommandePromotion;
    }

    public Integer getIdCommandePromotion() {
        return idCommandePromotion;
    }

    public void setIdCommandePromotion(Integer idCommandePromotion) {
        this.idCommandePromotion = idCommandePromotion;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getDateCommandePromotion() {
        return dateCommandePromotion;
    }

    public void setDateCommandePromotion(Date dateCommandePromotion) {
        this.dateCommandePromotion = dateCommandePromotion;
    }

    public List<Effectuer> getEffectuerList() {
        return effectuerList;
    }

    public void setEffectuerList(List<Effectuer> effectuerList) {
        this.effectuerList = effectuerList;
    }

    public List<ConcernePromotion> getConcernePromotionList() {
        return concernePromotionList;
    }

    public void setConcernePromotionList(List<ConcernePromotion> concernePromotionList) {
        this.concernePromotionList = concernePromotionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCommandePromotion != null ? idCommandePromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandePromotion)) {
            return false;
        }
        CommandePromotion other = (CommandePromotion) object;
        if ((this.idCommandePromotion == null && other.idCommandePromotion != null) || (this.idCommandePromotion != null && !this.idCommandePromotion.equals(other.idCommandePromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.CommandePromotion[ idCommandePromotion=" + idCommandePromotion + " ]";
    }
    
}
