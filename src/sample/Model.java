package sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model {
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

}
