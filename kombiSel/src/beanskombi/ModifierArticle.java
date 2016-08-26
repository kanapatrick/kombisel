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
@Table(name = "modifier_article")
@NamedQueries({
    @NamedQuery(name = "ModifierArticle.findAll", query = "SELECT m FROM ModifierArticle m")})
public class ModifierArticle implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ModifierArticlePK modifierArticlePK;
    @Basic(optional = false)
    @Column(name = "id_modification")
    private int idModification;
    @Basic(optional = false)
  
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public ModifierArticle() {
    }

    public ModifierArticle(ModifierArticlePK modifierArticlePK) {
        this.modifierArticlePK = modifierArticlePK;
    }

    public ModifierArticle(ModifierArticlePK modifierArticlePK, int idModification, Date dateModification) {
        this.modifierArticlePK = modifierArticlePK;
        this.idModification = idModification;
        this.dateModification = dateModification;
    }

    public ModifierArticle(int idUser, int idArticle) {
        this.modifierArticlePK = new ModifierArticlePK(idUser, idArticle);
    }

    public ModifierArticlePK getModifierArticlePK() {
        return modifierArticlePK;
    }

    public void setModifierArticlePK(ModifierArticlePK modifierArticlePK) {
        this.modifierArticlePK = modifierArticlePK;
    }

    public int getIdModification() {
        return idModification;
    }

    public void setIdModification(int idModification) {
        this.idModification = idModification;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
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
        hash += (modifierArticlePK != null ? modifierArticlePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierArticle)) {
            return false;
        }
        ModifierArticle other = (ModifierArticle) object;
        if ((this.modifierArticlePK == null && other.modifierArticlePK != null) || (this.modifierArticlePK != null && !this.modifierArticlePK.equals(other.modifierArticlePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ModifierArticle[ modifierArticlePK=" + modifierArticlePK + " ]";
    }
    
}
