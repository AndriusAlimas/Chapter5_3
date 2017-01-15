package com.example;

public class Dog {
	// FIELDS:
    private String breed;
    private String size;
    
    //CONSTRUCTORS:
    public Dog(String string) {
        this.breed = string;
    }

    public Dog(String string, String string2) {
        this.breed = string;
        this.size = string2;
    }
    // GETTERS:
    public String getBreed() {
        return this.breed;
    }

    public String getSize() {
        return this.size;
    }
}