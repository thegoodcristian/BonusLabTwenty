package com.bonusLabTwenty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		System.out.println("Welcome to Cristian's Amish Grocery. No photographs, please!"
				+ "\n\nHere is a list of our current stock: \n");

		ArrayList<String> groceryItems = new ArrayList<String>(Arrays.asList("kiwi", "banana", "grapefruit", "tomato",
				"apple", "avocado", "potato", "loom", "horse", "buggy"));

		ArrayList<Double> groceryPrices = new ArrayList<Double>(Arrays.asList(0.89, 0.39, 0.99, 0.79,
				0.45, 1.29, 0.40, 1995.99, 2750.00, 5500.00));

		ArrayList<String> shoppingCartItems = new ArrayList<String>();
		ArrayList<Double> shoppingCartPrices = new ArrayList<Double>();
		
		for (String item : groceryItems) {

			System.out.println(item);

		}

		String cont = "yes";
		while (cont.equalsIgnoreCase("yes")) {

			System.out.println("\nPlease enter an item name to add it to your perhaps-oversized shopping cart: ");
			String itemChoice = scnr.next();

			boolean checkContents = groceryItems.contains(itemChoice);
			if (checkContents == false) {

				System.out.println("We don't have any " + itemChoice + ". Sorry!");

			} else if (checkContents == true) {

				int itemIndex = groceryItems.indexOf(itemChoice);
				System.out.println("\n" + groceryItems.get(itemIndex) + "\t" + groceryPrices.get(itemIndex));

				shoppingCartItems.add(itemChoice);
				shoppingCartPrices.add(groceryPrices.get(itemIndex));

				cont = Validator.getString(scnr, "\nWould you like to add another item? yes/no");

				while (!cont.equalsIgnoreCase("yes") && !cont.equalsIgnoreCase("no")) {
					System.out.println("\nPlease only enter yes/no: ");
					cont = Validator.getString(scnr, "\nWould you like to add another item? yes/no");
				}

			}

		}
		
		System.out.println("\nI'll just go ahead and ring you up then!"
				+ "\nHere's your receipt."
				+ "\n\nCRISTIAN'S AMISH GROCERY"
				+ "\n========================");

		for (int i = 0; i < shoppingCartItems.size(); i++) {
			
			System.out.println(shoppingCartItems.get(i) + "\t\t\t$" + shoppingCartPrices.get(i));
			
		}
		
		double sum = 0;
		for(Double number : shoppingCartPrices) {
			
			sum += number;
		}

		System.out.printf("YOUR TOTAL IS:\t\t$" + sum
				+ "\nAverage item price: \t$%.2f", (sum/shoppingCartPrices.size()));
		
		
		
		
		
	}

}
