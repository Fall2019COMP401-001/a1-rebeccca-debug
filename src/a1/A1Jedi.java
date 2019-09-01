package a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;


public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();
		ArrayList<Item> itemList = new ArrayList<Item>();
		

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
				for ( int b = 0; b < numItems; b++)
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
		for ( int i = 0; i < itemList.size(); i++)
		{
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

class Item{
	String itemName = "";
	int itemQuant = 0;
	double itemCost = 0;
	int customerCount = 0;
}