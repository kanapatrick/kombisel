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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "mettre_article")
@NamedQueries({
    @NamedQuery(name = "MettreArticle.findAll", query = "SELECT m FROM MettreArticle m")})
public class MettreArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MettreArticlePK mettreArticlePK;
    @Basic(optional = false)
    @Column(name = "id_mise_en_ligne")
    private int idMiseEnLigne;
    @Basic(optional = false)
 
    @Column(name = "date_mise_en_ligne")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateMiseEnLigne;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public MettreArticle() {
    }

    public MettreArticle(MettreArticlePK mettreArticlePK) {
        this.mettreArticlePK = mettreArticlePK;
    }

    public MettreArticle(MettreArticlePK mettreArticlePK, int idMiseEnLigne, Date dateMiseEnLigne) {
        this.mettreArticlePK = mettreArticlePK;
        this.idMiseEnLigne = idMiseEnLigne;
        this.dateMiseEnLigne = dateMiseEnLigne;
    }

    public MettreArticle(int idArticle, int idUser) {
        this.mettreArticlePK = new MettreArticlePK(idArticle, idUser);
    }

    public MettreArticlePK getMettreArticlePK() {
        return mettreArticlePK;
    }

    public void setMettreArticlePK(MettreArticlePK mettreArticlePK) {
        this.mettreArticlePK = mettreArticlePK;
    }

    public int getIdMiseEnLigne() {
        return idMiseEnLigne;
    }

    public void setIdMiseEnLigne(int idMiseEnLigne) {
        this.idMiseEnLigne = idMiseEnLigne;
    }

    public Date getDateMiseEnLigne() {
        return dateMiseEnLigne;
    }

    public void setDateMiseEnLigne(Date dateMiseEnLigne) {
        this.dateMiseEnLigne = dateMiseEnLigne;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
        hash += (mettreArticlePK != null ? mettreArticlePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MettreArticle)) {
            return false;
        }
        MettreArticle other = (MettreArticle) object;
        if ((this.mettreArticlePK == null && other.mettreArticlePK != null) || (this.mettreArticlePK != null && !this.mettreArticlePK.equals(other.mettreArticlePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.MettreArticle[ mettreArticlePK=" + mettreArticlePK + " ]";
    }
    
}
