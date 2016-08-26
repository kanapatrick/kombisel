/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "sujet_forum")
@NamedQueries({
    @NamedQuery(name = "SujetForum.findAll", query = "SELECT s FROM SujetForum s")})
public class SujetForum implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_sujet")
    private Integer idSujet;
    @Basic(optional = false)
 
    @Column(name = "contenu_sujet")
    private String contenuSujet;
    @Basic(optional = false)
  
    @Column(name = "date_creation_sujet")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreationSujet;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sujetForum")
    private List<Repondre> repondreList;

    public SujetForum() {
    }

    public SujetForum(Integer idSujet) {
        this.idSujet = idSujet;
    }

    public SujetForum(Integer idSujet, String contenuSujet, Date dateCreationSujet) {
        this.idSujet = idSujet;
        this.contenuSujet = contenuSujet;
        this.dateCreationSujet = dateCreationSujet;
    }

    public Integer getIdSujet() {
        return idSujet;
    }

    public void setIdSujet(Integer idSujet) {
        this.idSujet = idSujet;
    }

    public String getContenuSujet() {
        return contenuSujet;
    }

    public void setContenuSujet(String contenuSujet) {
        this.contenuSujet = contenuSujet;
    }

    public Date getDateCreationSujet() {
        return dateCreationSujet;
    }

    public void setDateCreationSujet(Date dateCreationSujet) {
        this.dateCreationSujet = dateCreationSujet;
    }

    public KombiUser getKombiUser() {
        return kombiUser;
    }

    public void setKombiUser(KombiUser kombiUser) {
        this.kombiUser = kombiUser;
    }

    public List<Repondre> getRepondreList() {
        return repondreList;
    }

    public void setRepondreList(List<Repondre> repondreList) {
        this.repondreList = repondreList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSujet != null ? idSujet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SujetForum)) {
            return false;
        }
        SujetForum other = (SujetForum) object;
        if ((this.idSujet == null && other.idSujet != null) || (this.idSujet != null && !this.idSujet.equals(other.idSujet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.SujetForum[ idSujet=" + idSujet + " ]";
    }
    
}
