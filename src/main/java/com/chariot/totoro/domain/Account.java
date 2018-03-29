package com.chariot.totoro.domain;

import lombok.Getter;
import lombok.Setter;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Trung Vu on 2018/03/29.
 */
@Document(collection = "accounts")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Account {

    @Id
    private String username;

    private Date lastSeen;
}
