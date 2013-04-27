package lab2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * See if you can modify this class to use Spring as in Lab1.
 */
public class Startup {

    public static void main(String[] args) {
        // First create some low-level instances using
        // Liskov Substitution Principle

	
	final AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
		       new String[] {"applicationContext.xml"});
	


        // Next, create the high-level class
        TipService tipMgr = (TipService)ctx.getBean("tip"); //gets from spring!
	
        TipCalculator calc1 = tipMgr.getTipCalculator();	
	
        // Now ask the tip manager to do some work...
        double tip = tipMgr.getTip();
        String quality = tipMgr.getServiceQuality();

        // Now prove it works...
        System.out.println("\nThe tip for the "
                + calc1.getClass().getSimpleName() + " is: "
                + tip + ", with a service qualilty of: " + quality);

    }

}
