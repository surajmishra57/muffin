package org.example.desing_patterns.behavioral.b2_command_desing_pattern_tasks.solution.task_1_Smart_Home_Remote_Control;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Device tv = new TV();
        Device ac = new AC();
        Device fan = new Fan();

        RemoteController rc = new RemoteController();

        rc.setCommand(new TurnONCommand(tv));
        rc.pressButton();
        rc.setCommand(new TurnOffCommand(tv));
        rc.pressButton();
        rc.pressUndo();


        rc.setCommand(new TurnONCommand(ac));
        rc.pressButton();
        rc.setCommand(new TurnOffCommand(ac));
        rc.pressButton();
        rc.pressUndo();


        rc.setCommand(new TurnONCommand(fan));
        rc.pressButton();
        rc.setCommand(new TurnOffCommand(fan));
        rc.pressButton();
        rc.pressUndo();

        System.out.println("+++++++++++++++++++++++++++++++++");
        rc.setCommand(new MacroCommand(List.of(tv, ac, fan)));
        rc.pressButton();
        rc.pressUndo();


    }
}
