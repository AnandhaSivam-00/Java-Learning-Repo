package Application.Model;

import lombok.*;

import javax.persistence.*;
/**
 * This JPA Entity has been related with the Student entity via a @ManyToOne annotation. The actual table
 * this entity will be related to will contain a foreign key in the Student table that relates it to the Classroom
 * table.
 *
 * You can also find the addition of (fetch = FetchType.EAGER) to the multiplicity mapping. This is an important
 * concept. Spring has the choice of either retrieving entities related to this one together with this entity (eager
 * fetching), or it may retrieve related entities only when they are specifically requested (lazy fetching). As you
 * may guess, this makes Eager fetching optimized for retrieving many related entities repeatedly, and Lazy fetching
 * optimized for retrieving only this single entity. The fetch type that you use in your application should be chosen
 * carefully for maximal efficiency.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double grade;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroomFK")
    private Classroom classroom;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", classroom=" + classroom +
                '}';
    }
}
