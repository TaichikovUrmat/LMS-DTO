package java12.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Setter @Getter
public class SaveCourseRequest {

    private String courseName;
    private LocalDate dataOfStart = ZonedDateTime.now().toLocalDate();
    private  String description;

}
