package java12.service.Impl;

import java12.dto.request.SaveStudentRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Group;
import java12.entity.Student;
import java12.repository.GroupRepository;
import java12.repository.StudentRepository;
import java12.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @Override
    public SimpleResponse save(SaveStudentRequest saveStudentRequest ) {
        Student student = new Student();
        student.setFirsName(saveStudentRequest.getFirsName());
        student.setLastName(saveStudentRequest.getLastName());
        student.setEmail(saveStudentRequest.getEmail());
        student.setPhoneName(saveStudentRequest.getPhoneName());
        student.setStudyFormats(saveStudentRequest.getStudyFormats());

        studentRepository.save(student);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successful !! ")
                .build();
    }

    @Override
    @Transactional
    public Student GroupAssingStudent(Long groupId, Long studentId) {
        Group group = groupRepository.findById(groupId).orElseThrow();
        Student student = studentRepository.findById(studentId).orElseThrow();

        group.getStudents().add(student);
        student.setGroup(group);

        return student;
    }

    @Override
    public void delete(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
