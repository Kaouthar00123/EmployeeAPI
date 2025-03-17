package net.learning.ems.service;

import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto empdto);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long employeeId);
    EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto empsto);
    void deleteEmployeeById(Long employeeId);
}
