package org.rummel.kudos.repositories;

import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.entities.Kudos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KudosRepository extends JpaRepository<Kudos, Long> {

}
