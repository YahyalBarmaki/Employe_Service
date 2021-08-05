package com.employe_service.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
public class Service implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nomService;
    @OneToMany(mappedBy = "service",fetch = FetchType.LAZY)
    private Collection<Employe> employe;

}
