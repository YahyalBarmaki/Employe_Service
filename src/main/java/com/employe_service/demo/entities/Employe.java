package com.employe_service.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String adr;
    private String tel;
    @ManyToOne
    @JoinColumn()
    private Service service;
}
