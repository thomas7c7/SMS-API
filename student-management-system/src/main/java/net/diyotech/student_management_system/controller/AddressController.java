package net.diyotech.student_management_system.controller;

import net.diyotech.student_management_system.dto.AddressDto;
import net.diyotech.student_management_system.entity.Address;
import net.diyotech.student_management_system.model.Project;
import net.diyotech.student_management_system.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //@Controller @ResponseBody
@RequestMapping("/address")
//@Profile("localdev") //can only run this class from locadev profile
//@Profile("!localdev") //can  run this class from any other profile except localdev
public class AddressController {

    @Value("${domain}")
    private String company;

    //Dependency injection
    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @Autowired //Autowire injection of model Porject
    Project hospitalProject;

    @GetMapping("/test0")
    public ResponseEntity<String> readPropertyValue2(){
        System.err.println("Hospital project details: " +hospitalProject);
        return ResponseEntity.ok("Test") ;
    }

    //null pointer exception example
    @GetMapping("/test2")
    public ResponseEntity<String> readPropertyValue(){
        String text = null;
        System.out.println(text.length());
        return ResponseEntity.ok(company);
    }

    //array index example
    @GetMapping("/test1")
    public ResponseEntity<String> testGlobalExceptionHandling(){
        int nums[] = {2,4,5};
        System.out.println(nums[10]);
        return ResponseEntity.ok(company);
    }

    //inserts single address using Dto
    @PostMapping
    public ResponseEntity<String> saveUsingDto(@RequestBody AddressDto addressDto){
         addressService.save(addressDto);
         return new ResponseEntity<>("Address saved successfully", HttpStatus.CREATED);
    }

    //saves multiple addresses
    @PostMapping("/save-all")
    public ResponseEntity<String> saveAll(@RequestBody List<Address> addressList){
        addressService.saveAll(addressList);
        return ResponseEntity.ok("All address saved successfully");
    }

    //URL: locahost:8080/address/{id}
    @DeleteMapping("/{id}") //map used to delete
    public String delete(@PathVariable("id") Long addressID){
        addressService.delete(addressID);
        return "Address deleted successfully";
    }

    //same URL
    //gets address info based on address id
    @GetMapping("/{id}")
    //public address because it returns address object
    public Address get(@PathVariable("id") Long addressID){
        Address address = addressService.get(addressID);
        return address;
    }

    //Gets multiple address
    @GetMapping
    public  ResponseEntity< List<Address> > getAllAdddresses(){
        return  ResponseEntity.ok(addressService.getAllAddresses());
    }

    //updates address partially
    @PatchMapping("/{id}")
    public ResponseEntity<String> updatePartialAddress (@PathVariable("id") long addressID, @RequestBody Address address){
        addressService.updateAddressPartially(addressID, address);
        return new ResponseEntity<>("Address updated", HttpStatus.CREATED);
    }

   //Updates full address, similar to creating one
    @PutMapping
    public ResponseEntity<String> updateAddress(@RequestBody Address address){
        addressService.updateFullAddress(address);
        return new ResponseEntity<>("Full address updated", HttpStatus.CREATED);
    }

    //DTO: extracting only partial information
    //converting address to addressDto
    @GetMapping("/dto")
    public ResponseEntity<List<AddressDto>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }

    //native queries
    //SELECT * FROM STUDENTADDRESS WHERE COUNTRY = ?
    //http://localhost:8080/address/native-sql
    @GetMapping("/native-sql")
    public ResponseEntity<List<Address>> getAddressByCountryName(@RequestParam("country") String country){
      return ResponseEntity.ok(addressService.getAddressByCountry(country));
    }

    @GetMapping("/sql")
    public List<Address> getAddressByCountryAndState(@RequestParam("country") String country,
                                                     @RequestParam("state") String state){
        return addressService.getAddressByCountryAndState(country,state);

    }

    //query methods
    @GetMapping("/query-method")
    public ResponseEntity<List<Address>> getAddressByCountryUsingQueryMethod (@RequestParam("country") String country){
        return ResponseEntity.ok(addressService.getAddressByCountryUsingQueryMethod(country));
    }
    @GetMapping("/query-method2")
    public ResponseEntity<List<Address>> getAddressByCountryAndStateUsingQueryMethod (@RequestParam("country") String country,
                                                                                      @RequestParam("state") String state){
        return ResponseEntity.ok(addressService.getAddressByCountryAndStateUsingQueryMethod(country,state));
    }
}
