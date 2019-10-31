package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface List_Repository  extends JpaRepository<List_Entity, Long>{


}

