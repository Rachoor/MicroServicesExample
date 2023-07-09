package net.javaguides.departmentservice.service;

import net.javaguides.departmentservice.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO saveDepartment(DepartmentDTO departmentDTO);

    DepartmentDTO getDepartmentByCode(String code);
}
