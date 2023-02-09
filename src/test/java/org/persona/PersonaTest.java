package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


public class PersonaTest {
    Persona persona1 = new Persona("David",20,"male");

//----------------------------------------------------------------------------------------------------------------------
    @Test
    void GenderOfPerson1IsNotEmpty(){
        String gender1 = persona1.gender();
        String expectedValue = "";

        assertNotEquals(expectedValue.toLowerCase(),gender1.toLowerCase());
    }

    @Test
    void NameOfPerson1IsNotEmpty(){
        String gender1 = persona1.name();
        String expectedValue = "";

        assertNotEquals(expectedValue.toLowerCase(),gender1.toLowerCase());
    }

    @Test
    void GenderOfPerson1(){

        String gender1 = persona1.gender();
        String expectedValue = "Male";

        assertEquals(expectedValue.toLowerCase(),gender1.toLowerCase());
    }

    @Test
    void AgeOfPerson1(){
       int age1 = persona1.age();
       int expectedValue = 20;
       assertEquals(expectedValue,age1);
    }

    @Test
    void NameOfPerson1(){
       String name1 = persona1.name();
       String expectedValue = "David";
       assertEquals(expectedValue.toUpperCase(), name1.toUpperCase());
    }

    @Test
    void CheckAverageWithMalesAndFemales(){

        Persona p1 = new Persona("Pepe", 12, "mAle");
        Persona p2 = new Persona("Juan", 70, "MaLe");
        Persona p3 = new Persona("Alberto", 20, "maLe");
        Persona p4 = new Persona("Lucia", 12, "Female");
        Persona p5 = new Persona("Barbara", 20, "female");
        Persona p6 = new Persona("Marta", 70, "fEmAlE");

        List<Persona> lista = new LinkedList<Persona>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

       double[] media = persona1.averageAgePerGender(lista);
       double[] expectedValue = new double[2];
       expectedValue[0] = 34;
       expectedValue[1] = 34;
       assertEquals(expectedValue[0], media[0]);
       assertEquals(expectedValue[1], media[1]);
    }

    @Test
    void CheckAverageWithOnlyMales(){

        Persona p1 = new Persona("Pepe", 12, "mAle");
        Persona p2 = new Persona("Juan", 70, "MaLe");
        Persona p3 = new Persona("Alberto", 20, "maLe");


        List<Persona> lista = new LinkedList<Persona>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);


        double[] media = persona1.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 34;
        expectedValue[1] = 0;
        assertEquals(expectedValue[0], media[0]);
        assertEquals(expectedValue[1], media[1]);
    }

    @Test
    void CheckAverageWithOnlyFemales(){

        Persona p4 = new Persona("Lucia", 12, "Female");
        Persona p5 = new Persona("Barbara", 20, "feMale");
        Persona p6 = new Persona("Marta", 70, "female");

        List<Persona> lista = new LinkedList<Persona>();
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        double[] media = persona1.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0;
        expectedValue[1] = 34;
        assertEquals(expectedValue[0], media[0]);
        assertEquals(expectedValue[1], media[1]);
    }

    @Test
    void CheckAverageEmpty(){
        assertThrows(AverageEmpty.class, () -> persona1.averageAgePerGender(new LinkedList<>()));

    }

    /*@Test
    void Person1GenderNotExist(){
        assertThrows(AgeNegativeException.class, () -> persona1.gender());
    }

    @Test
    void Person1AgeNegative(){
        assertThrows(AgeNegativeException.class, () -> persona1.age());
    }


     */

     //hazme un test que compruebe que si la edad es negativa, se lanza una excepción


}