package org.enoir.rulest.test;

import static org.junit.Assert.*;

import org.enoir.rulest.ruleengine.drools.KnowledgeManager;
import org.enoir.rulest.ruleengine.drools.PathType;
import org.enoir.rulest.ruleengine.drools.Resource;
import org.junit.*;
import org.kie.api.io.ResourceType;
import org.kie.internal.definition.KnowledgePackage;

import java.util.Collection;

/**
 * Created by frank on 2015/4/2.
 */
public class KnowledgeManagerTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddRule(){
        KnowledgeManager km = new KnowledgeManager();
        Resource r = new Resource("test.drl", PathType.CLASSPATH,ResourceType.DRL);
        km.addResource(r);
        Collection<KnowledgePackage> packages = km.getKnowledgePackages();
        assertEquals(packages.size(),1);
    }
}
