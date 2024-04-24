package com.onclass.bootcamp.domain.model;

import java.time.LocalDate;

public class Version {
    private Long id;
    private Bootcamp bootcamp;
    private LocalDate startDate;
    private LocalDate endDate;
    private int maxNumOfStudents;

    public Version(Long id, Bootcamp bootcamp, LocalDate startDate, LocalDate endDate, int maxNumOfStudents) {
        this.id = id;
        this.bootcamp = bootcamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.maxNumOfStudents = maxNumOfStudents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bootcamp getBootcamp() {
        return bootcamp;
    }

    public void setBootcamp(Bootcamp bootcamp) {
        this.bootcamp = bootcamp;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getMaxNumOfStudents() {
        return maxNumOfStudents;
    }

    public void setMaxNumOfStudents(int maxNumOfStudents) {
        this.maxNumOfStudents = maxNumOfStudents;
    }
}
