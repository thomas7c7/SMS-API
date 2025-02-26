package net.diyotech.student_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "PERSON") //Renames table
//@Table(name = "PERSON1") //Renames table
@Table(name = "PERSON2") //many-to-many table name

//Person to address mapping so we have to do mapping in person entity to avoid duplications
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String firstName;
    private String lastName;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "person_address",
//            joinColumns = @JoinColumn(referencedColumnName = "personId"),
//    inverseJoinColumns = @JoinColumn(referencedColumnName = "addressId"))
//    private List<Address> addresses;


//    One to Many mapping
//    One person with many addresses
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "personId") //Adds personId column to addresses
    private List<Address> addresses;

    //One to One Mapping
    //One person with one address
//    @OneToOne(cascade = CascadeType.ALL) //if person table is updated, address table is updated as well
//    @JoinColumn(name = "fk_address_id") //connects person and address tables
//    private Address address;

}
