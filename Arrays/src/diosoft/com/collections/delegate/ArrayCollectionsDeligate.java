package diosoft.com.collections.delegate;

import java.util.List;

import diosoft.com.collections.ArrayCollections;
import diosoft.com.collections.Person;

public class ArrayCollectionsDeligate {
	
	private final ArrayCollections resource;
	
	public ArrayCollectionsDeligate(ArrayCollections input){
		this.resource = input;
	}
	
	public List<Person> union(List<Person> leftArray, List<Person> rightArray){
		return resource.union(leftArray, rightArray);
	}
	

}
