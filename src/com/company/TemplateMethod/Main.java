package com.company.TemplateMethod;

import java.util.ArrayList;
import java.util.List;

abstract class Progression {
    private int first;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    private int last;

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    private int h;

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    private ArrayList<Integer> progList;

    public List<Integer> getProgList() {
        return progList;
    }

    public void setProgList(ArrayList<Integer> progList) {
        this.progList = progList;
    }

    public Progression(int first, int last, int h) {
        this.first = first;
        this.last = last;
        this.h = h;
        this.progList = new ArrayList<Integer>();
    }

    public void TemplateMethod() {
        InitializeProgression(this.first, this.last, this.h);
        Progress();
        Print(this.progList);
    }

    private void Print(ArrayList<Integer> array) {
        System.out.println("Последовательность: ");
        for (int item: array) {
            System.out.println(item);
        }
    }

    private void InitializeProgression(int a, int b, int c) {
        this.first = a;
        this.last = b;
        this.h = c;
    }

    public abstract void Progress();
}

class ArithmeticProgression extends Progression {
    public ArithmeticProgression(int f, int l, int h) {
        super(f, l, h);
    }

    @Override
    public void Progress() {
        int fF = this.getFirst();
        do {
            this.getProgList().add(fF);
            fF += this.getH();
        }
        while (fF < this.getLast());
    }
}

class GeometricProgression extends Progression {
    public GeometricProgression(int f, int l, int h) {
        super(f, l, h);
    }

    @Override
    public void Progress() {
        int fF = this.getFirst();
        do {
            this.getProgList().add(fF);
            fF *= this.getH();
        }
        while (fF < this.getLast());
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        Progression val = new GeometricProgression(1, 10, 2);
        val.TemplateMethod();
    }
}
