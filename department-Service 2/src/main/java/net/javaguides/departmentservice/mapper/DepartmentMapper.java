package net.javaguides.departmentservice.mapper;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DepartmentMapper {
    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    Department mapToDepartment(DepartmentDTO departmentDto);
    DepartmentDTO mapToDepartmentDto(Department department);
}
