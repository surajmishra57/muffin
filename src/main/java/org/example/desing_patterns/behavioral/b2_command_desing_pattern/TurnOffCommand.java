package org.example.desing_patterns.behavioral.b2_command_desing_pattern;

public class TurnOffCommand implements Command {
    Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
       device.turnOff();
    }
}
