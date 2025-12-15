package com.CRUD;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Category;

public class Category_Crud {
	private static	final SessionFactory session=new Configuration().configure().buildSessionFactory();
	private static	final Session openSession = session.openSession();
	//private static	final Transaction beginTransaction = openSession.beginTransaction();
	
//1
	public String saveCategory(Category category)
	{
		if (category!=null) {
			try {
				Transaction beginTransaction = openSession.beginTransaction();
				
				Category savedata=(Category) openSession.merge(category);
				
				beginTransaction.commit();
				System.out.println();
				return "Successfully saved data with Category id : "+savedata.getId();
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println();
				return "already exists";
			}	
			
		} else {
			System.out.println();
					return "Category cannot be null ";
		}			
	}
	
//2
	public Category fetchCategorybyid(int id)
	{
		return openSession.find(Category.class, id);
		
	}

//3
	public List<Category> fetchCategorieslist()
	{
		
		 List<Category> resultList = openSession.createQuery("From Category",Category.class).getResultList();
		 
		 if (resultList.isEmpty()) {
			 System.out.println();
			System.out.println("No Categories Found");
		}
		 else {
			 System.out.println();
			System.out.println("Categories Found "+resultList.size());
			
		}
		 
		 return resultList;
	}
	
	
//4
	public String updateCategorybyid(int id, String name)
	{
		
		Category category = openSession.find(Category.class, id);
		if (category!=null) {
			
			Transaction beginTransaction = openSession.beginTransaction();
			category.setName(name);
			openSession.merge(category);
			beginTransaction.commit();
			System.out.println();
			return "Category Updated Successfully to id "+category.getId();
		}
		else {
			System.out.println();
			return "Category could not update";
		}	
	}
	
	
//5
	public String deleteCategorybyid(int id)
	{
		Category category = openSession.find(Category.class, id);
		
		if (category!=null) {
			
			Transaction beginTransaction = openSession.beginTransaction();
			openSession.remove(category);
			beginTransaction.commit();
			System.out.println();
			return "Category Deleted Successfully";
			
		} else {
			System.out.println();
			return "Category is not Deleted";
		}
		
	}
	
//6
	public Category getLastSavedCategory()
	{
		List<Category> resultList = openSession.createQuery("From Category c ORDER BY c.id DESC").setMaxResults(1).getResultList();
		
		return resultList.isEmpty()? null : resultList.get(0);
		
	}
	
}
