package ShopManagment;

import java.io.IOException;
import java.util.Scanner;

import ProductManagment.ProductManagment;
import UserManagment.UserManagment;

public class Application {
	

	public static void main(String args[]) throws IOException
	{
		Scanner scan = new Scanner(System.in);
		boolean CanIKeepRunTheProgram = true;
		
		 System.out.println("**** WELCOME TO SHOP MANAGMENT ****");
			
			System.out.println(" Enter the login name : ");
			String login = scan.nextLine();
			System.out.println(" Enter the Password : ");
			String password = scan.nextLine();
			
			if(!UserManagment.validateUserandPassword(login, password))
			{
				System.out.println(" !!! Login Failed !!! Close The Application ");
				return;
			}
			
		while(CanIKeepRunTheProgram == true)
		{
			System.out.println(" *** WELCOME TO SHOP MANAGMENT *** ");
			System.out.println(" 1. User Managment ");
			System.out.println(" 2. Product Managment ");
			System.out.println(" 3. Quit ");
			
			int optionselectedbyuser = scan.nextInt();
			
			if(optionselectedbyuser == 1)
			{
				UserManagment.UserManagment();
				
			}
			else if(optionselectedbyuser == 2)
			{
			     ProductManagment.ProductManagment();
			}
			else if(optionselectedbyuser == 3)
			{
				break;
			}
		}
	}

	

}
