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
public class ModifierArticlePK implements Serializable {
    @Basic(optional = false)
   
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)

    @Column(name = "id_article")
    private int idArticle;

    public ModifierArticlePK() {
    }

    public ModifierArticlePK(int idUser, int idArticle) {
        this.idUser = idUser;
        this.idArticle = idArticle;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        hash += (int) idUser;
        hash += (int) idArticle;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModifierArticlePK)) {
            return false;
        }
        ModifierArticlePK other = (ModifierArticlePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idArticle != other.idArticle) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ModifierArticlePK[ idUser=" + idUser + ", idArticle=" + idArticle + " ]";
    }
    
}
