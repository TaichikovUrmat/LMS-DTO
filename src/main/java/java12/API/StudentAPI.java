package java12.API;

import java12.dto.request.SaveStudentRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Student;
import java12.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentAPI {
    private final StudentService studentService;

    @PostMapping("/save")
    public SimpleResponse save(@RequestBody SaveStudentRequest saveStudentRequest ){
        return studentService.save(saveStudentRequest);
    }

    @PostMapping("/assign/{groupId}/{studentId}")
    public Student assign(@PathVariable Long groupId,
                          @PathVariable Long studentId){
        return studentService.GroupAssingStudent(groupId,studentId);
    }

    @DeleteMapping("/delete/{studentId}")
    public  void  delete(@PathVariable Long studentId){
        studentService.delete(studentId);
    }





}
