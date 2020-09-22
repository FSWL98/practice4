package com.company.Singleton;

import java.io.FileWriter;
import java.io.IOException;

class Log {
    private Log() {

    }
    private static Log instance = null;

    public static Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public void LogExecution(String mes) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(mes);
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private static void Logger(String mes, FileWriter writer) {
        try {
            writer.write("Log entry:");
            writer.write("Действие: " + mes);
            writer.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

class Operation {
    public static double Run(char code, int operand) {
        Log lg2 = Log.getInstance();
        double rez = 0;
        switch (code) {
            case '+':
                rez+=operand;
                lg2.LogExecution("Сложение " + operand);
                break;
            case '-':
                rez-=operand;
                lg2.LogExecution("Вычитание " + operand);
                break;
            case '*':
                rez-=operand;
                lg2.LogExecution("Умножение " + operand);
                break;
            case '/':
            case ':':
                rez-=operand;
                lg2.LogExecution("Деление " + operand);
                break;
        }
        return rez;
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Log lg = Log.getInstance();
        lg.LogExecution("Метод Main()");
        double op = Operation.Run('-', 35);
        op = Operation.Run('+', 30);
    }
}
