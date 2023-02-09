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

        if(age < 0 || age > 150){
            throw new AgeNegativeException("No puedes no haber nacido o ser un muerto viviente");
        }else{
            this.age = age;
        }

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

        int contMale=0;
        int contFemale=0;
        int ageMale=0;
        int ageFemale=0;

        double [] average = null;

        for (int i = 0; i < persons.size(); i++){
            if(persons.get(i).gender == "Male"){
                ageMale += persons.get(i).age;
                contMale++;
            }else if(persons.get(i).gender == "Female"){
                ageFemale += persons.get(i).age;
                contFemale++;
            }
        }
        average[0] = ageMale/contMale;
        average[1] = ageFemale/contFemale;
        return average;
    }

}
