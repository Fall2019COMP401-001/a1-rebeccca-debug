package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();

		String[] itemNames = new String[count];
		double[] itemCost = new double[count];
		for ( int i = 0; i < itemNames.length; i++)
		{
			itemNames[i] = scan.next();
			itemCost[i] = scan.nextDouble();
		}
		int totalPeople = scan.nextInt();
		double costSum = 0.0;
		double max = Integer.MIN_VALUE;
		double min = Integer.MAX_VALUE;
		String maxName = "";
		String minName = "";
		
		for ( int j = 0; j < totalPeople; j++)
		{
			String cfName = new String(scan.next());
			String clName = new String(scan.next());
			int numItems = scan.nextInt();
			double totalCost = 0.0;
			for ( int a = 0; a < numItems; a++)
			{
				int quantity = scan.nextInt();
				String itemName = scan.next();
				int index = 0;
				for ( int b = 0; b < itemNames.length; b++)
				{
					if ( itemNames[b].equals(itemName))
					{
						index = b;
					}
				}
				totalCost += quantity * itemCost[index];
			}
			costSum += totalCost;
			if (totalCost > max)
			{
				max = totalCost;
				maxName = cfName + " " + clName;
			}
			if (totalCost < min)
			{
				min = totalCost;
				minName = cfName + " " + clName;
			}
		}
		double average = costSum / (double)totalPeople;
		System.out.println("Biggest: " + maxName + " (" + String.format("%.2f", max) + ")");
		System.out.println("Smallest: " + minName + " (" + String.format("%.2f", min) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
	}
}
