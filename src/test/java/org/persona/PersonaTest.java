package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonaTest {
    Persona persona1 = new Persona("David",20,"male");

//----------------------------------------------------------------------------------------------------------------------
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

    /*@Test
    void Person1GenderNotExist(){
        assertThrows(AgeNegativeException.class, () -> persona1.gender());
    }

    @Test
    void Person1AgeNegative(){
        assertThrows(AgeNegativeException.class, () -> persona1.age());
    }


     */


}