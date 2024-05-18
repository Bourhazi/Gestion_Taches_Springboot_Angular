
package com.inn.tache.tachemanager.controllers;

        import com.inn.tache.tachemanager.dtos.DomainDTO;
        import com.inn.tache.tachemanager.dtos.PlatformeDTO;
        import com.inn.tache.tachemanager.dtos.tacheDTO;
        import com.inn.tache.tachemanager.dtos.typeDTO;
        import com.inn.tache.tachemanager.exeption.DPTNotFoundExeption;
        import com.inn.tache.tachemanager.exeption.tacheNotFoundExeption;
        import com.inn.tache.tachemanager.repository.Domainrepo;
        import com.inn.tache.tachemanager.repository.Platformerepo;
        import com.inn.tache.tachemanager.repository.Tacherepo;
        import com.inn.tache.tachemanager.repository.Typerepo;
        import com.inn.tache.tachemanager.service.TacheServises;
        import lombok.AllArgsConstructor;
        import lombok.extern.slf4j.Slf4j;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
//@RequestMapping("/tache")

public class tacheManagerContoller {
    private TacheServises tacheService;
    private Domainrepo Domainrepo;
    private Platformerepo Platformerepo;
    private Typerepo Typerepo;
    private Tacherepo Tacherepo;

    @GetMapping("/domains")
    public List<DomainDTO> domains(){
        return tacheService.ListDomain();
    }
    @GetMapping("/domains/count")
    public ResponseEntity<Long> getDomainCount() {
        Long count = Domainrepo.count();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/domains/search")
    public List<DomainDTO> Searchdomains(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return tacheService.searchDomain(keyword);
    }

    @GetMapping("/domains/{id}")
    public DomainDTO getdomain(@PathVariable(name = "id") Long domainId) throws DPTNotFoundExeption {
        return tacheService.getDomain(domainId);
    }
    @PostMapping("/domains")
    public DomainDTO savedomain(@RequestBody DomainDTO domainDTO){
        return tacheService.savedomain(domainDTO);
    }

    @PutMapping("/domains/{domainId}")
    public DomainDTO updatedomain(@PathVariable Long domainId, @RequestBody DomainDTO domainDTO){
        domainDTO.setId(domainId);
        return tacheService.updatedomain(domainDTO);
    }

    @DeleteMapping("/domains/{id}")
    public void deletedomain(@PathVariable(name = "id") Long domainid){
        tacheService.deletedomain(domainid);
    }

    @GetMapping("/platforms")
    public List<PlatformeDTO> platforms(){
        return tacheService.ListPlatforme();
    }

    @GetMapping("/platforms/count")
    public ResponseEntity<Long> getPlatformCount() {
        Long count = Platformerepo.count();
        return ResponseEntity.ok(count);
    }
    @GetMapping("/platforms/search")
    public List<PlatformeDTO> Searchplatforms(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return tacheService.searchPlatforme(keyword);
    }
    @GetMapping("/platforms/{id}")
    public PlatformeDTO getplatforme(@PathVariable(name = "id") Long platformeId) throws DPTNotFoundExeption {
        return tacheService.getPlatforme(platformeId);
    }
    @PostMapping("/platforms")
    public PlatformeDTO saveplatforme(@RequestBody PlatformeDTO platformeDTO){
        return tacheService.saveplatforme(platformeDTO);
    }
    @PutMapping("/platforms/{platformeId}")
    public PlatformeDTO updateplatforme(@PathVariable Long platformeId, @RequestBody PlatformeDTO platformeDTO){
        platformeDTO.setId(platformeId);
        return tacheService.updateplatforme(platformeDTO);
    }
    @DeleteMapping("/platforms/{id}")
    public void deleteplatforme(@PathVariable(name = "id") Long platformeid){
        tacheService.deleteplatforme(platformeid);
    }

    @GetMapping("/types")
    public List<typeDTO> types(){
        return tacheService.ListType();
    }

    @GetMapping("/types/count")
    public ResponseEntity<Long> getTypeCount() {
        Long count = Typerepo.count();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/types/search")
    public List<typeDTO> Searchtypes(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return tacheService.searchType(keyword);
    }
    @GetMapping("/types/{id}")
    public typeDTO gettype(@PathVariable(name = "id") Long typeId) throws DPTNotFoundExeption {
        return tacheService.gettype(typeId);
    }
    @PostMapping("/types")
    public  typeDTO savetype(@RequestBody typeDTO typeDTO){
        return tacheService.savetype(typeDTO);
    }
    @PutMapping("/types/{typeId}")
    public  typeDTO updatetype(@PathVariable Long typeId,@RequestBody typeDTO typeDTO){
        typeDTO.setId(typeId);
        return tacheService.updatetype(typeDTO);
    }
    @DeleteMapping("/types/{id}")
    public void deletetype(@PathVariable(name = "id") Long typeid){
        tacheService.deletetype(typeid);
    }

    @GetMapping("/taches")
    public List<tacheDTO> Taches(){
        return tacheService.ListTache();
    }
    @GetMapping("/taches/count")
    public ResponseEntity<Long> getTacheCount() {
        Long count = Tacherepo.count();
        return ResponseEntity.ok(count);
    }
    @GetMapping("/taches/search")
    public List<tacheDTO> Searchtaches(@RequestParam(name = "keyword",defaultValue = "") String keyword){
        return tacheService.searchTache(keyword);
    }
    @GetMapping("/taches/{id}")
    public tacheDTO gettache(@PathVariable(name = "id") Long tacheId) throws tacheNotFoundExeption {
        return tacheService.getTache(tacheId);
    }
    @PostMapping("/taches")
    public  tacheDTO savetache(@RequestBody tacheDTO tacheDTO) throws DPTNotFoundExeption {
        return tacheService.savetache(tacheDTO);
    }

    @PutMapping("/taches/{tacheId}")
    public  tacheDTO updatetache(@PathVariable Long tacheId,@RequestBody tacheDTO tacheDTO) throws DPTNotFoundExeption {
        tacheDTO.setId(tacheId);
        return tacheService.updatetache(tacheDTO);
    }

    @DeleteMapping("/taches/{id}")
    public void deletetache(@PathVariable(name = "id") Long tacheid){
        tacheService.deletetache(tacheid);
    }
}



