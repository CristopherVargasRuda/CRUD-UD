package app.logic;

import app.models.Person;
import data.PersonBD;
import java.util.ArrayList;
import java.util.Set;

public class PeopleCRUD {

    private PersonFactory personFactory;
    private PersonBD personBD;

    public PeopleCRUD() {
        personFactory = new PersonFactory();
        personBD = new PersonBD();
    }

    public void createPerson(String name, String lastName, String id, String email, String position) {
        Person person = personFactory.getPersonModel(position);
        person.setName(name);
        person.setLastName(lastName);
        person.setId(id);
        person.setEmail(email);
        try {
            personBD.insert(person);
        } catch (Exception e) {
        }
    }

    public ArrayList<String> getPersonByID(String id) {
        ArrayList<String> personData = null;
        try {
            Person person = personBD.getById(id);
            if (person.getName() != null) {
                personData = new ArrayList<>();
                System.out.println(person.getName());
                personData.add(person.getName());
                personData.add(person.getLastName());
                personData.add(person.getEmail());
                personData.add(person.getPosition());
            }
        } catch (Exception e) {
        }

        return personData;
    }

    public void modifyPerson(String name, String lastName, String id, String email, String position) {
        Person person = personFactory.getPersonModel(position);
        person.setName(name);
        person.setLastName(lastName);
        person.setId(id);
        person.setEmail(email);
        try {
            personBD.update(person);
        } catch (Exception e) {
        }
    }

    public void deletePerson(String id) {
        try {
            personBD.delete(id);
        } catch (Exception e) {
        }
    }

    public ArrayList<ArrayList<String>> getPeopleList() {
        ArrayList<ArrayList<String>> people = new ArrayList<>();
        try {
            for (Person person : personBD.getAll()) {
                System.out.println(person.getName());
                ArrayList<String> personData = new ArrayList<>();
                personData.add(person.getId());
                personData.add(person.getName());
                personData.add(person.getLastName());
                personData.add(person.getEmail());
                if (person.getPosition().equals("1")) {
                    personData.add("Student");
                } else if (person.getPosition().equals("2")) {
                    personData.add("Teacher");
                } else {
                    personData.add("Operator");
                }
                people.add(personData);
            }
        } catch (Exception e) {
        }
        return people;
    }

}
