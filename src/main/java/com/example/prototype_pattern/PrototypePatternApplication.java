package com.example.prototype_pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypePatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrototypePatternApplication.class, args);

		// Create an original prototype
		ConcretePrototype originalPrototype = new ConcretePrototype(1);

		// Shallow copy using Cloneable
		ConcretePrototype shallowCopy = (ConcretePrototype) originalPrototype.clone();

		// Deep copy using custom clonePrototype method
		ConcretePrototype deepCopy = (ConcretePrototype) originalPrototype.clonePrototype();

		// Modify the cloned objects
		shallowCopy.setId(2);
		deepCopy.setId(3);

		// Output the results
		System.out.println("Original Prototype ID: " + originalPrototype.getId());
		System.out.println("Shallow Copy ID: " + shallowCopy.getId());
		System.out.println("Deep Copy ID: " + deepCopy.getId());
	}
}

// The prototype interface
interface IPrototype extends Cloneable {
    int getId();
    void setId(int id);
    IPrototype clonePrototype();
}

// A concrete prototype class
class ConcretePrototype implements IPrototype {
    private int id;

    public ConcretePrototype(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Shallow copy implementation using Cloneable
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    // Deep copy implementation using custom clonePrototype method
    @Override
    public IPrototype clonePrototype() {
        return new ConcretePrototype(this.id);
    }
}