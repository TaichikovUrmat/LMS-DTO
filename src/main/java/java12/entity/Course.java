package java12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(generator = "courses_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "courses_gen", sequenceName = "courses_seq", allocationSize = 1)

    private Long id;
    private String courseName;
    private LocalDate dataOfStart = ZonedDateTime.now().toLocalDate();
    private  String description;

    //************************** Company ***********************************//
    @ManyToOne(cascade = {PERSIST,DETACH})
    private Company company;

    //************************** Instructor ***********************************//
    @OneToMany(mappedBy = "course",cascade = {REFRESH,REMOVE})
    private List<Instructor> instructors;

    //************************** Lesson  ***********************************//
    @OneToMany(mappedBy = "course",cascade = {PERSIST,REMOVE})
    private List<Lesson> lessons;

    //************************** Group ***********************************//
    @ManyToMany(mappedBy = "courses",cascade = {PERSIST,REMOVE})
    private List<Group> groups;

    public Course(Long id, String courseName, LocalDate dataOfStart, String description) {
        this.id = id;
        this.courseName = courseName;
        this.dataOfStart = dataOfStart;
        this.description = description;
    }
}
