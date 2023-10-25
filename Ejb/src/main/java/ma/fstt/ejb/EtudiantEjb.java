package ma.fstt.ejb;

import java.util.List;

import jakarta.ejb.Remote;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import ma.fstt.entity.Etudiant;

@Stateless
@Remote
public class EtudiantEjb {

  @PersistenceContext(unitName = "default")
  private EntityManager entityManager;

  public EtudiantEjb() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    this.entityManager = emf.createEntityManager();
  }

  public void addEtudiant(Etudiant etudiant) {
    entityManager.persist(etudiant);
  }

  public Etudiant getEtudiant(Long id) {
    return entityManager.find(Etudiant.class, id);
  }

  public List<Etudiant> getAllEtudiants() {
    return entityManager.createQuery("SELECT e FROM Etudiant e", Etudiant.class).getResultList();
  }

  public void updateEtudiant(Etudiant etudiant) {
    entityManager.merge(etudiant);
  }

  public void deleteEtudiant(Long id) {
    Etudiant etudiant = getEtudiant(id);
    if (etudiant != null) {
      entityManager.remove(etudiant);
    }
  }
}
