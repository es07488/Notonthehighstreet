package com.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Checkout {

	final double TravelCardHolder_Price1 = 9.25;
	final double TravelCardHolder_Price2 = 8.50;
	final double Personalisedcufflinks_Price = 45.00;
	final double KidsTshirt_Price = 19.95;

	double TravelCardHolderPrice;
	double PersonalisedCufflinksPrice;
	double KidsTshirtPrice;

	List<Integer> productCodeFrequency = new ArrayList<>();
	HashMap<String, Integer> productCodeAndFreq = new HashMap<>();

	public void countFrequencies(ArrayList<String> list) {
		Set<String> st = new HashSet<String>(list);
		for (String s : st) {
			productCodeFrequency.add(Collections.frequency(list, s));
			productCodeAndFreq.put(s, Collections.frequency(list, s));
		}
	}

	public void getProductPrice() {

		for (Map.Entry<String, Integer> entry : productCodeAndFreq.entrySet()) {

			if (entry.getKey().equals("01") && entry.getValue() >= 2) {
				TravelCardHolderPrice = entry.getValue() * TravelCardHolder_Price2;
			}
			if (entry.getKey().equals("01") && entry.getValue() < 2) {
				TravelCardHolderPrice = entry.getValue() * TravelCardHolder_Price1;
			}

			if (entry.getKey().equals("02")) {
				PersonalisedCufflinksPrice = entry.getValue() * Personalisedcufflinks_Price;
			}

			if (entry.getKey().equals("03")) {
				KidsTshirtPrice = entry.getValue() * KidsTshirt_Price;
			}

		}

	}

	public double getProductTravelCardHolderPrice() {

		return TravelCardHolderPrice;
	}

	public double getProductPersonalisedcufflinksPrice() {
		return PersonalisedCufflinksPrice;

	}

	public double getProductKidsTshirtPrice() {

		return KidsTshirtPrice;
	}

	public double getTotalPrice(double total) {
		double result;
		if (total > 60) {
			result = total - (total * 10) / 100;

		} else {
			result = total;
		}
		return result = Math.round(result * 100.0) / 100.0;
	}

	public static void main(String[] args) {
		Checkout c = new Checkout();
		ArrayList<String> list = new ArrayList<String>();

		Scanner console = new Scanner(System.in);
		System.out.println("Please provide product code with comma separated values : ");
		String productCode = console.nextLine();
		System.out.println("Hi, You have entered product code : " + productCode);
		System.out.println("Thank you...");
		String[] words = productCode.split(",");
		for (String str : words) {
			list.add(str);
		}

		c.countFrequencies(list);
		System.out.println("========================");
		c.getProductPrice();

		double s1, s2, s3;
		s1 = c.getProductTravelCardHolderPrice();
		s2 = c.getProductPersonalisedcufflinksPrice();
		s3 = c.getProductKidsTshirtPrice();

		double total = s1 + s2 + s3;
		double finalTotal = c.getTotalPrice(total);
		System.out.println("Total  price: " + finalTotal);

	}

}
