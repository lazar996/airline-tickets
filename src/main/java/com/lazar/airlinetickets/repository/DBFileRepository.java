package com.lazar.airlinetickets.repository;

import com.lazar.airlinetickets.model.DataBaseFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DataBaseFile, String> {
}
