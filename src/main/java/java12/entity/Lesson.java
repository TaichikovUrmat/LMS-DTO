package java12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "lessons")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(generator = "lessons_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lessons_gen", sequenceName = "lessons_seq", allocationSize = 1)
    private Long id;
    private String lessonName;

    //************************** Course ***********************************//
   @ManyToOne(cascade = {PERSIST,DETACH})
    private Course course;
    //************************** Task ***********************************//
    @OneToMany(cascade = {PERSIST,REMOVE})
    private List<Task> task;



}
