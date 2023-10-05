package UserManagment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserManagment {
	
	static ArrayList<User> al = new ArrayList(); 
	 static {
		 try {
			loadDataFromFileToArrayList();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public static void UserManagment() throws IOException
	{
		 Scanner scan = new Scanner(System.in);
		 boolean CanIKeepRunTheProgramn = true;
		 while(CanIKeepRunTheProgramn == true)
		 {
			 System.out.println(" *** WELCOME TO USER MANAGMENT ***");
			 System.out.println(" 1.Add User ");
			 System.out.println(" 2.Edit User ");
			 System.out.println(" 3.Search User ");
			 System.out.println(" 4.Delete User ");
			 System.out.println(" 5.Quit "); 			 
			 int optionselectedbyuser = scan.nextInt();
			 if(optionselectedbyuser == UserOption.Quit)
			 {
				File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\ShopManagment\\src\\UserManagment\\User.txt");
				
				FileWriter fr = new FileWriter(file , false);
				
				BufferedWriter br = new BufferedWriter(fr);
				
				for(User u1:al)
				{
					br.write(u1.user + "," +u1.login + "," +u1.password + "," +u1.role +"\n");
				}
				
				br.close();
				file=null;
				
				System.out.println(" !!! Program Closed !!! ");
				boolean CanIKeepRunTheProgram = false;
			 }
			 else if(optionselectedbyuser == UserOption.Add_User)
			 {
				 AddUser();
			 }
			 else if(optionselectedbyuser == UserOption.Search_User)
			 {
				 System.out.println(" Enter the user name to search : ");
				 scan.nextLine();
				 String searchuser = scan.nextLine();
				 Search(searchuser);
			 }
			 else if(optionselectedbyuser == UserOption.Edit_User)
			 {
				 System.out.println(" Enter the user name to edit : ");
				 scan.nextLine();
				 String edituser = scan.nextLine();
				 Edit(edituser);
			 }
			 else if(optionselectedbyuser == UserOption.Delete_User)
			 {
				 System.out.println(" Enter the user name to delete : ");
				 scan.nextLine();
				 String deleteuser = scan.nextLine();
				 Delete(deleteuser);
			 }
		 }
		System.out.println(" *** After While Loop *** ");
		for(int i=0;i<al.size();i++)
		{
			System.out.println(al.get(i).user);
			System.out.println(al.get(i).login);
			System.out.println(al.get(i).password);
			System.out.println(al.get(i).password1);
			System.out.println(al.get(i).role);
		}
	}
	 public static void AddUser()
	 {
		 Scanner  scan = new Scanner(System.in);
		 User u1 = new User();
		 System.out.println(" Enter the User Name : ");
		 u1.user = scan.nextLine();
		 System.out.println(" Enter the Login Name : ");
		 u1.login = scan.nextLine();
		 System.out.println(" Enter the Password : ");
		 u1.password = scan.nextLine();
		 System.out.println(" Enter the Confirm Password : ");
		 u1.password1 = scan.nextLine();
		 System.out.println(" Enter the User Role : ");
		 u1.role = scan.nextLine();
		 
		 al.add(u1);
	}
	public static void Search(String searchuser)
	{
		for(User u1:al)
		{
			if(u1.user.equalsIgnoreCase(searchuser))
			{
				System.out.println(u1.user);
				System.out.println(u1.login);
				System.out.println(u1.password);
				System.out.println(u1.password1);
				System.out.println(u1.role);
				return;
		  }
		}
		System.out.println(" USER NOT FOUND ");
	}
	public static void Edit(String edituser)
	{
		for(User u1:al)
		{
			if(u1.user.equalsIgnoreCase(edituser))
			{
				Scanner scan = new Scanner(System.in);
				System.out.println(" Editing User is : "+u1.user);
				
				System.out.println(" Enter the new use name : ");
				u1.user = scan.nextLine();
				System.out.println(" Enter the new login name : ");
				u1.login = scan.nextLine();
				System.out.println(" Enter the new password : ");
				u1.password = scan.nextLine();
				System.out.println(" Enter the new confirm password : ");
				u1.password1 = scan.nextLine();
				System.out.println(" Enter the new user role ");
				u1.role = scan.nextLine();
				
				System.out.println(" INFORMATION UPDATED ");
				return;
			}
		}
		System.out.println(" USER NOT FOUND ");
	}
	public static void Delete(String deleteuser)
	{
		Iterator<User>itr = al.iterator();
		while(itr.hasNext())
		{
			User u1 = itr.next();
			if(u1.user.equalsIgnoreCase(deleteuser))
			{
				itr.remove();
				System.out.println(" User "+u1.user+" has been deleted ");
				return;
			}
		}
	}
	public static void loadDataFromFileToArrayList() throws IOException
	{
		File file = new File("C:\\Users\\Mr Patil\\Desktop\\space\\ShopManagment\\src\\UserManagment\\User.txt");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br = new BufferedReader(fr);
		
		String line="";
		
		while((line = br.readLine())!=null)
		{
			User u1 = new User();
			
			String[] userDataArray = line.split(",");
			if(userDataArray.length>3)
			{
				u1.user = userDataArray[0];
				u1.login = userDataArray[1];
				u1.password = userDataArray[2];
				u1.role = userDataArray[3];
				
				al.add(u1);
			}
		}
		br.close(); // save
		fr.close();
		file= null;
	}
	public static boolean validateUserandPassword(String login ,String password)
	{
		 Iterator<User>itr = al.iterator();
		 while(itr.hasNext())
		 {
			 User u1 = itr.next();
			 if(u1.login.equalsIgnoreCase(login)&&u1.password.equalsIgnoreCase(password))
			 {
				 return true;
			 }
		 }
		 return false;
	 }


}
