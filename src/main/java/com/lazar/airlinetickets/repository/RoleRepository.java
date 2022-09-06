package com.lazar.airlinetickets.repository;


import com.lazar.airlinetickets.model.EnumRole;
import com.lazar.airlinetickets.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {

    Optional<Role> findByName(EnumRole name);
    Optional<Role> findById(Integer id);
}
