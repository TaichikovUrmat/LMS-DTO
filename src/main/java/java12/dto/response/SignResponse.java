package java12.dto.response;

import lombok.Builder;

@Builder
public record SignResponse(
        Long id,
        String name,
        String address,
        String email,
        Long phoneNumber
) {

}
