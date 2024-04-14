package com.bootcamp.scheduler.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TechnologyWithoutDescriptionResponse {
    private final Long id;
    private final String name;
}