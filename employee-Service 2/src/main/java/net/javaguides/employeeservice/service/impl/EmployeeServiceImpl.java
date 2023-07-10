package net.javaguides.employeeservice.service.impl;

import net.javaguides.employeeservice.dto.ApiResponseDTO;
import net.javaguides.employeeservice.dto.DepartmentDTO;
import net.javaguides.employeeservice.dto.EmployeeDto;
import net.javaguides.employeeservice.entity.Employee;
import net.javaguides.employeeservice.mapper.EmployeeMapper;
import net.javaguides.employeeservice.repository.EmployeeRepository;
import net.javaguides.employeeservice.service.APIClient;
import net.javaguides.employeeservice.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    Employee savedEmployee;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

//    @Autowired
//    private EmployeeMapper mapper;

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
//        Employee employee = mapper.mapToEmployee(employeeDto);

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
//        EmployeeDto savedEmployeeDto = mapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public ApiResponseDTO getEmployeyById(Long employeId) {
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
//        EmployeeDto employeeDto = mapper.mapToEmployeeDto(employee);

//        ResponseEntity<DepartmentDTO> responseEntity =  restTemplate.getForEntity(
//                "http://localhost:8080/api/department/"+ employee.getDepartmentCode(),
//                DepartmentDTO.class);

        //        DepartmentDTO departmentDTO = responseEntity.getBody();

//        DepartmentDTO departmentDTO =  webClient.get()
//                .uri("http://localhost:8080/api/department/"+ employee.getDepartmentCode())
//                .retrieve()
//                .bodyToMono(DepartmentDTO.class)
//                .block();

       DepartmentDTO departmentDTO =  apiClient.getDepartmentByCode(employee.getDepartmentCode());
        ApiResponseDTO apiResponseDTO = new ApiResponseDTO();
        apiResponseDTO.setEmployeeDto(employeeDto);
        apiResponseDTO.setDepartmentDTO(departmentDTO);

        return  apiResponseDTO;
    }
}
