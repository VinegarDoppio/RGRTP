package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service")
public class Service extends SuperID {

    @Column(name = "types")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "service")
    private List<Payment> payments;

}
