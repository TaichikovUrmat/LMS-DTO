package java12.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java12.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

@Setter
        @Getter
public class SaveStudentRequest {
    private String firsName;
    private String lastName;
    private String email;
    private Long phoneName;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormats;

}
