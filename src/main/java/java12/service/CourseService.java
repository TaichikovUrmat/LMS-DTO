package java12.service;

import java12.dto.request.SaveCourseRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Course;

public interface CourseService {
    SimpleResponse save(Long companyId, SaveCourseRequest courseRequest);

    Course findById(Long coursesId);

    SimpleResponse delete(Long courseId);

    SimpleResponse update(Long courseId, Course newCourse);

}
