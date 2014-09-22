package diosoft.com.collections;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestCollections {
	
	@Test
	public void TestArrayCollection(){
		Person p1 = new Person("Kim", "Er", 50);
		Person p2 = new Person("Kim", "Chen", 30);
		Person p3 = new Person("Kim", "In", 22);
		List<Person> leftArr = Arrays.asList(p1, p2);
		List<Person> rightArr = Arrays.asList(p2, p3);
		List<Person> expectedArr = Arrays.asList(p3, p2, p1);
		
		ArrayCollections ac = new ArrayCollections();
		
		List<Person> result = ac.union(rightArr, leftArr);
		assertEquals(expectedArr, result);
		
	}

}
