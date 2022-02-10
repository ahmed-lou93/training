package clinic.programming.training;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @since 02/02/2022
 * @author ahmed
 *
 */
@NoArgsConstructor
public class Application {

	public int countWords(String words) {
		String[] separateWords = StringUtils.split(words, ' ');
		return (separateWords == null) ? 0 : separateWords.length;
	}

	public void greet() {
		List<String> greetings = new ArrayList<>();
		greetings.add("Hello");
		for (String greeting : greetings) {
			System.out.println("Greeting: " + greeting);
		}
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
		int count = app.countWords("I have four words");
		System.out.format("Word Count: %d .", count);
	}
}