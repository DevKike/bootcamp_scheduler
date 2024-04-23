package com.bootcamp.scheduler.adapters.driving.http.controller;

import com.bootcamp.scheduler.adapters.driving.http.dto.request.AddBootcampRequest;
import com.bootcamp.scheduler.adapters.driving.http.dto.response.BootcampResponse;
import com.bootcamp.scheduler.adapters.driving.http.mapper.IBootcampRequestMapper;
import com.bootcamp.scheduler.adapters.driving.http.mapper.IBootcampResponseMapper;
import com.bootcamp.scheduler.domain.api.IBootcampServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/bootcamp")
@RequiredArgsConstructor
public class BootcampRestControllerAdapter {
    private final IBootcampServicePort bootcampServicePort;
    private final IBootcampRequestMapper bootcampRequestMapper;
    private final IBootcampResponseMapper bootcampResponseMapper;

    @PostMapping("/add")
    public ResponseEntity<Void> addBootcamp(@RequestBody AddBootcampRequest request) {
        bootcampServicePort.addBootcamp(bootcampRequestMapper.addRequestToBootcamp(request));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{bootcampId}/add/capacities")
    public ResponseEntity<Void> addCapacitiesToBootcamp(@PathVariable Long bootcampId, @RequestBody Set<Long> capacitiesIds) {
        bootcampServicePort.associateCapacitiesWithBootcamp(bootcampId, capacitiesIds);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAllBootcamps")
    public ResponseEntity<List<BootcampResponse>> getAllBootcamps(@RequestParam Integer page, @RequestParam Integer size, @RequestParam(required = false, defaultValue = "false") boolean isAscending, @RequestParam(required = false, defaultValue = "false") boolean orderByCapCountAscending) {
        return ResponseEntity.ok(bootcampResponseMapper.toBootcampResponseList(bootcampServicePort.getAllBootcamps(page, size, isAscending, orderByCapCountAscending)));
    }
}