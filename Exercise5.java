package lab6;

//Declares an abstract class Animal to serve as a base for animal-related classes 
abstract class Animal {
	// Declares an abstract bark() method that must be implemented by subclasses
	abstract void bark();
}

// Declares a Dog class that extends the Animal abstract class
class Dog extends Animal {
	@Override
	// Overrides the bark() method to provide a specific implementation for Dog
	public void bark() {
		System.out.println("Dog is barking");
	}
}

//MAIN CLASS
public class Exercise5 {
	public static void main(String[] args) {
		// Creates a Dog object (Dog extends Animal, so it's considered an Animal)
		Animal dogobject = new Dog();
		// Calls the bark() method on the dog object
		dogobject.bark();
	}
}
