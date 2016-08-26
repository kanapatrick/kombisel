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
@Table(name = "demande_article")
@NamedQueries({
    @NamedQuery(name = "DemandeArticle.findAll", query = "SELECT d FROM DemandeArticle d")})
public class DemandeArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)

    @Column(name = "desc_article")
    private String descArticle;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_demande")
    private Integer idDemande;
    @Basic(optional = false)
   
    @Column(name = "nom_article_demande")
    private String nomArticleDemande;
    @Basic(optional = false)
   
    @Column(name = "date_demande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDemande;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public DemandeArticle() {
    }

    public DemandeArticle(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public DemandeArticle(Integer idDemande, String descArticle, String nomArticleDemande, Date dateDemande) {
        this.idDemande = idDemande;
        this.descArticle = descArticle;
        this.nomArticleDemande = nomArticleDemande;
        this.dateDemande = dateDemande;
    }

    public String getDescArticle() {
        return descArticle;
    }

    public void setDescArticle(String descArticle) {
        this.descArticle = descArticle;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public String getNomArticleDemande() {
        return nomArticleDemande;
    }

    public void setNomArticleDemande(String nomArticleDemande) {
        this.nomArticleDemande = nomArticleDemande;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
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
        hash += (idDemande != null ? idDemande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DemandeArticle)) {
            return false;
        }
        DemandeArticle other = (DemandeArticle) object;
        if ((this.idDemande == null && other.idDemande != null) || (this.idDemande != null && !this.idDemande.equals(other.idDemande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.DemandeArticle[ idDemande=" + idDemande + " ]";
    }
    
}
