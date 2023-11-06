package com.example.questionprompt.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.questionprompt.model.ResEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ResRepository extends JpaRepository<ResEntity, Long> {
    // Define custom query methods if needed
}
