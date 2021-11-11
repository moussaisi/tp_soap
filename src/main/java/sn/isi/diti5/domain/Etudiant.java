package sn.isi.diti5.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sun.istack.NotNull;
import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Etudiant implements Serializable {

    private int id;
    private String nom;
    private String prenom;

    public String toString() {
        return "je suis " + prenom + " " + nom + " !";
    }
}
