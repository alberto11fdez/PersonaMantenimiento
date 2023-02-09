package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PersonaTest {
    Persona p = new Persona("Pepe",12,"Male");


    @Test
    void PersonGenderNotExist(){
        assertThrows(NoGenderException.class, () -> p.gender());
    }

    @Test
    void PersonAgeNegative(){
        assertThrows(AgeNegativeException.class, () -> p.age());
    }

}
