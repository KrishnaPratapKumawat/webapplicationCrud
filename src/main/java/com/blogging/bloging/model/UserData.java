package com.blogging.bloging.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "userData")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "name", nullable = false, length = 40)
    @Size(min = 6,max = 39,message = "Name is mandatory")
    public String name;
    @Column(name = "number", nullable = false, length = 10)
    @Size(min = 10, max = 10, message = "mobile number should be 10 digit thi is store in encrypted our database")
    public String phNum;

    @Column(name = "password", nullable = false, length = 16)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$\n")
    public String password;

    @Column(name = "confirmPassword", nullable = false, length = 16)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$\n")
    public String confirmPassword;

    @Column(name = "createdDate", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    public LocalDate createdDate;

    @Column(name = "email", nullable = false)
    @Email(message = "Please provide a valid email address")
    public String email;

    @Column(name = "userName", nullable = false)
    @NotBlank(message = "userName is mandatory")
    public  String userName;

    public boolean delete;

}
