package org.example.desing_patterns.behavioral.b2_command_desing_pattern_tasks.solution.task_1_Smart_Home_Remote_Control;

/**
 * This is Remote Class also called invoker that invoke the command
 */
public class RemoteController {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}
