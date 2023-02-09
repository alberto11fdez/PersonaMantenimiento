package org.persona;
import java.util.List;

/**
 * Class representing a person with a name, age and gender
 *
 * @author Alberto Fernández Ramos
 */

public class Persona {
    private final String name;
    private final int age;
    private final String gender; //Male, Female

    /**
     * Constructs a person with a name, age and gender
     *
     * @param name the name of the person
     * @param age the age of the person
     * @param gender the gender of the person
     */

    public Persona(String name, int age, String gender){
        this.name = name;
        this.age = age;
        if(gender.toUpperCase() != "Male" || gender.toUpperCase() != "Female"){
            throw new NoGenderException("No existe ese genero");
        }else{
            this.gender = gender;
        }

    }

    public String name(){ return name;}

    public int age() { return age; }

    public String gender(){
        return gender;
    }

    /**
     * Computes the averrage age of male and female in a List and returns the result in
     * an array of two elements (the first element is the male age and the second one is the
     * female mean age)
     *
     * @param persons
     * @return
     */

    public double[] averageAgePerGender(List<Persona> persons){
        return null;
    }

}
