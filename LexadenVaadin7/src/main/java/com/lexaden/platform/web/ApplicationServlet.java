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

import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinServletService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The class is responsible for application bean and application locale initialization.
 */
@SuppressWarnings("serial")
public class ApplicationServlet extends VaadinServlet {

    private static final Log LOGGER = LogFactory.getLog(ApplicationServlet.class);

    @Override
    protected VaadinServletService getService() {
        final VaadinServletService service = super.getService();
        service.setSystemMessagesProvider(new ApplicationMessagesProvider());
        return service;
    }


}