package app.logic;

import app.models.*;

public class PersonFactory {

    public Person getPersonModel(String position) {
        if (position.equals("Student")) {
            return new Student();
        } else if (position.equals("Teacher")) {
            return new Teacher();
        } else if (position.equals("Operator")) {
            return new Operator();
        } else {
            return null;
        }
    }
    
}
