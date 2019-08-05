package org.rummel.kudos.controller;


import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.entities.Kudos;
import org.rummel.kudos.entities.Pillar;
import org.rummel.kudos.repositories.EmployeeRepository;
import org.rummel.kudos.repositories.KudosRepository;
import org.rummel.kudos.repositories.PillarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class KudosController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PillarRepository pillarRepository;

    @Autowired
    KudosRepository kudosRepository;

    @PostMapping("/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        employee = employeeRepository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> retrieveEmployee(@RequestParam(value = "employeeId", required = false) long employeeId) {
        Optional<Employee> response = employeeRepository.findById(employeeId);
        Employee employee = null;
        if(response.isPresent()) {
            employee = response.get();
        } else {
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/pillar")
    public ResponseEntity<Pillar> savePillar(@RequestBody Pillar pillar) {

        pillar = pillarRepository.save(pillar);
        return new ResponseEntity<>(pillar, HttpStatus.OK);
    }

    @GetMapping("/pillar")
    public ResponseEntity<Pillar> retrievePillar(@RequestParam(value = "pillarId", required = false) long pillarId) {
        Optional<Pillar> response = pillarRepository.findById(pillarId);
        Pillar pillar = null;
        if(response.isPresent()) {
            pillar = response.get();
        } else {
        }
        return new ResponseEntity<>(pillar, HttpStatus.OK);
    }
    @PostMapping("/kudos")
    public ResponseEntity<Kudos> send(@RequestBody Kudos kudos) {
        kudos = kudosRepository.save(kudos);
        return new ResponseEntity<>(kudos, HttpStatus.OK);
    }

    @GetMapping("/kudos/findById/")
    public ResponseEntity<Kudos> retrieveKudos(@RequestParam(value = "kudosId", required = false) long kudosId) {
        Optional<Kudos> response = kudosRepository.findById(kudosId);
        Kudos kudos = null;
        if(response.isPresent()) {
            kudos = response.get();
        } else {
        }
        return new ResponseEntity<>(kudos, HttpStatus.OK);
    }

}
