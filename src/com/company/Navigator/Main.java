package com.company.Navigator;

abstract class FindStrategy {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void Find(int[] array);
}

class CarFind extends FindStrategy {
    public CarFind() {
        this.setName("Поиск автомаршрутов");
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Find(int[] array) {
        System.out.println("Осуществляется поиск маршрута по автодорогам");
    }
}
class HumanFind extends FindStrategy {
    public HumanFind() {
        this.setName("Поиск пеших маршрутов");
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Find(int[] array) {
        System.out.println("Осуществляется поиск пешего маршрута");
    }
}
class BicycleFind extends FindStrategy {
    public BicycleFind  () {
        this.setName("Поиск веломаршрутов");
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Find(int[] array) {
        System.out.println("Осуществляется поиск маршрута по велодорожкам");
    }
}
class PublicFind extends FindStrategy {
    public PublicFind() {
        this.setName("Поиск маршрутов на общественном транспорте");
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Find(int[] array) {
        System.out.println("Осуществляется поиск маршрута на общественном транспорте");
    }
}
class SitesFind extends FindStrategy {
    public SitesFind() {
        this.setName("Поиск по достопримечательностям");
    }
    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Find(int[] array) {
        System.out.println("Осуществляется поиск маршрута по достопримечательностям");
    }
}

class Map {

}

class Navigator {
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Navigator(Map map) {
        this.map = map;
    }

    public void showMap() {
        System.out.println("Карта");
    }

    public void Find(FindStrategy fs, int[] array) {
        fs.Find(array);
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
    }
}
