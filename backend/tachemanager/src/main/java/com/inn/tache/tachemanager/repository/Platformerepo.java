package com.inn.tache.tachemanager.repository;


import com.inn.tache.tachemanager.model.Domain;
import com.inn.tache.tachemanager.model.Platforme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Platformerepo extends JpaRepository<Platforme,Long> {
    List<Platforme> findBynomContains(String keyword);
}
