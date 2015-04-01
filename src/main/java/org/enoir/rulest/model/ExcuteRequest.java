package org.enoir.rulest.model;

import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
public class ExcuteRequest extends RulESTBaseModel{
    private List<Rule> targetRules;
    private List<Fact> Facts;

    public List<Rule> getTargetRules() {
        return targetRules;
    }

    public void setTargetRules(List<Rule> targetRules) {
        this.targetRules = targetRules;
    }

    public List<Fact> getFacts() {
        return Facts;
    }

    public void setFacts(List<Fact> facts) {
        Facts = facts;
    }
}
