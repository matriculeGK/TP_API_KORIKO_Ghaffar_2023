package ucao.api.Ega.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Table(name = "operations")
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private OperationType type;
    private double montant;

    @ManyToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;
    private Integer client_id;

    public Operation(){
        this.date = LocalDate.now();
    }

    public Operation(OperationType type, double montant, Compte compte){
        this();
        this.type = type;
        this.montant = montant;
        this.compte = compte;
    }
}

