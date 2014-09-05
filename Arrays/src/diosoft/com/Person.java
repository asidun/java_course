package diosoft.com;

public class Person {

	private String name;
	private String surname;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}
	public String toString(){
		return  name + " " + surname + " " + age;
	}
	
//	public boolean equals(Person person){
//		if (this.name.equals(person.getName()) )
//			//if (this.name.equals(person.getName()) && this.name.equals(person.getSurname()) && person.getAge() == this.age)
//			return true;
//		return false;		
//	}
	
	public Person (String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	
	public Person() {	
	}	

	private Person(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.age = builder.age;
	}

	public static class Builder{
		
		private String name;
		private String surname;
		private int age;
		
		public Builder(){};	
		
		
		public Builder(Person original){
			this.name = original.name;
			this.surname = original.surname;
			this.age = original.age;
		}
		
		public Builder name(String name){
			this.name = name;
			return this;
		}
		
		public Builder surname(String surname){
			this.surname = surname;
			return this;
		}
		
		public Builder age(int age){
			this.age = age;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}	
	
	}
	
	
}
