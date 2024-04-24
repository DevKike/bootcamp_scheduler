package com.onclass.bootcamp.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class BootcampResponse {
    private final Long id;
    private final String name;
    private final String description;
    private List<CapacityWithoutDescriptionResponse> capacities;
}
