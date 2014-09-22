package diosoft.com.collections.delegate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import diosoft.com.collections.ArrayCollections;
import diosoft.com.collections.Person;

public class TestArrayDelegate {
	
	@Test
	public void TestArrayDelegate(){
		Person p1 = new Person("Kim", "Er", 50);
		Person p2 = new Person("Kim", "Chen", 30);
		Person p3 = new Person("Kim", "In", 22);
		List<Person> leftArr = Arrays.asList(p1, p2);
		List<Person> rightArr = Arrays.asList(p2, p3);
		List<Person> expectedArr = Arrays.asList(p2, p3, p1);		
				
		ArrayCollections arrayColl = mock(ArrayCollections.class);
		
		ArrayCollectionsDeligate delegate = new ArrayCollectionsDeligate(arrayColl);
		
		stub(arrayColl.union(anyList(), anyList())).toReturn(expectedArr);
		
		List<Person> resultArr = delegate.union(leftArr, rightArr);
		
		assertEquals(expectedArr, resultArr);
	}

}
