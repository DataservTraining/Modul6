import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DemoData {
	public static List<Person> createDemoData() {
		final List<Person> persons = new ArrayList<>();
		persons.add(new Person("Michael", 44));
		persons.add(new Person("Barbara", 22, Gender.FEMALE));
		persons.add(new Person("Lili", 17, Gender.FEMALE));
		persons.add(new Person("Tom", 8));
		persons.add(new Person("Björn", 7));
		return persons;
	}

	public static List<String> createDemoNames() {
		final List<String> names = new ArrayList<>();
		names.add("Max");
		names.add(""); // Leereintrag
		names.add("Andy");
		names.add(" "); // potenziell auch ein "Leereintrag"
		names.add("Stefan");

		return names;
	}

	public static <E> void removeAll(final List<E> list, final Predicate<? super E> condition) {

		final Iterator<E> it = list.iterator();

		while (it.hasNext()) {
			if (condition.test(it.next())) {
				it.remove();
			}
		}
	}

	private static List<Person> createPersons() {
		final List<Person> persons = Arrays.asList(new Person("Michael", 44, Gender.MALE, "Zürich"),
				new Person("Merten", 39, Gender.MALE, "Aachen"), new Person("Babsi", 42, Gender.FEMALE, "Hamburg"),
				new Person("Lili", 22, Gender.FEMALE, "Aachen"), new Person("Tim", 44, Gender.MALE, "Kiel"),
				new Person("Mike", 26, Gender.MALE, "Kiel"));
		return persons;
	}
	

	private static Function<Person, String> createRegionClassifier() {
		final Function<Person, String> classifier = person -> {
			if (Arrays.asList("Kiel", "Hamburg").contains(person.getCity()))
				return "Nordlichter";
			if (person.getCity().equals("Aachen"))
				return "Öcher";
			return "Others";
		};
		return classifier;
	}
}
