package org.persona;

import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Pepe", 12, "mAle");
        Persona p2 = new Persona("Juan", 70, "MaLe");
        Persona p3 = new Persona("Alberto", 20, "maLe");
        Persona p4 = new Persona("Lucia", 12, "female");
        Persona p5 = new Persona("Barbara", 20, "Female");
        Persona p6 = new Persona("Marta", 70, "femAle");

        List<Persona> lista = new LinkedList<Persona>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        Persona x = new Persona("a",1,"male");

        System.out.println("Media Hombre: " + x.averageAgePerGender(lista)[0] + ", Media Mujeres: " + x.averageAgePerGender(lista)[1]);
    }
}
