package diosoft.com.helper;

import diosoft.com.Person;

public class ServiceDelegate {
	
	ArrayHelper helper;

	public ServiceDelegate(ArrayHelper helper){
		this.helper = helper;
	}
	
	public Person[] merge (Person[] arr1, Person[] arr2){
		return helper.merge(arr1, arr2);
	}
	
	
}
