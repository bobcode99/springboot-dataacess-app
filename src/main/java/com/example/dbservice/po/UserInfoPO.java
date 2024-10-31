package com.example.dbservice.po;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoPO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ipAddress;
}
