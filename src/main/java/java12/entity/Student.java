package java12.entity;

import jakarta.persistence.*;
import java12.enums.StudyFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table(name = "students")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(generator = "students_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "students_gen", sequenceName = "students_seq", allocationSize = 1)

    private Long id;
    private String firsName;
    private String lastName;
    private String email;
    private Long phoneName;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormats;

//************************** Student ***********************************//
    @ManyToOne(cascade = {PERSIST,DETACH })
    private Group group;
}
