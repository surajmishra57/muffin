package org.example.desing_patterns.behavioral.b2_command_desing_pattern_tasks.solution.task_1_Smart_Home_Remote_Control;

/**
 * This is Command Concrete Class That Have Object Of Receiver Class.
 */
public class TurnONCommand implements Command {
    Device device;

    public TurnONCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }

    @Override
    public void undo() {
        device.turnOff();
    }
}
