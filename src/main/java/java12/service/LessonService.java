package java12.service;

import java12.dto.request.LessonRequest;
import java12.dto.response.LessonResponse;
import java12.entity.Lesson;

public interface LessonService {

    Lesson save(Long courseId, LessonRequest lessonRequest);

    LessonResponse findById(Long lessonId);

    void delete(Long lessonId);

    void update(Long lessonId, Lesson newLesson);

}
