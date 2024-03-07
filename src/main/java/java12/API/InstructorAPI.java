package java12.API;

import java12.dto.request.InstructorRequest;
import java12.dto.response.InstructorResponse;
import java12.dto.response.SimpleResponse;
import java12.entity.Instructor;
import java12.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/instructor")
public class InstructorAPI {
    private final InstructorService instructorService;

    @PostMapping("/save")
    public SimpleResponse save(@RequestBody InstructorRequest instructorRequest){
      return instructorService.save(instructorRequest);
    }

    @PostMapping("/assign/{companyId}/{instructorId}")
    public  Instructor assignCompany(@PathVariable Long companyId,
                              @PathVariable Long instructorId){
        return instructorService.assignCompanyAndInstructor(companyId,instructorId);
    }
    @PostMapping("/assignCourse/{courseId}/{instructorId}")
    public Instructor assignCourse(@PathVariable Long courseId,
                                   @PathVariable Long instructorId ){
        return instructorService.assignCourseAndInstructor(courseId,instructorId);
    }
    @GetMapping("/findById/{instructorId}")
   public Instructor getById(@PathVariable Long instructorId){
        return instructorService.findById(instructorId);
    }

    @DeleteMapping("/delete/{instructorId}")
    public SimpleResponse delete(@PathVariable Long  instructorId){
      return   instructorService.delete(instructorId);
    }
    @PutMapping("/update/{instructorId}")
    public SimpleResponse update(@PathVariable Long instructorId,
                                 @RequestBody Instructor newInstructor){
        return instructorService.update(instructorId,newInstructor);
    }



}
