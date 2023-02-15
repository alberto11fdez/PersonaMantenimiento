package org.persona;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

//No se ha empleado en ningún momento la herramienta ChatGPT, por lo que el punto de:
//"Si se usa ChatGPT, incluir un fichero "chatgpt.pdf" en la raíz del proyecto que describa cómo lo habéis utilizado
// (podéis incluir las preguntas y las respuestas obtenidas) y comentad vuestra opinión sobre su uso en el ejercicio."
//no se incluye ningun chatgpt.pdf en el proyecto.

public class PersonTest {

//Name------------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que el nombre de la persona es justamente "David". En caso contrario, el assert indicará el fallo.
     */
    @Test
    void NameOfThisPersonIsDavid(){
        Person person = new Person("David",20,"male");
        String expectedValue = "David";
        assertEquals(expectedValue.toUpperCase(), person.name().toUpperCase(),"Error: el nombre de esta persona no es David");
    }


    /**
     * Comprueba que el nombre de la persona esta vacio. Si es así, el assert lanzará una excecpción con un mensaje de error.
     * .isBlank() es un boolean que devuelve true si p1.name() esta vacío o tiene la cadena vacía.
     */
    @Test
    void NameOfThisPersonIsEmpty(){
        Person person = new Person("", 2, "male");
        assertThrows(RuntimeException.class, () -> person.name().isBlank(), "Error: nombre vacio");
    }


//Gender----------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que el género de la persona es vacio. Si es así, el assert lanzará una excepción con un mensaje de error
     * indicando que no se ha introducido el género de la persona.
     */
    @Test
    void GenderOfThisPersonIsEmpty(){
        Person person = new Person("David",20,"");
        assertThrows(RuntimeException.class, () -> person.gender().isEmpty(), "Error: género de la persona no introducido");
    }

    /**
     * Comprueba si el género introducido es distinto de male, sin importar mayúsculas o minúsculas. En ese caso, se lanzará
     * excepción con su correspondiente mensaje de error.
     */
    @Test
    void GenderOfThisPersonIsDiferentThatMale(){
        Person person = new Person("David",20,"hola");
        assertThrows(RuntimeException.class, () -> person.gender().toUpperCase().equals("MALE"),"Error: esta persona no es un hombre");
    }

   /**
     * Comprueba si el género introducido es distinto de female, sin importar mayúsculas o minúsculas. En ese caso, se lanzará
     * excepción con su correspondiente mensaje de error.
     */
    @Test
    void GenderOfThisPersonIsDiferentThatFemale(){
        Person person = new Person("David",20,"hola");
        assertThrows(RuntimeException.class, () -> person.gender().toUpperCase().equals("FEMALE") ,"Error: esta persona no es mujer");
    }

    /**
     * Comprueba si el género de la persona se encuentre vacio. En caso de estar vacío, lanza excepción con un mensaje de error.
     * .isBlank() es un boolean que devuelve true si p1.gender() esta vacío o tiene la cadena vacía.
     */
    @Test
    void GenderOfThisPersonIsAEmptyString(){
        Person person = new Person("Marcos", 19, "");
        assertThrows(RuntimeException.class, () -> person.gender().equals(""), "El genero de una persona no puede ser la cadena vacia");
    }

    /**
     * Comprueba que el genero de la persona es male, indistintamente de mayusculas o minusculas. En caso contrario, el assert indicará el fallo.
     */
    @Test
    void GenderOfDavidIsMale(){
        Person person = new Person("David", 19, "MALE");
        String valorEsperado = "Male";
        assertEquals(person.gender().toUpperCase(), valorEsperado.toUpperCase(), "Error: el genero de David no es correcto (male) ");
    }

    /**
     * Comprueba que el genero de la persona es female, indistintamente de mayusculas o minusculas. En caso contrario, el assert indicará el fallo.
     */
    @Test
    void GenderOfBarbaraIsFemale(){
        Person person = new Person("Barbara", 19, "Female");
        String valorEsperado = "female";
        assertEquals(person.gender().toUpperCase(), valorEsperado.toUpperCase(), "Error: el genero de Barbara no es correcto (female) ");
    }



//Age-------------------------------------------------------------------------------------------------------------------

    /**
     * Comprueba que la edad de esta persona es de 20 años. En caso de no ser así, el assert indicará el fallo.
     */
    @Test
    void AgeOfThisPerson20(){
        Person person = new Person("David",20,"male");
       int expectedValue = 20;
       assertEquals(expectedValue,person.age());
    }


