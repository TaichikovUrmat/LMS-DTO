package java12.API;

import java12.dto.request.SaveCourseRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Course;
import java12.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseAPI {

    private final CourseService courseService;

      @PostMapping("/save/{companyId}")
    public SimpleResponse saveCourses(@PathVariable Long companyId,
                                      @RequestBody SaveCourseRequest courseRequest){
          return courseService.save(companyId,courseRequest);
      }

     @GetMapping("/{coursesId}")
    public Course findById(@PathVariable Long coursesId){
          return courseService.findById(coursesId);
     }
     @DeleteMapping("/delete/{courseId}")
      public SimpleResponse delete(@PathVariable Long courseId){
        return   courseService.delete(courseId);
     }
     @PutMapping("/update/{courseId}")
    public SimpleResponse update(@PathVariable Long courseId,
                       @RequestBody Course newCourse){
         return courseService.update(courseId,newCourse);

     }



}
