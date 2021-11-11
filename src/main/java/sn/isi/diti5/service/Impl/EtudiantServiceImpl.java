package sn.isi.diti5.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sn.isi.diti5.domain.Etudiant;
import sn.isi.diti5.service.DTO.EtudiantDTO;
import sn.isi.diti5.service.IEtudiantService;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    static List<EtudiantDTO> mesEtudiants = new ArrayList<>();

    /**
     * Retourne la liste de tous les étudiants ajoutés
     * @return
     */
    @Override
    public ResponseEntity<List<Etudiant>> getEtudiants() {
        List<Etudiant> maListe = new ArrayList<>();

        Etudiant etudiant1 = Etudiant.builder().id(1).nom("Sarr").prenom("Hady").build();

        maListe.add(etudiant1);

        ResponseEntity result = ResponseEntity.status(HttpStatus.OK).body(maListe);

        return result;
    }

    /**
     * Ajoute un étudiant dans la liste et retourn la liste en entier avec un code 200
     * @param etudiant
     * @return
     */

    @Override
    public ResponseEntity<List<EtudiantDTO>> addEtudiant(EtudiantDTO etudiant) {
        // List<EtudiantDTO> mesEtudiants = new ArrayList<>();

        if (null == etudiant) {
            ArrayList<EtudiantDTO> liste = new ArrayList<>();
            EtudiantDTO etudiant1 = new EtudiantDTO();
            liste.add(etudiant1);
            return ResponseEntity.badRequest().body(new ArrayList<>());
        }

        mesEtudiants.add(etudiant);
        return ResponseEntity.ok().body(mesEtudiants);
    }

    /**
     * Methode de récupération d'un étudiant à partir de son identifiant
     *  Retourne:
     *     - l'element lorsqu'il est trouvé dans la liste avec un code 200
     *     - vide avec un code 404 lorsque l'élément n'est pas dans la liste
     * @param id
     * @return @ResponeEntity
     */
    @Override
    public ResponseEntity<EtudiantDTO> getEtudiant(int id) {
        EtudiantDTO response;

        Optional<EtudiantDTO> etudiantDTO = mesEtudiants
            .stream()
            .filter(etudiantDTO1 -> {
                return etudiantDTO1.getId() == id;
            })
            .findFirst();

        if (etudiantDTO.isPresent()) {
            return ResponseEntity.ok(etudiantDTO.get());
        }

        return ResponseEntity.notFound().build();
    }
}
