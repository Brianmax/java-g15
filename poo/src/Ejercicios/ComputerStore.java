package Ejercicios;

import pooTeoria.Computer;

import java.util.ArrayList;
public class ComputerStore {
    private ArrayList<Computer> computers;
    private String name;
    private String address;
    private int quantity;

    public ComputerStore(String name, String address) {
        this.computers = new ArrayList<>();
        this.name = name;
        this.address = address;
        this.quantity = 0;
    }

    public ComputerStore() {
    }


    public void agregarComputadora(Computer computer) {
        computers.add(computer);
        quantity++;
    }
}
