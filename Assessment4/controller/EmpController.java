package com.example.assessment4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.assessment4.dto.Empdto;
import com.example.assessment4.entity.Employee;
import com.example.assessment4.service.EmployeeService;

import jakarta.validation.Valid;

@Controller
public class EmpController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/viewall")
    public String viewall(Model model) {
        List<Employee> list = service.getAll();
        model.addAttribute("emps", list);
        return "viewall";
    }

    @GetMapping("/edit/{eid}")
    public String editEmp(@PathVariable Integer eid, Model model) {

        Employee emp = service.getById(eid);

        Empdto dto = new Empdto();
        dto.setEmpId(emp.getEmpId());
        dto.setEmpName(emp.getEmpName());
        dto.setEmpSal(emp.getEmpSal());
        dto.setEmpDoj(emp.getEmpDoj());
        dto.setDeptName(emp.getDeptName());

        model.addAttribute("emp", dto);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(
            @Valid @ModelAttribute("emp") Empdto dto,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "edit";
        }

        Employee emp = new Employee();
        emp.setEmpId(dto.getEmpId());
        emp.setEmpName(dto.getEmpName());
        emp.setEmpSal(dto.getEmpSal());
        emp.setEmpDoj(dto.getEmpDoj());
        emp.setDeptName(dto.getDeptName());

        service.save(emp);
        model.addAttribute("msg", "Employee Edited");
        return "redirect:/viewall";
    }
    
    @GetMapping("/delete/{eid}")
    public String deleteEmp(@PathVariable Integer eid, Model model,RedirectAttributes ra) {

        service.delete(eid);

        model.addAttribute("msg", "Employee Deleted");


        return "redirect:/viewall";
    }
}