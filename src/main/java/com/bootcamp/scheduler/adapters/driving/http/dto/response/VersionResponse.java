package com.bootcamp.scheduler.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class VersionResponse {
    private final Long id;
    private final int maxNumOfStudents;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final FindVersionBootcamp bootcamp;
}