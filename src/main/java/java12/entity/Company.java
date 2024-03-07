package java12.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "companies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    @Id
    @GeneratedValue(generator = "companies_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "companies_gen", sequenceName = "companies_seq", allocationSize = 1)

    private Long id;
    private String  name;
    private String country;
    private String address;
    private Long phoneNumber;

    //************************** Instructor ***********************************//
    @ManyToMany(mappedBy = "companies",cascade = {PERSIST})
    private List<Instructor> instructor;

    //************************** Course ***********************************//
    @OneToMany(mappedBy = "company",cascade = {PERSIST,DETACH})
    private List<Course> course;


}
