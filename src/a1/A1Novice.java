package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		

		Customer[] customerValues = new Customer[count];
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
		
		for ( int i = 0; i < customerValues.length; i++)
		{
			System.out.println(customerValues[i].initial + " " + customerValues[i].last + ": " + String.format("%.2f", customerValues[i].total));
		}
		
	}

}

class Customer{
	String initial = "";
	String last = "";
	double total = 0.0;
	
	
}
