package java12.service;

import java12.dto.request.TaskRequest;
import java12.dto.response.TaskResponse;
import java12.entity.Task;

public interface TaskService {
    Task save(Long lessonId, TaskRequest taskRequest);

    TaskResponse findById(Long findById);

    void delete(Long taskId);

    void update(Long taskId,Task taskRequest);

}
