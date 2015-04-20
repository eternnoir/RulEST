package org.enoir.rulest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
public class ExcuteRequest extends RulESTBaseModel{
    private String targetRulePackage;
    private List<Fact> Facts;

    public List<Fact> getFacts() {
        return Facts;
    }

    public void setFacts(List<Fact> facts) {
        Facts = facts;
    }

    public String getTargetRulePackage() {
        return targetRulePackage;
    }

    public void setTargetRulePackage(String targetRulePackage) {
        this.targetRulePackage = targetRulePackage;
    }
}
