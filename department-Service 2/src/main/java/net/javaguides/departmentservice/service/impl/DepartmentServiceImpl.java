package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

//        convert department DTO to department JPA entity
//        Department department = new Department(
//                departmentDTO.getId(),
//                departmentDTO.getDepartmentName(),
//                departmentDTO.getDepartmentDescription(),
//                departmentDTO.getDepartmentCode()
//        );

//        Department department = modelMapper.map(departmentDTO, Department.class);
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);

//        convert department JPA to department DTO
//        DepartmentDTO savedDepartmentDTO = new DepartmentDTO(
//                savedDepartment.getId(),
//                savedDepartment.getDepartmentName(),
//                savedDepartment.getDepartmentDescription(),
//                savedDepartment.getDepartmentCode()
//        );

//        DepartmentDTO savedDepartmentDTO = modelMapper.map(savedDepartment, DepartmentDTO.class);
        DepartmentDTO savedDepartmentDTO = DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return savedDepartmentDTO;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String code) {
        Department department =  departmentRepository.findByDepartmentCode(code);
//        DepartmentDTO  departmentDTO = new DepartmentDTO(
//                department.getId(),
//                department.getDepartmentName(),
//                department.getDepartmentDescription(),
//                department.getDepartmentCode()
//        );
//        DepartmentDTO departmentDTO = modelMapper.map(department, DepartmentDTO.class);
        DepartmentDTO departmentDTO = DepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return departmentDTO;
    }
}
