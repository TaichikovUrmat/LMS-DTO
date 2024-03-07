package java12.API;

import java12.dto.request.SaveGroupRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Group;
import java12.repository.GroupRepository;
import java12.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/group")

public class GroupAPI {
    private final GroupService groupService;


    @PostMapping("save/{courseId}")
    public SimpleResponse saveGroup(@PathVariable Long courseId,
                                    @RequestBody SaveGroupRequest saveGroupRequest ){
        return groupService.save(courseId,saveGroupRequest);
    }
    @GetMapping("/findById/{courseId}")
    public Group findById(@PathVariable Long courseId){
        return groupService.findById(courseId);
    }
    @DeleteMapping("/delete/{groupId}")
    public SimpleResponse  delete(@PathVariable Long groupId){
     return groupService.delete(groupId);
    }




   }
