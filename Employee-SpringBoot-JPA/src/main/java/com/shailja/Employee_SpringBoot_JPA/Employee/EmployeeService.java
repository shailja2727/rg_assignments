package com.shailja.Employee_SpringBoot_JPA.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeerepo;



    public List<Employee> getEmployees()
    {
        return employeerepo.findAll();
    }

    public Optional<Employee> getEmployeeById(int id)
    {
        return employeerepo.findById(id);
    }

    public Employee writeEmployee(Employee employee)
    {
        return employeerepo.save(employee);
    }

    public Employee updateEmployee(int id,Employee employee_updated_details)
    {
        Employee employee = employeerepo.findById(id).orElseThrow();
        employee.setName(employee_updated_details.getName());
        employee.setDepartment(employee_updated_details.getDepartment());
        return employeerepo.save(employee);
    }

    public void deleteEmployee(int id)
    {
        employeerepo.deleteById(id);
    }
}
