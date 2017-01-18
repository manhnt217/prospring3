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

import com.lexaden.platform.system.ApplicationContextLocator;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * The class is used to load ApplicationContext.
 */
public class ApplicationContextListener implements ServletContextListener {
    /**
     * Initializes the application context by web flow xml configs.
     *
     * @param servletContextEvent the servlet context event.
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();
        final WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        ApplicationContextLocator.setApplicationContext(context);
    }

    /**
     * Sets the application context to null.
     *
     * @param servletContextEvent the servlet context event.
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ApplicationContextLocator.setApplicationContext(null);
    }
}

