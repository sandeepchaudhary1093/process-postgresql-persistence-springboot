/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.acme.deals;

import java.util.Optional;
import java.util.function.Function;
import org.kie.kogito.process.Process;
import org.kie.kogito.addon.cloudevents.spring.SpringMessageConsumer;
import org.kie.kogito.event.EventReceiver;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Component()
public class SecondMessageConsumer_5 extends SpringMessageConsumer<SecondModel, String> {

    @Autowired
    @Qualifier("second")
    Process<SecondModel> process;

    @Autowired
    EventReceiver eventReceiver;

    @PostConstruct
    void init() {
        init(process, "second", String.class, eventReceiver);
    }

    private SecondModel eventToModel(String event) {
        SecondModel model = new SecondModel();
        if (event != null) {
            model.setEnd(event);
        }
        return model;
    }

    @Override()
    protected Optional<Function<String, SecondModel>> getModelConverter() {
        return Optional.of(this::eventToModel);
    }
}
