package ma.fstt.ejb;

import java.util.List;
import ma.fstt.entity.Etudiant;

public interface EtudiantEjb {

  void addEtudiant(Etudiant etudiant);

  Etudiant getEtudiant(Long id);

  List<Etudiant> getAllEtudiants();

  void updateEtudiant(Etudiant etudiant);

  void deleteEtudiant(Long id);
}
