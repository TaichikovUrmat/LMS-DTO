package java12.repository;

import java12.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long> {

    @Query("SELECT i, c, g, s  " +
            "FROM Instructor i " +
            "JOIN i.course c " +
            " JOIN c.groups g " +
            "JOIN g.students s " +
            "WHERE i.id = :instructorId " +
            "GROUP BY i, c, g, s")
    Instructor findByIdd(@Param("instructorId") Long instructorId);

}
