package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.logger.*;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");

            // go !
            kSession.fireAllRules();
            
            Straz s = new Straz();
            kSession.insert(s);
            kSession.fireAllRules();
                       
            kLogger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static class Pomiar {
    	public static boolean dym;
    	public static float temperatura;
    }
    
    public static class Pozar { };
    
    public static class Telefon {
    	public static int numer;
    	
    	public Telefon(int x) {
    		numer = x;
    	}
    }
    
    public static class Straz { };
    

}
