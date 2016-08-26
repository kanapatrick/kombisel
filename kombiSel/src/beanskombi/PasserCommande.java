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
@Table(name = "passer_commande")
@NamedQueries({
    @NamedQuery(name = "PasserCommande.findAll", query = "SELECT p FROM PasserCommande p")})
public class PasserCommande implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PasserCommandePK passerCommandePK;
    @Basic(optional = false)
    @Column(name = "id_passer_commande")
    private int idPasserCommande;
    @Basic(optional = false)

    @Column(name = "date_commande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    @JoinColumn(name = "id_commande", referencedColumnName = "id_commande", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public PasserCommande() {
    }

    public PasserCommande(PasserCommandePK passerCommandePK) {
        this.passerCommandePK = passerCommandePK;
    }

    public PasserCommande(PasserCommandePK passerCommandePK, int idPasserCommande, Date dateCommande) {
        this.passerCommandePK = passerCommandePK;
        this.idPasserCommande = idPasserCommande;
        this.dateCommande = dateCommande;
    }

    public PasserCommande(int idCommande, int idUser) {
        this.passerCommandePK = new PasserCommandePK(idCommande, idUser);
    }

    public PasserCommandePK getPasserCommandePK() {
        return passerCommandePK;
    }

    public void setPasserCommandePK(PasserCommandePK passerCommandePK) {
        this.passerCommandePK = passerCommandePK;
    }

    public int getIdPasserCommande() {
        return idPasserCommande;
    }

    public void setIdPasserCommande(int idPasserCommande) {
        this.idPasserCommande = idPasserCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
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
        hash += (passerCommandePK != null ? passerCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasserCommande)) {
            return false;
        }
        PasserCommande other = (PasserCommande) object;
        if ((this.passerCommandePK == null && other.passerCommandePK != null) || (this.passerCommandePK != null && !this.passerCommandePK.equals(other.passerCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.PasserCommande[ passerCommandePK=" + passerCommandePK + " ]";
    }
    
}
