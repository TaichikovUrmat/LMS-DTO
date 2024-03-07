package java12.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class InstructorRequest {
    private String fullName;
    private String lastName;
    private Long phoneNumber;
    private String specializations;

}
