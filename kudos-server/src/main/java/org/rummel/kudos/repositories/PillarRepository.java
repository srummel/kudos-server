package org.rummel.kudos.repositories;

import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.entities.Pillar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PillarRepository extends JpaRepository<Pillar, Long> {

}
