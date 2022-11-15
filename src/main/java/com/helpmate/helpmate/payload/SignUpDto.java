package com.helpmate.helpmate.payload;

import lombok.Data;

@Data
public class SignUpDto {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phoneNo;
}
