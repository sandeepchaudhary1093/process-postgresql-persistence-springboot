package org.acme.deals;

import org.acme.deals.SecondModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("second")
public class SecondProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.SecondModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    org.acme.deals.SecondMessageProducer_3 producer_3;

    @org.springframework.beans.factory.annotation.Autowired()
    public SecondProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public SecondProcess() {
    }

    @Override()
    public org.acme.deals.SecondProcessInstance createInstance(org.acme.deals.SecondModel value) {
        return new org.acme.deals.SecondProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.SecondProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.SecondModel value) {
        return new org.acme.deals.SecondProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.SecondProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.SecondModel value) {
        return new org.acme.deals.SecondProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.SecondModel createModel() {
        return new org.acme.deals.SecondModel();
    }

    public org.acme.deals.SecondProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.SecondModel) value);
    }

    public org.acme.deals.SecondProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.SecondModel) value);
    }

    public org.acme.deals.SecondProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.SecondProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.SecondProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.SecondProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("second", true);
        factory.variable("end", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("secondEnd", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("inter", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("second");
        factory.packageName("org.acme.deals");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode1 = factory.actionNode(1);
        actionNode1.name("second inter");
        actionNode1.action(kcontext -> {
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            System.out.println("Second after intermediate...");
        });
        actionNode1.metaData("UniqueId", "_B2762559-8298-455B-B9F3-ABE7A5253376");
        actionNode1.metaData("elementname", "second inter");
        actionNode1.metaData("NodeType", "ScriptTask");
        actionNode1.metaData("x", 957);
        actionNode1.metaData("width", 154);
        actionNode1.metaData("y", 254);
        actionNode1.metaData("height", 102);
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.EventNodeFactory<?> eventNode2 = factory.eventNode(2);
        eventNode2.name("intersec");
        eventNode2.eventType("Message-intersec");
        eventNode2.variableName("inter");
        eventNode2.inputVariableName("inter");
        eventNode2.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_447BEEFA-EEAA-474E-AF62-646A2C41289F_interOutputX", "inter", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("inter", "inter", "java.lang.Object", null), null, null));
        eventNode2.metaData("UniqueId", "_447BEEFA-EEAA-474E-AF62-646A2C41289F");
        eventNode2.metaData("TriggerType", "ConsumeMessage");
        eventNode2.metaData("EventType", "message");
        eventNode2.metaData("Documentation", "intermediate");
        eventNode2.metaData("TriggerRef", "intersec");
        eventNode2.metaData("elementname", "intersec");
        eventNode2.metaData("x", 812);
        eventNode2.metaData("width", 56);
        eventNode2.metaData("y", 277);
        eventNode2.metaData("MappingVariable", "inter");
        eventNode2.metaData("MessageType", "String");
        eventNode2.metaData("height", 56);
        eventNode2.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode3 = factory.endNode(3);
        endNode3.name("endsec");
        endNode3.terminate(false);
        endNode3.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<String>("endsec", "secondEnd", () -> producer_3));
        endNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("secondEnd", "secondEnd", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_338B414E-81D6-459C-9A70-3F0EF479E992_secondendInputX", "secondend", "String", null), null, null));
        endNode3.metaData("UniqueId", "_338B414E-81D6-459C-9A70-3F0EF479E992");
        endNode3.metaData("TriggerType", "ProduceMessage");
        endNode3.metaData("Variable", "secondEnd");
        endNode3.metaData("EventType", "message");
        endNode3.metaData("TriggerRef", "endsec");
        endNode3.metaData("elementname", "endsec");
        endNode3.metaData("MappingVariableInput", "secondend");
        endNode3.metaData("x", 1200);
        endNode3.metaData("width", 56);
        endNode3.metaData("y", 277);
        endNode3.metaData("MappingVariable", "secondEnd");
        endNode3.metaData("MessageType", "String");
        endNode3.metaData("height", 56);
        endNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode4 = factory.actionNode(4);
        actionNode4.name("log second");
        actionNode4.action(kcontext -> {
            System.out.println("Second Start message logging...");
            System.out.println("process id : " + kcontext.getProcessInstance().getStringId());
        });
        actionNode4.metaData("UniqueId", "_6941ED9E-9968-4BAC-B628-E195C62B4D12");
        actionNode4.metaData("elementname", "log second");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 543);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 254);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode5 = factory.startNode(5);
        startNode5.name("second");
        startNode5.interrupting(false);
        startNode5.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_41E2BB6E-2A2B-4DFF-8E2E-A8805B2D61F5_endOutputX", "end", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("end", "end", "java.lang.Object", null), null, null));
        startNode5.metaData("TriggerMapping", "end");
        startNode5.metaData("UniqueId", "_41E2BB6E-2A2B-4DFF-8E2E-A8805B2D61F5");
        startNode5.metaData("TriggerType", "ConsumeMessage");
        startNode5.metaData("EventType", "message");
        startNode5.metaData("TriggerRef", "second");
        startNode5.metaData("elementname", "second");
        startNode5.metaData("x", 357);
        startNode5.metaData("width", 56);
        startNode5.metaData("y", 277);
        startNode5.metaData("MappingVariable", "end");
        startNode5.metaData("TriggerMappingInput", "end");
        startNode5.metaData("MessageType", "String");
        startNode5.metaData("height", 56);
        startNode5.done();
        startNode5.trigger("second", java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_41E2BB6E-2A2B-4DFF-8E2E-A8805B2D61F5_endOutputX", "end", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("end", "end", "java.lang.Object", null), null, null)));
        factory.connection(2, 1, "_20B0C0D6-7A86-42A5-BEAF-341A37E2591B");
        factory.connection(4, 2, "_0C0A781B-70EE-4C8D-BAC7-EA798A45B707");
        factory.connection(1, 3, "_87B96F9B-ED0F-40E0-8286-29650A5DE35B");
        factory.connection(5, 4, "_937252CF-42AB-4736-91C0-AD90977171A7");
        factory.validate();
        return factory.getProcess();
    }
}
