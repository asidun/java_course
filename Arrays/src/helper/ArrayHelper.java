package helper;

import java.util.Arrays;

import diosoft.com.Person;

public class ArrayHelper {
	
	public Person[] merge (Person[] arr1, Person[] arr2){
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
	
	public static boolean consist(Person element, Person[] array){
		for (Person person : array) {
			if (person.equals(element))
				return true;
		}
		return false;
	}

}
