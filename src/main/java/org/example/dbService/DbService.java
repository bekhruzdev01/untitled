package org.example.dbService;

import org.example.model.Result;

import java.sql.*;

public class DbService {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/first-db";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "root123";

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
    }

    public Result addCountry(String name,Result result) throws SQLException, ClassNotFoundException {
        CallableStatement cs = getConnection().prepareCall("{call add_country(?,?,?)}");
        cs.setString(1,name);

        cs.registerOutParameter(2, Types.VARCHAR);
        cs.registerOutParameter(3, Types.BOOLEAN);
        cs.execute();


        result.setMessage(cs.getString(2));
        result.setSuccess(cs.getBoolean(3));
        return result;
    }
    public void getCountry() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = getConnection().prepareStatement("select * from country");

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt(1) + " Name: ");
            System.out.println(rs.getString(2));
        }
    }
    public Result addRegion(String name, Integer countryid, Result result) throws SQLException, ClassNotFoundException {

        String query = "{call add_region(?,?,?,?)}";
        CallableStatement pS = getConnection().prepareCall(query);

        pS.setString(1, name);
        pS.setInt(2, countryid);

        pS.registerOutParameter(3, Types.VARCHAR);
        pS.registerOutParameter(4, Types.BOOLEAN);

        pS.execute();

        result.setMessage(pS.getString(3));
        result.setSuccess(pS.getBoolean(4));

        return result;

    }
    public Result editRegion(Integer id, String name, Integer countryId, Result result) throws SQLException, ClassNotFoundException {
        String query = "{call region(?,?,?,?,?)}";
        CallableStatement pS = getConnection().prepareCall(query);

        pS.setInt(1, id);
        pS.setString(2, name);
        pS.setInt(3, countryId);

        pS.registerOutParameter(4, Types.VARCHAR);
        pS.registerOutParameter(5, Types.BOOLEAN);

        pS.execute();
        result.setMessage(pS.getString(4));
        result.setSuccess(pS.getBoolean(5));

        return result;
    }

    public String deleteRegion(Integer id) throws SQLException, ClassNotFoundException {
        String query = "delete from region where id = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(query);
        preparedStatement.setInt(1, id);
        int delete = preparedStatement.executeUpdate();
        if (delete==1){
            return "success";
        }
        else{
            return "fail";
        }
    }
}
