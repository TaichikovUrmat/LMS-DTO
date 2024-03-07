package java12.service.Impl;

import java12.dto.request.InstructorRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.*;
import java12.repository.CompanyRepository;
import java12.repository.CourseRepository;
import java12.repository.InstructorRepository;
import java12.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {
    private final InstructorRepository instructorRepository;
    private final CompanyRepository companyRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse save(InstructorRequest instructorRequest) {
       Instructor instructor = new Instructor();

        instructor.setFullName(instructorRequest.getFullName());
        instructor.setLastName(instructorRequest.getLastName());
        instructor.setPhoneNumber(instructorRequest.getPhoneNumber());
        instructor.setSpecializations(instructorRequest.getSpecializations());

        instructorRepository.save(instructor);
        return  SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("sonun !!")
                .build();
    }
    @Transactional
    @Override
    public Instructor assignCompanyAndInstructor(Long companyId, Long instructorId) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("companyId invalid !!"));
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("instructorId invalid !!"));

        company.getInstructor().add(instructor);
        instructor.getCompanies().add(company);
           return instructor;

    }

    @Transactional
    @Override
    public Instructor assignCourseAndInstructor(Long courseId, Long instructorId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("companyId invalid !!"));
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("instructorId invalid !!"));

        course.getInstructors().add(instructor);
        instructor.setCourse(course);
        return instructor;
    }

    @Override
    public Instructor findById(Long instructorId) {
        return instructorRepository.findByIdd(instructorId);

    }

    @Override
    public SimpleResponse delete(Long instructorId) {
        instructorRepository.deleteById(instructorId);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("removed !! ")
                .build();
    }

    @Override
    public SimpleResponse update(Long instructorId, Instructor newInstructor) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() -> new RuntimeException("companyId invalid !!"));
        instructor.setFullName(newInstructor.getFullName());
        instructor.setLastName(newInstructor.getLastName());
        instructor.setPhoneNumber(newInstructor.getPhoneNumber());
        instructor.setSpecializations(newInstructor.getSpecializations());
        instructorRepository.save(instructor);
        return SimpleResponse
                .builder()
                .httpStatus(HttpStatus.OK)
                .message("updated !! ")
                .build();
    }
//       instructor.getId(),
//               instructor.getFullName(),
//               instructor.getLastName(),
//               instructor.getPhoneNumber(),
//               instructor.getSpecializations(),
//
//               course.getId(),
//               course.getCourseName(),
//               course.getDataOfStart(),
//               course.getDescription(),
//
//               group.getId(),
//               group.getGroup_name(),
//               group.getImageLike(),
//               group.getDescription(),
//
//               student.getId(),
//               student.getFirsName(),
//               student.getLastName(),
//               student.getEmail(),
//               student.getPhoneName(),
//               student.getStudyFormats()


}
