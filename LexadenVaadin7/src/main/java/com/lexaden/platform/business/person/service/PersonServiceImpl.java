/*
 * Copyright 2012 Lexaden.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.lexaden.platform.business.person.service;


import com.lexaden.platform.business.person.Person;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    private Log LOGGER = LogFactory.getLog(PersonServiceImpl.class);

    @Override
    public List<Person> createPersonList() {
        final List<Person> persons = new ArrayList<Person>();

        Person person;

        person = new Person();
        person.setFirstName("Victoria");
        person.setLastName("Azarenka");
        setBirthday(person, "1989-07-31");
        person.setScore(10595);
        person.setHeight(1.83f);
        persons.add(person);

        person = new Person();
        person.setFirstName("Maria");
        person.setLastName("Sharapova");
        setBirthday(person, "1987-04-19");
        person.setScore(10045);
        person.setHeight(1.88f);
        persons.add(person);

        person = new Person();
        person.setFirstName("Serena");
        person.setLastName("Williams");
        setBirthday(person, "1981-09-26");
        person.setScore(9750);
        person.setHeight(1.75f);
        persons.add(person);

        person = new Person();
        person.setFirstName("Agnieszka");
        person.setLastName("Radwanska");
        setBirthday(person, "1989-03-06");
        person.setScore(7505);
        person.setHeight(1.72f);
        persons.add(person);

        person = new Person();
        person.setFirstName("Angelique");
        person.setLastName("Kerber");
        setBirthday(person, "1988-01-18");
        person.setScore(5550);
        person.setHeight(1.73f);
        persons.add(person);

        return persons;
    }

    private void setBirthday(Person person, String source) {
        try {
            person.setBirthday(new SimpleDateFormat("yyyy-mm-dd").parse(source));
        } catch (ParseException e) {
            LOGGER.trace(e);
        }
    }
}
