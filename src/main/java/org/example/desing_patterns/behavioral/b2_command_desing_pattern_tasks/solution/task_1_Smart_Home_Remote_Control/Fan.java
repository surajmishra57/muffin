package org.example.desing_patterns.behavioral.b2_command_desing_pattern_tasks.solution.task_1_Smart_Home_Remote_Control;

public class Fan implements Device {
    @Override
    public void turnOn() {
        System.out.println("Fan is on");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is off");

    }
}
