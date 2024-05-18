package com.inn.tache.tachemanager.service;

import com.inn.tache.tachemanager.dtos.DomainDTO;
import com.inn.tache.tachemanager.dtos.PlatformeDTO;
import com.inn.tache.tachemanager.dtos.tacheDTO;
import com.inn.tache.tachemanager.dtos.typeDTO;
import com.inn.tache.tachemanager.enums.TachePriority;
import com.inn.tache.tachemanager.enums.TacheStatus;
import com.inn.tache.tachemanager.exeption.DPTNotFoundExeption;
import com.inn.tache.tachemanager.exeption.tacheNotFoundExeption;
import com.inn.tache.tachemanager.mappers.TacheManagerMapperImp;
import com.inn.tache.tachemanager.model.Domain;
import com.inn.tache.tachemanager.model.Platforme;
import com.inn.tache.tachemanager.model.Tache;
import com.inn.tache.tachemanager.model.Type;
import com.inn.tache.tachemanager.repository.Domainrepo;
import com.inn.tache.tachemanager.repository.Platformerepo;
import com.inn.tache.tachemanager.repository.Tacherepo;
import com.inn.tache.tachemanager.repository.Typerepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class TacheServicesImp implements TacheServises {
    private Domainrepo domainrepo;
    private Platformerepo platformerepo;
    private Typerepo typerepo;
    private Tacherepo tacherepo;
    private TacheManagerMapperImp dtoMapper;
    @Override
    public DomainDTO savedomain(DomainDTO domainDTO) {
        log.info("saving new domain");
        Domain domaine = dtoMapper.fromDomainDTO(domainDTO);
        Domain savedDomaine =domainrepo.save(domaine);
        return dtoMapper.fromDomain(savedDomaine);
    }
    @Override
    public PlatformeDTO saveplatforme(PlatformeDTO platformeDTO) {
        log.info("saving new platforme");
        Platforme platforme = dtoMapper.fromplatformeDTO(platformeDTO);
        Platforme saveplatforme=platformerepo.save(platforme);
        return dtoMapper.fromplatforme(saveplatforme);
    }
    @Override
    public typeDTO savetype(typeDTO typeDTO) {
        log.info("saving new type");
        Type type = dtoMapper.fromtypeDTO(typeDTO);
        Type savetype=typerepo.save(type);
        return dtoMapper.fromtype(savetype);
    }

    /*@Override
    public tacheDTO savetache(Date Startdate, Date Enddate, String nom, String comments, String description, Long domain_id, Long platforme_id, Long type_id) throws DPTNotFoundExeption {
        Domain domaine=domainrepo.findById(domain_id).orElse(null);
        platforme platformee=platformerepo.findById(platforme_id).orElse(null);
        type typee=typerepo.findById(type_id).orElse(null);
        if(domaine==null || platformee==null || typee==null)
            throw new DPTNotFoundExeption("domain or platforme or type not found");
        tache tache=new tache();
        tache.setStartdate(Startdate);
        tache.setStartdate(Enddate);
        tache.setNom(nom);
        tache.setComments(comments);
        tache.setDescription(description);
        tache.setDeliverydate(new Date());
        tache.setStatus(TacheStatus.Canceled);
        tache.setPriority(TachePriority.Minor);
        tache.setDomain(domaine);
        tache.setPlatforme(platformee);
        tache.setType(typee);
        tache savetache = tacherepo.save(tache);
        return dtoMapper.fromtache(savetache);
    }*/

    @Override
    public tacheDTO savetache(tacheDTO tacheDTO) throws DPTNotFoundExeption {
        Domain domaine=domainrepo.findById(tacheDTO.getDomainedto().getId()).orElse(null);
        Platforme platformee=platformerepo.findById(tacheDTO.getPlatformdto().getId()).orElse(null);
        Type typee=typerepo.findById(tacheDTO.getTypedto().getId()).orElse(null);
        if(domaine==null || platformee==null || typee==null)
            throw new DPTNotFoundExeption("domain or platforme or type not found");
        Tache tache=dtoMapper.fromtacheDTO(tacheDTO);
        tache.setDeliverydate(new Date());
        tache.setStatus(TacheStatus.Canceled);
        tache.setPriority(TachePriority.Minor);
        tache.setDomain(domaine);
        tache.setPlatforme(platformee);
        tache.setType(typee);
        Tache savetache = tacherepo.save(tache);
        return dtoMapper.fromtache(savetache);
    }

    @Override
    public List<DomainDTO> ListDomain() {
        List<Domain> domains= domainrepo.findAll();
        List<DomainDTO> domainsDTO= domains.stream().map(dmn->dtoMapper.fromDomain(dmn)).collect(Collectors.toList());
        return domainsDTO;
    }

    @Override
    public List<PlatformeDTO> ListPlatforme() {
        List<Platforme> platformes=platformerepo.findAll();
        List<PlatformeDTO> platformeDTOS=platformes.stream().map(plt->dtoMapper.fromplatforme(plt)).collect(Collectors.toList());
        return platformeDTOS;
    }

    @Override
    public List<typeDTO> ListType() {
        List<Type> types=typerepo.findAll();
        List<typeDTO> typeDTOS=types.stream().map(typ->dtoMapper.fromtype(typ)).collect(Collectors.toList());
        return typeDTOS;
    }

    @Override
    public List<tacheDTO> ListTache() {
        List<Tache> taches=tacherepo.findAll();
        List<tacheDTO> tacheDTOS=taches.stream().map(tach->dtoMapper.fromtache(tach)).collect(Collectors.toList());
        return tacheDTOS;
    }

    @Override
    public tacheDTO getTache(Long tacheId) throws tacheNotFoundExeption {
        Tache gettache = tacherepo.findById(tacheId).orElseThrow(()->new tacheNotFoundExeption("tache not found"));
        return dtoMapper.fromtache(gettache);
    }

    @Override
    public DomainDTO getDomain(Long domainId) throws DPTNotFoundExeption {
        Domain domain = domainrepo.findById(domainId).orElseThrow(()->new DPTNotFoundExeption("domain not found"));
        return dtoMapper.fromDomain(domain);
    }
    @Override
    public PlatformeDTO getPlatforme(Long platformeId) throws DPTNotFoundExeption {
        Platforme platforme= platformerepo.findById(platformeId).orElseThrow(()->new DPTNotFoundExeption("platforme not found"));
        return dtoMapper.fromplatforme(platforme);
    }

    @Override
    public typeDTO gettype(Long typeId) throws DPTNotFoundExeption {
        Type type= typerepo.findById(typeId).orElseThrow(()->new DPTNotFoundExeption("type not found"));
        return dtoMapper.fromtype(type);
    }
    @Override
    public DomainDTO updatedomain(DomainDTO domainDTO) {
        log.info("updating domain");
        Domain domaine = dtoMapper.fromDomainDTO(domainDTO);
        Domain savedDomaine =domainrepo.save(domaine);
        return dtoMapper.fromDomain(savedDomaine);
    }

    @Override
    public PlatformeDTO updateplatforme(PlatformeDTO platformeDTO) {
        log.info("updating platforme");
        Platforme platforme = dtoMapper.fromplatformeDTO(platformeDTO);
        Platforme saveplatforme=platformerepo.save(platforme);
        return dtoMapper.fromplatforme(saveplatforme);
    }

    @Override
    public typeDTO updatetype(typeDTO typeDTO) {
        log.info("updating type");
        Type type = dtoMapper.fromtypeDTO(typeDTO);
        Type savetype=typerepo.save(type);
        return dtoMapper.fromtype(savetype);
    }
    @Override
    public tacheDTO updatetache(tacheDTO tacheDTO) throws DPTNotFoundExeption {
        Domain domaine=domainrepo.findById(tacheDTO.getDomainedto().getId()).orElse(null);
        Platforme platformee=platformerepo.findById(tacheDTO.getPlatformdto().getId()).orElse(null);
        Type typee=typerepo.findById(tacheDTO.getTypedto().getId()).orElse(null);
        if(domaine==null || platformee==null || typee==null)
            throw new DPTNotFoundExeption("domain or platforme or type not found");
        Tache tache=dtoMapper.fromtacheDTO(tacheDTO);
        tache.setDeliverydate(new Date());
        tache.setDomain(domaine);
        tache.setPlatforme(platformee);
        tache.setType(typee);
        Tache savetache = tacherepo.save(tache);
        return dtoMapper.fromtache(savetache);
    }

    @Override
    public void deletedomain(Long domainID){
        domainrepo.deleteById(domainID);
    }
    @Override
    public void deleteplatforme(Long platformeID){
        platformerepo.deleteById(platformeID);
    }
    @Override
    public void deletetype(Long typeID){
        typerepo.deleteById(typeID);
    }

    @Override
    public void deletetache(Long tacheID){
        tacherepo.deleteById(tacheID);
    }

    @Override
    public List<DomainDTO> searchDomain(String keyword){
        List<Domain> domains=domainrepo.findBynomContains(keyword);
        List<DomainDTO> domainDTOS= domains.stream().map(dom -> dtoMapper.fromDomain(dom)).collect(Collectors.toList());
        return domainDTOS;
    }
    public List<PlatformeDTO> searchPlatforme(String keyword){
        List<Platforme> platformes=platformerepo.findBynomContains(keyword);
        List<PlatformeDTO> platformeDTOS= platformes.stream().map(pla -> dtoMapper.fromplatforme(pla)).collect(Collectors.toList());
        return platformeDTOS;
    }

    public List<typeDTO> searchType(String keyword){
        List<Type> types=typerepo.findBynomContains(keyword);
        List<typeDTO> typeDTOS= types.stream().map(typ -> dtoMapper.fromtype(typ)).collect(Collectors.toList());
        return typeDTOS;
    }

    public List<tacheDTO> searchTache(String keyword){
        List<Tache> taches=tacherepo.findBynomContains(keyword);
        List<tacheDTO> tacheDTOS= taches.stream().map(tch -> dtoMapper.fromtache(tch)).collect(Collectors.toList());
        return tacheDTOS;
    }
}
