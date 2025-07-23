package org.example.desing_patterns.behavioral.b2_command_desing_pattern;

public class TurnOnCommand implements Command {
    Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}
