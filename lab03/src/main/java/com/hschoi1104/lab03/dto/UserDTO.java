package com.hschoi1104.lab03.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class UserDTO {
    private int seq;
    private String name;
    private String country;
}
