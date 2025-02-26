package net.diyotech.student_management_system.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.diyotech.student_management_system.entity.Address;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class User {

    @NotNull(message = "Username cannot be blank")//Username cannot be null
    @NotBlank
    private String username;

    @NotNull(message = "Password cannot be null.")
    @Length(min = 10, max = 50, message = "Password cannot be less than 10 characters.")//password cannot be less than 10 and more than 50 characters
    private String password;

    @Email(message = "Invalid email address.")//email has to be in correct format
    private String email;
    private List<String> hobbies;

    @Valid //validation for nested object
    private Address address; //nesting: object within an object

    public User() {
    }

    public User(String username, String password, String email, List<String> hobbies, Address address ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.hobbies = hobbies;
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", hobbies=" + hobbies +
                ", address=" + address +
                '}';
    }
}
