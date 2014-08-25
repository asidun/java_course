package diosoft.com;

import java.util.Arrays;

public class TestMain {
	
	public static void main(String[] args) {
		testMerge();
		testMerge_firstNull();
		testMerge_firstEmpty();
		//testMerge_firstHuge();
		outerUnion();
		outerUnion_secondEmpty();
    }
	
	private static void testMerge() {
		System.out.println("Running test method : testMerge");
		
		Person[] arr1 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 30),
				new Person("Teodor", "Plin", 60)};
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 30),
				new Person("Teodor", "Plin", 60), new Person("Bill", "Plin", 70)};
		
		Person[] result = Main.merge(arr1, arr2);
		
		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
		boolean isArraysEquals = Arrays.equals(expected, result);
		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
	}
	
	private static void testMerge_firstNull() {
		System.out.println("Running test method : testMerge_firstNull");
		
		Person[] arr1 = null;
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		
		Person[] result = Main.merge(arr1, arr2);
		
		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
		boolean isArraysEquals = Arrays.equals(expected, result);
		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
	}
	
	private static void testMerge_firstEmpty() {
		System.out.println("Running test method : testMerge_firstEmpty");
		
		Person[] arr1 = {};
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		
		Person[] result = Main.merge(arr1, arr2);
		
		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
		boolean isArraysEquals = Arrays.equals(expected, result);
		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
	}
	
//	private static void testMerge_firstHuge() {
//		System.out.println("Running test method : testMerge_firstHuge");
//		
//		
//		Person person = new Person("Bill", "Klinton", 70);
//		Person arr1[] = new Person[Integer.MAX_VALUE];
//		Arrays.fill(arr1, person);
//		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
//		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
//		
//		Person[] result = Main.merge(arr1, arr2);
//		
//		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
//		boolean isArraysEquals = Arrays.equals(expected, result);
//		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
//        assert (isArraysEquals);
//	}
	
	private static void outerUnion() {
		System.out.println("Running test method : outerUnion");
		
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Teodor", "Plin", 60)};
		Person[] arr1 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		Person[] expected = {new Person("Teodor", "Plin", 60), new Person("Bill", "Plin", 70)};
		
		Person[] result = Main.outerUnion(arr1, arr2);
		
		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
		boolean isArraysEquals = Arrays.equals(expected, result);
		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
	}
	
	private static void outerUnion_secondEmpty() {
		System.out.println("Running test method : outerUnion_secondEmpty");
		
		Person[] arr1 = {new Person("Bill", "Klinton", 70), new Person("Teodor", "Plin", 60)};
		Person[] arr2 = {};
		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Teodor", "Plin", 60)};
		
		Person[] result = Main.outerUnion(arr1, arr2);
		
		System.out.println(String.format("Result array : %s", Arrays.toString(result)));
		boolean isArraysEquals = Arrays.equals(expected, result);
		System.out.println(String.format("Test successful : %s \n", isArraysEquals));
        assert (isArraysEquals);
	}

}
