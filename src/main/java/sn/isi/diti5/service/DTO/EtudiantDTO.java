package sn.isi.diti5.service.DTO;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EtudiantDTO implements Serializable {

    private int id;
    private String nom;
    private String prenom;
}
