package com.technologies.microservice.adapters.driving.http.controller;

import com.technologies.microservice.adapters.driving.http.dto.request.AddTechnologyRequest;
import com.technologies.microservice.adapters.driving.http.mapper.ITechnologyRequestMapper;
import com.technologies.microservice.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technology")
@RequiredArgsConstructor
public class TechnologyRestControllerAdapter {
    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addTechnology(@RequestBody AddTechnologyRequest request) {
        technologyServicePort.addTechnology(technologyRequestMapper.addRequestToTechnology(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
