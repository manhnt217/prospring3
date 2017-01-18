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
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.UI;
import org.springframework.context.ApplicationContext;

public class ApplicationUIProvider extends UIProvider {
    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        VaadinRequest request = event.getRequest();

        Object uiBeanNameObj = request
                .getService()
                .getDeploymentConfiguration()
                .getApplicationOrSystemProperty("UIBean",
                        null);

        if (uiBeanNameObj instanceof String) {
            String uiBeanName = uiBeanNameObj.toString();
            final ApplicationContext applicationContext = ApplicationContextLocator.getApplicationContext();
            final Class<? extends UI> bean = (Class<? extends UI>) applicationContext.getType(uiBeanName);
            if (bean != null) {
                return bean;
            } else {
                ClassLoader classLoader = request.getService().getClassLoader();
                try {
                    Class<? extends UI> uiClass = Class.forName(uiBeanName, true,
                            classLoader).asSubclass(UI.class);

                    return uiClass;
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException("Could not find UI class", e);
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public UI createInstance(UICreateEvent event) {
        VaadinRequest request = event.getRequest();
        Object uiBeanNameObj = request
                .getService()
                .getDeploymentConfiguration()
                .getApplicationOrSystemProperty("UIBean",
                        null);

        //Stored in VaadinSession to use it in
        // the ApplicationScope later to initialize vaadin application scope beans
        final Integer uiId = event.getUiId();
        VaadinSession.getCurrent().setAttribute("applicationScope.UiId", uiId);

        if (uiBeanNameObj instanceof String) {
            String uiBeanName = uiBeanNameObj.toString();
            return (UI) ApplicationContextLocator.getBean(uiBeanName);
        }
        return super.createInstance(event);
    }
}
