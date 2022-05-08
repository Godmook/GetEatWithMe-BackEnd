package com.geteatwithme.geteatwithme.Database;
import javax.sql.DataSource;
import java.sql.Connection;
public class UserDB {
    private DataSource dataSource;

    public void testConnection() {
        try(Connection con=dataSource.getConnection()){
            System.out.println("Maria DB 연동 성공 "+ con);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
