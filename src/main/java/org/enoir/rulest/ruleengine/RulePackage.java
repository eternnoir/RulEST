package org.enoir.rulest.ruleengine;

import org.enoir.rulest.ruleengine.drools.Resource;

import java.util.List;

/**
 * Created by frank on 2015/4/18.
 */
public abstract class RulePackage {
    protected String name;
    abstract public String getName();
    abstract public void  onCreate(RulePackageManager rpm);
    abstract public List<Resource> getResources();
}
