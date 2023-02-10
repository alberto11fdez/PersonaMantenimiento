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
        this.gender=gender;
    }

    /**
     * Get de name, devulve el nombre de la persona o lanza una excepción NameEmptyException si el nombre esta vacio
     * después de haberlo introducido en el constructor.
     * @return
     */
    public String name(){
        if(name == ""){
            throw new NameEmptyException("No puede dejar el nombre vacio");
        }else {
            return name;
        }
    }

    /**
     * Get de age, devulve la edad de la persona o lanza una excepción AgeOutOfRangeException si es negativo o mayor de 130 (número relativo por
     * si alguna persona vive más años de los que vivio Jeanne Calment -> 122 años y 164 días).
     * @return
     */

    public int age() {
        if(age < 0 || age > 130){
            throw new AgeOutOfRangeException("No puedes no haber nacido o ser un muerto viviente");
        }else{
            return age;
        }
    }

    /**
     * Get de gender, devuelve el género de la persona o lanza una excepción NoGenderException si el genero no coincide
     * con los generos predefinidos, Male y Female.
     * @return
     */
    public String gender(){
        if(gender.toUpperCase().equals("MALE") || gender.toUpperCase().equals("FEMALE")){
            return gender.toUpperCase();
        }else{
            throw new GenderEmptyException("No existe ese genero");
        }
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

        double [] average = new double[2];

        for (int i = 0; i < persons.size(); i++){
            if(persons.get(i).gender.toUpperCase().equals("MALE")){
                ageMale += persons.get(i).age;
                contMale++;
            }else if(persons.get(i).gender.toUpperCase().equals("FEMALE")){
                ageFemale += persons.get(i).age;
                contFemale++;
            }
        }

        if(persons.isEmpty()){
            throw new AverageEmpty("No existen personas");
        }else if(ageMale == 0 ){
            average[0] = 0;
            average[1] = ageFemale/contFemale;
        }else if(ageFemale == 0){
            average [0] = ageMale/contMale;
            average [1] = 0;
        }else{
            average[0] = ageMale/contMale;
            average[1] = ageFemale/contFemale;
        }

        return average;
    }


}
