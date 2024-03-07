package java12.service.Impl;

import java12.dto.request.SaveGroupRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Course;
import java12.entity.Group;
import java12.entity.Student;
import java12.repository.CourseRepository;
import java12.repository.GroupRepository;
import java12.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;

   @Transactional
    @Override
    public SimpleResponse save(Long courseId, SaveGroupRequest saveGroupRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(()-> new RuntimeException("courseID invalid !!!"));

        Group group = new Group();
        List<Student> students = new ArrayList<>();
        group.setStudents(students);
        course.getGroups().add(group);
        group.setGroup_name(saveGroupRequest.getGroup_name());
        group.setDescription(saveGroupRequest.getDescription());
        group.setImageLike(saveGroupRequest.getImageLike());
       groupRepository.save(group);
       return SimpleResponse
               .builder()
               .httpStatus(HttpStatus.OK)
               .message("sonun !!")
               .build();
    }

    @Override
    public Group findById(Long findById) {
       return  groupRepository.findById(findById).orElseThrow(()-> new RuntimeException("courseID invalid !!!"));
    }

    @Override
    public SimpleResponse delete(Long groupId) {
        groupRepository.deleteById(groupId);
      return SimpleResponse
              .builder()
              .httpStatus(HttpStatus.OK)
              .message("removed !!! ")
              .build();


    }
}
