package java12.service;

import java12.dto.request.InstructorRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Instructor;

public interface InstructorService {
    SimpleResponse save(InstructorRequest instructorRequest);

    Instructor assignCompanyAndInstructor(Long companyId, Long instructorId);

    Instructor assignCourseAndInstructor(Long courseId, Long instructorId);
    Instructor findById(Long instructorId);

    SimpleResponse delete(Long instructorId);

    SimpleResponse update(Long instructorId,Instructor newInstructor);

}
