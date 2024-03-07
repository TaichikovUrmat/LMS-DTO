package java12.dto.request;

import java12.enums.GroupName;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter

public class SaveGroupRequest {
    private String group_name;
    private String imageLike;
    private String description;
}
