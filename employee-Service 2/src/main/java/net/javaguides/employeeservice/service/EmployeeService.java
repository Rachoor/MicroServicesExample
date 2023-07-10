package net.javaguides.employeeservice.service;

import net.javaguides.employeeservice.dto.ApiResponseDTO;
import net.javaguides.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDTO getEmployeyById(Long employeId);
}
