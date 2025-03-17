package net.learning.ems.controller;

import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.exception.ResourceNotFoundException;
import net.learning.ems.service.EmployeeService;
import net.learning.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl empservice;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto empdto)
    {
        return new ResponseEntity<>(empservice.createEmployee(empdto), HttpStatus.CREATED) ;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees()
    {
        List<EmployeeDto> response = empservice.getAllEmployees();
        return ResponseEntity.ok(response);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId )
    {
        EmployeeDto response = empservice.getEmployeeById(employeeId);
        return ResponseEntity.ok(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto empdto )
    {
        EmployeeDto response = empservice.updateEmployeeById(employeeId, empdto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long employeeId )
    {
        empservice.deleteEmployeeById(employeeId);
        return ResponseEntity.ok("Emplyee succefully deleted");
    }
}
