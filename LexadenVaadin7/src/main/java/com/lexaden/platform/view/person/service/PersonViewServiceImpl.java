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

package com.lexaden.platform.view.person.service;


import com.lexaden.grid.Grid;
import com.lexaden.platform.business.person.Person;
import com.lexaden.platform.business.person.service.PersonService;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonViewServiceImpl implements PersonViewService {
    @Autowired
    private PersonService personService;


    @Override
    public Grid buildPersonsGrid() {
        final Table table = new Table();
        final List<Person> persons = personService.createPersonList();

        table.setContainerDataSource(new BeanItemContainer<Person>(Person.class, persons));
        table.setWidth(100, Sizeable.Unit.PERCENTAGE);
        int tableSize = table.size();
        if (tableSize > 20) {
            table.setHeight(400, Sizeable.Unit.PIXELS);
        }
        table.setPageLength(tableSize);
        table.setColumnCollapsingAllowed(true);
        table.setColumnReorderingAllowed(true);

        table.setVisibleColumns(new Object[]{"firstName", "lastName", "birthday", "score", "height", "female"});

        table.setColumnHeaders(new String[]{"First Name", "Last Name", "Birthday", "Score", "Height", "Female"});

        table.setSelectable(true);

        return new Grid(table);
    }
}
