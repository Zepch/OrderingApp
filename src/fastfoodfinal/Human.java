package fastfoodfinal;
import java.io.Serializable;

/**
 * Represents a person within the fast-food system. This class can be used
 * to model customers, staff, or other human stakeholders.
 */
public class Human implements Serializable{
    private String name;
    private char gender;
    private int age;

    /**
     * Creates a Human object with specified name, gender, and age.
     * @param name The person's full name.
     * @param gender The person's gender ('M', 'F', or other if applicable).
     * @param age The person's age in years.
     */
    public Human(String name, char gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;}
    
     /**
     * Creates a new Human object with default values.
     */
    public Human() {}

    // getters
    /** 
   * this is to get Name in String
   * @return  return name in String
   */
    public String getName() { return name; }
    /** 
   * this is to get Gender in String
   * @return  return gender in String
   */
    public char getGender() { return gender; }
    /** 
   * this is to get Age in String
   * @return  return age in String
   */
    public int getAge() { return age; }

    // setters
    /** 
   * this is to set Name
   * @param name name of Human
   */
    public void setName(String name) { this.name = name; }
     /** 
   * this is to set Gender
   * @param gender gender of Human
   */
    public void setGender(char gender) { this.gender = gender; }
     /** 
   * this is to set Age
   * @param age age of Human
   */
    public void setAge(int age) { this.age = age; }
}
