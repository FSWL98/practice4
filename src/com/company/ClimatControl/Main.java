package com.company.ClimatControl;

import java.util.Random;

interface ISensor {
    double getTemperature();
}
class Sensor implements ISensor {
    private Random r;
    public Sensor() {
        r = new Random();
    }
    public double getTemperature() {
        return r.nextInt(400) - 150;
    }
}
class CelciusAdapter {
    private Sensor sensor;
    public CelciusAdapter(Sensor s) {
        sensor = s;
    }
    public double getTemperature() {
        return Math.round((sensor.getTemperature() - 32) * 5 / 9);
    }
}

class Controller {
    private String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Controller (String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

    public double SeansControl(ISensor is) {
        return is.getTemperature();
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        Controller controller = new Controller("Vlad");
        Sensor sensor = new Sensor();
        CelciusAdapter ca = new CelciusAdapter(sensor);
        System.out.println("Температура в Фаренгейтах: " + sensor.getTemperature() + ", в Цельсиях: " + ca.getTemperature());
    }
}