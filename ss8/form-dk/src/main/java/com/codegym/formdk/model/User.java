package com.codegym.formdk.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "First Name Không được phép để trống")
    @Size(min = 5,max = 45 ,message = "FirstName phải ít nhất 5 lớn nhất là 45 ký tự ")
    private String firstName;
    @NotBlank(message = "Last Name không được phép để trống")
    @Size(min = 5,max = 45,message = "LastName phải ít nhất 5 lớn nhất là 45 ký tự ")
    private String lastName;
    @NotBlank(message="Phone không được phép để trống")
    @Pattern(regexp = "^\\d{10}$",message = "Phải nhập đủ 10 số")
    private String phoneNumber;
    @Min(value = 18,message = "Phải đủ 18 tuổi bạn nhé")
    private int age;
    @Email(message="phải đúng định dạng email vd:Name@gmail.com")
    private String email;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

}
