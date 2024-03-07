package java12.repository;

import java12.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository  extends JpaRepository<Group,Long> {

    @Query("DELETE FROM Course c WHERE :groupId IN (SELECT g.id FROM c.groups g) AND c.id = :courseId")
    void deleteByIdGroup(Long courseId,Long groupId);

//    @Query("DELETE FROM Course c WHERE :groupId IN (SELECT g.id FROM c.groups g) AND c.id = :courseId")
//    void deleteCourseByGroupId(Long courseId, Long groupId);

}
