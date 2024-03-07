package java12.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import static jakarta.persistence.CascadeType.DETACH;

@Entity
@Table(name = "task")
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "task_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen", sequenceName = "task_seq", allocationSize = 1)
    private Long id;
    private String taskName;
    private String taskText;
    private LocalDate deadLine ;

    //************************** Lesson ***********************************//
    @ManyToOne(cascade = {CascadeType.PERSIST,DETACH})
    private Lesson lesson;
}
