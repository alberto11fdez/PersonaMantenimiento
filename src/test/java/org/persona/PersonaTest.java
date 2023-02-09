package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


public class PersonaTest {
    Persona persona = new Persona("David",20,"male");
    Persona p1 = new Persona("", 20, "male");

//Name------------------------------------------------------------------------------------------------------------------

    @Test
    void NameOfPersonIsNotEmpty(){
        String gender = persona.name();
        String expectedValue = "";

        assertNotEquals(expectedValue.toLowerCase(),gender.toLowerCase());
    }



    @Test
    void NameOfThePerson(){
        String name1 = persona.name();
        String expectedValue = "David";
        assertEquals(expectedValue.toUpperCase(), name1.toUpperCase());
    }

    /*
    @Test
    void NameOfPersonIsNotEmpty(){
        assertThrows(NameEmptyException.class, () -> persona.name());
    }

     */

//Gender----------------------------------------------------------------------------------------------------------------
    @Test
    void GenderOfPersonIsNotEmpty(){
        String gender = persona.gender();
        String expectedValue = "";

        assertTrue(gender.toUpperCase().equals("MALE") || gender.toUpperCase().equals("FEMALE"));
    }

    @Test
    void GenderOfPerson(){

        String gender = persona.gender();
        String expectedValue = "Male";

        assertEquals(expectedValue.toLowerCase(),gender.toLowerCase());
    }
/*
    @Test
    void GenderPersonNotExist(){
        assertThrows(GenderPersonNotExist().class, () -> persona.gender());
    }

 */

//Age-------------------------------------------------------------------------------------------------------------------

    @Test
    void AgeOfPerson(){
       int age = persona.age();
       int expectedValue = 20;
       assertEquals(expectedValue,age);
    }

    @Test
    void AgeOfPersonRange(){
        int age = persona.age();
        int expectedValue = 20;
        assertTrue(age>=0 && age<=150);
    }

    /*
    @Test
    void AgeOfPersoneNotNegative(){
        assertThrows(AgeNegativeException.class, () -> persona.age());
    }

     */

//Average---------------------------------------------------------------------------------------------------------------

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

       double[] media = persona.averageAgePerGender(lista);
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


        double[] media = persona.averageAgePerGender(lista);
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

        double[] media = persona.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0;
        expectedValue[1] = 34;
        assertEquals(expectedValue[0], media[0]);
        assertEquals(expectedValue[1], media[1]);
    }

    @Test
    void CheckAverageEmpty(){
        assertThrows(AverageEmpty.class, () -> persona.averageAgePerGender(new LinkedList<>()));

    }

}