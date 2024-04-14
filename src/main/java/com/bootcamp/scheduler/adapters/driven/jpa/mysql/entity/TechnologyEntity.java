package com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "technology")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TechnologyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private Long id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "technologies", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CapacityEntity> capacities;
}