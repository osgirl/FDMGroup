package com.fdmgroup.pool;

public class Main {
	
	public static void main(String[] args){
		ConnectionPool pool = new ConnectionPool();
		
		Connection conn1 = pool.getConnection();
		Connection conn2 = pool.getConnection();
		Connection conn3 = pool.getConnection();
		Connection conn4 = pool.getConnection();

		
	}

}
