package sn.isi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rset;

    public void open() throws Exception {
        String url = "jdbc:mysql://localhost:3306/dbjdbc";
        String mysqluser = "root";
        String mysqlpassword = "";

        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, mysqluser, mysqlpassword);

    }
    public  void  close() throws Exception{
        if(conn != null){
            conn.close();
        }

    }
    //initialisation des requetes
    public void init(String sql) throws Exception{
        pst = conn.prepareStatement(sql);
    }

    // execution des requetes update
    public int executeUpdate() throws Exception{
        int ok = 0;
        ok = pst.executeUpdate();
        return ok;
    }
    //execution des requetes select
    public ResultSet executeSelect() throws Exception{
        rset = pst.executeQuery();
        return rset;
    }
    //getteur de pstm
    public PreparedStatement getPst() {
        return pst;
    }
}
