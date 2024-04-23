package com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.CapacityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICapacityRepository extends JpaRepository<CapacityEntity, Long> {
    Optional<CapacityEntity> findByName(String name);
    Optional<CapacityEntity> findById(Long id);

    @Query("SELECT c FROM CapacityEntity c ORDER BY SIZE(c.technologies) ASC")
    Page<CapacityEntity> findAllWithTechnologiesOrderByAsc(Pageable pageable);

    @Query("SELECT c FROM CapacityEntity c ORDER BY SIZE(c.technologies) DESC")
    Page<CapacityEntity> findAllWithTechnologiesOrderByDesc(Pageable pageable);
}