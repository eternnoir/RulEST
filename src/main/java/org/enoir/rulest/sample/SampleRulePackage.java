package org.enoir.rulest.sample;

import org.enoir.rulest.ruleengine.RulePackage;
import org.enoir.rulest.ruleengine.RulePackageManager;
import org.enoir.rulest.ruleengine.drools.Resource;

import java.util.List;

/**
 * Created by frank on 2015/4/18.
 */
public class SampleRulePackage extends RulePackage {
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void onCreate(RulePackageManager rpm) {
        this.name = "SampleRP";
    }

    @Override
    public List<Resource> getResources() {
        return null;
    }
}
