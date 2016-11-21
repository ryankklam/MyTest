package book.springinaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import book.springinaction.springidol.Auditorium;
import book.springinaction.springidol.Performer;

public class SpringInActionMain {
	
	  public static void main(String[] args) {
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("book/springinaction/springidol/spring-idol.xml");
		    Performer performer = (Performer) ctx.getBean("duke");
		    performer.perform();
		    
		    Performer poeticPerformer = (Performer) ctx.getBean("poeticduke");
		    poeticPerformer.perform();
		    
		    Performer JinglePerformer = (Performer) ctx.getBean("kenny");
		    JinglePerformer.perform();
		    
//		    Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");	    
	  }
}
