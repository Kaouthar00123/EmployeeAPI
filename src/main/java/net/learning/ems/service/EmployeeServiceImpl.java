package net.learning.ems.service;

import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.entity.Employee;
import net.learning.ems.exception.ResourceNotFoundException;
import net.learning.ems.mapper.EmployeeMapper;
import net.learning.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository emprepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto empdto) {
        Employee em = EmployeeMapper.employeedtoToemployee(empdto);
        return EmployeeMapper.employeeToemployeedto(emprepo.save(em));
    }

    @Override
    public List<EmployeeDto> getAllEmployees()
    {
        return (emprepo.findAll().stream().map((emp)->EmployeeMapper.employeeToemployeedto(emp))).collect(Collectors.toList());

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee resposnse =  emprepo.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));
        return EmployeeMapper.employeeToemployeedto(resposnse);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto empsto) {
        Employee resposnse =  emprepo.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        resposnse.setFirstName(empsto.getFirstName());
        resposnse.setLastName(empsto.getLastName());
        resposnse.setEmail(empsto.getEmail());

        return EmployeeMapper.employeeToemployeedto(emprepo.save(resposnse));
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        Employee resposnse =  emprepo.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        emprepo.deleteById(employeeId);
    }
}
