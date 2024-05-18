package com.inn.tache.tachemanager.dtos;

//import com.inn.tache.tachemanager.controllers.TacheRessource;
import com.inn.tache.tachemanager.enums.TachePriority;
import com.inn.tache.tachemanager.enums.TacheStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class tacheDTO implements Serializable {
    private Long id;
    private String nom;
    private Date Startdate;
    private Date Enddate;
    private Date Deliverydate;
    private String comments;
    private  String description;
    private TacheStatus status;
    private TachePriority priority;
    private DomainDTO domainedto;
    private PlatformeDTO platformdto;
    private typeDTO typedto;
}

