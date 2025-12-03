import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.util.*;
import java.util.Scanner;


public class Atm_Simulation {
	
	
			private static final Atm_Simulation atm = null;
			private double accountNumber;
			private double mobileNumber;
			private int pin;
	
	
						public Atm_Simulation(double accountNumber,double mobileNumber, int pin ) {
							this.accountNumber=accountNumber;
							this.mobileNumber = mobileNumber;
							this.pin = pin;
						}
						public double getAccountNumber() {
					        return accountNumber;
					    }
					
					    public double getMobileNumber() {
					        return mobileNumber;
					    }
					
					    public int getPin() {
					        return pin;
					    }
					
						  
		    static double amount=0;
		    static double withdrawamount;
		    static double depositeamount;
	
						public static void functionalities() {
							Scanner sc = new Scanner(System.in);
							
							
							System.out.println(" Enter 1: Check Balence \n Enter 2: Deposite \n Enter 3: WithDraw \n Enter 4: Exit \n ");
							while(true) {
							
							int enter=sc.nextInt();
							
							
							
								
							switch(enter) {
							
							case 1:
							
							System.err.println("Your corrent balence : "+amount +"\n");
							
							System.out.println("\n Enter 0 to main menu \n Enter 4 to exit");
							break;
								
							case 2 :
					//		deposite
					
							System.out.println("Enter your deposite amount :");
							depositeamount=sc.nextDouble();
							if(depositeamount>0) {
							amount+=depositeamount;
							System.out.println("Your Deposite Successfully Completed..."+depositeamount);
							System.out.println("\n Enter 0 to main menu \n Enter 4 to exit");
							}else {
								System.err.println("\n Insufficient Balance \n");
								System.out.println(" Enter 0 to main menu \n Enter 4 to exit");
							}
							
							break;
							
							case 3 :
							
					//		Withdrawal
							
							System.out.println("Enter the withdrawal amount : ");
							withdrawamount = sc.nextDouble();
							if(withdrawamount<amount && withdrawamount>0) {
							amount-=withdrawamount;
							
							System.out.println("Transcation successfully Completed...\n");
							System.err.println("Your Remining Balance is : "+amount);
							
							System.out.println("\n Enter 0 to main menu \n Enter 4 to exit");
							}else {
								System.err.println("Insufficient Balance");
								System.out.println("\n Enter 0 to main menu \n Enter 4 to exit");
							}
							break;
							
							case 0 :
								
							functionalities();
							break;
							
							case 4 :
							
					//		Exit
							System.out.println(" Thanks for Using Our Services ");
							System.exit(0);
							break;
							}
							}
							
							
							
						}
	
	
						public static void creating() {
							Scanner sc=new Scanner(System.in);
							
							System.out.print(" Please Enter your Account Number : ");
							
							Double d=sc.nextDouble();
							
							System.out.print(" Enter Your Mobile number : ");
							
							double n=sc.nextDouble();
							
							System.out.print(" Create a Secret Pin. Note: Set 4 digits pin only : ");
							
							int p=sc.nextInt();
							String s=Integer.toString(p);
							if(s.length()!=4) {
								System.err.print("The number of charecters must be  4 digits :");
								
								p=sc.nextInt();
								
								String m=Integer.toString(p);
								if(m.length()!=4) {
									p=sc.nextInt();
								}
								
							}
							
							System.out.println("\n 			THANKS FOR CREATING YOUR ID			\n");
							
							Atm_Simulation atm= new Atm_Simulation(d, n, p);
							
							Atm_Simulation.login(atm);
								
						}
	// Login credentials information
	
						public static void login(Atm_Simulation atm) {
							Scanner sc=new Scanner(System.in);
							while(true) {
							try {
						        System.out.print("Please Enter your Mobile Number: ");
						        double phone = sc.nextDouble();
						        System.out.print("Please Enter Pin: ");
						        int password = sc.nextInt();
						        
						        if (atm.getMobileNumber() == phone && atm.getPin() == password) {
						            System.out.println("Login Successfull \n \n");
						            Atm_Simulation.functionalities();
						        } else {
						            System.err.println("Incorrect Mobile Number or Pin!");
						        }
					
						    } catch (InputMismatchException e) {
						        System.err.println(" Invalid input! Please enter only numbers for mobile and pin.");
						    } catch (Exception e) {
						        System.err.println(" An unexpected error occurred: " + e.getMessage());
						           
						    }
							}
							
						}
	// Main method Starting point
	
	
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("      ...Welcome to ATM... \n");
		
		while(true) {
		
		System.out.println(" Enter 1: To create a new ID \n Enter 2: To Login");
		
		int a=sc.nextInt();
		
		switch(a) {
		case 1: creating();
		case 2: login(atm);
		}
		}
		
	}
	

}

