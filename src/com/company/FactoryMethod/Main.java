package com.company.FactoryMethod;

import com.sun.jdi.connect.Transport;

abstract class TransportService {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public TransportService(String name) {
        this.name = name;
    }

    abstract public double CostTransportation(double distance);
}

abstract class TransportCompany {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public TransportCompany(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }

    abstract public TransportService Create(String name, int k);
}

class TaxiService extends TransportService {
    private int category;

    public void setCategory(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

    public TaxiService(String name, int cat)
    {
        super(name);
        this.category = cat;
    }

    @Override
    public double CostTransportation(double distance){
        return distance * this.category;
    }

    @Override
    public String toString() {
        return "Фирма " + getName() + ", поездка категории " + this.category;
    }
}

class Shipping extends TransportService{
    private double tariff;

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }
    public Shipping(String name, double taff) {
        super(name);
        this.tariff = taff;
    }

    @Override
    public double CostTransportation(double distance) {
        return distance * this.tariff;
    }

    @Override
    public String toString() {
        return "Фирма " + getName() + ", доставка по тарифу " + this.tariff;
    }
}

class TaxiCompany extends TransportCompany {
    public TaxiCompany(String name) {
        super(name);
    }

    @Override
    public TransportService Create(String name, int k) {
        return new TaxiService(name, k);
    }
}

class ShippingCompany extends TransportCompany{
    public ShippingCompany(String name) {
        super(name);
    }

    @Override
    public TransportService Create(String name, int k) {
        return new Shipping(name, k);
    }
}

class DrunkenPilot extends TransportService {
    private double tariff;

    public double getTariff() {
        return tariff;
    }

    public void setTariff(double tariff) {
        this.tariff = tariff;
    }
    public DrunkenPilot(String name, double taff) {
        super(name);
        this.tariff = taff;
    }

    @Override
    public double CostTransportation(double distance) {
        return distance * this.tariff;
    }

    @Override
    public String toString() {
        return "Фирма " + getName() + ", услуга \"Пьяный водитель\" по тарифу " + this.tariff;
    }
}

public class Main {

    public static void main(String[] args) {
        // write your code here
        TransportCompany transportCompany = new TaxiCompany("Служба такси");
        TransportService transportService = transportCompany.Create("Такси", 1);
        double distance = 16;
        System.out.println("Компания " + transportService.getName() + ", расстояние " + distance +
                ", стоимость " + transportService.CostTransportation(distance));
    }
}