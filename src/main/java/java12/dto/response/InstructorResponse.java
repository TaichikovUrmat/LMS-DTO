package java12.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java12.enums.StudyFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.ZonedDateTime;
@Setter @Getter
public class InstructorResponse{

    private String fullName;
    private String lastName;
    private Long phoneNumber;
    private String specializations;

    private String courseName;
    private LocalDate dataOfStart = ZonedDateTime.now().toLocalDate();
    private  String description;

    private String group_name;
    private String imageLike;
    private String descriptions;

    private String firsName;
    private String lastNamee;
    private String email;
    private Long phoneName;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormats;

   }
//Long id,
//String fullName,
//String lastName,
//Long phoneNumber,
//String specializations,
//
//Long Id,
//String courseName,
//LocalDate dataOfStart,
//String descriptions,
//
//Long ID,
//String group_name,
//String imageLike,
//String description,
//
//Long idd,
//String firsName,
//String lastNamee,
//String email,
//Long phoneName,
//StudyFormat studyFormats