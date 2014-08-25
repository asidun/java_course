package diosoft.com;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Person[] arr1 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 30),
				new Person("Teodor", "Plin", 60)};
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		System.out.println("First array = " + Arrays.toString(arr1));
		System.out.println("Second array = " + Arrays.toString(arr2));
		for (Person person : arr1) {
			if (consist(person, arr2))
				System.out.println(person);
		}
		System.out.println("Merge");
		System.out.println(Arrays.toString(merge(arr1,arr2)));
		
		
	}
	
	public static boolean consist(Person element, Person[] array){
		for (Person person : array) {
			if (person.equals(element))
				return true;
		}
		return false;
	}
	
	public static Person[] merge (Person[] arr1, Person[] arr2){
		if(arr1 == null || arr1.length == 0) return arr2;
		if(arr2 == null || arr2.length == 0) return arr1;
		Person[] result = Arrays.copyOf(arr1, arr1.length+arr2.length);
		int cnt = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (!consist(arr2[i], arr1)){
				cnt++;
				result[(arr1.length-1)+i] = arr2[i];
			}
		}		
		return Arrays.copyOf(result, arr1.length+cnt);		
	}
	
	public static Person[] outerUnion (Person[] arr1, Person[] arr2){
		if(arr1 == null || arr1.length == 0) return arr2;
		if(arr2 == null || arr2.length == 0) return arr1;
		Person[] result = new Person[arr1.length+arr2.length];
		int cnt = 0;
		for (Person person : arr2) {
			if (!consist(person, arr1)){				
				result[cnt] = person;
				cnt++;
			}
		}
		for (Person person : arr1) {
			if (!consist(person, arr2)){				
				result[cnt] = person;
				cnt++;
			}
		}
		return Arrays.copyOf(result, cnt);
	}

}
