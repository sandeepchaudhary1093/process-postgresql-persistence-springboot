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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "intermediate", name = "Intermediate", hidden = true)
@ProcessInput(processName = "intermediate")
public class IntermediateModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<IntermediateModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "processid")
    @javax.validation.Valid()
    private java.lang.String processid;

    public java.lang.String getProcessid() {
        return processid;
    }

    public void setProcessid(java.lang.String processid) {
        this.processid = processid;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "success")
    @javax.validation.Valid()
    private java.lang.String success;

    public java.lang.String getSuccess() {
        return success;
    }

    public void setSuccess(java.lang.String success) {
        this.success = success;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "inter")
    @javax.validation.Valid()
    private java.lang.String inter;

    public java.lang.String getInter() {
        return inter;
    }

    public void setInter(java.lang.String inter) {
        this.inter = inter;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "start")
    @javax.validation.Valid()
    private java.lang.String start;

    public java.lang.String getStart() {
        return start;
    }

    public void setStart(java.lang.String start) {
        this.start = start;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "end")
    @javax.validation.Valid()
    private java.lang.String end;

    public java.lang.String getEnd() {
        return end;
    }

    public void setEnd(java.lang.String end) {
        this.end = end;
    }

    @Override()
    public IntermediateModel toModel() {
        IntermediateModel result = new IntermediateModel();
        result.setProcessid(getProcessid());
        result.setSuccess(getSuccess());
        result.setInter(getInter());
        result.setStart(getStart());
        result.setEnd(getEnd());
        return result;
    }
}
