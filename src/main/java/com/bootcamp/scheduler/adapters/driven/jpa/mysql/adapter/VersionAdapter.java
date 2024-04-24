package com.bootcamp.scheduler.adapters.driven.jpa.mysql.adapter;

import com.bootcamp.scheduler.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.DateException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.exception.NotFoundException;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.mapper.IVersionEntityMapper;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IBootcampRepository;
import com.bootcamp.scheduler.adapters.driven.jpa.mysql.repository.IVersionRepository;
import com.bootcamp.scheduler.domain.model.Version;
import com.bootcamp.scheduler.domain.spi.IVersionPersistencePort;
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
    public List<Version> getAllVersions(Integer page, Integer size, boolean isAscending) {
        String direction = isAscending ? "ASC" : "DESC";
        Pageable sortedPaginationByName = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(direction), "bootcamp.name"));

        Page<VersionEntity> versionsPage = versionRepository.findAll(sortedPaginationByName);
        List<VersionEntity> versions = versionsPage.getContent();

        return versionEntityMapper.toModelList(versions);
    }
}