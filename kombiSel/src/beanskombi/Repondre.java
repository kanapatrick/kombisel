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
@Table(name = "repondre")
@NamedQueries({
    @NamedQuery(name = "Repondre.findAll", query = "SELECT r FROM Repondre r")})
public class Repondre implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepondrePK repondrePK;
    @Basic(optional = false)
    @Column(name = "id_reponse")
    private int idReponse;
    @Basic(optional = false)
  
    @Column(name = "contenu_reponse")
    private String contenuReponse;
    @Basic(optional = false)
  
    @Column(name = "date_reponse")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReponse;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;
    @JoinColumn(name = "id_sujet", referencedColumnName = "id_sujet", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SujetForum sujetForum;

    public Repondre() {
    }

    public Repondre(RepondrePK repondrePK) {
        this.repondrePK = repondrePK;
    }

    public Repondre(RepondrePK repondrePK, int idReponse, String contenuReponse, Date dateReponse) {
        this.repondrePK = repondrePK;
        this.idReponse = idReponse;
        this.contenuReponse = contenuReponse;
        this.dateReponse = dateReponse;
    }

    public Repondre(int idUser, int idSujet) {
        this.repondrePK = new RepondrePK(idUser, idSujet);
    }

    public RepondrePK getRepondrePK() {
        return repondrePK;
    }

    public void setRepondrePK(RepondrePK repondrePK) {
        this.repondrePK = repondrePK;
    }

    public int getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(int idReponse) {
        this.idReponse = idReponse;
    }

    public String getContenuReponse() {
        return contenuReponse;
    }

    public void setContenuReponse(String contenuReponse) {
        this.contenuReponse = contenuReponse;
    }

    public Date getDateReponse() {
        return dateReponse;
    }

    public void setDateReponse(Date dateReponse) {
        this.dateReponse = dateReponse;
    }

    public KombiUser getKombiUser() {
        return kombiUser;
    }

    public void setKombiUser(KombiUser kombiUser) {
        this.kombiUser = kombiUser;
    }

    public SujetForum getSujetForum() {
        return sujetForum;
    }

    public void setSujetForum(SujetForum sujetForum) {
        this.sujetForum = sujetForum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (repondrePK != null ? repondrePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Repondre)) {
            return false;
        }
        Repondre other = (Repondre) object;
        if ((this.repondrePK == null && other.repondrePK != null) || (this.repondrePK != null && !this.repondrePK.equals(other.repondrePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.Repondre[ repondrePK=" + repondrePK + " ]";
    }
    
}
