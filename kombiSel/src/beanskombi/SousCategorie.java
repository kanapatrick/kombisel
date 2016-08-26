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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "sous_categorie")
@NamedQueries({
    @NamedQuery(name = "SousCategorie.findAll", query = "SELECT s FROM SousCategorie s")})
public class SousCategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sous_categorie")
    private Integer idSousCategorie;
    @Basic(optional = false)
   
    @Column(name = "id_categorie")
    private int idCategorie;
    @Basic(optional = false)

    @Column(name = "nom_sous_categorie")
    private String nomSousCategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sousCategorie")
    private List<Article> articleList;

    public SousCategorie() {
    }

    public SousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public SousCategorie(Integer idSousCategorie, int idCategorie, String nomSousCategorie) {
        this.idSousCategorie = idSousCategorie;
        this.idCategorie = idCategorie;
        this.nomSousCategorie = nomSousCategorie;
    }

    public Integer getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(Integer idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomSousCategorie() {
        return nomSousCategorie;
    }

    public void setNomSousCategorie(String nomSousCategorie) {
        this.nomSousCategorie = nomSousCategorie;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSousCategorie != null ? idSousCategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCategorie)) {
            return false;
        }
        SousCategorie other = (SousCategorie) object;
        if ((this.idSousCategorie == null && other.idSousCategorie != null) || (this.idSousCategorie != null && !this.idSousCategorie.equals(other.idSousCategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.SousCategorie[ idSousCategorie=" + idSousCategorie + " ]";
    }
    
}
