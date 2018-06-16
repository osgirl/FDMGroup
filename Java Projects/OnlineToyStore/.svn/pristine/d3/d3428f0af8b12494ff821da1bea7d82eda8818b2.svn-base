package com.fdmgroup.toystore.DAOToJDBC;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.fdmgroup.toystore.Stock;

public class DAOToysJPA implements DAO<Stock>{
	private EntityManagerFactory emf;

	public DAOToysJPA(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	public EntityManager getEntityManager(){
		return emf.createEntityManager();
	}

	@Override
	public void create(Stock object){
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(object);
		et.commit();
		em.close();
	}

	@Override
	public Stock read(int id){
		Stock stock = new Stock();
		EntityManager em = getEntityManager();
		try{
			stock = em.find(Stock.class, id);
		}
		finally{
			em.close();
		}
		return stock;
	}

	@Override
	public void update(Stock object){
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		Stock existingStock = em.find(Stock.class, object.getProduct().getToy_id());
		try{
			if (existingStock != null){
				et.begin();
				existingStock.setProductName(object.getProductName());
				existingStock.setProductDesc(object.getProductDesc());
				existingStock.setProductPrice(object.getProductPrice());
				if(object.getProduct().isRecalled() == true){
					existingStock.setProductRecalled(true);
				}
				else 
					existingStock.setProductRecalled(true);
				et.commit();
			}
		}
		finally{
			em.close();
		}
	}

	@Override
	public void delete(Stock object){
		EntityManager em = getEntityManager();
		EntityTransaction et = em.getTransaction();
		Stock stock = em.find(Stock.class, object.getProduct().getToy_id());
		try{
			if (stock != null) {
				et.begin();
				em.remove(stock);
				et.commit();
			}
		}
		finally{
			em.close();
		}
	}
}