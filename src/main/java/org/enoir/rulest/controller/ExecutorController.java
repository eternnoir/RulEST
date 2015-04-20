package org.enoir.rulest.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.enoir.rulest.model.ErrorMsg;
import org.enoir.rulest.model.ExcuteRequest;
import org.enoir.rulest.model.Fact;
import org.enoir.rulest.model.RulESTBaseModel;
import org.enoir.rulest.ruleengine.Exception.RulePackageNotFoundException;
import org.enoir.rulest.ruleengine.RulePackageManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by frank on 2015/4/1.
 */
@RestController
public class ExecutorController {

    @RequestMapping(value = "/execute",method = RequestMethod.POST)
    public RulESTBaseModel execute(HttpServletRequest request) {
        String jsonString = "";
        ExcuteRequest excuteRequest = null;
        try {
            jsonString = IOUtils.toString(request.getInputStream());
            if(jsonString.isEmpty()){
                throw new Exception("Json String is empty");
            }
            excuteRequest = convertJsonToExecuteRequest(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorMsg("00","Parse json error");
        }catch (Exception ex){
            ex.printStackTrace();
            return new ErrorMsg("00", ex.getMessage());
        }
        return excuteRequest;
    }

    private ExcuteRequest convertJsonToExecuteRequest(String jsonString) throws RulePackageNotFoundException {
        JsonParser parser = new JsonParser();
        JsonObject jsonObj = (JsonObject)parser.parse(jsonString);
        String targetPackage = jsonObj.get("targetRulePackage").getAsString();
        JsonArray jsonFacts = jsonObj.getAsJsonArray("Facts");
        List<Fact> facts = RulePackageManager.getInstance().getRulePackage(targetPackage).parseJsonToFact(jsonFacts);
        ExcuteRequest er = new ExcuteRequest();
        er.setFacts(facts);
        er.setTargetRulePackage(targetPackage);
        return er;
    }
}
