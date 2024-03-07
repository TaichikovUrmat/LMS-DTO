package java12.API;

import java12.dto.request.TaskRequest;
import java12.dto.response.TaskResponse;
import java12.entity.Task;
import java12.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
public class TaskAPI {

    private final TaskService taskService;

    @PostMapping("/save/{lessonId}")
    public Task save(@PathVariable Long lessonId,
                     @RequestBody TaskRequest taskRequest){
        return taskService.save(lessonId,taskRequest);
    }

    @GetMapping("/find/{taskId}")
    public TaskResponse findById(@PathVariable Long taskId){
        return taskService.findById(taskId);
    }

    @DeleteMapping("/delete/{taskId}")
    public void delete (@PathVariable Long taskId){
        taskService.delete(taskId);
    }

    @PutMapping("/update/{taskId}")
    public void update(@PathVariable Long taskId,
                       @RequestBody Task taskRequest){
        taskService.update(taskId,taskRequest);
    }


}
