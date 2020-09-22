package com.company.Adapter;

import java.util.Random;

interface IGame {
    int Brosok();
}

class Kost implements IGame {
    private Random r;
    public Kost() {
        r = new Random();
    }
    public int Brosok() {
        return r.nextInt(6) + 1;
    }
}

class Monet {
    private Random r;
    public Monet() {
        r = new Random();
    }
    public int BrosokM() {
        return r.nextInt(2) + 1;
    }
}

class AdapterGame implements IGame {
    private Monet monet;
    public AdapterGame(Monet mt) {
        monet = mt;
    }
    public int Brosok() {
        return monet.BrosokM();
    }
}
class Gamer {
    public String Name;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Gamer (String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return Name;
    }

    public int SeansGame(IGame ig) {
        return ig.Brosok();
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        Kost kubik = new Kost();
        Gamer g1 = new Gamer("Шева");
        System.out.println("Выпало очков " + g1.SeansGame(kubik) + " для игрока " + g1.toString());
        Monet monet = new Monet();
        IGame bmon = new AdapterGame(monet);
        System.out.println("Монета показала " + g1.SeansGame(bmon) + " для игрока " + g1.toString());
    }
}
