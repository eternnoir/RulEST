package org.enoir.rulest.ruleengine.drools;

import org.drools.core.marshalling.impl.ProtobufMessages;
import org.kie.internal.runtime.StatefulKnowledgeSession;

/**
 * Created by frank on 2015/4/2.
 */
public class KnowledgeManager {
    private ProtobufMessages.KnowledgeBase kbase;
    private StatefulKnowledgeSession ksession;

}
