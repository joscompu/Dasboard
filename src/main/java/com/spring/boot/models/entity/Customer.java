package com.spring.boot.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "customers")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lasName;
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date crateAt;

}
