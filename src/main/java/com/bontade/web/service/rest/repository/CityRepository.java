package com.bontade.web.service.rest.repository;

import com.bontade.web.service.rest.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by zarebaa on 19/05/2016.
 */
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByName(@Param("name") String name);
}
