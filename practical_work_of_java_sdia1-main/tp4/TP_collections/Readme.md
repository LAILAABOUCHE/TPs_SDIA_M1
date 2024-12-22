## Exercise 1
### Explication
- The `Produit` class represents a product with an ID, name, and price.
```
public class Produit { 
	private long id; // Product ID
	private String nom; // Product name
	private double prix; // Product price
	
	// constructor / getters / toString
	...
}
```
- The `GestionProduitsApp` class provides methods to manage a list of `Produit` objects. * It demonstrates adding, removing, updating, and searching products.
- creating the list
```
ArrayList<Produit> produits = new ArrayList<>();
```
- Adding products to the list
```
produits.add(new Produit(1, "p1", 1111));
produits.add(new Produit(2, "p2", 2222));
produits.add(new Produit(3, "p3", 3333));
produits.add(new Produit(4, "p4", 4444));
```
- Removing a product by index 
```
produits.remove(2); 
```
- Printing all products 
```
for (Produit p : produits) { 
	System.out.println(p); 
} 
```
- Updating a product at a specific index 
```
produits.set(2, new Produit(5, "p5", 555));
``` 
- Searching for a product by name that the user will insert
```
Scanner scanner = new Scanner(System.in); 
String nom = scanner.nextLine(); 
for (Produit p : produits) { 
	if (p.getNom().equals(nom)) { 
		System.out.println(p); 
	} 
}
```
### Output
```
Produit{id=1, nom='p1', prix=1111.0}
Produit{id=2, nom='p2', prix=2222.0}
Produit{id=4, nom='p4', prix=4444.0}
p2
Produit{id=2, nom='p2', prix=2222.0}

Process finished with exit code 0
```
---
## Exercise 2
### Explication
- Initialize a HashMap to store student scores with String keys and Double values
```
HashMap<String, Double> notes = new HashMap<String, Double>();
```
- Add initial scores to the HashMap
```
notes.put("e1", 3.5);
notes.put("e2", 5.5);
notes.put("e3", 9.0);
notes.put("e4", 10.0);
```
- Update the score for student "e2" by adding 5 to the existing score
```
notes.put("e2", notes.get("e2") + 5);
```
 - Print all scores in the HashMap
```
System.out.println("la hashmap ------------>");
notes.forEach((key, value) -> System.out.println(value));
```
- Remove the score for student "e1"
```
notes.remove("e1");
```
- Print all scores after removal
```
System.out.println("la hashmap ------------>");
notes.forEach((key, value) -> System.out.println(value));
```
- Print the current size of the HashMap
```
System.out.println("taille ------------>");
System.out.println(notes.size());
```
- Print all scores after size check
```
System.out.println("la hashmap ------------>");
notes.forEach((key, value) -> System.out.println(value));
```
- Calculate the minimum, maximum, and average of the scores
```
double min = Double.MAX_VALUE, max = Double.MIN_VALUE, moy = 0;
for (double v : notes.values()) {
	if (v > max) max = v;
	if (v < min) min = v;
	moy += v;
}
moy = moy / notes.size();
```
- Print the average, minimum, and maximum scores
```
System.out.println("moy = " + moy + " | min = " + min + " | max = " + max);
```
- Print all scores after calculations
```
System.out.println("la hashmap ------------>");
notes.forEach((key, value) -> System.out.println(value));
```
- Check if any score equals 20 and print result
```
boolean exists = false;
for (double v : notes.values()) {
	if (v == 20) exists = true;
}
if (exists) {
	System.out.println("il y a une note egale a 20");
} else {
	System.out.println("il n'y a pas une note egale a 20");
}
```
- Print all scores in the HashMap after checking for score of 20
```
System.out.println("la hashmap ------------>");
notes.forEach((key, value) -> System.out.println(value));
```
### Output
```
la hashmap ------------>
3.5
10.5
9.0
10.0
la hashmap ------------>
10.5
9.0
10.0
taille ------------>
3
la hashmap ------------>
10.5
9.0
10.0
moy = 9.833333333333334 | min = 0.0 | max = 10.5
la hashmap ------------>
10.5
9.0
10.0
il n'y a pas une note egale a 20
la hashmap ------------>
10.5
9.0
10.0

Process finished with exit code 0
```
---
## Exercise 3
### Explication
- Initialize two HashSets representing two groups of elements
```
HashSet<String> groupA = new HashSet<>();
HashSet<String> groupB = new HashSet<>();
```
- Add elements to groupA
```
groupA.add("a1");
groupA.add("a2");
groupA.add("a3");
```
- Add elements to groupB
```
groupB.add("b1");
groupB.add("b2");
groupB.add("a2");
groupB.add("a3");
```
- Perform intersection of groupA and groupB, intersection will contain only elements present in both sets
```
HashSet<String> intersection = new HashSet<>(groupA);
intersection.retainAll(groupB);
```
- Perform union of groupA and groupB, union will contain all unique elements from both sets
```
HashSet<String> union = new HashSet<>(groupA);
union.addAll(groupB);
```
- Print the results of the intersection and union operations
```
System.out.println("Intersection: " + intersection);
System.out.println("Union: " + union);
```
### Output
```
Intersection: [a2, a3]
Union: [a1, b2, a2, a3, b1]

Process finished with exit code 0
```
