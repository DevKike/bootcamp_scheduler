package com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.VersionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVersionRepository extends JpaRepository<VersionEntity, Long> {
}