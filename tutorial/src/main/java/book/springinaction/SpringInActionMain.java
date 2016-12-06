package book.springinaction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import book.springinaction.springidol.Auditorium;
import book.springinaction.springidol.ISong;
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
		    
//		    Auditorium auditorium = (Auditorium) ctx.getBean("auditorium");	 //设置了init-method ，即使没有用这个bean，其实也已经加载了
		    
		    Performer pianoPerformer = (Performer) ctx.getBean("penny");
		    pianoPerformer.perform(); //piano在xml配置声明为内部bean，内部bean没有id属性（虽然可以配置），这是内部bean最大的缺点，不能被复用
		    
		    
		    Performer itinerantSinger = (Performer) ctx.getBean("KimLing");
		    itinerantSinger.perform();
		    
		    //KimLingBestSong是从KimLing bean里面的装配 用SpEL random选出
		    ISong kimLingBestSong = (ISong) ctx.getBean("KimLingBestSong");
		    System.out.println("KimLingBestSong: " + kimLingBestSong.getTitle());
		    ;
		    
	  }
}
