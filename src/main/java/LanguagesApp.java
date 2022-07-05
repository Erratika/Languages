import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class LanguagesApp {
	public void run() {

		while (true) {
			SayHelloInterface say;

			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose a language from below by entering associated value.");
			HashMap<Integer, String> helloMap = new HashMap<>();
			helloMap.put(1, "English");
			helloMap.put(2, "French");
			helloMap.put(3, "Spanish");
			helloMap.put(4, "Italian");
			helloMap.put(5, "German");
			helloMap.put(6, "Turkish");

			for (Entry<Integer,String> entry : helloMap.entrySet()) {
				System.out.println(entry.getKey().toString() + " : " + entry.getValue());
			}

			say = switch (Integer.parseInt(scanner.next())) {
				case 1 -> new EnglishHello();
				case 2 -> new FrenchHello();
				case 3 -> new SpanishHello();
				case 4 -> new ItalianHello();
				case 5 -> new GermanHello();
				case 6 -> new TurkishHello();
				default -> throw new IllegalArgumentException("No Language selected");
			};

			try {
				System.out.println(say.sayHello());
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
