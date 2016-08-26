/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "produit_promotion")
@NamedQueries({
    @NamedQuery(name = "ProduitPromotion.findAll", query = "SELECT p FROM ProduitPromotion p")})
public class ProduitPromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produit_promotion")
    private Integer idProduitPromotion;
    @Basic(optional = false)

    @Column(name = "quantite_promotion")
    private int quantitePromotion;
    @JoinColumn(name = "id_article", referencedColumnName = "id_article")
    @ManyToOne(optional = false)
    private Article article;
    @JoinColumn(name = "id_produit_promotion_correspond", referencedColumnName = "id_produit_promotion")
    @ManyToOne(optional = false)
    private Promotion promotion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitPromotion")
    private List<ConcernePromotion> concernePromotionList;

    public ProduitPromotion() {
    }

    public ProduitPromotion(Integer idProduitPromotion) {
        this.idProduitPromotion = idProduitPromotion;
    }

    public ProduitPromotion(Integer idProduitPromotion, int quantitePromotion) {
        this.idProduitPromotion = idProduitPromotion;
        this.quantitePromotion = quantitePromotion;
    }

    public Integer getIdProduitPromotion() {
        return idProduitPromotion;
    }

    public void setIdProduitPromotion(Integer idProduitPromotion) {
        this.idProduitPromotion = idProduitPromotion;
    }

    public int getQuantitePromotion() {
        return quantitePromotion;
    }

    public void setQuantitePromotion(int quantitePromotion) {
        this.quantitePromotion = quantitePromotion;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
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
        hash += (idProduitPromotion != null ? idProduitPromotion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitPromotion)) {
            return false;
        }
        ProduitPromotion other = (ProduitPromotion) object;
        if ((this.idProduitPromotion == null && other.idProduitPromotion != null) || (this.idProduitPromotion != null && !this.idProduitPromotion.equals(other.idProduitPromotion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ProduitPromotion[ idProduitPromotion=" + idProduitPromotion + " ]";
    }
    
}
