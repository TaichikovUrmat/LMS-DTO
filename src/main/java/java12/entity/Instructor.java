package java12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.PERSIST;


@Entity
@Table(name = "instructors")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(generator = "instructors_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructors_gen", sequenceName = "instructors_seq", allocationSize = 1)
    private Long  id;
    private String fullName;
    private String lastName;
    private Long phoneNumber;
    private String specializations;  // специализации


    //************************** Company ***********************************//
    @ManyToMany(cascade = {PERSIST,DETACH})
    private List<Company> companies;

    //************************** Course ***********************************//
    @ManyToOne(cascade = {DETACH,PERSIST})
    private Course course;



}
