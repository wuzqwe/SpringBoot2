package com.szq.vo;

public class Zoo {
    private Cat cat;

    private Dog dog;

    public Zoo(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "cat=" + cat +
                ", dog=" + dog +
                '}';
    }
}
