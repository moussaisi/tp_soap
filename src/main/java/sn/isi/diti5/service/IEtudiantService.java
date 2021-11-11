package sn.isi.diti5.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import sn.isi.diti5.domain.Etudiant;
import sn.isi.diti5.service.DTO.EtudiantDTO;

public interface IEtudiantService {
    public ResponseEntity<List<Etudiant>> getEtudiants();

    public ResponseEntity<List<EtudiantDTO>> addEtudiant(EtudiantDTO etudiant);

    public ResponseEntity<EtudiantDTO> getEtudiant(int id);
}
