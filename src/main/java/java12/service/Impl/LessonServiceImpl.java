package java12.service.Impl;

import java12.dto.request.LessonRequest;
import java12.dto.response.LessonResponse;
import java12.entity.Course;
import java12.entity.Lesson;
import java12.repository.CourseRepository;
import java12.repository.LessonRepository;
import java12.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
     private final LessonRepository lessonRepository;
     private final CourseRepository courseRepository;


    @Override
    public Lesson save(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException(" courseId invalid!!"));

        Lesson lesson = new Lesson();
        course.getLessons().add(lesson);
        lesson.setCourse(course);

         lesson.setLessonName(lessonRequest.getLessonName());
        return lessonRepository.save(lesson);
    }

    @Override
    public LessonResponse findById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(()->new RuntimeException("invalid lessonId"));
        return new LessonResponse(
                lesson.getId(),
                lesson.getLessonName()
        );
    }
    @Override
    public void delete(Long lessonId) {
        try {
            lessonRepository.deleteById(lessonId);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    @Override
    public void update(Long lessonId, Lesson newLesson) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(()-> new RuntimeException("invalid lessonId"));
        lesson.setLessonName(newLesson.getLessonName());

        lessonRepository.save(lesson);


    }


}
