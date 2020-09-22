package com.company.Strategy;

abstract class StrategySort {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void Sort(int[] array);
}

class InsertionSort extends StrategySort {
    public InsertionSort() {
        this.setName("Сортировка вставками");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = 0;
            int buffer = array[i];
            for (j = i - 1; j >=0; j--) {
                if (array[j] < buffer)
                    break;
                array[j+1] = array[j];
            }
            array[j+1] = buffer;
        }
    }
}

class SelectSort extends StrategySort {
    public SelectSort() {
        this.setName("Сортировка выбором");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int k = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[k] > array[j])
                    k = j;
            if (k != i) {
                int temp = array[k];
                array[k] = array[i];
                array[i] = temp;
            }
        }
    }
}

class BubbleSort extends StrategySort {
    public BubbleSort() {
        this.setName("Сортировка пузырьком");
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void Sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j >= i; j--) {
                if (array[i] > array[j]){
                    int buf = array[i];
                    array[i] = array[j];
                    array[j] = buf;
                }
            }
        }
    }
}

class Context {
    StrategySort strategySort;
    int[] array;
    public Context(StrategySort sort, int[] array) {
        this.strategySort = sort;
        this.array = array;
    }
    public void Sort() {
        this.strategySort.Sort(this.array);
    }
    public void printArray() {
        System.out.println(strategySort.toString());
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + ", ");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        int[] arr = {31, 15, 10, 13, 15, 124, 2, 0, 51};
        StrategySort sort = new BubbleSort();
        Context context = new Context(sort, arr);
        context.Sort();
        context.printArray();
    }
}
