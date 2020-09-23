package com.company.Haircut;

import java.util.ArrayList;

abstract class Haircut {
    private String name;
    private int cost;
    private ArrayList<String> steps;

    public ArrayList<String> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<String> steps) {
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Haircut(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.steps = new ArrayList<String>();
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void doHaircut() {
        getInfo();
        Progress();
        pay(this.cost);
    }

    private void pay(int cost) {
        System.out.println("Стрижка оплачена - " + cost + " руб");
    }

    private void getInfo() {
        System.out.println("Информация о стрижке:");
    }

    public abstract void Progress();
}

class PompadurHaircut extends Haircut {
    public PompadurHaircut(int cost) {
        super("Помпадур", cost);
        getSteps().add("Бритье машинкой");
        getSteps().add("Стрижка ножницами");
        getSteps().add("Мытье головы");
        getSteps().add("Укладка");
    }

    @Override
    public void Progress() {
        System.out.println(getName() + " всего за " + getCost() + " руб");
        for (String step: getSteps()) {
            System.out.println(step);
        }
    }
}

class FadeHaircut extends Haircut {
    public FadeHaircut(int cost) {
        super("Фейд", cost);
        getSteps().add("Бритье машинкой");
        getSteps().add("Мытье головы");
    }

    @Override
    public void Progress() {
        System.out.println(getName() + " всего за " + getCost() + " руб");
        for (String step: getSteps()) {
            System.out.println(step);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Haircut haircut = new FadeHaircut(700);
        haircut.doHaircut();
    }
}
