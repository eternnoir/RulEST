package org.enoir.rulest.ruleengine.drools;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import org.kie.api.runtime.ObjectFilter;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Created by frank on 2015/4/2.
 */
public class FactHelper {
    public static Collection<Object> findFacts(StatefulKnowledgeSession session, final String className) {

        ObjectFilter filter = new ObjectFilter() {
            @Override
            public boolean accept(Object object) {
                return true;
            }
        };

        Collection<FactHandle> factHandles = session.getFactHandles();
        Collection<Object> facts = new ArrayList<Object>();
        for (FactHandle handle : factHandles) {
            Object fact = session.getObject(handle);
            facts.add(fact);
        }
        return facts;
    }

    private void setValue(Object o,Map<String, Object> propertyMap){
        for(String key:propertyMap.keySet()){
            try {
                Field aField = o.getClass().getDeclaredField(key);
                aField.set(o,propertyMap.get(key));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
