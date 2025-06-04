package it.revo.demo.entity;

import it.revo.demo.enums.GeneralStatus;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false, unique = true)
    private String Email;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GeneralStatus status;

}
