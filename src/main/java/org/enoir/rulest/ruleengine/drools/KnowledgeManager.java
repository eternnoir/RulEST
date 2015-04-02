package org.enoir.rulest.ruleengine.drools;

import org.kie.api.io.ResourceType;
import org.kie.internal.KnowledgeBase;
import org.kie.internal.KnowledgeBaseFactory;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.definition.KnowledgePackage;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.enoir.rulest.ruleengine.drools.PathType.*;

/**
 * Created by frank on 2015/4/2.
 */
public class KnowledgeManager {
    private KnowledgeBuilder kBuilder;
    private StatefulKnowledgeSession ksession;
    private List<Resource> resources ;

    public KnowledgeManager(){
        this.kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        this.resources = new ArrayList<Resource>();
    }

    public void addResource(Resource r){
        switch (r.getPathType()) {
            case CLASSPATH:
                this.kBuilder.add(ResourceFactory.newClassPathResource(r.getPath()),r.getType());
                break;
            case FILE:
                this.kBuilder.add(ResourceFactory.newFileResource(r.getPath()),r.getType());
                break;
            case URL:
                this.kBuilder.add(ResourceFactory.newUrlResource(r.getPath()),r.getType());
                break;
            default:
                throw new RuntimeException("not support pathtype");
        }
        if(this.kBuilder.hasErrors()){
            throw new RuntimeException(this.kBuilder.getErrors().toString());
        }
    }

    public void fireAll(){
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(this.kBuilder.getKnowledgePackages());
        this.ksession = kbase.newStatefulKnowledgeSession();
        this.ksession.fireAllRules();
    }

    public Collection<KnowledgePackage> getKnowledgePackages(){
        return this.kBuilder.getKnowledgePackages();
    }

    public void initSession(){

    }

}
