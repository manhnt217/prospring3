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


import com.vaadin.server.CustomizedSystemMessages;
import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;

public class ApplicationMessagesProvider implements SystemMessagesProvider {
    @Override
    public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo) {
        final CustomizedSystemMessages customizedSystemMessages = new CustomizedSystemMessages();
        customizedSystemMessages.setSessionExpiredNotificationEnabled(false);
        customizedSystemMessages.setOutOfSyncNotificationEnabled(false);
        customizedSystemMessages.setAuthenticationErrorNotificationEnabled(false);
        customizedSystemMessages.setCommunicationErrorNotificationEnabled(false);
        customizedSystemMessages.setCookiesDisabledNotificationEnabled(false);

        return customizedSystemMessages;
    }
}
