package com.example;

public class Dog {
	// FIELDS:
    private String breed;
    private String size;
    
    //CONSTRUCTORS:
    public Dog(String breed) {
        this.breed = breed;
    }

    public Dog(String breed, String size) {
        this.breed = breed;
        this.size = size;
    }
    // GETTERS:
    public String getBreed() {
        return this.breed;
    }

    public String getSize() {
        return this.size;
    }
}