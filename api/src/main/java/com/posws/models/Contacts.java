package com.posws.models;

import lombok.Data;

import java.util.List;

@Data
public class Contacts {
    private String name;
    private String email;
    private List<Phone> phones;
}