    /**
     *  Comprueba que la edad introducida de la persona no es mayor de 130 años. En caso contrario, el assert
     *  lanzará excepción, indicando el error.
     */
    @Test
    void AgeOfThisPersoneIsMoreThan130(){
        Person person = new Person("Alberto", 131, "Male");
        assertThrows(RuntimeException.class, () -> person.age(), "Error: Fuera de rango, edad introducida >=130 años");

    }

    /**
     *  Comprueba que la edad introducida de la persona no es negativa. En caso contrario, el assert
     *  lanzará excepción, indicando el error.
     */
    @Test
    void AgeOfThisPersoneIsNegative(){
        Person person = new Person("Alberto", -1, "Male");
        assertThrows(RuntimeException.class, () -> person.age(), "Error: Fuera de rango, edad introducida <=0 años (Negativo)");
    }


//Average---------------------------------------------------------------------------------------------------------------

    /**
     * Realiza la media de 3 hombres y 3 mujeres y comprueba que la de los hombres es de 34 años y la de las mujeres es
     * 28 años.
     * (Caso en el que hay hombres y mujeres).
     */
    @Test
    void CheckAverageWithMalesAndFemales(){

        Person person = new Person("David",20,"male");

        Person person1 = new Person("Pepe", 12, "male");
        Person person2 = new Person("Juan", 70, "male");
        Person person3 = new Person("Alberto", 20, "male");
        Person person4 = new Person("Lucia", 17, "female");
        Person person5 = new Person("Barbara", 21, "female");
        Person person6 = new Person("Marta", 46, "female");

        List<Person> lista = new LinkedList<Person>();
        lista.add(person1);
        lista.add(person2);
        lista.add(person3);
        lista.add(person4);
        lista.add(person5);
        lista.add(person6);

       double[] media = person.averageAgePerGender(lista);
       double[] expectedValue = new double[2];
       expectedValue[0] = 34;
       expectedValue[1] = 28;
       assertEquals(expectedValue[0], media[0]);
       assertEquals(expectedValue[1], media[1]);
    }


    /**
     * Realiza la media de 3 hombres y comprueba que tiene un valor de 34 años y la media de las mujeres (al no haber) es 0.
     * (Caso en el que hay hombres, pero no mujeres).
     */

    @Test
    void CheckAverageWithOnlyMales(){
        Person person = new Person("David",20,"male");

        Person person1 = new Person("Pepe", 12, "male");
        Person person2 = new Person("Juan", 70, "male");
        Person person3 = new Person("Alberto", 20, "male");


        List<Person> lista = new LinkedList<Person>();
        lista.add(person1);
        lista.add(person2);
        lista.add(person3);


        double[] media = person.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 34;
        expectedValue[1] = 0;
        assertEquals(expectedValue[0], media[0]);
        assertEquals(expectedValue[1], media[1]);
    }



    /**
     * Realiza la media de 3 mujeres y comprueba que tiene un valor de 28 y la media de los hombres (al no haber) es 0.
     * (Caso en el que hay mujeres, pero no hombres).
     */


    @Test
    void CheckAverageWithOnlyFemales(){
        Person person = new Person("Maria",20,"female");

        Person person1 = new Person("Lucia", 17, "female");
        Person person2 = new Person("Barbara", 21, "female");
        Person person3 = new Person("Marta", 46, "female");

        List<Person> lista = new LinkedList<Person>();
        lista.add(person1);
        lista.add(person2);
        lista.add(person3);

        double[] media = person.averageAgePerGender(lista);
        double[] expectedValue = new double[2];
        expectedValue[0] = 0;
        expectedValue[1] = 28;
        assertEquals(expectedValue[0], media[0]);
        assertEquals(expectedValue[1], media[1]);
    }

    /**
     * Comprueba que no existen ni hombres ni mujeres para hacerles la media, por lo que lanza
     * una Excepción con un mensaje de error para indicarlo.
     * (Caso en el que no hay ni hombres ni mujeres).
     */
    @Test
    void CheckAverageEmpty(){
        Person person = new Person("David",20,"male");
        assertThrows(RuntimeException.class, () -> person.averageAgePerGender(new LinkedList<Person>()),"Error: no existen personas a las que hacerles la media.");

    }

}