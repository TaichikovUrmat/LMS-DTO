package java12.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SaveCompanyRequest {

    private String  name;
    private String country;
    private String address;
    private Long phoneNumber;
}
