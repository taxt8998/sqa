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

    public int checkLogin(Employee employee){
        int kq = 0;
        String sql = "SELECT u.*,e.position FROM tbluser as u  JOIN tblemployee as e" +
                " WHERE u.username = ? AND u.role = 'employee'";
        try {
            PreparedStatement ps  = connection.prepareStatement(sql);
            ps.setString(1,employee.getUsername());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(employee.getPassword().equals(rs.getString("password"))){
                    employee.setPosition(rs.getString("position"));
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("u_name"));
                    employee.setRole(rs.getString("role"));
                    employee.setAddress(rs.getString("address"));
                    employee.setBirth(rs.getDate("birth"));
                    kq = 1;
                }
                // Sai mật khẩu
                else {
                    kq = 2;
                }
            }
            // Sai tên đăng nhập
            else {
                kq = 3;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kq;
    }
}
