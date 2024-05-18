package com.inn.tache.tachemanager.repository;

import com.inn.tache.tachemanager.model.Domain;
import com.inn.tache.tachemanager.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Typerepo extends JpaRepository<Type,Long> {
    List<Type> findBynomContains(String keyword);
}
