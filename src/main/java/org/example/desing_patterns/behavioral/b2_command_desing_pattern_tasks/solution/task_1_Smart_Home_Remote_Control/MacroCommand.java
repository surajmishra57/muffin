package org.example.desing_patterns.behavioral.b2_command_desing_pattern_tasks.solution.task_1_Smart_Home_Remote_Control;

import java.util.List;

public class MacroCommand implements Command {
    List<Device> devices;

    public MacroCommand(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public void execute() {
        for (var i : devices) {
            i.turnOn();
        }
    }

    @Override
    public void undo() {
        for (var i : devices) {
            i.turnOff();
        }
    }
}
