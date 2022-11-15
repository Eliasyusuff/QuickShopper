package com.helpmate.helpmate.repository;

import com.helpmate.helpmate.entity.PersonalShopper;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PersonalShopperRepository extends JpaRepository<PersonalShopper, Long> {
    PersonalShopper findPersonalShopperByEmail(String email);
    Optional<PersonalShopper> findByEmail(String email);
    Boolean existsPersonalShopperByEmail(String email);

}
