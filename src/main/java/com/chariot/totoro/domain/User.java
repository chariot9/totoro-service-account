package com.chariot.totoro.domain;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
public class User {

    @NotNull
    @Length(min = 3, max = 20)
    private String username;
    @NotNull
    @Length(min = 6, max = 30)
    private String password;
}
