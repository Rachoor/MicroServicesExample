package net.javaguides.departmentservice.controller;

import net.javaguides.departmentservice.dto.DepartmentDTO;
import net.javaguides.departmentservice.entity.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/department")
public interface BaseController {

    @PostMapping
    public DepartmentDTO saveDepartment(@RequestBody DepartmentDTO departmentDTO);

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String code) ;
}
