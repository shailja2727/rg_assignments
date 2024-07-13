package com.shailja.Employee_Spring_JDBC.Layers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee-jdbc")
public class EmployeeController {

   @Autowired
    private EmployeeServiceLayer employeeService;

   @GetMapping("/employees")
    public List<EmployeeModalLayer> getAllEmployees()
   {
       return employeeService.getAllEmployees();
   }

    @GetMapping("/employees/{id}")
    public EmployeeModalLayer getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/save")
    public void createEmployee(@RequestBody EmployeeModalLayer employee) {
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody EmployeeModalLayer employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
    }

}
