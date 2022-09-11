package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

    public Route findRouteById(Long id);
}
