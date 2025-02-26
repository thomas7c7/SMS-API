package net.diyotech.student_management_system.service;

import net.diyotech.student_management_system.dto.AddressDto;
import net.diyotech.student_management_system.mapper.AddressMapper;
import net.diyotech.student_management_system.entity.Address;
import net.diyotech.student_management_system.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    //insert
    //addressDto to address
    public void save(AddressDto addressDto){
      addressRepository.save(AddressMapper.mapAddressDtoToAddress(addressDto));
    }

    //saves multiple address
    public void saveAll(List<Address> addressList){
        addressRepository.saveAll(addressList);
    }

    //delete
    public void delete(Long addressID){
        addressRepository.deleteById(addressID);
    }

    //get
    public Address get(Long addressID){
       Optional<Address> addressOptional = addressRepository.findById(addressID);
       if(addressOptional.isPresent()) {
           return addressOptional.get();
       } else {
           throw new RuntimeException("Address not found"); //
       }

    }

    //gets multiple address
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    //updates partial
    public void updateAddressPartially(long addressID, Address address){
        Address existingAddress = addressRepository.findById(addressID)
                .orElseThrow(() -> new RuntimeException("Address not found having id: "+addressID));
        if(address.getCity() != null){
            existingAddress.setCity(address.getCity());
        } if (address.getCountry() != null){
            existingAddress.setCountry(address.getCountry());
        } if (address.getState() != null){
            existingAddress.setState(address.getState());
        } if(address.getStreetName() != null){
            existingAddress.setStreetName(address.getStreetName());
        } if (address.getZipCode() != null){
            existingAddress.setZipCode(address.getZipCode());
        }
        addressRepository.save(existingAddress);
    }

    //Updates full address, similar to creating one
    public void updateFullAddress(Address address){
        //Include the ID within the body
        Address existingAddress = addressRepository.findById(address.getAddressID()) //Checks for id within the body
                .orElseThrow(()-> new RuntimeException("Address cannot be found for id:" +address.getAddressID()));
        existingAddress.setCountry(address.getCountry());
        existingAddress.setCity(address.getCity());
        existingAddress.setState(address.getState());
        existingAddress.setZipCode(address.getZipCode());
        existingAddress.setStreetName(address.getStreetName());
        addressRepository.save(existingAddress);
    }

    //Dto
    public List<AddressDto> getAllAddress(){
        return addressRepository.findAll().stream()
                .map(address -> AddressMapper.mapAddressToAddressDto(address))
                .collect(Collectors.toList());
    }

    //Native queries
    public List<Address> getAddressByCountry (String country){
        return addressRepository.getAddressByCountryUsingNativeSQL(country);
    }

    public List<Address> getAddressByCountryAndState(String country, String state){
        return addressRepository.getAddressByCountryAndStateUsingNativeSQL(country,state);
    }

    public List<Address> getAddressByCountryUsingQueryMethod(String country){
        return addressRepository.findAddressByCountry(country);
    }

    public List<Address> getAddressByCountryAndStateUsingQueryMethod(String country, String State){
        return addressRepository.findAddressByCountryAndState(country, State);
    }

}
