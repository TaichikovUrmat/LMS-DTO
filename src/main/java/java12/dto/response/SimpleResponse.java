package java12.dto.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleResponse {
    private HttpStatus httpStatus;
    private  String message;
}
