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
package org.kie.kogito.app;

import org.kie.kogito.event.cloudevents.CloudEventMeta;

@org.springframework.context.annotation.Configuration()
public class ProcessCloudEventMetaFactory {

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_PRODUCED_outgoing() {
        return new CloudEventMeta("process.intermediate.outgoing", "/process/intermediate", org.kie.kogito.event.EventKind.PRODUCED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_CONSUMED_start() {
        return new CloudEventMeta("start", "", org.kie.kogito.event.EventKind.CONSUMED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_PRODUCED_successend() {
        return new CloudEventMeta("process.intermediate.successend", "/process/intermediate", org.kie.kogito.event.EventKind.PRODUCED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_PRODUCED_end() {
        return new CloudEventMeta("process.intermediate.end", "/process/intermediate", org.kie.kogito.event.EventKind.PRODUCED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_CONSUMED_intersec() {
        return new CloudEventMeta("intersec", "", org.kie.kogito.event.EventKind.CONSUMED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_CONSUMED_second() {
        return new CloudEventMeta("second", "", org.kie.kogito.event.EventKind.CONSUMED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_PRODUCED_endsec() {
        return new CloudEventMeta("process.second.endsec", "/process/second", org.kie.kogito.event.EventKind.PRODUCED);
    }

    @org.springframework.context.annotation.Bean()
    public CloudEventMeta buildCloudEventMeta_CONSUMED_intermediate() {
        return new CloudEventMeta("intermediate", "", org.kie.kogito.event.EventKind.CONSUMED);
    }
}
