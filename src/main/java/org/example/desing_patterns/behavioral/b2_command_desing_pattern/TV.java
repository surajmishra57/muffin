package org.example.desing_patterns.behavioral.b2_command_desing_pattern;

public class TV implements Device {
    @Override
    public void turnOff() {
        System.out.println("TV is off");


    }

    @Override
    public void turnOn() {
        System.out.println("TV is ON");
    }
}
