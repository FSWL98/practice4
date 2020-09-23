package com.company.Facade;

import jdk.jfr.Event;

import java.beans.EventHandler;

class Drive {
    private String twist;

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }

    public Drive() {
        this.twist = "Исходная позиция";
        System.out.println(this.toString());
    }

    public void turnLeft() {
        this.twist = "Поворот влево";
        System.out.println(this.toString());
    }

    public void turnRight() {
        this.twist = "Поворот вправо";
        System.out.println(this.toString());
    }
    public void stop() {
        this.twist = "Стоп";
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Привод: " + this.twist;
    }
}

class Power {
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Заданная мощность: " + this.power;
    }
}

class Notification {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

    public void startProcess() {
        this.message = "Операция началась";
        System.out.println(this.toString());
    }

    public void stopProcess() {
        this.message = "Операция завершилась";
        System.out.println(this.toString());
    }
}

class Microwave {
    private Drive drive;
    private Power power;
    private Notification notification;

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Microwave(Drive drive, Power power, Notification notification) {
        this.drive = drive;
        this.power = power;
        this.notification = notification;
    }

    public void defrost() {
        this.notification.startProcess();
        this.power.setPower(700);
        this.drive.turnRight();
        this.drive.turnRight();
        this.power.setPower(500);
        this.drive.stop();
        this.drive.turnLeft();
        this.drive.turnLeft();
        this.power.setPower(200);
        this.drive.stop();
        this.drive.turnRight();
        this.drive.turnRight();
        this.drive.stop();
        this.power.setPower(0);
        this.notification.stopProcess();
    }

    public void cook() {
        this.notification.startProcess();
        this.power.setPower(800);
        this.drive.turnRight();
        this.drive.turnRight();
        this.drive.turnRight();
        this.drive.stop();
        this.power.setPower(200);
        this.drive.turnLeft();
        this.drive.stop();
        this.power.setPower(0);
        this.notification.stopProcess();
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Drive drive = new Drive();
        Power power = new Power();
        Notification notification = new Notification();
        Microwave microwave = new Microwave(drive, power, notification);
        microwave.defrost();
        microwave.cook();
    }
}
