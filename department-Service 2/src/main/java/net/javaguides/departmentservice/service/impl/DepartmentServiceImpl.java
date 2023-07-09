package net.javaguides.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.exception.DepartmentDuplicateException;
import net.javaguides.departmentservice.exception.DepartmentNotFoundException;
import net.javaguides.departmentservice.mapper.DepartmentMapper;
import net.javaguides.departmentservice.repository.DepartmentRepository;
import net.javaguides.departmentservice.service.DepartmentService;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
//    private ModelMapper modelMapper;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {

        Optional<Department> foundDepartment = departmentRepository.findByDepartmentCode(departmentDTO.getDepartmentCode());
        if(foundDepartment.isPresent()) {
            throw new DepartmentDuplicateException(departmentDTO.getDepartmentCode());
        }

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
        Department department = departmentRepository.findByDepartmentCode(code)
                .orElseThrow(()-> new DepartmentNotFoundException(code));


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
