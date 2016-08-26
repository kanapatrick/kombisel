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
@Table(name = "article_commande")
@NamedQueries({
    @NamedQuery(name = "ArticleCommande.findAll", query = "SELECT a FROM ArticleCommande a")})
public class ArticleCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleCommandePK articleCommandePK;
    @Basic(optional = false)
    @Column(name = "id_article_commande")
    private int idArticleCommande;
    @Basic(optional = false)
   
    @Column(name = "qte_commander")
    private int qteCommander;
    @Basic(optional = false)

    @Column(name = "prix_unitaire")
    private float prixUnitaire;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK, int idArticleCommande, int qteCommander, float prixUnitaire) {
        this.articleCommandePK = articleCommandePK;
        this.idArticleCommande = idArticleCommande;
        this.qteCommander = qteCommander;
        this.prixUnitaire = prixUnitaire;
    }

    public ArticleCommande(int idCommande, int idArticle) {
        this.articleCommandePK = new ArticleCommandePK(idCommande, idArticle);
    }

    public ArticleCommandePK getArticleCommandePK() {
        return articleCommandePK;
    }

    public void setArticleCommandePK(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public int getIdArticleCommande() {
        return idArticleCommande;
    }

    public void setIdArticleCommande(int idArticleCommande) {
        this.idArticleCommande = idArticleCommande;
    }

    public int getQteCommander() {
        return qteCommander;
    }

    public void setQteCommander(int qteCommander) {
        this.qteCommander = qteCommander;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleCommandePK != null ? articleCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommande)) {
            return false;
        }
        ArticleCommande other = (ArticleCommande) object;
        if ((this.articleCommandePK == null && other.articleCommandePK != null) || (this.articleCommandePK != null && !this.articleCommandePK.equals(other.articleCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ArticleCommande[ articleCommandePK=" + articleCommandePK + " ]";
    }
    
}
