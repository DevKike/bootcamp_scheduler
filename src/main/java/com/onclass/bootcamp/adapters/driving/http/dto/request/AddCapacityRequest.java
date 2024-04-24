package com.onclass.bootcamp.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddCapacityRequest {
    private final String name;
    private final String description;
}