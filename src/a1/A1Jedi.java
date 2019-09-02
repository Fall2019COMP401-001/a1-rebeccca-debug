package a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

public class A1Jedi {
	/* Implementation of Item scanner.
	 * 
	 * Input - String containing the orders of Customers
	 * Output - The number of customers that bought each Item
	 * 
	 */
	public static void main(String[] args) {
		

		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		//Loops through potential items and saves their name & cost.
		for (int i = 0; i  < count; i++)
		{
			Item Food = new Item();
			Food.itemName = scan.next();
			Food.itemCost = scan.nextDouble();
			itemList.add(Food);
		}
		
		int totalPeople = scan.nextInt();
		ArrayList<String> firstName = new ArrayList<String>(totalPeople);
		ArrayList<String> lastName = new ArrayList<String>(totalPeople);
		ArrayList<Item> custItemList = new ArrayList<Item>();
		
		//Loops through customers and their items, then saves them in various array lists.
		for ( int j = 0; j < totalPeople; j++)
		{
			firstName.add(scan.next());
			lastName.add(scan.next());
			
			int numItems = scan.nextInt();
			String[] tempItems = new String[numItems];
			
			for ( int a = 0; a < numItems; a++)
			{
				Item custFood = new Item();
				int quantityPerItem = scan.nextInt();
				custFood.itemQuant = quantityPerItem;
				custFood.itemName = scan.next();
				boolean inList = false;
				for ( int b = 0; b < a; b++)
				{
					if( tempItems[b].equals(custFood.itemName))
					{
						inList = true;
					}
				}
				if (!inList)
				{
					custFood.customerCount++;
				}
				tempItems[a] = custFood.itemName;
				custItemList.add(custFood);
			}
				
		}
		
		/*Loops through the general item list and each customer's item list,
		 * adding each customer's item count to the total item count by
		 * finding the matching itemName in the lists.
		*/
		for ( int z = 0; z < itemList.size(); z++)
		{
			for ( int y = 0; y < custItemList.size(); y++)
			{
				if ( custItemList.get(y).itemName.equals(itemList.get(z).itemName))
				{
					int tempQuant = custItemList.get(y).itemQuant;
					int newQuant = tempQuant + itemList.get(z).itemQuant;
					itemList.get(z).itemQuant = newQuant;
					itemList.get(z).customerCount += custItemList.get(y).customerCount;
				}
			}
		}
		scan.close();
		/*
		 * Prints each item's name, quantity, and customer count.
		 */
		for ( int i = 0; i < itemList.size(); i++)
		{
			//For items that no customers bought
			if (itemList.get(i).customerCount == 0)
			{
				System.out.println("No customers bought " + itemList.get(i).itemName);
			}
			else
			{
				System.out.println( itemList.get(i).customerCount +
				" customers bought " + itemList.get(i).itemQuant +
				" " + itemList.get(i).itemName);
			}
		}
	}
}

/* Item
 * Generic class for holding items' qualities.
 *
 * Local variables:
 * String itemName - Holds item name for each item
 * int itemQuant - Holds item quantity for each item
 * double itemCost - Holds item cost for each item
 * int customerCount - Holds the customer count for each item
 * 
 */

class Item{
	
	String itemName = "";
	int itemQuant = 0;
	double itemCost = 0.0;
	int customerCount = 0;
}