package net.diyotech.student_management_system.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


//@ToString
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//Dto is used to hide the real field name / filter fields for client
public class AddressDto {

    private Long addressId;
    private String country;
    private String state;

}
