package com.inn.tache.tachemanager.model;

//import com.inn.tache.tachemanager.controllers.TacheRessource;
import com.inn.tache.tachemanager.enums.TachePriority;
import com.inn.tache.tachemanager.enums.TacheStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Tache implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(nullable = false,updatable = false)
    private Long id;
    private String nom;
    private Date Startdate;
    private Date Enddate;
    private Date Deliverydate;
    private String comments;
    private  String description;
    @Enumerated(EnumType.STRING)
    private TacheStatus status;
    @Enumerated(EnumType.STRING)
    private TachePriority priority;
    @ManyToOne
    private Domain domain;
    @ManyToOne
    private Platforme platforme;
    @ManyToOne
    private Type type;
}

