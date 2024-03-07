package java12.service;

import java12.dto.request.SaveGroupRequest;
import java12.dto.response.SimpleResponse;
import java12.entity.Group;

public interface GroupService {
    SimpleResponse save(Long courseId, SaveGroupRequest saveGroupRequest);

    Group findById(Long findById);

    SimpleResponse delete(Long groupId);
}
