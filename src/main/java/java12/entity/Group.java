package java12.entity;

import jakarta.persistence.*;
import java12.enums.GroupName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Setter @Getter
@NoArgsConstructor

public class Group {
    @Id
    @GeneratedValue(generator = "groups_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "groups_gen", sequenceName = "groups_seq", allocationSize = 1)

    private Long id;
    private String group_name;
    private String imageLike;
    private String description;

    //************************** Course ***********************************//
    @OneToMany(mappedBy = "group",cascade = {PERSIST,REMOVE})
    private List<Student> students;

    @ManyToMany(cascade = {PERSIST,DETACH})
    private List<Course> courses;

    public Group(Long id, String group_name, String imageLike, String description, List<Student> students) {
        this.id = id;
        this.group_name = group_name;
        this.imageLike = imageLike;
        this.description = description;
        this.students = students;
    }
}
