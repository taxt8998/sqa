package dao;

import model.Employee;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO extends DAO{
    public EmployeeDAO() {
        super();
        System.out.println("EMPLOYEEDAO");
    }

    public boolean checkLogin(Employee employee){
        boolean kq = false;
        String sql = "SELECT u.*,e.position FROM tbluser as u  JOIN tblemployee as e" +
                " WHERE u.username = ? AND u.password = ? AND u.role = 'employee'";
        try {
            PreparedStatement ps  = connection.prepareStatement(sql);
            ps.setString(1,employee.getUsername());
            ps.setString(2,employee.getPassword());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                employee.setPosition(rs.getString("position"));
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("u_name"));
                employee.setRole(rs.getString("role"));
                employee.setAddress(rs.getString("address"));
                employee.setBirth(rs.getDate("birth"));
                kq = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kq;
    }
}
