package com.bootcamp.scheduler.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CapacityWithoutDescriptionResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final List<TechnologyWithoutDescriptionResponse> technologies;
}
