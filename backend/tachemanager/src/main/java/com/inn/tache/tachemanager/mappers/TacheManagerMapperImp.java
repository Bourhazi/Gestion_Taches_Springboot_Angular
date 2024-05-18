package com.inn.tache.tachemanager.mappers;

import com.inn.tache.tachemanager.dtos.DomainDTO;
import com.inn.tache.tachemanager.dtos.PlatformeDTO;
import com.inn.tache.tachemanager.dtos.tacheDTO;
import com.inn.tache.tachemanager.dtos.typeDTO;
import com.inn.tache.tachemanager.model.Domain;
import com.inn.tache.tachemanager.model.Platforme;
import com.inn.tache.tachemanager.model.Tache;
import com.inn.tache.tachemanager.model.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TacheManagerMapperImp {
    public DomainDTO fromDomain(Domain domain){
        DomainDTO domainDTO=new DomainDTO();
        BeanUtils.copyProperties(domain, domainDTO);
        return domainDTO;
    }
    public Domain fromDomainDTO(DomainDTO domaindto){
        Domain domain=new Domain();
        BeanUtils.copyProperties(domaindto, domain);
        return domain;
    }

    public PlatformeDTO fromplatforme(Platforme platforme){
        PlatformeDTO platformeDTO=new PlatformeDTO();
        BeanUtils.copyProperties(platforme, platformeDTO);
        return platformeDTO;
    }

    public Platforme fromplatformeDTO(PlatformeDTO platformeDTO){
        Platforme platforme=new Platforme();
        BeanUtils.copyProperties(platformeDTO, platforme);
        return platforme;
    }

    public typeDTO fromtype(Type type){
        typeDTO typeDTO=new typeDTO();
        BeanUtils.copyProperties(type, typeDTO);
        return typeDTO;
    }

    public Type fromtypeDTO(typeDTO typeDTO){
        Type type=new Type();
        BeanUtils.copyProperties(typeDTO, type);
        return type;
    }

    public tacheDTO fromtache(Tache tache){
        tacheDTO tacheDTO=new tacheDTO();
        BeanUtils.copyProperties(tache, tacheDTO);
        tacheDTO.setDomainedto(fromDomain(tache.getDomain()));
        tacheDTO.setPlatformdto(fromplatforme(tache.getPlatforme()));
        tacheDTO.setTypedto(fromtype(tache.getType()));
        return tacheDTO;
    }

    public Tache fromtacheDTO(tacheDTO tacheDTO){
        Tache tache=new Tache();
        BeanUtils.copyProperties(tacheDTO, tache);
        tache.setDomain(fromDomainDTO(tacheDTO.getDomainedto()));
        tache.setPlatforme(fromplatformeDTO(tacheDTO.getPlatformdto()));
        tache.setType(fromtypeDTO(tacheDTO.getTypedto()));
        return tache;
    }
}
