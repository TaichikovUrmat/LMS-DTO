package java12.dto.response;

import java.time.LocalDate;

public record TaskResponse(
        Long id,
        String taskName,
        String taskText,
        LocalDate deadLine
) {
}
