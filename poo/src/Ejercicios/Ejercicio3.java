package Ejercicios;

import pooTeoria.Computer;

import java.util.ArrayList;

public class Ejercicio3 {
    public static void main(String[] args) {
        ComputerStore computerStore = new ComputerStore("SC", "address");

        Computer computer = new Computer("Lenovo", "kjsjsjs", 23, 233);

        computerStore.agregarComputadora(new Computer("HP", "KSKSK", 4, 222));
        computerStore.agregarComputadora(computer);
    }
}
