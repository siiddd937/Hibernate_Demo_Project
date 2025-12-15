package com.Execution;

import java.util.Scanner;

import com.CRUD.Category_Crud;
import com.entity.Category;

public class Category_Execution {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome To Category !!");
		
		
		Category_Crud category_Crud = new Category_Crud();
		
		while(true) {

		System.out.println("enter 1 to save category");
		System.out.println("enter 2 to fetch category by id");
		System.out.println("enter 3 to fetch all categories");
		System.out.println("enter 4 to update category");
		System.out.println("enter 5 to delete category by id");
		System.out.println("enter 6 to exit");

		Scanner scanner=new Scanner(System.in);
		
		int mychoice = scanner.nextInt();
		
		switch (mychoice) {
		case 1:{
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			Category category=new Category();
			System.out.println("Enter the name of the Category");
			String name=scanner.next();
			category.setName(name);
			
			//to print the result
			String saveCategory = category_Crud.saveCategory(category);
			System.out.println("Entered Name is  "+saveCategory);
			
		}
			
			break;
			
		case 2:{
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("Enter Category ID to fetch");
			int nextInt = scanner.nextInt();
			Category fetchCategorybyid = category_Crud.fetchCategorybyid(nextInt);
			
			if (fetchCategorybyid !=null) {
				System.out.println("ID : "+fetchCategorybyid.getId());
				System.out.println("Name : "+fetchCategorybyid.getName());
			}
			else {
				System.out.println("Category Not Found");
			}
		}
		break;
		case 3:{
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			
			for(Category category:  category_Crud.fetchCategorieslist())
			{
				System.out.println();
				System.out.println();
				System.out.println("ID - "+category.getId()+" Name - "+category.getName()+" Product - "+category.getProducts() );
				System.out.println();
				System.out.println();
								
			}
		}
		break;
		case 4:{
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			
			
			System.out.println("Enter Category id");
			int nextInt = scanner.nextInt();
			
			System.out.println("Enter the name of the Category");
			String name=scanner.next();
			
			String updateCategorybyid = category_Crud.updateCategorybyid(nextInt, name);
			
			System.out.println("Category Name updated - "+updateCategorybyid);
			
			
		}
		break;
		case 5:{
			System.out.println();
			System.out.println("-------------------------------------");
			System.out.println();
			
			System.out.println("Enter Category id");
			int nextInt = scanner.nextInt();
			
			String deleteCategorybyid = category_Crud.deleteCategorybyid(nextInt);
			System.out.println("Category Deleted - "+deleteCategorybyid);
			
		}
		break;
		default: {
			System.out.println("Enter Correct Choice");
		}
			break;
		
		case 6: {
			System.out.println("Exiting the application. Goodbye!");
			return;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}
	}}


