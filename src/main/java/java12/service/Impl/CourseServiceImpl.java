package java12.service.Impl;

import java12.dto.request.SaveCourseRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Company;
import java12.entity.Course;
import java12.entity.Group;
import java12.entity.Lesson;
import java12.repository.CompanyRepository;
import java12.repository.CourseRepository;
import java12.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CompanyRepository companyRepo;
    @Override
    public SimpleResponse save(Long companyId, SaveCourseRequest courseRequest) {
       Company company = companyRepo.findById(companyId).orElseThrow(()-> new RuntimeException("invalid company id !!"));

       Course newCourse = new Course();

       company.getCourse().add(newCourse);
       newCourse.setCompany(company);

        List<Lesson> lessons = new ArrayList<>();
       newCourse.setLessons(lessons);

       List<Group> groups =  new ArrayList<>();
       newCourse.setGroups(groups);


       newCourse.setCourseName(courseRequest.getCourseName());
       newCourse.setDataOfStart(courseRequest.getDataOfStart());
       newCourse.setDescription(courseRequest.getDescription());
       courseRepository.save(newCourse);
       return SimpleResponse
               .builder()
               .httpStatus(HttpStatus.OK)
               .message("sonun !!")
               .build();

    }

    @Override
    public Course findById(Long coursesId) {
       return  courseRepository.findById(coursesId).orElseThrow(() -> new RuntimeException("courId invalid !!!"));
    }

    @Override
    public SimpleResponse delete(Long courseId) {
        courseRepository.deleteById(courseId);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("removed !! ")
                .build();
    }

    @Override
    public SimpleResponse update(Long courseId, Course newCourse) {

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("courId invalid !!!"));
        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setDataOfStart(newCourse.getDataOfStart());
        courseRepository.save(course);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("updated !!! ")
                .build();
    }
}
