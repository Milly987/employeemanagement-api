package milly.com.Employee.management.Service;

import milly.com.Employee.management.Repository.EmployeeRepository;
import milly.com.Employee.management.exceptions.UserNotFoundException;
import milly.com.Employee.management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
            public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;

            }
            public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
            }
            public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();

            }
            public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
            }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }
    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById (id)
                .orElseThrow(()->new UserNotFoundException("User by id "+ id + "was not found"));
    }



}


