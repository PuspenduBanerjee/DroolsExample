package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.dto.Department;

/**
 * This is a sample class to launch a rule.
 */
public class DecisionTable2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(DecisionTable2.class);

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-dtables");

            // go !
			Department department = new Department();
			department.divisionId = 100;
			department.id = 99;
			kSession.insert(department);
            kSession.fireAllRules();
			LOGGER.info("Department: {} ", GSONPrettyPrinter.INSTANCE.toJson(department));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
