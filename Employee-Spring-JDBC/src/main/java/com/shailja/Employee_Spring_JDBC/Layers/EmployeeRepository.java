package com.shailja.Employee_Spring_JDBC.Layers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final class EmployeeMapper implements RowMapper<EmployeeModalLayer> {
        public EmployeeModalLayer mapRow(ResultSet rs, int rowNum) throws SQLException {
            EmployeeModalLayer employee = new EmployeeModalLayer();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }

    public List<EmployeeModalLayer> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
    }

    public EmployeeModalLayer findEmployeeById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?", new EmployeeMapper(), id);
    }

    public int writeEmployeeToDB(EmployeeModalLayer employee) {
        return jdbcTemplate.update("INSERT INTO employee (name, department) VALUES (?, ?)",
                employee.getName(), employee.getDepartment());
    }

    public int updateEmployeeDetails(EmployeeModalLayer employee) {
        return jdbcTemplate.update("UPDATE employee SET name = ?, department = ? WHERE id = ?",
                employee.getName(), employee.getDepartment(), employee.getId());
    }

    public int deleteEmployeeById(int id) {
        return jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
    }
}
