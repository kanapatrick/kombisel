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
public class RepondrePK implements Serializable {
    @Basic(optional = false)
  
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)

    @Column(name = "id_sujet")
    private int idSujet;

    public RepondrePK() {
    }

    public RepondrePK(int idUser, int idSujet) {
        this.idUser = idUser;
        this.idSujet = idSujet;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdSujet() {
        return idSujet;
    }

    public void setIdSujet(int idSujet) {
        this.idSujet = idSujet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUser;
        hash += (int) idSujet;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepondrePK)) {
            return false;
        }
        RepondrePK other = (RepondrePK) object;
        if (this.idUser != other.idUser) {
            return false;
        }
        if (this.idSujet != other.idSujet) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.RepondrePK[ idUser=" + idUser + ", idSujet=" + idSujet + " ]";
    }
    
}
