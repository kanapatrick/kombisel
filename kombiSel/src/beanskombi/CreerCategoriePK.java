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
public class CreerCategoriePK implements Serializable {
    @Basic(optional = false)
   
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)

    @Column(name = "id_categorie")
    private int idCategorie;

    public CreerCategoriePK() {
    }

    public CreerCategoriePK(int idUser, int idCategorie) {
        this.idUser = idUser;
        this.idCategorie = idCategorie;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idCategorie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreerCategoriePK)) {
            return false;
        }
        CreerCategoriePK other = (CreerCategoriePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idCategorie != other.idCategorie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.CreerCategoriePK[ idUser=" + idUser + ", idCategorie=" + idCategorie + " ]";
    }
    
}
