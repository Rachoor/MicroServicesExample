package net.javaguides.employeeservice.service.impl;

import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    Employee savedEmployee;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
//        Employee employee = new Employee(
//                employeeDto.getId(),
//                employeeDto.getFirstName(),
//                employeeDto.getLastName(),
//                employeeDto.getEmail()
//        );
//        Employee employee = modelMapper.map(employeeDto, Employee.class);

        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        
        try {
             savedEmployee = employeeRepository.save(employee);
        }
        catch(DataIntegrityViolationException ex) {
            System.out.println(" user record already exist : " +ex.getMessage());
        }

//        EmployeeDto savedEmployeeDto = new EmployeeDto(
//                savedEmployee.getId(),
//                savedEmployee.getFirstName(),
//                savedEmployee.getLastName(),
//                savedEmployee.getEmail()
//        );

//        EmployeeDto savedEmployeeDto = modelMapper.map(savedEmployee, EmployeeDto.class);
        EmployeeDto savedEmployeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeyById(Long employeId) {
        Employee employee = employeeRepository.findById(employeId)
                    .orElseThrow(()-> new RuntimeException("Employee not found "));
//        EmployeeDto employeeDto = new EmployeeDto(
//                employee.getId(),
//                employee.getFirstName(),
//                employee.getLastName(),
//                employee.getEmail()
//        );

//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        EmployeeDto employeeDto = EmployeeMapper.MAPPER.mapToEmployeeDto(employee);


        return  employeeDto;
    }
}
