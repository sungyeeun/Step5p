package singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g = (Greeter)ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		ctx.close();
		
		Greeter g2 = (Greeter)ctx.getBean("greeter", Greeter.class);
		String msg2 = g2.greet("스프링");
		System.out.println(msg);
		ctx.close();
	}
}
