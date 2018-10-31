package com.biziitech.mlfm;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;

public class IdGenerator implements IdentifierGenerator {
    //You can give any name to sequence be sure that you know how to use it.
    private final String DEFAULT_SEQUENCE_NAME = "hibernate_sequence";
    //private final String DEFAULT_SEQUENCE_NAME = "hib_sequence";

    /*
    * This method will generate custom id based on String followed by id
    * e.g. 20180900001 .
    * */
 

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		   Serializable result = null;
	        Connection connection = null;
	        Statement statement = null;
	        ResultSet resultSet = null;

	    
	        String year= String.valueOf(Year.now().getValue());
	        String month= String.format("%02d",Calendar.getInstance().get(Calendar.MONTH)+1);
	        try {
	            connection = session.connection();
	            statement = connection.createStatement();
	            try {
	                /*
	                * uncomment below line if you are using mysql and the sequence DOES NOT EXIST.
	                * As we all know MySql does not support sequence, instead there is AUTO INCREMENT
	                * if you are using other databases change SQL according to that
	                * e.g. Oracle: "SELECT "+sequenceName+".NEXTVAL FROM DUAL"
	                * PostgreSQL: "SELECT  NEXTVAL('+sequenceName+"')  
	                * */
	            	 statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
	                resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
	            } catch (Exception e) {

	                System.out.println("In catch, cause : Table is not available.");
	                // if sequence is not found then creating the sequence
	                // Below code is for MySql database you change according to your database
	                
	              //  statement.execute("CREATE table " + DEFAULT_SEQUENCE_NAME + " (next_val INT NOT NULL)");
	              //  statement.executeUpdate("INSERT INTO " + DEFAULT_SEQUENCE_NAME + " VALUES(0)");
	                //==> LAST_INSERT_ID(next_val+1)  -> this is inbuilt function of MySql so by using this we can achieve our custom sequence like auto increment
	                statement.executeUpdate("UPDATE " + DEFAULT_SEQUENCE_NAME + " SET next_val=LAST_INSERT_ID(next_val+1)");
	                resultSet = statement.executeQuery("SELECT next_val FROM  " + DEFAULT_SEQUENCE_NAME);
	                //e.printStackTrace();
	            }
	            if (resultSet.next()) {

	                int nextValue = resultSet.getInt(1);
	                String suffix = String.format("%05d", nextValue);
	                result = year.concat(month).concat(suffix);
	            //    System.out.println("Custom generated sequence is : " + result);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return Long.valueOf((String) result);
	}
}
