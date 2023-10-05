package ProductManagment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManagment {
	
	static ArrayList<Product> al = new ArrayList();
	public static void ProductManagment() throws IOException
	{
		loadDataFromFileToArrayList();
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunTheProgram = true;
		while(CanIKeepRunTheProgram == true )
		{
			System.out.println(" *** WELCOME TO PRODUCT MANAGMENT *** ");
			System.out.println(" 1.Add Product ");
			System.out.println(" 2.Edit Product ");
			System.out.println(" 3.Search Product ");
			System.out.println(" 4.Delete Product ");
			System.out.println(" 5.Quit ");
			
			int optionselectedbycustomer = scan.nextInt();
			if(optionselectedbycustomer == ProductOption.Quit)
			{
				File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\ShopManagment\\src\\ProductManagment\\Product.txt");
				
				FileWriter fw = new FileWriter(file);
				
				BufferedWriter bw = new BufferedWriter(fw);
				
				for(Product p1 : al)
				{
					bw.write(p1.name+" "+p1.id+" "+p1.category+" "+p1.quantity+","+p1.price+" \n");
				}
				bw.close();
				file=null;
				System.out.println(" !!! PROGRAM CLOSED !!! ");
				CanIKeepRunTheProgram = false;
			}
			else if(optionselectedbycustomer == ProductOption.Add_Product)
			{
				AddProduct();
			}
			else if(optionselectedbycustomer == ProductOption.Search_Product)
			{
				System.out.println(" Enter the product name to search : ");
				scan.nextLine();
				String searchproduct = scan.nextLine();
				Search(searchproduct);
			}
			else if(optionselectedbycustomer == ProductOption.Delete_Product)
			{
				System.out.println(" Enter the product name to delete : ");
				scan.nextLine();
				String deleteproduct = scan.nextLine();
			}
		}
		System.out.println(" *** After While Loop *** ");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).name);
			System.out.println(al.get(i).id);
			System.out.println(al.get(i).category);
			System.out.println(al.get(i).quantity);
			System.out.println(al.get(i).price);
		}
	}
	public static void AddProduct()
	{
		Scanner scan = new Scanner(System.in);
		Product p1 = new Product();
		
		System.out.println(" Enter the product name : ");
		p1.name = scan.nextLine();
		System.out.println(" Enter the product id : ");
		p1.id = scan.nextLine();
		System.out.println(" Enter the product category : ");
		p1.category = scan.nextLine();
		System.out.println(" Enter the product quantity : ");
		p1.quantity = scan.nextLine();
		System.out.println(" Enter the product price : ");
		p1.price = scan.nextLine();
		
		al.add(p1);
	}
	public static void Search(String searchproduct)
	{
		for( Product p1 : al)
		{
			if(p1.name.equalsIgnoreCase(searchproduct))
			{
				System.out.println(p1.name);
				System.out.println(p1.id);
				System.out.println(p1.category);
				System.out.println(p1.quantity);
				System.out.println(p1.price);
				return;
			}
		}
		System.out.println(" PRODUCT NOT FOUND ");
	}
	public static void Edit(String editproduct)
	{
		for(Product p1 : al)
		{
			if(p1.name.equalsIgnoreCase(editproduct))
			{
				Scanner scan = new Scanner(System.in);
				System.out.println(" Editing product is : "+p1.name);
				
				System.out.println(" Enter the new product name :");
				p1.name = scan.nextLine();
				System.out.println(" Enter the new product id : ");
				p1.id = scan.nextLine();
				System.out.println(" Enter the new product category : ");
				p1.category = scan.nextLine();
				System.out.println(" Enter the new product quantity : ");
				p1.quantity = scan.nextLine();
				System.out.println(" Enter the new product price : ");
				p1.price = scan.nextLine();
				
				System.out.println(" INFORMATION UPDATED ");
				return;
			}
		}
		System.out.println(" PRODUCT NOT FOUND ");
	}
	public static void Delete(String deleteproduct)
	{
		Iterator<Product>itr = al.iterator();
		while(itr.hasNext())
		{
			Product p1 = itr.next();
			if(p1.name.equalsIgnoreCase(deleteproduct))
			{
				itr.remove();
				System.out.println(" Product "+p1.name +" has been deleted ");
				return;
			}
		}
	}
    public static void loadDataFromFileToArrayList() throws IOException
    {
    	File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\ShopManagment\\src\\ProductManagment\\Product.txt");
    	
    	FileReader fr = new FileReader(file);
    	
    	BufferedReader br = new BufferedReader(fr);
    	
    	String line ="";
    	
    	while((line = br.readLine())!=null)
    	{
    		Product p1 = new Product();
    		
    		String[] productDataArray = line.split(",");
    		if(productDataArray.length>4)
    		{
    			p1.name = productDataArray[0];
    			p1.id = productDataArray[1];
    			p1.category = productDataArray[2];
    			p1.quantity = productDataArray[3];
    			p1.price = productDataArray[4];
    			
    			al.add(p1);
    		}
    	}
    	br.close();
    	fr.close();
    	file = null;
    }

}
