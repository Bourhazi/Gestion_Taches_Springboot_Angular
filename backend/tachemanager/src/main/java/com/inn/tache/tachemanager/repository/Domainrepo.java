package com.inn.tache.tachemanager.repository;

import com.inn.tache.tachemanager.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Domainrepo extends JpaRepository<Domain,Long> {
    List<Domain> findBynomContains(String keyword);
}
