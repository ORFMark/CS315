package Homework.HW_12;

import java.text.NumberFormat;
import java.util.Comparator;

public class Item implements Comparable<Item> {
	private String description;
	private double price;
	private double reviews;

	Item(String description, double price, double reviews) {
		this.description = description;
		this.price = price;
		this.reviews = reviews;
	}

	public String toString() {
		return String.format("%10s %3.1f %s", NumberFormat.getCurrencyInstance().format(price), reviews, description);
		// NumberFormat currency = NumberFormat.getCurrencyInstance();
		// return reviews + " " + currency.format(price) + " " + description;
	}

	public int compareTo(Item other) {
		return description.compareTo(other.description);
	}

	/** WRITE THE FACTORY METHOD TO RETURN A PriceComparator OBJECT **/
	public static PriceComparator getPriceComparator() {
		return new PriceComparator();
	}
	/** WRITE THE PriceComparator STATIC CLASS AND ITS compare METHOD **/
	
	static class PriceComparator implements Comparator<Item> {

		@Override
		public int compare(Item arg0, Item arg1) {
			return Double.compare(arg0.price, arg1.price);
		}
		
	}
	public static ReviewComparator getReviewComparator() {
		return new ReviewComparator();
	}

	static class ReviewComparator implements Comparator<Item> {
		public int compare(Item item1, Item item2) {
			return Double.compare(item1.reviews, item2.reviews);
		}
	}
}