package com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

}
