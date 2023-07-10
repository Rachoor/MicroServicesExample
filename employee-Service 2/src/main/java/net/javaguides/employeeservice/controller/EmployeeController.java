package net.javaguides.employeeservice.controller;

import net.javaguides.employeeservice.dto.ApiResponseDTO;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements BaseController{
    @Autowired
    private EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto =  employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponseDTO> getEmployee(String id) {
        ApiResponseDTO apiResponseDTO = employeeService.getEmployeyById(Long.parseLong(id));
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }
}
