package com.onclass.bootcamp.adapters.driven.jpa.mysql.adapter;

import com.onclass.bootcamp.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.DateException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.onclass.bootcamp.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.onclass.bootcamp.domain.model.Version;
import com.onclass.bootcamp.domain.spi.IVersionPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class VersionAdapter implements IVersionPersistencePort {
    private final IVersionRepository versionRepository;
    private final IBootcampRepository bootcampRepository;
    private final IVersionEntityMapper versionEntityMapper;

    @Override
    public void addVersion(Version version) {
        if (!bootcampRepository.existsById(version.getBootcamp().getId())) {
            throw new NotFoundException("No registered bootcamp found with id " + version.getBootcamp().getId());
        }

        LocalDate startDate = version.getStartDate();
        LocalDate endDate = version.getEndDate();

        if (endDate.isBefore(startDate)) {
            throw new DateException("End date cannot be less than the start date");
        }

        versionRepository.save(versionEntityMapper.toEntity(version));
    }

    @Override
    public List<Version> getAllVersions(Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        String direction = isAscending ? "ASC" : "DESC";
        Pageable sortedPagination;

        if (orderByMaxQuota) {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "maxNumOfStudents"));
        } else if (orderByStartDate) {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "startDate"));
        } else {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "bootcamp.name"));
        }

        Page<VersionEntity> versionsPage = versionRepository.findAll(sortedPagination);
        List<VersionEntity> versions = versionsPage.getContent();

        return versionEntityMapper.toModelList(versions);
    }

    @Override
    public List<Version> getByBootcampId(Long bootcampId, Integer page, Integer size, boolean isAscending, boolean orderByStartDate, boolean orderByMaxQuota) {
        String direction = isAscending ? "ASC" : "DESC";
        Pageable sortedPagination;

        if (orderByMaxQuota) {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "maxNumOfStudents"));
        } else if (orderByStartDate) {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "startDate"));
        } else {
            sortedPagination = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "bootcamp.name"));
        }

        Page<VersionEntity> versionsPage = versionRepository.findByBootcampId(bootcampId, sortedPagination);
        List<VersionEntity> versions = versionsPage.getContent();

        if (versions.isEmpty()) {
            throw new NotFoundException("No versions found for bootcamp with ID: " + bootcampId);
        }

        return versionEntityMapper.toModelList(versions);
    }
}