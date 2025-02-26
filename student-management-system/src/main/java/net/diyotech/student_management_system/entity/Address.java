package net.diyotech.student_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Entity //Creates a table in mySQL
//@Table(name = "ADDRESS") //one to one table name
//@Table(name = "ADDRESS1") //one to many table
@Table(name = "ADDRESS2") //many-to-many table name
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Address {

    @Id //Indicates Primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increments ID values
    private Long addressID;

//    @NotBlank(message = "Country cannot be blank")
    private String country;

//    @NotBlank(message = "State cannot be blank")
    private String state;

    @Column(name = "cityName") //renames column in sql
    private String city;

    @Min(value = 20,message = "zip code cannot be blank")
//    @Transient //Doesn't include this as a column in sql
    private Integer zipCode;

    private String streetName;

    @ManyToMany(mappedBy = "addresses") //Checks the "addresses" field in "Person" class and establishes relation
    private List<Person> persons;

// mapAddressDtoToAddress
    public Address(Long addressId, String country, String state) {
        this.addressID = addressId;
        this.country = country;
        this.state = state;
    }
}
