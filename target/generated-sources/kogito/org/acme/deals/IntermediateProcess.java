package org.acme.deals;

import org.acme.deals.IntermediateModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("intermediate")
public class IntermediateProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.IntermediateModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    org.acme.deals.IntermediateMessageProducer_2 producer_2;

    @org.springframework.beans.factory.annotation.Autowired()
    org.acme.deals.IntermediateMessageProducer_5 producer_5;

    @org.springframework.beans.factory.annotation.Autowired()
    org.acme.deals.IntermediateMessageProducer_9 producer_9;

    @org.springframework.beans.factory.annotation.Autowired()
    public IntermediateProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public IntermediateProcess() {
    }

    @Override()
    public org.acme.deals.IntermediateProcessInstance createInstance(org.acme.deals.IntermediateModel value) {
        return new org.acme.deals.IntermediateProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.IntermediateProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.IntermediateModel value) {
        return new org.acme.deals.IntermediateProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.IntermediateProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.IntermediateModel value) {
        return new org.acme.deals.IntermediateProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.IntermediateModel createModel() {
        return new org.acme.deals.IntermediateModel();
    }

    public org.acme.deals.IntermediateProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.IntermediateModel) value);
    }

    public org.acme.deals.IntermediateProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.IntermediateModel) value);
    }

    public org.acme.deals.IntermediateProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.IntermediateProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.IntermediateProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.IntermediateProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("intermediate", true);
        factory.variable("start", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("end", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("inter", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("success", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("processid", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.name("intermediate");
        factory.packageName("org.acme.deals");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode1 = factory.actionNode(1);
        actionNode1.name("post out msg");
        actionNode1.action(kcontext -> {
            java.lang.String end = (java.lang.String) kcontext.getVariable("end");
            System.out.println("after sending out msg logging..");
        });
        actionNode1.metaData("UniqueId", "_C025B290-65BC-43E3-97D8-E8184DEC74F4");
        actionNode1.metaData("elementname", "post out msg");
        actionNode1.metaData("NodeType", "ScriptTask");
        actionNode1.metaData("x", 1018);
        actionNode1.metaData("width", 154);
        actionNode1.metaData("y", 504);
        actionNode1.metaData("height", 102);
        actionNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("outgoing");
        actionNode2.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<String>("outgoing", "start", () -> producer_2));
        actionNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("start", "start", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_53AE71D3-B8C9-4CCF-BA04-6819A9E01A35_outmsgInputX", "outmsg", "String", null), null, null));
        actionNode2.metaData("UniqueId", "_53AE71D3-B8C9-4CCF-BA04-6819A9E01A35");
        actionNode2.metaData("TriggerType", "ProduceMessage");
        actionNode2.metaData("Variable", "start");
        actionNode2.metaData("EventType", "message");
        actionNode2.metaData("TriggerRef", "outgoing");
        actionNode2.metaData("elementname", "outgoing");
        actionNode2.metaData("MappingVariableInput", "outmsg");
        actionNode2.metaData("x", 903);
        actionNode2.metaData("width", 56);
        actionNode2.metaData("y", 527);
        actionNode2.metaData("MappingVariable", "start");
        actionNode2.metaData("MessageType", "String");
        actionNode2.metaData("height", 56);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode3 = factory.actionNode(3);
        actionNode3.name("failure intermediate wait");
        actionNode3.action(kcontext -> {
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            System.out.println("failure intermediate wait logging..");
        });
        actionNode3.metaData("UniqueId", "_D36C6871-CB88-4FFC-9795-7F005D562918");
        actionNode3.metaData("elementname", "failure intermediate wait");
        actionNode3.metaData("NodeType", "ScriptTask");
        actionNode3.metaData("x", 490);
        actionNode3.metaData("width", 154);
        actionNode3.metaData("y", 341);
        actionNode3.metaData("height", 102);
        actionNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode4 = factory.actionNode(4);
        actionNode4.name("success intermediate log");
        actionNode4.action(kcontext -> {
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            java.lang.String success = (java.lang.String) kcontext.getVariable("success");
            System.out.println("success intermediate logging..");
        });
        actionNode4.metaData("UniqueId", "_91E21117-8868-4412-9DB1-6A14EBE06AED");
        actionNode4.metaData("elementname", "success intermediate log");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 672);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 177);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode5 = factory.endNode(5);
        endNode5.name("success end");
        endNode5.terminate(false);
        endNode5.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<String>("successend", "success", () -> producer_5));
        endNode5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("success", "success", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_9D480E9F-6294-4B22-BD06-57F27DAD33FB_successendInputX", "successend", "String", null), null, null));
        endNode5.metaData("UniqueId", "_9D480E9F-6294-4B22-BD06-57F27DAD33FB");
        endNode5.metaData("TriggerType", "ProduceMessage");
        endNode5.metaData("Variable", "success");
        endNode5.metaData("EventType", "message");
        endNode5.metaData("TriggerRef", "successend");
        endNode5.metaData("elementname", "success end");
        endNode5.metaData("MappingVariableInput", "successend");
        endNode5.metaData("x", 903);
        endNode5.metaData("width", 56);
        endNode5.metaData("y", 200);
        endNode5.metaData("MappingVariable", "success");
        endNode5.metaData("MessageType", "String");
        endNode5.metaData("height", 56);
        endNode5.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode6 = factory.splitNode(6);
        splitNode6.name("Split");
        splitNode6.type(2);
        splitNode6.metaData("UniqueId", "_9B25EDF9-4D86-4768-B86C-C628EAED042D");
        splitNode6.metaData("x", 539);
        splitNode6.metaData("width", 56);
        splitNode6.metaData("y", 200);
        splitNode6.metaData("Default", null);
        splitNode6.metaData("height", 56);
        splitNode6.constraint(3, "_D762E10E-A99A-4D1D-A45F-DF0FB4E6DAA6", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String start = (java.lang.String) kcontext.getVariable("start");
            java.lang.String end = (java.lang.String) kcontext.getVariable("end");
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            java.lang.String success = (java.lang.String) kcontext.getVariable("success");
            java.lang.String processid = (java.lang.String) kcontext.getVariable("processid");
            return !start.equals("hello");
        }, 0, false);
        splitNode6.constraint(4, "_D0AA2C14-0549-46E4-8C15-E53FA5E3F2DE", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String start = (java.lang.String) kcontext.getVariable("start");
            java.lang.String end = (java.lang.String) kcontext.getVariable("end");
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            java.lang.String success = (java.lang.String) kcontext.getVariable("success");
            java.lang.String processid = (java.lang.String) kcontext.getVariable("processid");
            return start.equals("hello");
        }, 0, false);
        splitNode6.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode7 = factory.actionNode(7);
        actionNode7.name("failure intermediate log");
        actionNode7.action(kcontext -> {
            java.lang.String inter = (java.lang.String) kcontext.getVariable("inter");
            System.out.println("failure intermediate logging..");
        });
        actionNode7.metaData("UniqueId", "_8B59EC84-EF94-4A1C-990B-E75C2CB501F8");
        actionNode7.metaData("elementname", "failure intermediate log");
        actionNode7.metaData("NodeType", "ScriptTask");
        actionNode7.metaData("x", 672);
        actionNode7.metaData("width", 154);
        actionNode7.metaData("y", 504);
        actionNode7.metaData("height", 102);
        actionNode7.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode8 = factory.actionNode(8);
        actionNode8.name("start log");
        actionNode8.action(kcontext -> {
            java.lang.String processid = (java.lang.String) kcontext.getVariable("processid");
            System.out.println("Start message logging...");
            System.out.println("process id : " + kcontext.getProcessInstance().getStringId());
            processid = kcontext.getProcessInstance().getStringId();
        });
        actionNode8.metaData("UniqueId", "_67491F3B-762C-4294-983A-B29A43C5AD86");
        actionNode8.metaData("elementname", "start log");
        actionNode8.metaData("NodeType", "ScriptTask");
        actionNode8.metaData("x", 289);
        actionNode8.metaData("width", 154);
        actionNode8.metaData("y", 177);
        actionNode8.metaData("height", 102);
        actionNode8.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode9 = factory.endNode(9);
        endNode9.name("end");
        endNode9.terminate(false);
        endNode9.action(new org.jbpm.process.instance.impl.actions.ProduceEventAction<String>("end", "end", () -> producer_9));
        endNode9.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("end", "end", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_3B856E42-5EFF-4213-BEEC-630BC2D55481_endInputX", "end", "String", null), null, null));
        endNode9.metaData("UniqueId", "_3B856E42-5EFF-4213-BEEC-630BC2D55481");
        endNode9.metaData("TriggerType", "ProduceMessage");
        endNode9.metaData("Variable", "end");
        endNode9.metaData("EventType", "message");
        endNode9.metaData("TriggerRef", "end");
        endNode9.metaData("elementname", "end");
        endNode9.metaData("MappingVariableInput", "end");
        endNode9.metaData("x", 1256);
        endNode9.metaData("width", 56);
        endNode9.metaData("y", 527);
        endNode9.metaData("MappingVariable", "end");
        endNode9.metaData("MessageType", "String");
        endNode9.metaData("height", 56);
        endNode9.done();
        org.jbpm.ruleflow.core.factory.EventNodeFactory<?> eventNode10 = factory.eventNode(10);
        eventNode10.name("intermediate");
        eventNode10.eventType("Message-intermediate");
        eventNode10.variableName("inter");
        eventNode10.inputVariableName("inter");
        eventNode10.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_A7B4ED32-3255-4C8B-A5EA-7F4D3BE5F724_interOutputX", "inter", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("inter", "inter", "java.lang.Object", null), null, null));
        eventNode10.metaData("UniqueId", "_A7B4ED32-3255-4C8B-A5EA-7F4D3BE5F724");
        eventNode10.metaData("TriggerType", "ConsumeMessage");
        eventNode10.metaData("EventType", "message");
        eventNode10.metaData("TriggerRef", "intermediate");
        eventNode10.metaData("elementname", "intermediate");
        eventNode10.metaData("x", 539);
        eventNode10.metaData("width", 56);
        eventNode10.metaData("y", 527);
        eventNode10.metaData("MappingVariable", "inter");
        eventNode10.metaData("MessageType", "String");
        eventNode10.metaData("height", 56);
        eventNode10.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode11 = factory.startNode(11);
        startNode11.name("start");
        startNode11.interrupting(true);
        startNode11.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_A5207201-613B-44E9-84BA-978C5A1EFED0_startOutputX", "start", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("start", "start", "java.lang.Object", null), null, null));
        startNode11.metaData("TriggerMapping", "start");
        startNode11.metaData("UniqueId", "_A5207201-613B-44E9-84BA-978C5A1EFED0");
        startNode11.metaData("TriggerType", "ConsumeMessage");
        startNode11.metaData("EventType", "message");
        startNode11.metaData("TriggerRef", "start");
        startNode11.metaData("elementname", "start");
        startNode11.metaData("x", 156);
        startNode11.metaData("width", 56);
        startNode11.metaData("y", 200);
        startNode11.metaData("MappingVariable", "start");
        startNode11.metaData("TriggerMappingInput", "start");
        startNode11.metaData("MessageType", "String");
        startNode11.metaData("height", 56);
        startNode11.done();
        startNode11.trigger("start", java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_A5207201-613B-44E9-84BA-978C5A1EFED0_startOutputX", "start", "String", null)), new org.jbpm.workflow.core.impl.DataDefinition("start", "start", "java.lang.Object", null), null, null)));
        factory.connection(2, 1, "_7550E5BB-F379-4039-A7F9-55877B91B965");
        factory.connection(7, 2, "_58734449-F4FB-4879-908C-67A261BA1EC8");
        factory.connection(6, 3, "_D762E10E-A99A-4D1D-A45F-DF0FB4E6DAA6");
        factory.connection(6, 4, "_D0AA2C14-0549-46E4-8C15-E53FA5E3F2DE");
        factory.connection(4, 5, "_874EB13F-522A-483F-AEDE-B30E2677108E");
        factory.connection(8, 6, "_26E546AE-3F7F-489C-AD8A-AEF4C7AC684F");
        factory.connection(10, 7, "_F02BEE59-CAD9-45B9-9BFC-C9D7C5EBCAEA");
        factory.connection(11, 8, "_587F9DC7-4434-4596-9880-303ADD460154");
        factory.connection(1, 9, "_90E7701C-80C9-407A-AA98-C7BA5A2872CC");
        factory.connection(3, 10, "_DEFAFAE1-9DE1-41E2-A44B-79DB7F42EEBE");
        factory.validate();
        return factory.getProcess();
    }
}
