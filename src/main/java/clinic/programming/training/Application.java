package clinic.programming.training;

import java.util.ArrayList;
import java.util.List;

/**
 * @since 02/02/2022
 * @author ahmed
 *
 */
public class Application {

	public void greet() {
		List<String> greetings = new ArrayList<String>();
		greetings.add("Hello");
		for (String greeting : greetings) {
			System.out.println("Greeting: " + greeting);
		}
	}

	public Application() {
		System.out.println("Inside Application");
	}

	/**
	 * method main(): ALWAYS the APPLICATION entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting Application");
		Application app = new Application();
		app.greet();
	}
}