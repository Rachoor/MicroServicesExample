package net.javaguides.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDTO {
    private EmployeeDto employeeDto;
    private DepartmentDTO departmentDTO;
}
