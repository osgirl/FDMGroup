package com.fdmgroup.toystore.DAOToJDBC;

public interface DAO<T> {
	public void create(T object);
	public T read(int id);
	public void update(T object);
	public void delete(T object);
}