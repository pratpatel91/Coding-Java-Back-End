package net.javaguides.springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import net.javaguides.springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	// dependency (EmployeeServiceImpl obj has-a employeeRepo obj)
	private EmployeeRepository dataAccessor;

	// constructor to inject dependency (EmployeeServiceImpl obj has-a employeeRepo
	// obj)
	public EmployeeServiceImpl(EmployeeRepository employeeRepo)
	{
		super();
		this.dataAccessor = employeeRepo;
	}

	@Override
	public void deleteEmployeeById(long id)
	{
		Optional<Employee> isEmployeeInDB = dataAccessor.findById(id);

		// checking to see if the employee with given id exists in the database
		if (isEmployeeInDB.isPresent())
		{   //if the employee exists in the DB then we can delete the employee
			//from the db
			Employee db_EmployeeObject = isEmployeeInDB.get();
			dataAccessor.delete(db_EmployeeObject);
		} else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee updateEmployeeById(Employee newState_EmployeeObject, long id)
	{
		Optional<Employee> isEmployeeInDB = dataAccessor.findById(id);

		// checking to see if the employee with given id exists in the database
		if (isEmployeeInDB.isPresent())
		{
			// updating the db state of employee object
			Employee overwrote_OldDBState_EmployeeObject = isEmployeeInDB.get();
			overwrote_OldDBState_EmployeeObject.setFirstName(newState_EmployeeObject.getFirstName());
			overwrote_OldDBState_EmployeeObject.setFirstName(newState_EmployeeObject.getLastName());
			overwrote_OldDBState_EmployeeObject.setFirstName(newState_EmployeeObject.getEmail());

			// saving the updated state of employee object back into the database
			dataAccessor.save(overwrote_OldDBState_EmployeeObject);
			return overwrote_OldDBState_EmployeeObject;

		} else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee getEmployeeById(long id)
	{
		Optional<Employee> retrievedDBRowObject = dataAccessor.findById(id);
		if (retrievedDBRowObject.isPresent())
		{
			return retrievedDBRowObject.get();
		} else
		{
			throw new ResourceNotFoundException("Employee", "Id", id);
		}
	}

	@Override
	public Employee saveEmployee(Employee employeeObject)
	{
		return dataAccessor.save(employeeObject);
	}

	@Override
	public List<Employee> getAllEmployees()
	{
		return dataAccessor.findAll();
	}
}
