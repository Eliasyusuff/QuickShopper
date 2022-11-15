package com.helpmate.helpmate.repository;

import com.helpmate.helpmate.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findLocationByLocalGovernmentArea (String LocalGovernmentArea);
    Boolean existsLocationByLocalGovernmentArea (String LocalGovernmentArea);
}
