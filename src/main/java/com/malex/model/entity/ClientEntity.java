package com.malex.model.entity;

import lombok.Data;

@Data
public class ClientEntity {

    private Long id;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String info;
}
