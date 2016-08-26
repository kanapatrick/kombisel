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
public class MettreArticlePK implements Serializable {
    @Basic(optional = false)

    @Column(name = "id_article")
    private int idArticle;
    @Basic(optional = false)

    @Column(name = "id_user")
    private int idUser;

    public MettreArticlePK() {
    }

    public MettreArticlePK(int idArticle, int idUser) {
        this.idArticle = idArticle;
        this.idUser = idUser;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idArticle;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MettreArticlePK)) {
            return false;
        }
        MettreArticlePK other = (MettreArticlePK) object;
        if (this.idArticle != other.idArticle) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.MettreArticlePK[ idArticle=" + idArticle + ", idUser=" + idUser + " ]";
    }
    
}
