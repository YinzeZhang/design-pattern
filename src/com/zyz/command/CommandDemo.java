package com.zyz.command;

interface Command {
    public void execute();
}

//Receiver
class GarageDoor {
    public void on() {
        System.out.println("Garage door is on");
    }
    public void off() {
        System.out.println("Garage door is off");
    }
}

//ConcreteCommand
class GarageDoorOpenCommand implements Command {

    GarageDoor garageDoor;
    GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.on();
    }
}

class GarageDoorCloseCommand implements Command {

    GarageDoor garageDoor;

    GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.off();
    }
}


class Light {
    public void on() {
        System.out.println("light is on");
    }

    public void off() {
        System.out.println("light is off");
    }
}

class LightOnCommand implements Command {
    Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.on();
    }
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

//Invoker
class SimpleRemoteControl {
    Command slot;

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Command command = new LightOnCommand(new Light());
        remote.setSlot(command);
        remote.buttonWasPressed();

        remote.setSlot(new GarageDoorCloseCommand(new GarageDoor()));
        remote.buttonWasPressed();
    }
}
