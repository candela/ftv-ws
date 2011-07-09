package com.candela.ftvws;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;


@Repository
public class PersonDao {

    static {
        ObjectifyService.register(Person.class);
    }


    public PersonDao() {
        Objectify ofy = ObjectifyService.begin();

        Person p1 = new Person();
        p1.setId((long) 1);
        p1.setName("P1");
        p1.setAge(27);
        p1.setAddress("Address");

        ofy.put(p1);

        Person p2 = new Person();
        p2.setId((long) 2);
        p2.setName("P2");
        p2.setAge(25);
        p2.setAddress("Address");

        ofy.put(p2);
    }

    public List<Person> getPersons() {
        Objectify ofy = ObjectifyService.begin();
        Query<Person> q = ofy.query(Person.class);
        return q.list();
    }

    public Person getPerson(int id) {
        Objectify ofy = ObjectifyService.begin();
        return ofy.find(Person.class, (long) id);
    }

    public void savePerson(Person person) {
        Objectify ofy = ObjectifyService.begin();
        ofy.put(person);
        System.out.println("Saving " + person);
    }
}