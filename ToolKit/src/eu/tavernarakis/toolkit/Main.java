package eu.tavernarakis.toolkit;

import java.util.Scanner;

public class Main {
	public static void main (String[] args){
		Scanner scanIn = new Scanner(System.in);
		
		System.out.println("-===== Tool Kit 2014 =====-");
		System.out.println("Write info to see available commends !.");
		System.out.print("Enter Your Choice: ");
		
		while(true){
			int port = 0;
			String input = scanIn.nextLine();
			
			if (input.equals("exit"))
				break;
			else if (input.equals("info")){
				System.out.println("-===== Tool Kit Available Commends =====-");
				System.out.println("Check AFM: afm");
				System.out.println("Check Crebit Card: cc");
				System.out.println("Check Website Status: site");
				System.out.println("Check Custom Ports: cport");
				System.out.println("Close The Program: exit");
				System.out.print("Enter Your Choice: ");
			} else if (input.equals("afm")){
				System.out.print("Enter Your AFM: ");
				input = scanIn.nextLine();
				
				boolean correctAFM = Core.checkAFM(input);
				if (correctAFM){
					System.out.println("AFM: " + input + " is Correct !.");
					System.out.print("Enter Your Choice: ");
				} else {
					System.out.println("AFM: " + input + " is Incorrect !.");
					System.out.print("Enter Your Choice: ");
				}
			} else if (input.equals("cc")){
				System.out.print("Enter Your Crebit Card Number: ");
				input = scanIn.nextLine();
				
				boolean correctCC = Core.checkCC(input);
				if (correctCC){
					System.out.println("Crebit Card: " + input + " is Correct !.");
					System.out.print("Enter Your Choice: ");
				} else {
					System.out.println("Crebit Card: " + input + " is Incorrect !.");
					System.out.print("Enter Your Choice: ");
				}
			} else if (input.equals("site")){
				System.out.print("Enter The Site You Want To Check: ");
				input = scanIn.nextLine();
				Core.CheckSite(input);
				System.out.print("Enter Your Choice: ");
			} else if (input.equals("cport")){
				System.out.print("Enter The IP:Port You Want To Check: ");
				input = scanIn.nextLine();
				Core.CheckCPort(input, port);
				System.out.print("Enter Your Choice: ");
			} else {
				System.err.println("Please Use The Right Commands !.");
				System.out.print("Enter Your Choice: ");
			}
		} 
		scanIn.close();
	}
}