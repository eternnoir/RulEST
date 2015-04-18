package org.enoir.rulest.test;

import org.enoir.rulest.ruleengine.RulePackage;
import org.enoir.rulest.ruleengine.RulePackageManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by frank on 2015/4/18.
 */
public class RulePackageManagerTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInit(){
        RulePackageManager rpm = RulePackageManager.getInstance();
    }


    @Test
    public void testDefaultPackageSize(){
        RulePackageManager rpm = RulePackageManager.getInstance();
        Assert.assertEquals(rpm.getRulePackages().size(),1);
    }

    @Test
    public void testDefaultPackageName(){
        RulePackageManager rpm =  RulePackageManager.getInstance();
        Assert.assertEquals(rpm.getRulePackages().size(),1);
        RulePackage firstRp = rpm.getRulePackages().get(0);
        Assert.assertEquals(firstRp.getName(),"SampleRP");
    }
}
