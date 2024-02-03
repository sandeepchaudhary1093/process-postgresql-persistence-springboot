package org.acme.deals;

import org.acme.deals.IntermediateModel;

public class IntermediateProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<IntermediateModel> {

    public IntermediateProcessInstance(org.acme.deals.IntermediateProcess process, IntermediateModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public IntermediateProcessInstance(org.acme.deals.IntermediateProcess process, IntermediateModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public IntermediateProcessInstance(org.acme.deals.IntermediateProcess process, IntermediateModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public IntermediateProcessInstance(org.acme.deals.IntermediateProcess process, IntermediateModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public IntermediateProcessInstance(org.acme.deals.IntermediateProcess process, IntermediateModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(IntermediateModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(IntermediateModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
