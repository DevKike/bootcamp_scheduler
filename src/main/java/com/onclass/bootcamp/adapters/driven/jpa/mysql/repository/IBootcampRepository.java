package com.onclass.bootcamp.adapters.driven.jpa.mysql.repository;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.BootcampEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IBootcampRepository extends JpaRepository<BootcampEntity, Long> {
    Optional<BootcampEntity> findByName(String name);
    Optional<BootcampEntity> findById(Long id);

    @Query("SELECT c FROM BootcampEntity c ORDER BY SIZE(c.capacities) ASC")
    Page<BootcampEntity> findAllWitchCapacitiesOrderByAsc(Pageable pageable);

    @Query("SELECT c FROM BootcampEntity c ORDER BY SIZE(c.capacities) DESC")
    Page<BootcampEntity> findAllWitchCapacitiesOrderByDesc(Pageable pageable);
}