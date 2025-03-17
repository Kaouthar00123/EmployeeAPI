package net.learning.ems.mapper;

import net.learning.ems.dto.EmployeeDto;
import net.learning.ems.entity.Employee;

public class EmployeeMapper {
    public static Employee employeedtoToemployee(EmployeeDto empdto)
    {
        return new Employee( empdto.getId(), empdto.getFirstName(), empdto.getLastName(), empdto.getEmail() );
    }
    public static EmployeeDto employeeToemployeedto(Employee emp)
    {
        return new EmployeeDto( emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail() );
    }
}
