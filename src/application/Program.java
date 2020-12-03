package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of employee: ");
		int n = sc.nextInt();
		List <Employee> list = new ArrayList<>();
		
		for(int i = 1; i<=n;i++) {
			System.out.println("Employee #"+i+" data:");
			System.out.print("Outsourced (y/n)?: ");
			char resposta = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();
			if(resposta =='n') {
				Employee emp = new Employee(name, hours, valuePerHour);
				list.add(emp);
			}else {
				System.out.print("Additional charge: ");
				Double additionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge));
			}
			
		}
		
		System.out.println();
		System.out.println("PAYMENTS:");
		for(Employee emp:list) {
			System.out.println(emp.getName()+" - $"+String.format("%.2f", emp.payment()));	
	}
		
		
	sc.close();	

	}

}
