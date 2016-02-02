import oata.*;

public class HelloWorldTest extends junit.framework.TestCase {

    public void testSayHelloShouldGreetWithName() {
    	HelloWorld robot = new HelloWorld();
    	String name = "Ronnie";

    	assertEquals("Hello " + name, robot.sayHello(name));
    }

    public void testSaysHeyBudIfNoName() {
    	HelloWorld robot = new HelloWorld();

    	assertEquals("Hey bud!", robot.sayHello());
    }
    
}
