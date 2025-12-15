package com.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Product;

public class Product_Crud {
	
	private static	final SessionFactory session=new Configuration().configure().buildSessionFactory();
	private static	final Session openSession = session.openSession();
	
	
//1	
	public String saveProduct(Product product)
	{
		if(product!=null)
		{
		try {
			Transaction beginTransaction = openSession.beginTransaction();
			Product saveData =(Product) openSession.merge(product);
			beginTransaction.commit();
			
			return "Product Inserted Successfully to id "+saveData.getId();
			
		} catch (Exception e) {
			e.printStackTrace();
			return " Product Already exist";
		}	
	}
		else {
			return " Product not saved";
		}
	}
	
	
//2
	public Product fetchproductbyid(int id)
	{
		return openSession.find(Product.class, id);
	}
	
	
//3 
	public String deleteproductbyid(int id)
	{
		Product product = openSession.find(Product.class, id);
		
		if (product!=null) {
			
			try {
				Transaction beginTransaction = openSession.beginTransaction();
				openSession.remove(product);
				beginTransaction.commit();
				
				return "Product Deleted Successfully ";
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "Product Does Not Deleted Successfully";
			}
			
			
			
		} else {
			return "Product Not Exist ";
		}
	}
	
//4
	public String updateProductName(String name,int id)
	{
		
		Product product = openSession.find(Product.class, id);
		
		if (product!=null) {
			
			try {
				Transaction beginTransaction = openSession.beginTransaction();
				product.setName(name);
				Product updateProduct = (Product) openSession.merge(product);
				beginTransaction.commit();
				return "Product Name Updated Successfully to id "+updateProduct.getId();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "Product Not Exist ";
			}			
		}
		else {
			return "Product Name Not Updated  ";
			
		}
	}
	
	
//5
	public String updateproductdetails(int id, Product product)
	{
		
	Product	new_product = openSession.find(Product.class, id);
		
	
		if (new_product!=null) {
			
			try {
				Transaction beginTransaction = openSession.beginTransaction();
				new_product.setName(product.getName());
				new_product.setPrice(product.getPrice());
				new_product.setDescription(product.getDescription());
				new_product.setCategory(product.getCategory());
				Product details_updated = (Product) openSession.merge(new_product);
				beginTransaction.commit();
				
				return "Product Details Uploaded Successfully to id "+details_updated.getId();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "Product Not Exist ";
			}			
			
			
		} else {
				return "Product Details Not Updated";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
