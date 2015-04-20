package org.enoir.rulest.sample;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.enoir.rulest.model.Fact;
import org.enoir.rulest.ruleengine.RulePackage;
import org.enoir.rulest.ruleengine.RulePackageManager;
import org.enoir.rulest.ruleengine.drools.Resource;
import sun.plugin2.message.Message;

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

    @Override
    public List<Fact> parseJsonToFact(JsonArray jsonFacts) {
        Gson gson = new Gson();
        List<Fact> facts = gson.fromJson(jsonFacts, new TypeToken<List<SampleFact>>() {}.getType());
        return facts;
    }
}
