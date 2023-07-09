package net.javaguides.departmentservice.controller;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import net.javaguides.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController implements BaseController{

    @Autowired
    private DepartmentService departmentService;


    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        return departmentService.saveDepartment(departmentDTO);
    }

    @Override
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(String code) {
        DepartmentDTO departmentDTO = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}

