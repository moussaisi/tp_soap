package sn.isi.diti5.web.rest;

import com.sun.xml.bind.v2.TODO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.diti5.domain.Etudiant;
import sn.isi.diti5.service.DTO.EtudiantDTO;
import sn.isi.diti5.service.IEtudiantService;

@RestController
@RequestMapping("/api")
public class EtudiantController {

    IEtudiantService etudiantService;

    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /*
    @Autowired
    IEtudiantService etudiantService;
    */

    @GetMapping("/etudiants")
    public ResponseEntity<List<Etudiant>> getEtudiant() {
        return this.etudiantService.getEtudiants();
    }

    @PostMapping("/etudiant/add")
    public ResponseEntity<List<EtudiantDTO>> postEtudiant(@RequestBody EtudiantDTO etudiant) {
        return this.etudiantService.addEtudiant(etudiant);
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<EtudiantDTO> getEtudiant(@PathVariable int id) {
        return this.etudiantService.getEtudiant(id);
    }
    //TODO: ajout methode pour suppression et mise à jour d'étudiant
    //TODO: /!\ les methodes dans les services doivent avoir chacune son test unitaire
    //TODO: qui gère les différent cas (A rendre !)
}
