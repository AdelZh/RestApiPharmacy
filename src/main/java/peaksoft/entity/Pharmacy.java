package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToMany
    private List<Medicine> medicine;
    @OneToMany(mappedBy = "pharmacy")
    private List<Worker> workers;
}
