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
@Table(name = "creer_categorie")
@NamedQueries({
    @NamedQuery(name = "CreerCategorie.findAll", query = "SELECT c FROM CreerCategorie c")})
public class CreerCategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CreerCategoriePK creerCategoriePK;
    @Basic(optional = false)
    @Column(name = "id_creation")
    private int idCreation;
    @Basic(optional = false)

    @Column(name = "nom_categorie_creer")
    private String nomCategorieCreer;
    @Basic(optional = false)
    
    @Column(name = "date_creation_categorie")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationCategorie;
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categorie categorie;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public CreerCategorie() {
    }

    public CreerCategorie(CreerCategoriePK creerCategoriePK) {
        this.creerCategoriePK = creerCategoriePK;
    }

    public CreerCategorie(CreerCategoriePK creerCategoriePK, int idCreation, String nomCategorieCreer, Date dateCreationCategorie) {
        this.creerCategoriePK = creerCategoriePK;
        this.idCreation = idCreation;
        this.nomCategorieCreer = nomCategorieCreer;
        this.dateCreationCategorie = dateCreationCategorie;
    }

    public CreerCategorie(int idUser, int idCategorie) {
        this.creerCategoriePK = new CreerCategoriePK(idUser, idCategorie);
    }

    public CreerCategoriePK getCreerCategoriePK() {
        return creerCategoriePK;
    }

    public void setCreerCategoriePK(CreerCategoriePK creerCategoriePK) {
        this.creerCategoriePK = creerCategoriePK;
    }

    public int getIdCreation() {
        return idCreation;
    }

    public void setIdCreation(int idCreation) {
        this.idCreation = idCreation;
    }

    public String getNomCategorieCreer() {
        return nomCategorieCreer;
    }

    public void setNomCategorieCreer(String nomCategorieCreer) {
        this.nomCategorieCreer = nomCategorieCreer;
    }

    public Date getDateCreationCategorie() {
        return dateCreationCategorie;
    }

    public void setDateCreationCategorie(Date dateCreationCategorie) {
        this.dateCreationCategorie = dateCreationCategorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
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
        hash += (creerCategoriePK != null ? creerCategoriePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreerCategorie)) {
            return false;
        }
        CreerCategorie other = (CreerCategorie) object;
        if ((this.creerCategoriePK == null && other.creerCategoriePK != null) || (this.creerCategoriePK != null && !this.creerCategoriePK.equals(other.creerCategoriePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.CreerCategorie[ creerCategoriePK=" + creerCategoriePK + " ]";
    }
    
}
