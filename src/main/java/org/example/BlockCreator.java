package org.example;

public record BlockCreator(String color, String material) implements Block {

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
