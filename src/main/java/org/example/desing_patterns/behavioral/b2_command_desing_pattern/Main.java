package org.example.desing_patterns.behavioral.b2_command_desing_pattern;

public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TurnOnCommand turnOnCommand = new TurnOnCommand(tv);
        TurnOffCommand turnOffCommand = new TurnOffCommand(tv);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(turnOffCommand);
        remoteControl.pressButton();
        remoteControl.setCommand(turnOnCommand);
        remoteControl.pressButton();

    }
}
