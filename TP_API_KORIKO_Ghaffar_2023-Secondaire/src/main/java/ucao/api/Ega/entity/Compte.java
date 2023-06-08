package ucao.api.Ega.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Data
@Table(name = "comptes")
@Entity
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String numeroCompte;

    private String typeCompte;
    private LocalDate dateCreation;
    private double solde;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false, nullable = false)
    private Client client;
    private Integer client_id;

    public Compte(){
        this.numeroCompte = genererNumeroCompte();
        this.dateCreation = LocalDate.now();
        this.solde = 0.0;
    }


    public Compte( String typeCompte) {
        this();
        this.typeCompte = typeCompte;
    }



    private String genererNumeroCompte() {
        String randomString = UUID.randomUUID().toString().replaceAll("[^A-Z0-9]", "").substring(0, 5);
        String anneeCreation = String.valueOf(LocalDate.now().getYear());
        String numeroCompte = randomString + anneeCreation;
        return numeroCompte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Compte compte)) return false;
        return Objects.equals(id, compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", numeroCompte='" + numeroCompte + '\'' +
                ", typeCompte='" + typeCompte + '\'' +
                ", dateCreation=" + dateCreation +
                ", solde=" + solde +
                ", client=" + client +
                '}';
    }
}
