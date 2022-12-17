package milly.com.Employee.management.Controller;

import milly.com.Employee.management.Service.EmployeeService;
import milly.com.Employee.management.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>>getAllEmployees(){
        List<Employee>employees=employeeService.findAllEmployees();
        return new ResponseEntity<>( employees, HttpStatus.OK);
    }
    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") Long id){
        Employee employees=employeeService.findEmployeeById(id);
        return new ResponseEntity<>( employees, HttpStatus.OK);
    }
    @PostMapping("/addEmployee")
    public ResponseEntity<Employee>addEmployee (@RequestBody Employee employee){
        Employee employees=employeeService.addEmployee(employee);
        return new ResponseEntity<>( employees, HttpStatus.CREATED);
    }
    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee>updateEmployee(@RequestBody Employee employee) {
        Employee employees = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employees, HttpStatus.OK);

    }
    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<?>deleteEmployeeById(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

