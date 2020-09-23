package com.company.Command;

import java.util.ArrayList;

abstract class Command {
    protected ArithmeticUnit unit;
    protected double operand;
    public abstract void Execute();
    public abstract void UnExecute();
}

class ArithmeticUnit {
    public double register;
    public void Run(char code, double operand) {
        switch (code) {
            case '+':
                register += operand;
                break;
            case '-':
                register -= operand;
                break;
            case '*':
                register *= operand;
                break;
            case '/':
            case ':':
                register /= operand;
                break;
        }
    }
}

class ControlUnit {
    private ArrayList<Command> commands = new ArrayList<Command>();
    private int current = 0;

    public void StoreCommand(Command command) {
        this.commands.add(command);
    }

    public void ExecuteCommand() {
        this.commands.get(current).Execute();
        current++;
    }

    public void Undo() {
        this.commands.get(current - 1).UnExecute();
    }

    public void Redo() {
        this.commands.get(current - 1).Execute();
    }
}

class Add extends Command {
    public Add(ArithmeticUnit unit, double operand) {
        this.unit = unit;
        this.operand = operand;
    }

    @Override
    public void Execute() {
        unit.Run('+', this.operand);
    }

    @Override
    public void UnExecute() {
        unit.Run('-', operand);
    }
}

class Subtract extends Command {
    public Subtract(ArithmeticUnit unit, double operand) {
        this.unit = unit;
        this.operand = operand;
    }

    @Override
    public void Execute() {
        unit.Run('-', this.operand);
    }

    @Override
    public void UnExecute() {
        unit.Run('+', operand);
    }
}

class Multiple extends Command {
    public Multiple(ArithmeticUnit unit, double operand) {
        this.unit = unit;
        this.operand = operand;
    }

    @Override
    public void Execute() {
        unit.Run('*', this.operand);
    }

    @Override
    public void UnExecute() {
        unit.Run('/', operand);
    }
}

class Divide extends Command {
    public Divide(ArithmeticUnit unit, double operand) {
        this.unit = unit;
        this.operand = operand;
    }

    @Override
    public void Execute() {
        unit.Run('/', this.operand);
    }

    @Override
    public void UnExecute() {
        unit.Run('*', operand);
    }
}

class Calculator {
    ArithmeticUnit arithmeticUnit;
    ControlUnit controlUnit;

    public Calculator() {
        this.arithmeticUnit = new ArithmeticUnit();
        this.controlUnit = new ControlUnit();
    }

    private double Run(Command command) {
        this.controlUnit.StoreCommand(command);
        controlUnit.ExecuteCommand();
        return this.arithmeticUnit.register;
    }

    public double add(double operand) {
        return Run(new Add(arithmeticUnit, operand));
    }

    public double subtract(double operand) {
        return Run(new Subtract(arithmeticUnit, operand));
    }

    public double divide(double operand) {
        return Run(new Divide(arithmeticUnit, operand));
    }

    public double multiple(double operand) {
        return Run(new Multiple(arithmeticUnit, operand));
    }

    public double Redo() {
        this.controlUnit.Redo();
        return this.arithmeticUnit.register;
    }

    public double Undo() {
        this.controlUnit.Undo();
        return this.arithmeticUnit.register;
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Calculator calculator = new Calculator();
        double result = 0;
        result = calculator.add(4);
        System.out.println(result);
        result = calculator.subtract(4);
        System.out.println(result);
        result = calculator.add(3);
        System.out.println(result);
        result = calculator.multiple(2);
        System.out.println(result);
        result = calculator.divide(2);
        System.out.println(result);
        result = calculator.Undo();
        System.out.println(result);
    }
}