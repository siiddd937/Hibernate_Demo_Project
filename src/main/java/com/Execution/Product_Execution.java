package com.Execution;

import java.util.Scanner;

import com.CRUD.Category_Crud;
import com.CRUD.Product_Crud;
import com.entity.Category;
import com.entity.Product;

public class Product_Execution {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Products !!");
		
			Product_Crud product_Crud = new Product_Crud();
			
		
			while(true)
			{
			System.out.println("enter 1 to save product");
			System.out.println("enter 2 to fetch product by id");
			System.out.println("enter 3 to delete product by id");
			System.out.println("enter 4 to update product name by id");
			System.out.println("enter 5 to update product details by id");
			System.out.println("enter 6 to exit");
		
			Scanner scanner=new Scanner(System.in);
			
			int mychoice = scanner.nextInt();
			
			switch (mychoice) {
			case 1:
			{
				
				Product product = new Product();
				Category_Crud category_Crud = new Category_Crud();
				
				System.out.print("Enter Product Name - ");
				String name = scanner.next();
				System.out.println("Enter Product Description - ");
				String description = scanner.next();
				System.out.println("Enter Product Price - ");
				int price = scanner.nextInt();
				
				
				product.setName(name);
				product.setPrice(price);
				product.setDescription(description);
				
				Category lastSavedCategory = category_Crud.getLastSavedCategory();
				
				if (lastSavedCategory!=null) {
					product.setCategory(lastSavedCategory);
				}
				else {
					System.out.println("No Category Found, Add Category");
					continue;
				}
				
				String saveProduct = product_Crud.saveProduct(product);
				System.out.println("Product saved with id - "+saveProduct);
			}
				
				break;
			case 2:
			{
				System.out.println();
				
				System.out.println("Enter ID : ");
				int nextInt = scanner.nextInt();
				Product fetchproductbyid = product_Crud.fetchproductbyid(nextInt);
				
				if (fetchproductbyid != null) {
					System.out.println("ID - "+fetchproductbyid.getId()+"Name - "+fetchproductbyid.getName()+"Description - "+fetchproductbyid.getDescription()+"Price - "+fetchproductbyid.getPrice()+"Category - "+fetchproductbyid.getCategory());
					
					
				} else {
					System.out.println("Not Found");
				}
				
			}
				break;
			case 3:
			{
				System.out.println();
				
				System.out.println("Enter ID : ");
				int nextInt = scanner.nextInt();
				
				String deleteproductbyid = product_Crud.deleteproductbyid(nextInt);
				System.out.println("Deleted Product id - "+deleteproductbyid);
				
			}
				break;
			case 4:
			{
				System.out.println("Enter ID : ");
				int nextInt = scanner.nextInt();
				
				System.out.print("Enter Product Name - ");
				String name = scanner.next();
				
				String updateProductName = product_Crud.updateProductName(name, nextInt);
				System.out.println("Product Updated "+updateProductName);
				
			}
				break;
			case 5:
			{
				
				
				System.out.println("Enter ID : ");
				int nextInt = scanner.nextInt();
				
				Product fetchproductbyid = product_Crud.fetchproductbyid(nextInt);
				if (fetchproductbyid!=null) {
					
					System.out.println("Current Product Details "+fetchproductbyid);
					
					System.out.println("Enter Product Name - ");
					String name = scanner.next();
					System.out.println("Enter Product Description - ");
					String description = scanner.next();
					System.out.println("Enter Product Price - ");
					int price = scanner.nextInt();
					
					
					fetchproductbyid.setName(name);
					fetchproductbyid.setPrice(price);
					fetchproductbyid.setDescription(description);
					
					
					String updateproductdetails = product_Crud.updateproductdetails(nextInt, fetchproductbyid);
					System.out.println("Product Updated - "+updateproductdetails);
					
					
					
					
					
					
					
					
					
					
				} else {

				}
				
				
				
				
				
				
			}
				break;
			case 6:
			{
				System.out.println("THanks to visit us!!");
				return;
			}
				

			default:
			{
				System.out.println("Please Enter Correct ID Again !");
			}
				break;
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	}
}
