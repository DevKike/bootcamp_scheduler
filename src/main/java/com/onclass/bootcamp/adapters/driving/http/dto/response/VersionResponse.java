package com.onclass.bootcamp.adapters.driving.http.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class VersionResponse {
    private final Long id;
    private final int maxNumOfStudents;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private final LocalDate startDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private final LocalDate endDate;

    private final FindVersionBootcamp bootcamp;
}