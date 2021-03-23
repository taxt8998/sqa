/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DepositType;
import model.LoanType;

/**
 *
 * @author ASUS
 */
public class DepositTypeDAO extends DAO {

    public DepositTypeDAO() {
        super();
    }

    public ArrayList<DepositType> getAllDepositType() {
        ArrayList<DepositType> result = null;
        String sql = "{call getdeposit}";
        try {
            CallableStatement cs = connection.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                DepositType dt = new DepositType();
                dt.setId(rs.getInt("id"));
                dt.setName(rs.getString("deptype_name"));
                dt.setRate(rs.getDouble("rate"));
                dt.setDuration(rs.getInt("duration"));
                dt.setDescription(rs.getString("description"));

                result.add(dt);
            }

        } catch (SQLException e) {
            result = null;
            e.printStackTrace();
        }
        return result;
    }

    public boolean saveDepRate(ArrayList<DepositType> choseDep) {
        boolean kq = false;
        String sql_lock = "SELECT * FROM tbldeposittype WHERE id=? FOR UPDATE";
        String sql_update = "UPDATE tbldeposittype SET rate=? WHERE id=?";
        try {
            this.connection.setAutoCommit(false);
            for (int i = 0; i < choseDep.size(); i++) {
                PreparedStatement ps0 = connection.prepareStatement(sql_lock);
                ps0.setInt(1, choseDep.get(i).getId());
                ps0.execute();
                PreparedStatement ps1 = connection.prepareStatement(sql_update);
                ps1.setDouble(1, choseDep.get(i).getRate());
                ps1.setInt(2, choseDep.get(i).getId());
                ps1.executeUpdate();
            }
            this.connection.commit();//cmt dong nay ney chay che do JUnit test
            kq = true;
        } catch (SQLException e) {
            try {
                this.connection.rollback();//cmt dong nay ney chay che do JUnit test
            } catch (Exception ee) {
                kq = false;
                ee.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                this.connection.setAutoCommit(true);//cmt dong nay ney chay che do JUnit test
            } catch (Exception e) {
                kq = false;
                e.printStackTrace();
            }
        }

        return kq;
    }
}