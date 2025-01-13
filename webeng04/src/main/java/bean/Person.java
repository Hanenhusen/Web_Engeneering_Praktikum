package bean;
import java.io.Serializable;

public class Person implements java.io.Serializable {
    public Person (){}
    public Person (String lastName, String firstName, int age){
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;


    }

    private String lastName;

    public String getLastName (){

        return lastName;

    }
    public void setLastName(String _lastName){

        this.lastName = _lastName;

    }

    private String firstName;

    public String getFirstName(){

        return firstName;

    }
    public void setFirstName(String _firstName){

        this.firstName = _firstName;

    }

    private int age;

    public int getAge (){

        return age;

    }
    public void setAge(int _age){

        this.age = _age;

    }



}