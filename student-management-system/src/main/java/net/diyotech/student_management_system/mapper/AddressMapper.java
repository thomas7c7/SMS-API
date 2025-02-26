package net.diyotech.student_management_system.mapper;

import net.diyotech.student_management_system.dto.AddressDto;
import net.diyotech.student_management_system.entity.Address;

public class AddressMapper {

    //static so we don't need to create an object to call a method
    //address to addressDTO
    public static AddressDto mapAddressToAddressDto (Address address){
        return AddressDto.builder().addressId(address.getAddressID())
                .country(address.getCountry()).build();

//        return new AddressDto(address.getAddressID(),
//                address.getCountry());
    }

    //addressDto to address
    public static Address mapAddressDtoToAddress(AddressDto addressDto){

        return new Address(addressDto.getAddressId(),
                addressDto.getCountry(),
                addressDto.getState());
    }
}
