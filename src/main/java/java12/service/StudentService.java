package java12.service;

import java12.dto.request.SaveStudentRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Student;

public interface StudentService {
    SimpleResponse save(SaveStudentRequest saveStudentRequest);

    Student GroupAssingStudent(Long groupId, Long studentId);

    void delete(Long studentId);

}
