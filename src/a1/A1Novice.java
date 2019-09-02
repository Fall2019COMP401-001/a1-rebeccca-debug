package a1;

import java.util.Scanner;

public class A1Novice {
	/* Implementation of Item scanner.
	 * 
	 * Input - String containing the orders of Customers
	 * Output - Each Customer's first initial, last name,
	 * 			and total amount spent
	 * 
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		

		Customer[] customerValues = new Customer[count];
		
		/* 
		 * Loops through customers and saves their names and item info.
		 * Then, calculates the customer's total amount spent.
		 */
		for ( int i = 0; i < customerValues.length; i++)
		{
			customerValues[i] = new Customer();
			customerValues[i].initial = scan.next().substring(0,1) + ".";
			customerValues[i].last = scan.next();
			int numItems = scan.nextInt();
			for ( int j = 0; j < numItems; j++)
			{
				int itemsCount = scan.nextInt();
				scan.next();
				double cost = scan.nextDouble();
				customerValues[i].total += (itemsCount * cost);
			}
		}
		
		
		scan.close();
		
		/* Loops through each customer and prints their first
		 * initial, last name, and total amount spent.
		 */
		
		for ( int i = 0; i < customerValues.length; i++)
		{
			System.out.println(customerValues[i].initial + " " + customerValues[i].last + ": " + String.format("%.2f", customerValues[i].total));
		}
		
	}

}

/* Customer
 * Generic class for holding customers' qualities.
 *
 * Local variables:
 * String initial - Holds customer's first initial
 * String last - Holds customer's last name
 * double total - Holds customer's total amount spent
 * 
 */
class Customer{
	String initial = "";
	String last = "";
	double total = 0.0;
	
	
}
