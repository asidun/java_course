package helper;

import diosoft.com.Person;

public class ServiceDelegate {
	
	ArrayHelper helper;

	ServiceDelegate(ArrayHelper helper){
		this.helper = helper;
	}
	
	Person[] merge (Person[] arr1, Person[] arr2){
		return helper.merge(arr1, arr2);
	}
	
	
}
