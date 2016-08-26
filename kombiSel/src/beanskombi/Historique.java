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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "historique")
@NamedQueries({
    @NamedQuery(name = "Historique.findAll", query = "SELECT h FROM Historique h")})
public class Historique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_historique")
    private Integer idHistorique;
    @Basic(optional = false)

    @Column(name = "action")
    private String action;
    @Basic(optional = false)
 
    @Column(name = "date_historique")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHistorique;
    @JoinTable(name = "consulter", joinColumns = {
        @JoinColumn(name = "id_historique", referencedColumnName = "id_historique")}, inverseJoinColumns = {
        @JoinColumn(name = "id_user", referencedColumnName = "id_user")})
    @ManyToMany
    private List<KombiUser> kombiUserList;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public Historique() {
    }

    public Historique(Integer idHistorique) {
        this.idHistorique = idHistorique;
    }

    public Historique(Integer idHistorique, String action, Date dateHistorique) {
        this.idHistorique = idHistorique;
        this.action = action;
        this.dateHistorique = dateHistorique;
    }

    public Integer getIdHistorique() {
        return idHistorique;
    }

    public void setIdHistorique(Integer idHistorique) {
        this.idHistorique = idHistorique;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDateHistorique() {
        return dateHistorique;
    }

    public void setDateHistorique(Date dateHistorique) {
        this.dateHistorique = dateHistorique;
    }

    public List<KombiUser> getKombiUserList() {
        return kombiUserList;
    }

    public void setKombiUserList(List<KombiUser> kombiUserList) {
        this.kombiUserList = kombiUserList;
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
        hash += (idHistorique != null ? idHistorique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historique)) {
            return false;
        }
        Historique other = (Historique) object;
        if ((this.idHistorique == null && other.idHistorique != null) || (this.idHistorique != null && !this.idHistorique.equals(other.idHistorique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.Historique[ idHistorique=" + idHistorique + " ]";
    }
    
}
