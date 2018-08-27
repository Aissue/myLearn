package main;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {

    public static void main(String[] args) {
        Connection conn = test();
        String sql = "select * from gsj_hj_hz_an_baseinfo_valid a where a.REGNO = ''";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            int col = rs.getMetaData().getColumnCount();
            System.out.println("============================");
            while (rs.next()) {
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i) + "\t");
                    if ((i == 2) && (rs.getString(i).length() < 8)) {
                        System.out.print("\t");
                    }
                }
                System.out.println("");
            }
            System.out.println("============================");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static Connection test(){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://59.202.43.142:3306/yscredit?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
        String username = "yscredit";
        String password = "Yscredit4321";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
