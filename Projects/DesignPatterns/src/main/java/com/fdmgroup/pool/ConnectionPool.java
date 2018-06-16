package com.fdmgroup.pool;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	
	int LIMIT = 3;
	int released = 0;
	
	List<Connection> connections = new ArrayList<Connection>();
	
	
	
	public Connection getConnection(){
		if(connections.size()>0){
			
			released = released + 1;
			System.out.println("Got connection from pool");
			return connections.get(0);
			
		} else if(released == LIMIT){
			
			System.err.println("Max no. of connections reached. Try again later");
			
		} else {
			released = released + 1;
			Connection conn = new Connection();
			System.out.println("Got connection from pool");
			return conn;			
		}		
		
		
		return null;
	}
	
	
	
	public void returnConnection(Connection conn){
		released = released - 1;
		connections.add(conn);
	}

}
