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
@Table(name = "supprimer_article")
@NamedQueries({
    @NamedQuery(name = "SupprimerArticle.findAll", query = "SELECT s FROM SupprimerArticle s")})
public class SupprimerArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_suppression_article")
    private Integer idSuppressionArticle;
    @Basic(optional = false)

    @Column(name = "nom_article_supprimer")
    private String nomArticleSupprimer;
    @Basic(optional = false)

    @Column(name = "date_suppression_article")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppressionArticle;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public SupprimerArticle() {
    }

    public SupprimerArticle(Integer idSuppressionArticle) {
        this.idSuppressionArticle = idSuppressionArticle;
    }

    public SupprimerArticle(Integer idSuppressionArticle, String nomArticleSupprimer, Date dateSuppressionArticle) {
        this.idSuppressionArticle = idSuppressionArticle;
        this.nomArticleSupprimer = nomArticleSupprimer;
        this.dateSuppressionArticle = dateSuppressionArticle;
    }

    public Integer getIdSuppressionArticle() {
        return idSuppressionArticle;
    }

    public void setIdSuppressionArticle(Integer idSuppressionArticle) {
        this.idSuppressionArticle = idSuppressionArticle;
    }

    public String getNomArticleSupprimer() {
        return nomArticleSupprimer;
    }

    public void setNomArticleSupprimer(String nomArticleSupprimer) {
        this.nomArticleSupprimer = nomArticleSupprimer;
    }

    public Date getDateSuppressionArticle() {
        return dateSuppressionArticle;
    }

    public void setDateSuppressionArticle(Date dateSuppressionArticle) {
        this.dateSuppressionArticle = dateSuppressionArticle;
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
        hash += (idSuppressionArticle != null ? idSuppressionArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupprimerArticle)) {
            return false;
        }
        SupprimerArticle other = (SupprimerArticle) object;
        if ((this.idSuppressionArticle == null && other.idSuppressionArticle != null) || (this.idSuppressionArticle != null && !this.idSuppressionArticle.equals(other.idSuppressionArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.SupprimerArticle[ idSuppressionArticle=" + idSuppressionArticle + " ]";
    }
    
}
