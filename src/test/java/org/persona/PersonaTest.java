package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonaTest {
    Persona persona1 = new Persona("Pepe",12,"Male");

//----------------------------------------------------------------------------------------------------------------------
   @Test
    void GenderOfPerson1(){

        String gender1 = persona1.gender();
        String expectedValue = "Male";

        assertEquals(expectedValue.toLowerCase(),gender1.toLowerCase());
    }



    @Test
    void Person1GenderNotExist(){
        assertThrows(AgeNegativeException.class, () -> persona1.gender());
    }

    @Test
    void Person1AgeNegative(){
        assertThrows(AgeNegativeException.class, () -> persona1.age());
    }

    @Test
    void prueba(){
       String s="h";
       String n="h";

       assertEquals(s,n);
    }



}