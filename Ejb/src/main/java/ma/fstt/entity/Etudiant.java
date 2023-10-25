package ma.fstt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiants")
public class Etudiant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_etudiant;
  private String nom;
  private String prenom;

  private String cne;
  private String adresse;
  private String niveau;

  public Etudiant() {
  }

  public Etudiant(String nom, String prenom, String cne, String adresse, String niveau) {
    this.nom = nom;
    this.prenom = prenom;
    this.cne = cne;
    this.adresse = adresse;
    this.niveau = niveau;
  }

  public Long getId_etudiant() {
    return id_etudiant;
  }

  public void setId_etudiant(Long id_etudiant) {
    this.id_etudiant = id_etudiant;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getCne() {
    return cne;
  }

  public void setCne(String cne) {
    this.cne = cne;
  }

  public String getAdresse() {
    return adresse;
  }

  public void setAdresse(String adresse) {
    this.adresse = adresse;
  }

  public String getNiveau() {
    return niveau;
  }

  public void setNiveau(String niveau) {
    this.niveau = niveau;
  }

}
