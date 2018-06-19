package com.alekseysamoylov.career.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "user")
@Data
@Accessors(chain = true)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
}
