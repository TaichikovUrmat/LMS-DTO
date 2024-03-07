package java12.API;

import java12.dto.request.LessonRequest;
import java12.dto.response.LessonResponse;
import java12.entity.Lesson;
import java12.repository.LessonRepository;
import java12.service.Impl.LessonServiceImpl;
import java12.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/lesson")
public class LessonAPI {

    private final LessonService lessonService;

    @PostMapping("/save/{courseId}")
    public Lesson save(@PathVariable Long courseId,
                       @RequestBody LessonRequest lessonRequest){
    return  lessonService.save(courseId,lessonRequest);
    }

    @GetMapping("/find/{lessonId}")
    public LessonResponse findById(@PathVariable Long  lessonId){
        return lessonService.findById(lessonId);
    }

    @DeleteMapping("/delete/{lessonId}")
    public  void delete(@PathVariable Long lessonId){
        lessonService.delete(lessonId);
    }

    @PutMapping("/update/{lessonId}")
    public  void  update(@PathVariable Long lessonId,
                         @RequestBody Lesson newLesson ){
        lessonService.update(lessonId,newLesson);
    }



}
