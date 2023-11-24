package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private int salary;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Pharmacy pharmacy;

}
