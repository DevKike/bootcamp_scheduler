package com.onclass.bootcamp.adapters.driving.http.controller;

import com.onclass.bootcamp.adapters.driving.http.dto.request.AddVersionRequest;
import com.onclass.bootcamp.adapters.driving.http.dto.response.VersionResponse;
import com.onclass.bootcamp.adapters.driving.http.mapper.IVersionRequestMapper;
import com.onclass.bootcamp.adapters.driving.http.mapper.IVersionResponseMapper;
import com.onclass.bootcamp.domain.api.IVersionServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/version")
@RequiredArgsConstructor
public class VersionRestControllerAdapter {
    private final IVersionServicePort versionServicePort;
    private final IVersionRequestMapper versionRequestMapper;
    private final IVersionResponseMapper versionResponseMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addVersion(@RequestBody AddVersionRequest request) {
        versionServicePort.addVersion(versionRequestMapper.addRequestToVersion(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<VersionResponse>> getAllVersions(@RequestParam Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        return ResponseEntity.ok(versionResponseMapper.toVersionResponseList(versionServicePort.getAllBy(page, size, isAscending, orderByStartDate, orderByMaxQuota)));
    }

    @GetMapping("/getBy/{bootcampId}")
    public ResponseEntity<List<VersionResponse>> getVersionsByBootcampId(@PathVariable Long bootcampId, @RequestParam Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        return ResponseEntity.ok(versionResponseMapper.toVersionResponseList(versionServicePort.getByBootcampId(bootcampId, page, size, isAscending, orderByStartDate, orderByMaxQuota)));
    }
}