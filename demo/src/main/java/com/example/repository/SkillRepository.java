package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.SkillEntity;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
    
}
