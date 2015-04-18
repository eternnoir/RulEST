package org.enoir.rulest.ruleengine;

import org.reflections.Reflections;

import java.util.*;

/**
 * Created by frank on 2015/4/18.
 */
public class RulePackageManager {

    private Map<String,RulePackage> rulePackageMap;
    public RulePackageManager(){
        this.rulePackageMap = new HashMap<String, RulePackage>();
        this.reloadAllRulePackages();
    }

    public void reloadAllRulePackages(){
        this.rulePackageMap = new HashMap<String, RulePackage>();
        Reflections reflections = new Reflections("org.enoir");
        Set<Class<? extends RulePackage>> subTypes =
                reflections.getSubTypesOf(RulePackage.class);
        for(Class rp : subTypes){
            try {
                RulePackage rpi = (RulePackage) rp.newInstance();
                rpi.onCreate(this);
                this.rulePackageMap.put(rpi.getName(),rpi);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public List<RulePackage> getRulePackages(){
        return new ArrayList<RulePackage>(this.rulePackageMap.values());
    }
}
