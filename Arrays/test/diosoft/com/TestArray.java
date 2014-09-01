package diosoft.com;

import helper.ArrayHelper;
import helper.ServiceDelegate;

import java.lang.reflect.Array;
import java.util.Arrays;

import static junit.framework.Assert.*;

import org.junit.Test;


public class TestArray {
	
	@Test
	public void Test_Merge(){
		
		Person[] arr1 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 30),
				new Person("Teodor", "Plin", 60)};
		Person[] arr2 = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 70)};
		Person[] expected = {new Person("Bill", "Klinton", 70), new Person("Bill", "Plin", 30),
				new Person("Teodor", "Plin", 60), new Person("Bill", "Plin", 70)};
		
		ArrayHelper resourse = new ArrayHelper();
		ServiceDelegate serviceDeligate = new ServiceDelegate(resourse);
		Person[] result = serviceDeligate.merge(arr1, arr2);
		assertTrue(Arrays.equals(expected, result));
	}

}
