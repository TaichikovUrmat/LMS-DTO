package java12.service.Impl;

import java12.dto.request.TaskRequest;
import java12.dto.response.SimpleResponse;
import java12.dto.response.TaskResponse;
import java12.entity.Lesson;
import java12.entity.Task;
import java12.repository.LessonRepository;
import java12.repository.TaskRepository;
import java12.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl  implements TaskService {

    private final TaskRepository taskRepository;
    private final LessonRepository lessonRepository;

    @Override
    public Task save(Long lessonId, TaskRequest taskRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        Task task = new Task();
        lesson.getTask().add(task);
        task.setLesson(lesson);

        task.setTaskName(taskRequest.getTaskName());
        task.setTaskText(taskRequest.getTaskText());
        task.setDeadLine(taskRequest.getDeadLine());

        return taskRepository.save(task);
    }

    @Override
    public TaskResponse findById(Long findById) {
        Task task = taskRepository.findById(findById).orElseThrow(() -> new RuntimeException("taskId invalid !!!"));
        return new TaskResponse(
                task.getId(),
                task.getTaskName(),
                task.getTaskText(),
                task.getDeadLine()
        );
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    @Override
    public void update(Long taskId, Task taskRequest) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("taskId invalid !!!"));
       task.setTaskName(taskRequest.getTaskName());
       task.setTaskText(taskRequest.getTaskText());
       task.setDeadLine(taskRequest.getDeadLine());
         taskRepository.save(task);

//     return SimpleResponse.builder()
//                .httpStatus(HttpStatus.OK)
//                .message("sonun")
//                .build();
    }


}
