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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "article")
@NamedQueries({
    @NamedQuery(name = "Article.findAll", query = "SELECT a FROM Article a")})
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_article")
    private Integer idArticle;
    @Basic(optional = false)

    @Column(name = "nom_article")
    private String nomArticle;
    @Basic(optional = false)
    @Column(name = "quantite")
    private int quantite;
    @Basic(optional = false)
  
    @Column(name = "prix")
    private float prix;
    @Basic(optional = false)

    @Column(name = "description")
    private String description;
    @Basic(optional = false)
 
    @Column(name = "image_article")
    private String imageArticle;
    @Basic(optional = false)
  
    @Column(name = "status_article")
    private int statusArticle;
    @JoinTable(name = "consulter_article", joinColumns = {
        @JoinColumn(name = "id_article", referencedColumnName = "id_article")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @ManyToMany
    private List<KombiUser> kombiUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<ModifierArticle> modifierArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<ProduitPromotion> produitPromotionList;
    @JoinColumn(name = "id_sous_categorie", referencedColumnName = "id_sous_categorie")
    @ManyToOne(optional = false)
    private SousCategorie sousCategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<ArticleCommande> articleCommandeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<MettreArticle> mettreArticleList;

    public Article() {
    }

    public Article(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public Article(Integer idArticle, String nomArticle, int quantite, float prix, String description, String imageArticle, int statusArticle) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.quantite = quantite;
        this.prix = prix;
        this.description = description;
        this.imageArticle = imageArticle;
        this.statusArticle = statusArticle;
    }

    public Integer getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Integer idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticle) {
        this.imageArticle = imageArticle;
    }

    public int getStatusArticle() {
        return statusArticle;
    }

    public void setStatusArticle(int statusArticle) {
        this.statusArticle = statusArticle;
    }

    public List<KombiUser> getKombiUserList() {
        return kombiUserList;
    }

    public void setKombiUserList(List<KombiUser> kombiUserList) {
        this.kombiUserList = kombiUserList;
    }

    public List<ModifierArticle> getModifierArticleList() {
        return modifierArticleList;
    }

    public void setModifierArticleList(List<ModifierArticle> modifierArticleList) {
        this.modifierArticleList = modifierArticleList;
    }

    public List<ProduitPromotion> getProduitPromotionList() {
        return produitPromotionList;
    }

    public void setProduitPromotionList(List<ProduitPromotion> produitPromotionList) {
        this.produitPromotionList = produitPromotionList;
    }

    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorie sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public List<ArticleCommande> getArticleCommandeList() {
        return articleCommandeList;
    }

    public void setArticleCommandeList(List<ArticleCommande> articleCommandeList) {
        this.articleCommandeList = articleCommandeList;
    }

    public List<MettreArticle> getMettreArticleList() {
        return mettreArticleList;
    }

    public void setMettreArticleList(List<MettreArticle> mettreArticleList) {
        this.mettreArticleList = mettreArticleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArticle != null ? idArticle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.idArticle == null && other.idArticle != null) || (this.idArticle != null && !this.idArticle.equals(other.idArticle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.Article[ idArticle=" + idArticle + " ]";
    }
    
}
