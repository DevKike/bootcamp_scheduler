package com.technologies.microservice.adapters.driven.jpa.mysql.repository;

import com.technologies.microservice.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechnologyRepository extends JpaRepository<TechnologyEntity, Long> {

}
