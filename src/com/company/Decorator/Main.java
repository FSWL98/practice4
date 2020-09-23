package com.company.Decorator;

abstract class AutoBase {
    public String name;
    public String description;
    public double costBase;
    public abstract double getCost();

    @Override
    public String toString() {
        return "Ваш автомобиль: " + name + "\nОписание: " + description + "\nСтоимость: " + getCost();
    }
}

class Renault extends AutoBase {
    public Renault(String name, String info, double cost) {
        this.name = name;
        this.description = info;
        this.costBase = cost;
    }

    @Override
    public double getCost() {
        return costBase * 1.18;
    }
}
class Audi extends AutoBase {
    public Audi(String name, String info, double cost) {
        this.name = name;
        this.description = info;
        this.costBase = cost;
    }

    @Override
    public double getCost() {
        return costBase * 1.3;
    }
}

abstract class DecorationOptions extends AutoBase {
    public AutoBase autoBase;
    public String title;
    public DecorationOptions(AutoBase au, String title) {
        this.autoBase = au;
        this.title = title;
    }
}

class MediaNavigation extends DecorationOptions {
    public MediaNavigation(AutoBase au, String t) {
        super(au, t);
        this.autoBase = au;
        this.name = au.name + ". Современный";
        this.description = au.description + ". " + this.title + ". Обновленная мультимедийная навигационная система";
    }

    @Override
    public double getCost() {
        return this.autoBase.getCost() + 15.99;
    }
}
class Cabriolette extends DecorationOptions {
    public Cabriolette (AutoBase au, String t) {
        super(au, t);
        this.autoBase = au;
        this.name = au.name + ". Кабриолет";
        this.description = au.description + ". " + this.title + ". Убирающаяся крыша";
    }

    @Override
    public double getCost() {
        return this.autoBase.getCost() + 30.99;
    }
}

class Spoiler extends DecorationOptions {
    public Spoiler (AutoBase au, String t) {
        super(au, t);
        this.autoBase = au;
        this.name = au.name + ". Спортивная";
        this.description = au.description + ". " + this.title + ". Спортивный спойлер для улучшенной аэродинамики";
    }

    @Override
    public double getCost() {
        return this.autoBase.getCost() + 30.99;
    }
}


class SystemSecurity extends DecorationOptions {
    public SystemSecurity(AutoBase au, String t) {
        super(au, t);
        this.autoBase = au;
        this.name = au.name + ". Повышенной безопасности";
        this.description = au.description + ". " + this.title +
                ". Передние боковые подушки безопасности, ESP - система динамической стабилизации автомобиля";
    }

    @Override
    public double getCost() {
        return this.autoBase.getCost() + 20.99;
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Renault renault = new Renault("Renault", "Renault Logan Active", 499.0);
        System.out.println(renault.toString());

        AutoBase myRenault = new MediaNavigation(renault, "Навигация");
        System.out.println(myRenault.toString());

        AutoBase myNewRenault = new SystemSecurity(new MediaNavigation(renault, "Навигация"), "Безопасность");
        System.out.println(myNewRenault.toString());

        Audi audi = new Audi("Audi", "Audi A6", 1000);
        System.out.println(audi.toString());

        AutoBase sportAudi = new Spoiler(audi, "Спойлер");
        System.out.println(sportAudi.toString());

        AutoBase fullAudi = new Cabriolette(new Spoiler(new SystemSecurity(new MediaNavigation(audi, "Навигация"), "Безопасность"), "Спойлер"), "Кабриолет");
        System.out.println(fullAudi.toString());
    }
}
