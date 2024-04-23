package com.bootcamp.scheduler.adapters.driving.http.controller;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddVersionRequest;
import com.bootcamp.scheduler.adapters.driving.http.mapper.IVersionRequestMapper;
import com.bootcamp.scheduler.domain.api.IVersionServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionRestControllerAdapter {
    private final IVersionServicePort versionServicePort;
    private final IVersionRequestMapper versionRequestMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addVersion(@RequestBody AddVersionRequest request) {
        versionServicePort.addVersion(versionRequestMapper.addRequestToVersion(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}