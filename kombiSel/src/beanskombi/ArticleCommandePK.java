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
public class ArticleCommandePK implements Serializable {
    @Basic(optional = false)

    @Column(name = "id_commande")
    private int idCommande;
    @Basic(optional = false)
 
    @Column(name = "id_article")
    private int idArticle;

    public ArticleCommandePK() {
    }

    public ArticleCommandePK(int idCommande, int idArticle) {
        this.idCommande = idCommande;
        this.idArticle = idArticle;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCommande;
        hash += (int) idArticle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArticleCommandePK)) {
            return false;
        }
        ArticleCommandePK other = (ArticleCommandePK) object;
        if (this.idCommande != other.idCommande) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ArticleCommandePK[ idCommande=" + idCommande + ", idArticle=" + idArticle + " ]";
    }
    
}
