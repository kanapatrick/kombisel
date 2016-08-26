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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "supprimer_user")
@NamedQueries({
    @NamedQuery(name = "SupprimerUser.findAll", query = "SELECT s FROM SupprimerUser s")})
public class SupprimerUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)

    @Column(name = "nom_user_supprimer")
    private String nomUserSupprimer;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_suppression_user")
    private Integer idSuppressionUser;
    @Basic(optional = false)

    @Column(name = "date_suppression_user")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSuppressionUser;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public SupprimerUser() {
    }

    public SupprimerUser(Integer idSuppressionUser) {
        this.idSuppressionUser = idSuppressionUser;
    }

    public SupprimerUser(Integer idSuppressionUser, String nomUserSupprimer, Date dateSuppressionUser) {
        this.idSuppressionUser = idSuppressionUser;
        this.nomUserSupprimer = nomUserSupprimer;
        this.dateSuppressionUser = dateSuppressionUser;
    }

    public String getNomUserSupprimer() {
        return nomUserSupprimer;
    }

    public void setNomUserSupprimer(String nomUserSupprimer) {
        this.nomUserSupprimer = nomUserSupprimer;
    }

    public Integer getIdSuppressionUser() {
        return idSuppressionUser;
    }

    public void setIdSuppressionUser(Integer idSuppressionUser) {
        this.idSuppressionUser = idSuppressionUser;
    }

    public Date getDateSuppressionUser() {
        return dateSuppressionUser;
    }

    public void setDateSuppressionUser(Date dateSuppressionUser) {
        this.dateSuppressionUser = dateSuppressionUser;
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
        hash += (idSuppressionUser != null ? idSuppressionUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SupprimerUser)) {
            return false;
        }
        SupprimerUser other = (SupprimerUser) object;
        if ((this.idSuppressionUser == null && other.idSuppressionUser != null) || (this.idSuppressionUser != null && !this.idSuppressionUser.equals(other.idSuppressionUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.SupprimerUser[ idSuppressionUser=" + idSuppressionUser + " ]";
    }
    
}
