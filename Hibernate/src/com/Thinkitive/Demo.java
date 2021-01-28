package com.Thinkitive;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		MyDBConnection d=new MyDBConnection();
		
//		d.insertEmployee();
//		d.selectEmployee();
//		d.updateEmployee();
		d.display();
		while(true) {
			
			System.out.println("Enter 1 to Insert");
			System.out.println("Enter 2 to Update");
			System.out.println("Enter 3 to Delete");
			System.out.println("Enter 4 to Display");
			System.out.println("Enter 5 to Select");
			System.out.println("Enter 6 to Exit");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice :");
			int ch = sc.nextInt();
			
			switch(ch) {
			
				case 1:
					System.out.println("Enter the empid, ename, salary");
					int empid = sc.nextInt();
					String ename = sc.next();
					int salary = sc.nextInt();
					d.insertEmployee(empid, ename, salary);
					break;
				case 2:
					d.updateEmployee();
					break;
				case 3:
					d.deleteEmployee();
					break;
				case 4:
					d.display();
					break;
				case 5:
					d.selectEmployee();
					break;
				case 6:
					System.exit(1);
			}
		}
	}
}
