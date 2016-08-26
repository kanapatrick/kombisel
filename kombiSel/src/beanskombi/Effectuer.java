/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "effectuer")
@NamedQueries({
    @NamedQuery(name = "Effectuer.findAll", query = "SELECT e FROM Effectuer e")})
public class Effectuer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EffectuerPK effectuerPK;
    @Basic(optional = false)
    @Column(name = "id_effectuer")
    private int idEffectuer;
    @JoinColumn(name = "id_commande_promotion", referencedColumnName = "id_commande_promotion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CommandePromotion commandePromotion;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private KombiUser kombiUser;

    public Effectuer() {
    }

    public Effectuer(EffectuerPK effectuerPK) {
        this.effectuerPK = effectuerPK;
    }

    public Effectuer(EffectuerPK effectuerPK, int idEffectuer) {
        this.effectuerPK = effectuerPK;
        this.idEffectuer = idEffectuer;
    }

    public Effectuer(int idUser, int idCommandePromotion) {
        this.effectuerPK = new EffectuerPK(idUser, idCommandePromotion);
    }

    public EffectuerPK getEffectuerPK() {
        return effectuerPK;
    }

    public void setEffectuerPK(EffectuerPK effectuerPK) {
        this.effectuerPK = effectuerPK;
    }

    public int getIdEffectuer() {
        return idEffectuer;
    }

    public void setIdEffectuer(int idEffectuer) {
        this.idEffectuer = idEffectuer;
    }

    public CommandePromotion getCommandePromotion() {
        return commandePromotion;
    }

    public void setCommandePromotion(CommandePromotion commandePromotion) {
        this.commandePromotion = commandePromotion;
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
        hash += (effectuerPK != null ? effectuerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Effectuer)) {
            return false;
        }
        Effectuer other = (Effectuer) object;
        if ((this.effectuerPK == null && other.effectuerPK != null) || (this.effectuerPK != null && !this.effectuerPK.equals(other.effectuerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.Effectuer[ effectuerPK=" + effectuerPK + " ]";
    }
    
}
