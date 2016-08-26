/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beanskombi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author kana patrick
 */
@Entity
@Table(name = "kombi_user")
@NamedQueries({
    @NamedQuery(name = "KombiUser.findAll", query = "SELECT k FROM KombiUser k")})
public class KombiUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_user")
    private Integer idUser;
    @Basic(optional = false)

    @Column(name = "nom_user")
    private String nomUser;

    @Column(name = "prenom_user")
    private String prenomUser;
    @Basic(optional = false)
  
    @Column(name = "pseudo")
    private String pseudo;
    @Basic(optional = false)
  
    @Column(name = "addresse")
    private String addresse;
    @Basic(optional = false)

    @Column(name = "email_user")
    private String emailUser;
    @Basic(optional = false)
  
    @Column(name = "telephone_user")
    private String telephoneUser;
    @Basic(optional = false)

    @Column(name = "passwd_user")
    private String passwdUser;
    @Column(name = "status_user")
    private Integer statusUser;
    @ManyToMany(mappedBy = "kombiUserList")
    private List<Article> articleList;
    @ManyToMany(mappedBy = "kombiUserList")
    private List<Historique> historiqueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<PasserCommande> passerCommandeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<ModifierArticle> modifierArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<SujetForum> sujetForumList;
    @JoinColumn(name = "id_groupe", referencedColumnName = "id_groupe")
    @ManyToOne(optional = false)
    private Groupe groupe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<Effectuer> effectuerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<CreerCategorie> creerCategorieList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<SupprimerArticle> supprimerArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<Repondre> repondreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<ParticiperPromotion> participerPromotionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<SupprimerUser> supprimerUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<MettreEnPromotion> mettreEnPromotionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<DemandeArticle> demandeArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<MettreArticle> mettreArticleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kombiUser")
    private List<Historique> historiqueList1;

    public KombiUser() {
    }

    public KombiUser(Integer idUser) {
        this.idUser = idUser;
    }

    public KombiUser(Integer idUser, String nomUser, String pseudo, String addresse, String emailUser, String telephoneUser, String passwdUser) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.pseudo = pseudo;
        this.addresse = addresse;
        this.emailUser = emailUser;
        this.telephoneUser = telephoneUser;
        this.passwdUser = passwdUser;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getTelephoneUser() {
        return telephoneUser;
    }

    public void setTelephoneUser(String telephoneUser) {
        this.telephoneUser = telephoneUser;
    }

    public String getPasswdUser() {
        return passwdUser;
    }

    public void setPasswdUser(String passwdUser) {
        this.passwdUser = passwdUser;
    }

    public Integer getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(Integer statusUser) {
        this.statusUser = statusUser;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Historique> getHistoriqueList() {
        return historiqueList;
    }

    public void setHistoriqueList(List<Historique> historiqueList) {
        this.historiqueList = historiqueList;
    }

    public List<PasserCommande> getPasserCommandeList() {
        return passerCommandeList;
    }

    public void setPasserCommandeList(List<PasserCommande> passerCommandeList) {
        this.passerCommandeList = passerCommandeList;
    }

    public List<ModifierArticle> getModifierArticleList() {
        return modifierArticleList;
    }

    public void setModifierArticleList(List<ModifierArticle> modifierArticleList) {
        this.modifierArticleList = modifierArticleList;
    }

    public List<SujetForum> getSujetForumList() {
        return sujetForumList;
    }

    public void setSujetForumList(List<SujetForum> sujetForumList) {
        this.sujetForumList = sujetForumList;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public List<Effectuer> getEffectuerList() {
        return effectuerList;
    }

    public void setEffectuerList(List<Effectuer> effectuerList) {
        this.effectuerList = effectuerList;
    }

    public List<CreerCategorie> getCreerCategorieList() {
        return creerCategorieList;
    }

    public void setCreerCategorieList(List<CreerCategorie> creerCategorieList) {
        this.creerCategorieList = creerCategorieList;
    }

    public List<SupprimerArticle> getSupprimerArticleList() {
        return supprimerArticleList;
    }

    public void setSupprimerArticleList(List<SupprimerArticle> supprimerArticleList) {
        this.supprimerArticleList = supprimerArticleList;
    }

    public List<Repondre> getRepondreList() {
        return repondreList;
    }

    public void setRepondreList(List<Repondre> repondreList) {
        this.repondreList = repondreList;
    }

    public List<ParticiperPromotion> getParticiperPromotionList() {
        return participerPromotionList;
    }

    public void setParticiperPromotionList(List<ParticiperPromotion> participerPromotionList) {
        this.participerPromotionList = participerPromotionList;
    }

    public List<SupprimerUser> getSupprimerUserList() {
        return supprimerUserList;
    }

    public void setSupprimerUserList(List<SupprimerUser> supprimerUserList) {
        this.supprimerUserList = supprimerUserList;
    }

    public List<MettreEnPromotion> getMettreEnPromotionList() {
        return mettreEnPromotionList;
    }

    public void setMettreEnPromotionList(List<MettreEnPromotion> mettreEnPromotionList) {
        this.mettreEnPromotionList = mettreEnPromotionList;
    }

    public List<DemandeArticle> getDemandeArticleList() {
        return demandeArticleList;
    }

    public void setDemandeArticleList(List<DemandeArticle> demandeArticleList) {
        this.demandeArticleList = demandeArticleList;
    }

    public List<MettreArticle> getMettreArticleList() {
        return mettreArticleList;
    }

    public void setMettreArticleList(List<MettreArticle> mettreArticleList) {
        this.mettreArticleList = mettreArticleList;
    }

    public List<Historique> getHistoriqueList1() {
        return historiqueList1;
    }

    public void setHistoriqueList1(List<Historique> historiqueList1) {
        this.historiqueList1 = historiqueList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KombiUser)) {
            return false;
        }
        KombiUser other = (KombiUser) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beanskombi.KombiUser[ idUser=" + idUser + " ]";
    }
    
}
