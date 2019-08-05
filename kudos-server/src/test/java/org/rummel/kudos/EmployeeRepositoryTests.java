package org.rummel.kudos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rummel.kudos.entities.Employee;
import org.rummel.kudos.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository customers;

    @Test
    public void testFindByLastName() {
        Employee employee = new Employee("first", "last", "emailAddress");
        entityManager.persist(employee);

        List<Employee> findByLastName = customers.findByLastName(employee.getLastName());

        assertThat(findByLastName).extracting(Employee::getLastName).containsOnly(employee.getLastName());
    }
}