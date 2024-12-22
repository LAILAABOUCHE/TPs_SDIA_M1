## Exercise 1
### Explication
- Initialize a StringBuilder for use in transformations
```
StringBuilder input = new StringBuilder();
```
- Initialize a list of words
```
List<String> words = List.of("Apple", "Banana", "Cherry", "Date", "Elderberry", "Fig", "Grape", "Honeydew", "Kiwi", "Lemon");
```
- Print the original list of words
```
System.out.println("Original List: " + words);
```
- Filter words containing the letter 'a' (case-insensitive)
```
List<String> first = words.stream()
						  .filter(word -> word.toLowerCase().contains("a"))
						  .toList();
System.out.println("Words containing 'a': " + first);
```
- Filter words with length > 3, reverse each word, and collect them in a list
```
List<String> second = words.stream()
						   .filter(word -> word.length() > 3)
						   .map(word -> {
							   input.delete(0, input.length());
							   input.append(word);
							   return input.reverse().toString();
						   })
						   .toList();
System.out.println("Reversed words with length > 3: " + second);
```
- Filter words containing 'e', convert each to a character array, and collect them in a list
```
List<char[]> third = words.stream()
						  .filter(word -> word.contains("e"))
						  .map(String::toCharArray)
						  .toList();
System.out.println("Character arrays of words containing 'e':");
third.forEach(System.out::println);
```
- Convert all words to uppercase
```
List<String> forth = words.stream()
						  .map(String::toUpperCase)
						  .toList();
System.out.println("Words in uppercase: " + forth);
```
- Collect the length of each word in a list
```
List<Integer> fifth = words.stream()
						   .map(String::length)
						   .toList();
System.out.println("Length of each word: " + fifth);
```
- Convert each character of all words into a flat list
```
List<Character> sixth = words.stream()
							 .flatMap(word -> word.chars().mapToObj(c -> (char) c))
							 .toList();
System.out.println("All characters of all words: " + sixth);
```
- Create a list of words with their index position
```
List<String> seventh = IntStream.range(0, words.size())
								.mapToObj(index -> words.get(index) + " - " + index)
								.toList();
System.out.println("Words with index positions: " + seventh);
```
### Output
```
Original List: [Apple, Banana, Cherry, Date, Elderberry, Fig, Grape, Honeydew, Kiwi, Lemon]
Words containing 'a': [Apple, Banana, Date, Grape]
Reversed words with length > 3: [elppA, ananaB, yrrehC, etaD, yrrebredlE, eparG, wedyenoH, iwiK, nomeL]
Character arrays of words containing 'e':
Apple
Cherry
Date
Elderberry
Grape
Honeydew
Lemon
Words in uppercase: [APPLE, BANANA, CHERRY, DATE, ELDERBERRY, FIG, GRAPE, HONEYDEW, KIWI, LEMON]
Length of each word: [5, 6, 6, 4, 10, 3, 5, 8, 4, 5]
All characters of all words: [A, p, p, l, e, B, a, n, a, n, a, C, h, e, r, r, y, D, a, t, e, E, l, d, e, r, b, e, r, r, y, F, i, g, G, r, a, p, e, H, o, n, e, y, d, e, w, K, i, w, i, L, e, m, o, n]
[Apple - 0, Banana - 1, Cherry - 2, Date - 3, Elderberry - 4, Fig - 5, Grape - 6, Honeydew - 7, Kiwi - 8, Lemon - 9]

Process finished with exit code 0
```
## Exercise 2
### Explication
- The Employe class represents an employee with a name, department, and salary.
```
public class Employe { 
	private String nom;
	private String departement;
	private double salaire;
	// constructor - getters and setters - toString
	...
}
```
- in method main we do the following
- Initialize a list of employees
```
ArrayList<Employe> employes = new ArrayList<>();
employes.add(new Employe("Alice", "IT", 60000));
employes.add(new Employe("Bob", "HR", 55000));
employes.add(new Employe("Charlie", "Finance", 65000));
employes.add(new Employe("David", "Marketing", 50000));
employes.add(new Employe("Eva", "IT", 62000));
employes.add(new Employe("Frank", "HR", 53000));
employes.add(new Employe("Grace", "Finance", 70000));
employes.add(new Employe("Henry", "Marketing", 48000));
employes.add(new Employe("Ivy", "IT", 67000));
employes.add(new Employe("Jack", "Finance", 75000));
```
- Calculate the total sum of all employee salaries
```
double sum = employes.stream()
					 .mapToDouble(Employe::getSalaire)
					 .reduce(0.0, Double::sum);
System.out.println("Total Salary Sum: " + sum);
```
- Sort employees by name and collect them in a list
```
List<String> sorted = employes.stream()
							  .map(Employe::getNom)
							  .sorted()
							  .toList();
System.out.println("Sorted Employee Names: " + sorted);
```
- Find the employee with the minimum salary
```
double minValue = employes.stream()
						  .map(Employe::getSalaire)
						  .min(Double::compareTo)
						  .get();
Employe minEmploye = employes.stream()
							 .filter(e -> e.getSalaire() == minValue)
							 .findFirst()
							 .get();
System.out.println("Employee with Minimum Salary: " + minEmploye);
```
- Find employees with a salary of 90000 (expected to be none)
```
List<Employe> someEmployes = employes.stream()
									 .filter(e -> e.getSalaire() >= 90000)
									 .toList();
System.out.println("Employees with Salary 90000: " + someEmployes);
```
- Find the employee with the maximum salary
```
double maxValue = employes.stream()
						  .mapToDouble(Employe::getSalaire)
						  .reduce(Math::max)
						  .getAsDouble();
Employe maxEmploye = employes.stream()
							 .filter(e -> e.getSalaire() == maxValue)
							 .findFirst()
							 .get();
System.out.println("Employee with Maximum Salary: " + maxEmploye);
```
- Concatenate all employee names into a single string
```
String noms = employes.stream()
					  .map(Employe::getNom)
					  .reduce((a, b) -> a + " " + b)
					  .get();
System.out.println("Concatenated Employee Names: " + noms);
```
### Output
```
Total Salary Sum: 605000.0
Sorted Employee Names: [Alice, Bob, Charlie, David, Eva, Frank, Grace, Henry, Ivy, Jack]
Employee with Minimum Salary: Employe{nom='Henry', departement='Marketing', salaire=48000.0}
30000
Employees with Salary 90000: [Employe{nom='Alice', departement='IT', salaire=60000.0}, Employe{nom='Bob', departement='HR', salaire=55000.0}, Employe{nom='Charlie', departement='Finance', salaire=65000.0}, Employe{nom='David', departement='Marketing', salaire=50000.0}, Employe{nom='Eva', departement='IT', salaire=62000.0}, Employe{nom='Frank', departement='HR', salaire=53000.0}, Employe{nom='Grace', departement='Finance', salaire=70000.0}, Employe{nom='Henry', departement='Marketing', salaire=48000.0}, Employe{nom='Ivy', departement='IT', salaire=67000.0}, Employe{nom='Jack', departement='Finance', salaire=75000.0}]
Employee with Maximum Salary: Employe{nom='Jack', departement='Finance', salaire=75000.0}
Concatenated Employee Names: Alice Bob Charlie David Eva Frank Grace Henry Ivy Jack

Process finished with exit code 0
```