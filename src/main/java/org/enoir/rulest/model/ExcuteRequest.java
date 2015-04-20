package org.enoir.rulest.model;

import com.google.gson.annotations.SerializedName;
import org.enoir.rulest.ruleengine.RulePackage;

import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
public class ExcuteRequest extends RulESTBaseModel{
    private RulePackage targetRulePackage;
    private List<Fact> Facts;

    public List<Fact> getFacts() {
        return Facts;
    }

    public void setFacts(List<Fact> facts) {
        Facts = facts;
    }

    public RulePackage getTargetRulePackage() {
        return targetRulePackage;
    }

    public void setTargetRulePackage(RulePackage targetRulePackage) {
        this.targetRulePackage = targetRulePackage;
    }
}
