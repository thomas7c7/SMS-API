package net.diyotech.student_management_system.repository;

import net.diyotech.student_management_system.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//JpaRepository is an inbuilt function from spring dta jpa dependency
public interface AddressRepository extends JpaRepository<Address, Long>{
    //native queries
    //: makes it dynamic
    @Query(value = "SELECT * FROM STUDENTADDRESS WHERE COUNTRY = :country", nativeQuery = true)
    public List<Address> getAddressByCountryUsingNativeSQL(String country);

    @Query(value = "SELECT * FROM STUDENTADDRESS WHERE COUNTRY = :country AND state = :state", nativeQuery = true)
    public List<Address> getAddressByCountryAndStateUsingNativeSQL(String country, String state);

    //Query Methods
    public List<Address> findAddressByCountry(String country);
    public List<Address> findAddressByCountryAndState(String country, String state);


}
