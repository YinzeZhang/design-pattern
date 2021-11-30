package com.zyz.command.macrocommand;

interface Command {
    void execute();
    void undo();
}

class Light {
    void on() {
        System.out.println("light is on");
    }
    void off() {
        System.out.println("light is off");
    }
}


class LightOnCommand implements Command {

    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}

class LightOffCommand implements Command {
    Light light;
    LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

class MacroCommand implements Command {

    Command[] commands;

    MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}

public class MacroCommandDemo {
    public static void main(String[] args) {
        Command command1 = new LightOnCommand(new Light());
        Command command2 = new LightOffCommand(new Light());
        Command[] commands = {command1, command2};
        MacroCommand macroCommand = new MacroCommand(commands);
        macroCommand.execute();
    }
}
