package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


public class PersonaTest {
    Persona persona = new Persona("David",20,"male");
    //Persona p1 = new Persona("", 20, "male");

//Name------------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que el nombre de la persona es justamente "David". En caso contrario, el assert indicará el fallo.
     */
    @Test
    void NameOfThePerson(){
        String name1 = persona.name();
        String expectedValue = "David";
        assertEquals(expectedValue.toUpperCase(), name1.toUpperCase());
    }


    /**
     * Comprueba que el nombre de la persona no esta vacio. En caso contrario, el assert indicará el fallo.
     */
    @Test
    void NameOfPersonIsNotEmpty(){
        Persona p1 = new Persona("", 2, "male");
        assertThrows(NameEmptyException.class, () -> p1.name().equals(""));
    }

    /**
     * Comprueba que el nombre de la persona no esta vacio. En caso contrario, el assert indicará el fallo.
     */
    /*
    @Test
    void NameOfPersonIsNotEmpty(){
        String name = persona.name();
        String expectedValue = "";

        assertNotEquals(expectedValue.toLowerCase(),name.toLowerCase());
    }

     */



//Gender----------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que se introduzca un género para la persona. En caso contrario, el assert indicará que no se ha
     * introducido el género de la persona y dará fallo.
     */
    @Test
    void GenderOfPersonIsNotEmpty(){
        String gender = persona.gender();
        String expectedValue = "";

        assertTrue(!gender.toUpperCase().equals(expectedValue) || !gender.toUpperCase().equals(expectedValue));
    }

    /**
     * Comprueba que el género introducido es male o female, sin importar mayúsculas o minúsculas. En caso de introducir,
     * cualquier otro string, el assert indicará el fallo.
      */
    @Test
    void GenderOfPersonIsMaleOrFemale(){
        String gender = persona.gender();

        assertTrue(gender.toUpperCase().equals("MALE") || gender.toUpperCase().equals("FEMALE"));
    }

    /**
     * Comprueba que el género introducido de esta persona es male. Si se modifica, y se introduce female o cualquier
     * otro string el assert indicará el fallo.
     */
    @Test
    void GenderOfPerson(){

        String gender = persona.gender();
        String expectedValue = "Male";

        assertEquals(expectedValue.toLowerCase(),gender.toLowerCase());
    }


    /**
     * Comprueba que el género de la persona no se encuentre vacio. En caso de estar vacío, lanza la excepción
     * GenderEmptyException.
     */
    @Test
    void GenderPersonNotExist(){
        Persona p1 = new Persona("Marcos", 19, "");
        assertThrows(GenderEmptyException.class, () -> p1.gender().equals(""));
    }



//Age-------------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que la edad de esta persona es de 20 años. En caso de no ser así, el assert indicará el fallo.
     */
    @Test
    void AgeOfPerson(){
       int age = persona.age();
       int expectedValue = 20;
       assertEquals(expectedValue,age);
    }


    /**
     *  Comprueba que la edad introducida de la persona no esté fuera del rango de 0-130. En caso contrario, el assert
     *  indicará el fallo.
     */
    @Test
    void AgeOfPersonRange(){
        int age = persona.age();
        assertTrue(age>=0 && age<=130);
    }


    @Test
    void AgeOfPersoneNotNegative(){
        Persona p1 = new Persona("Alberto", 1112, "Male");
        //Persona p1 = new Persona("Alberto", -111, "Male");
        assertThrows(AgeOutOfRangeException.class, () -> p1.age());

    }

//Average---------------------------------------------------------------------------------------------------------------

    /**
     * Realiza la media de 3 hombres y 3 mujeres y comprueba que cada una tiene un valor de 34.
     * (Caso en el que hay hombres y mujeres).
     */
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

    /**
     * Realiza la media de 3 hombres y comprueba que tiene un valor de 34 y la media de las mujeres (al no haber) es 0.
     * (Caso en el que hay hombres, pero no mujeres).
     */

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

    /**
     * Realiza la media de 3 mujeres y comprueba que tiene un valor de 34 y la media de los hombres (al no haber) es 0.
     * (Caso en el que hay mujeres, pero no hombres).
     */
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

    /**
     * Comprueba que no existen ni hombres ni mujeres para hacerles la media, por lo que lanza
     * la excepción AverageEmpty para indicarlo.
     * (Caso en el que no hay ni hombres ni mujeres).
     */
    @Test
    void CheckAverageEmpty(){
        assertThrows(AverageEmpty.class, () -> persona.averageAgePerGender(new LinkedList<>()));

    }

}