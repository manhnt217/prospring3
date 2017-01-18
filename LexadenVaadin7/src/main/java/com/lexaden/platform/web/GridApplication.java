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

package com.lexaden.platform.web;


import com.lexaden.platform.view.person.service.PersonViewService;
import com.vaadin.server.Sizeable;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Grid application
 */
public class GridApplication extends UI {
    private Log LOGGER = LogFactory.getLog(GridApplication.class);
    @Autowired
    private PersonViewService personViewService;

    /**
     * Initializes the application.
     */
    @Override
    public void init(VaadinRequest request) {
        final Panel panel = new Panel("Grid Demo");
        panel.setWidth(850, Sizeable.Unit.PIXELS);
        panel.setContent(personViewService.buildPersonsGrid());

        setContent(panel);

        getPage().setTitle("Grid Demo");
    }

}
