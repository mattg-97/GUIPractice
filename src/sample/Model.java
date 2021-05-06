package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.PropertyPermission;

public class Model {
    int userid;
    double balance;
    boolean connected;
    Connection myConnection;
    public Model(){
        myConnection = SQLConnection.getConnection();
        if (myConnection == null){
            System.out.println("Connection Unsuccessful");
            //System.exit(1);
        } else {
            connected = true;
            System.out.println("Connection successful");
        }
    }
    public boolean isConnected(){
        return connected;
    }
    public boolean isLogin(String user, String pass) throws Exception{
        PreparedStatement statement = null;

        ResultSet rs = null;

        String query = "select * from userpass where username = ? and password = ?";

        try{
            statement = myConnection.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, pass);
            rs = statement.executeQuery();
            if (rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public int getUserid(String user, String pass){
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "select userid from userpass where username = ? and password = ?";
        try{
            statement = myConnection.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, pass);
            rs = statement.executeQuery();
            if (rs.next()){
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    public double returnBalance(int userId){
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "select * from finances where userid = ?";
        try {
            statement = myConnection.prepareStatement(query);
            statement.setInt(1, userId);
            rs = statement.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble(2);
            }
            return balance;
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return balance;
    }


}
