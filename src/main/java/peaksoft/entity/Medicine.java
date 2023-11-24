package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    @ManyToMany(mappedBy = "medicine")
    private List<Pharmacy> pharmacy;


}
