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
@Table(name = "concerne_promotion")
@NamedQueries({
    @NamedQuery(name = "ConcernePromotion.findAll", query = "SELECT c FROM ConcernePromotion c")})
public class ConcernePromotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ConcernePromotionPK concernePromotionPK;
    @Basic(optional = false)
    @Column(name = "id_concerne_promotion")
    private int idConcernePromotion;
    @Basic(optional = false)
   
    @Column(name = "qte_promotion_commande")
    private int qtePromotionCommande;
    @Basic(optional = false)

    @Column(name = "prix_unitaire_promotion_cmd")
    private float prixUnitairePromotionCmd;
    @JoinColumn(name = "id_commande_promotion", referencedColumnName = "id_commande_promotion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CommandePromotion commandePromotion;
    @JoinColumn(name = "id_produit_promotion", referencedColumnName = "id_produit_promotion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ProduitPromotion produitPromotion;

    public ConcernePromotion() {
    }

    public ConcernePromotion(ConcernePromotionPK concernePromotionPK) {
        this.concernePromotionPK = concernePromotionPK;
    }

    public ConcernePromotion(ConcernePromotionPK concernePromotionPK, int idConcernePromotion, int qtePromotionCommande, float prixUnitairePromotionCmd) {
        this.concernePromotionPK = concernePromotionPK;
        this.idConcernePromotion = idConcernePromotion;
        this.qtePromotionCommande = qtePromotionCommande;
        this.prixUnitairePromotionCmd = prixUnitairePromotionCmd;
    }

    public ConcernePromotion(int idCommandePromotion, int idProduitPromotion) {
        this.concernePromotionPK = new ConcernePromotionPK(idCommandePromotion, idProduitPromotion);
    }

    public ConcernePromotionPK getConcernePromotionPK() {
        return concernePromotionPK;
    }

    public void setConcernePromotionPK(ConcernePromotionPK concernePromotionPK) {
        this.concernePromotionPK = concernePromotionPK;
    }

    public int getIdConcernePromotion() {
        return idConcernePromotion;
    }

    public void setIdConcernePromotion(int idConcernePromotion) {
        this.idConcernePromotion = idConcernePromotion;
    }

    public int getQtePromotionCommande() {
        return qtePromotionCommande;
    }

    public void setQtePromotionCommande(int qtePromotionCommande) {
        this.qtePromotionCommande = qtePromotionCommande;
    }

    public float getPrixUnitairePromotionCmd() {
        return prixUnitairePromotionCmd;
    }

    public void setPrixUnitairePromotionCmd(float prixUnitairePromotionCmd) {
        this.prixUnitairePromotionCmd = prixUnitairePromotionCmd;
    }

    public CommandePromotion getCommandePromotion() {
        return commandePromotion;
    }

    public void setCommandePromotion(CommandePromotion commandePromotion) {
        this.commandePromotion = commandePromotion;
    }

    public ProduitPromotion getProduitPromotion() {
        return produitPromotion;
    }

    public void setProduitPromotion(ProduitPromotion produitPromotion) {
        this.produitPromotion = produitPromotion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (concernePromotionPK != null ? concernePromotionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConcernePromotion)) {
            return false;
        }
        ConcernePromotion other = (ConcernePromotion) object;
        if ((this.concernePromotionPK == null && other.concernePromotionPK != null) || (this.concernePromotionPK != null && !this.concernePromotionPK.equals(other.concernePromotionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.ConcernePromotion[ concernePromotionPK=" + concernePromotionPK + " ]";
    }
    
}
