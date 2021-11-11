package sn.isi.diti5.service;

import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sn.isi.diti5.domain.Etudiant;
import sn.isi.diti5.service.DTO.EtudiantDTO;
import sn.isi.diti5.service.Impl.EtudiantServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EtudiantServiceImpl.class)
public class EtudiantServiceImplTest {

    @Autowired
    IEtudiantService etudiantService;

    @Test
    public void addEtudiantTest() {
        // Given
        EtudiantDTO etudiant = new EtudiantDTO();
        etudiant.setId(10);
        etudiant.setPrenom("Aissata");
        etudiant.setNom("SY");
        ResponseEntity<List<EtudiantDTO>> result = ResponseEntity.of(Optional.empty());
        // When

        result = etudiantService.addEtudiant(etudiant);

        // Then
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getBody());
        Assert.assertFalse(result.getBody().isEmpty());
        Assert.assertTrue(!result.getBody().isEmpty());
        Assert.assertEquals(result.getBody().get(result.getBody().size() - 1), etudiant);
    }

    @Test
    public void addEtudiantTestReturn200() {
        // Given
        EtudiantDTO etudiant = new EtudiantDTO();
        etudiant.setId(10);
        etudiant.setPrenom("Aissata");
        etudiant.setNom("SY");
        ResponseEntity<List<EtudiantDTO>> result = ResponseEntity.of(Optional.empty());
        // When

        result = etudiantService.addEtudiant(etudiant);

        // Then
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getStatusCode().value(), HttpStatus.OK.value());
        Assert.assertEquals(result.getStatusCode().value(), 200);
    }

    @Test
    public void addEtudiantTestReturn400() {
        // Given

        ResponseEntity<List<EtudiantDTO>> result = ResponseEntity.of(Optional.empty());
        // When

        result = etudiantService.addEtudiant(null);

        // Then
        Assert.assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
        Assert.assertEquals(result.getStatusCode().value(), HttpStatus.BAD_REQUEST.value());
        Assert.assertEquals(result.getStatusCode().value(), 400);
        Assert.assertTrue(result.getBody().isEmpty());
    }

    @Test
    public void getEtudiantTest() {
        // Given
        EtudiantDTO etudiant = new EtudiantDTO();
        int identifiant = 10;
        etudiant.setId(identifiant);
        etudiant.setPrenom("Aissata");
        etudiant.setNom("SY");
        ResponseEntity<EtudiantDTO> result = ResponseEntity.of(Optional.empty());
        etudiantService.addEtudiant(etudiant);
        // When

        result = etudiantService.getEtudiant(identifiant);

        // Then

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
        Assert.assertEquals(result.getStatusCode().value(), HttpStatus.OK.value());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertNotNull(result.getBody());
        Assert.assertEquals(result.getBody().getId(), identifiant);
        Assert.assertEquals(result.getBody().getNom(), "SY");
        Assert.assertEquals(result.getBody().getPrenom(), "Aissata");
    }

    @Test
    public void getEtudiantTest2() {
        // Given
        EtudiantDTO etudiant = new EtudiantDTO();
        int identifiant = 10;
        int unfoudIdentifiant = 25;
        etudiant.setId(identifiant);
        etudiant.setPrenom("Aissata");
        etudiant.setNom("SY");
        ResponseEntity<EtudiantDTO> result = ResponseEntity.of(Optional.empty());

        // When
        etudiantService.addEtudiant(etudiant);
        result = etudiantService.getEtudiant(unfoudIdentifiant);

        // Then

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.NOT_FOUND);
        Assert.assertEquals(result.getStatusCode().value(), HttpStatus.NOT_FOUND.value());
        Assert.assertEquals(result.getStatusCode().value(), 404);
    }
}
