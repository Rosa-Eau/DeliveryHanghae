package com.example.demo.domain.common.signup.entity;


import com.example.demo.domain.common.signup.entity.enums.MemberRoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private String gender;

    @Column
    private String phoneNumber;

    @Column
    private String address;

    @Column
    @Enumerated(value = EnumType.STRING)
    private MemberRoleEnum auth;

}
