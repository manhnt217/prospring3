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

package com.lexaden.platform.system.configuration;

import com.lexaden.platform.business.person.service.PersonService;
import com.lexaden.platform.business.person.service.PersonServiceImpl;
import com.lexaden.platform.view.person.service.PersonViewService;
import com.lexaden.platform.view.person.service.PersonViewServiceImpl;
import com.lexaden.platform.web.GridApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class PersonServiceContext {
    @Bean
    @Scope(WebApplicationContext.SCOPE_SESSION)
    public GridApplication gridApplication() {
        return new GridApplication();
    }

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Bean
    public PersonViewService personViewService() {
        return new PersonViewServiceImpl();
    }
}