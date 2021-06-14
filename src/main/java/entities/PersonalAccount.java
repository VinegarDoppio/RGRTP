package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "personal_accounts")
public class PersonalAccount extends SuperID {

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "house")
    private String house;

    @Column(name = "flat")
    private String flat;

    @Column(name = "number_of_residents")
    private int number_of_residents;

    @Column(name = "area")
    private int area;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "personalAccount")
    private List<Payment> payments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_street")
    private Street street;
}
