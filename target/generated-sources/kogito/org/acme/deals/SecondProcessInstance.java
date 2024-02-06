package org.acme.deals;

import org.acme.deals.SecondModel;

public class SecondProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<SecondModel> {

    public SecondProcessInstance(org.acme.deals.SecondProcess process, SecondModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public SecondProcessInstance(org.acme.deals.SecondProcess process, SecondModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public SecondProcessInstance(org.acme.deals.SecondProcess process, SecondModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public SecondProcessInstance(org.acme.deals.SecondProcess process, SecondModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public SecondProcessInstance(org.acme.deals.SecondProcess process, SecondModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(SecondModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(SecondModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
