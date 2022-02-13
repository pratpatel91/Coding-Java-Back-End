package net.javaguides.springbootbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springbootbackend.model.Employee;

//1st parameter is employee
//2nd parameter is datatype of the primary key column
public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	Optional<Employee> findById(long id);
}
