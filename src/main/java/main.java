import org.persona.Person;

import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Person p1 = new Person("Pepe", 12, "mAle");
        Person p2 = new Person("Juan", 70, "fewwe");
        Person p3 = new Person("Alberto", 20, "maLe");
        Person p4 = new Person("Lucia", 12, "male");
        Person p5 = new Person("Barbara", 20, "male");
        Person p6 = new Person("Marta", 70, "male");
        System.out .println(p1.gender().toUpperCase().equals("MALE"));
        System.out .println(p2.gender());


        /*

        List<Person> lista = new LinkedList<Person>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        Person x = new Person("a",1,"male");

        System.out.println("Media Hombre: " + x.averageAgePerGender(lista)[0] + ", Media Mujeres: " + x.averageAgePerGender(lista)[1]);

        List<Person> lista1 = new LinkedList<Person>();


        System.out.println(p1.averageAgePerGender(lista));


        //Persona p = new Persona("lucia", , "Male");

         */
    }
}
