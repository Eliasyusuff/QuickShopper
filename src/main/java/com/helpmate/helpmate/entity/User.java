package com.helpmate.helpmate.entity;

import com.helpmate.helpmate.entity.enums.RoleType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNo;

    @OneToOne
    private Role role;



    public User(Long id, String firstname, String lastname, String email, String password, String phoneNo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
    }


    public User() {

    }
}
