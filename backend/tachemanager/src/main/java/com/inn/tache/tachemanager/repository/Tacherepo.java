package com.inn.tache.tachemanager.repository;

import com.inn.tache.tachemanager.model.Platforme;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inn.tache.tachemanager.model.Tache;

import java.util.List;
import java.util.Optional;

public interface Tacherepo extends JpaRepository<Tache, Long> {
    //void deleteTacheById(Long id);

    //Optional<Tache> findTacheById(Long id);
    List<Tache> findBynomContains(String keyword);
}
