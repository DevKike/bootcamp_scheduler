package com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bootcamp")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BootcampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bootcamp_id")
    private Long id;

    private String name;

    private String description;
}