package com.inn.tache.tachemanager.service;

import com.inn.tache.tachemanager.dtos.DomainDTO;
import com.inn.tache.tachemanager.dtos.PlatformeDTO;
import com.inn.tache.tachemanager.dtos.tacheDTO;
import com.inn.tache.tachemanager.dtos.typeDTO;
import com.inn.tache.tachemanager.exeption.DPTNotFoundExeption;
import com.inn.tache.tachemanager.exeption.tacheNotFoundExeption;

import java.util.List;

public interface TacheServises {
    //domain savedomain(domain domain);

    DomainDTO savedomain(DomainDTO domainDTO);

    PlatformeDTO saveplatforme(PlatformeDTO platformeDTO);
    typeDTO savetype(typeDTO typeDTO);

    tacheDTO savetache(tacheDTO tacheDTO) throws DPTNotFoundExeption;

    List<DomainDTO> ListDomain();
    List<PlatformeDTO> ListPlatforme();
    List<typeDTO> ListType();
    List<tacheDTO> ListTache();
    tacheDTO getTache(Long tacheId) throws tacheNotFoundExeption;

    DomainDTO getDomain(Long domainId) throws DPTNotFoundExeption;


    PlatformeDTO getPlatforme(Long platformeId) throws DPTNotFoundExeption;

    typeDTO gettype(Long typeId) throws DPTNotFoundExeption;

    DomainDTO updatedomain(DomainDTO domainDTO);

    PlatformeDTO updateplatforme(PlatformeDTO platformeDTO);

    typeDTO updatetype(typeDTO typeDTO);

    tacheDTO updatetache(tacheDTO tacheDTO) throws DPTNotFoundExeption;

    void deletedomain(Long domainID);

    void deleteplatforme(Long platformeID);

    void deletetype(Long typeID);

    void deletetache(Long tacheID);

    List<DomainDTO> searchDomain(String keyword);

    List<PlatformeDTO> searchPlatforme(String keyword);

    List<typeDTO> searchType(String keyword);
    List<tacheDTO> searchTache(String keyword);

}
