package lesson3_sets;

import java.util.ArrayList;
import java.util.List;

public class Set <T> {
    T[][] values;
    int capacity;
    int[][] capacities; // capacities[basketSize][2] 0 - capacity of basket, 1 - number of elements in basket
    int basketSize = 1;
    boolean containsNull = false;
    int size;
    float loadFactor = 0.75f;

    public Set() {
        this(10);
    }

    public Set(int capacity) {
        size = 0;
        this.capacity = capacity;
        this.values = (T[][]) new Object[this.capacity][basketSize];
        this.capacities = new int[capacity][2];
        for (int i = 0; i < capacity; i++) {
            capacities[i][0] = basketSize;
        }
    }

    public boolean contains(T x) {
        if(containsNull) return true;
        int basketIndex = getBasketIndex(x.hashCode());
        for (int i = 0; i < values[basketIndex].length; i++) {
            if(values[basketIndex][i] == null) {
                return false;
            } else if(values[basketIndex][i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    void addToBasket(int basketIndex, T element) {
        reorderBasket(basketIndex);
        int index = ++capacities[basketIndex][1];
        values[basketIndex][index] = element;
        size++;
    }

    void reorderBasket(int basketIndex) {
        if (capacities[basketIndex][1] == capacities[basketIndex][0] - 1) {
            int currentCapacity = capacities[basketIndex][0];
            T[] newBasket = (T[]) new Object[currentCapacity * 2];
            System.arraycopy(values[basketIndex], 0, newBasket, 0, currentCapacity);
            values[basketIndex] = newBasket;
            capacities[basketIndex][0] = currentCapacity * 2;
        }
    }

    void reorderCapacity() {
        if(size > capacity * loadFactor) {
            int newCapacity = capacity * 2;
            int[][] newCapacities = new int[newCapacity][2];
            for (int i = 0; i < newCapacity; i++) {
                newCapacities[i][0] = basketSize;
            }
            T[][] newValues = (T[][]) new Object[newCapacity][basketSize];
            List<T> list = getValues();
            for (int i = 0; i < size; i++) {
                T element = list.get(i);
                if (element != null) {
                    int basketIndex = getBasketIndex(element.hashCode(), newCapacity);
                    newValues[basketIndex][newCapacities[basketIndex][1]++] = element;
                    reorderBasket(basketIndex, newValues, newCapacities);
                }
            }
            values = newValues;
            capacity = newCapacity;
            capacities = newCapacities;
        }
    }

    void reorderBasket(int basketIndex, T[][] values, int[][] capacities) {
        if (capacities[basketIndex][1] == capacities[basketIndex][0]) {
            int currentCapacity = capacities[basketIndex][0];
            T[] newBasket = (T[]) new Object[currentCapacity * 2];
            System.arraycopy(values[basketIndex], 0, newBasket, 0, currentCapacity);
            values[basketIndex] = newBasket;
            capacities[basketIndex][0] = currentCapacity * 2;
        }
    }

    public void add(T element) {
        if (element == null) {
            containsNull = true;
            size++;
            return;
        }
        int basketIndex = getBasketIndex(element.hashCode());
        boolean contains = false;
        for (int i = 0; i < values[basketIndex].length; i++) {
            if(values[basketIndex][i] == null) {
                break;
            } else if (values[basketIndex][i].equals(element)) {
                contains = true;
                break;
            }
        }
        if(!contains) addToBasket(basketIndex, element);
        reorderCapacity();
    }

    public void add(T element, T[][] values, int[][] capacities, int capacity) {
        if (element != null) {
            int basketIndex = getBasketIndex(element.hashCode(), capacity);
            values[basketIndex][capacities[basketIndex][1]++] = element;
            reorderBasket(basketIndex, values, capacities);
        }
    }

    public boolean delete(T x) {
        int hash = getBasketIndex(x.hashCode());
        for (int i = 0; i < values[hash].length; i++) {
            if(values[hash][i] != null && values[hash][i].equals(x)) {
                values[hash][i] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    int getBasketIndex(int x) {
        return Math.abs(x) % capacity;
    }

    int getBasketIndex(int x, int capacity) {
        return Math.abs(x) % capacity;
    }

    public List<T> getValues() {
        List<T> list = new ArrayList<>(size);
        int start = containsNull ? 1 : 0;
        for (int i = start; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if(values[i][j] != null) list.add(values[i][j]);
            }
        }
        return list;
    }
}
