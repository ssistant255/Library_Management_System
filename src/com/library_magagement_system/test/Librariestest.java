package com.library_magagement_system.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.library_Magament_system.dao.LibrariesDaoImpl;
import com.library_management_system.pojo.Libraries;
public class Librariestest 
{
	public static void main(String args[])
	{
		 int id,choice;
		 String name, address, city,state;
	     Long  contanct;
	     Libraries l=new Libraries();
	     LibrariesDaoImpl ld=new LibrariesDaoImpl();
			do
			{
				Scanner sc=new Scanner(System.in);
				System.out.println("1.Add Libraries\n2.Show Libraries\n3.Exit");
				System.out.println("Enter your choice[1-3]");
				choice=sc.nextInt();
				switch(choice)
				{
				case 1:
					System.out.println("Enter the name");
					name=sc.next();
					System.out.println("Enter the address");
					address=sc.next();
					System.out.println("Enter the city");
					city=sc.next();
					System.out.println("Enter the state");
					state=sc.next();
					System.out.println("Enter the contanct");
					contanct=sc.nextLong();
					l.setName(name);
					l.setAddress(address);
					l.setCity(city);
					l.setState(state);
					l.setContanct(contanct);
					boolean flag = ld.addLibraries(l);
			        if(flag==true)
			        {
			        	System.out.println("Libraries Added SuccessFully");
			        }
			        else
			        {
			        	System.out.println("Libraries Added Failed");
			        }
					break;
				case 2:
					List<Libraries> hd = new ArrayList<Libraries>();
					hd= ld.showLibraries();
					for(Libraries libraries : hd)
					{
						System.out.println(libraries.getId()+" "+libraries.getName()+" "+libraries.getAddress()+" "+libraries.getCity()+" "+libraries.getState()+" "+libraries.getContanct());
					}
					break;	
				case 3:
					System.out.println("Exit");
					break;
				}
			}while(choice<6);
	}
}