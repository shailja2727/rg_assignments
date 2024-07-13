package com.shailja.Employee_Spring_JDBC.Layers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceLayer {

    @Autowired
     private EmployeeRepository employeerepo;


     public List<EmployeeModalLayer> getAllEmployees()
     {
        return employeerepo.getAllEmployees();
     }

    public EmployeeModalLayer getEmployeeById(int id) {
        return employeerepo.findEmployeeById(id);
    }

    public void saveEmployee(EmployeeModalLayer employee) {
        employeerepo.writeEmployeeToDB(employee);
    }

    public void updateEmployee(EmployeeModalLayer employee) {
        employeerepo.updateEmployeeDetails(employee);
    }

    public void deleteEmployee(int id) {
        employeerepo.deleteEmployeeById(id);
    }

}
