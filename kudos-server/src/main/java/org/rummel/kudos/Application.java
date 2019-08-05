package org.rummel.kudos;

import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.entities.Pillar;
import org.rummel.kudos.repositories.EmployeeRepository;
import org.rummel.kudos.repositories.PillarRepository;
import org.rummel.kudos.service.KudosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(EmployeeRepository employeeRepository, KudosService kudosService, PillarRepository pillarRepository) {
        return (args) -> {
            // save a couple of employees
            createEmployees(employeeRepository);
            fetchAllEmployees(employeeRepository);

            // Send a Kudos
            Employee stan = employeeRepository.getOne(new Long(1));
            Employee steve = employeeRepository.getOne(new Long(2));
            Employee tony = employeeRepository.getOne(new Long(3));
            Employee pepper = employeeRepository.getOne(new Long(4));

            //2, 'People First', 'Values team members’ input and acknowledges each person’s contribution to the team.');
            Pillar valuesTeamMembers = pillarRepository.getOne(new Long(2));
            kudosService.sendKudos(stan, steve, valuesTeamMembers, "Steve values team members input and works great in a team");




            // Send another

            // Send another

            // Retrieve all the Kudos that Cap has received


            log.info("");

            // fetch an individual customer by ID
            employeeRepository.findById(1L)
                    .ifPresent(employee -> {
                        log.info("Employee found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(employee.toString());
                        log.info("");
                    });

            // fetch customers by last name
            log.info("Employee found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            employeeRepository.findByLastName("Rogers").forEach(rogers -> {
                log.info(rogers.toString());
            });
            // for (Employee bauer : employeeRepository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

    private void fetchAllEmployees(EmployeeRepository employeeRepository) {
        // fetch all customers
        log.info("Employees found with findAll():");
        log.info("-------------------------------");
        for (Employee employee : employeeRepository.findAll()) {
            log.info(employee.toString());
        }
    }

    private void createEmployees(EmployeeRepository employeeRepository) {
        employeeRepository.save(new Employee("Stan", "Lee", "stan@avengers.com"));
        employeeRepository.save(new Employee("Steve", "Rogers", "stan@avengers.com"));
        employeeRepository.save(new Employee("Tony", "Stark", "stan@avengers.com"));
        employeeRepository.save(new Employee("Pepper", "Potts", "stan@avengers.com"));
    }

}
