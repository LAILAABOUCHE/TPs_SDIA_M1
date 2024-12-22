## Objectives
in this practical work we got the chance to explore a lot of important concepts in java, including:
- reading files and writing in them, using classes like `File`, `FileReader`, `FileWriter`.
- importing and exporting object in a file with `.dat` extension and implementing `Serialisable` Interface.
- working with generic class in.
## Ex 1
- in this exercise we made a simple application that shows us files and subdirectories of a directory.
- we create the dive method
```java
public static void dive(File file, String margin) {
	...
}
```
- we call the directory in file object
```java
File root = new File(path);
```
- we get the files of that directory
```java
File[] list = root.listFiles();
```
- if the there is no files in the directory we quit the method
```java
if(list == null) {  
    return;
}
```
- we loop trough the files files to show them and at the same time if it was a directory it will dive in a recursive way until we finish every file and directory.
```java
for ( File f : list ) {  
    signature = "";  
    if(f.canRead()) signature+="r";  
    if(f.canWrite()) signature+="w";  
    if ( f.isDirectory() ) {  
        System.out.println(margin + f.getPath() + " <DIR> " + signature);  
        dive( f.getAbsolutePath(), margin + "___" );  
    }  
    else {  
        System.out.println(margin + f.getPath() + " <FILE> " + signature);  
    }  
}
```
- finally to test the functionality of this method it is enough to call it with the file name and an empty margin in main method
```java
public static void main(String[] args) {  
    dive("C:\\Users\\hp\\Desktop\\Master\\English","");  
}
```
## Ex 2
- in this exercise we will handle some files that contains contacts of a bunch of people.
- we create a wrapper class for the data and the file.
- i find it not worthy to put the file in this class as it is asked from us in the practical work.
- however this class is `DossierContact` and contains a `hashmap`, the keys are the names of persons, and the values are the actual number.
```java
public class DossierContact {  
    private HashMap<String, String> contacts;
    ...
}
```
- this class contains every method that we will use to manipulate our data and files. which are :
	- `find(String searchedPerson)` to find the number of a person from its name, and if it is not there it will return a message.
	- `addContact(File dir, String nom, String numero)` to add a new contact, we add it simultaneously to the hashmap and file using `PrintWriter`
	- `updateContact(File file, String numero)` in update we do the same as add and it change the content of the file.
	- `deleteContact(File file)` to delete the file by checking if it exist then deleting it.
- finally to test all of that we create the main method
```java
public static void main(String[] args) {  
    // initialization of helper objects and attributes
    int choice;  
    Scanner scanner = new Scanner(System.in);  
    Scanner stringScanner = new Scanner(System.in);  
    DossierContact dc = new DossierContact(new HashMap<String, String>());  
    File folder = new File("src\\main\\java\\org\\example\\EX2\\folder");  
    BufferedReader reader;  
  
    // read all the data of the files and put it in hashmap in the DossierContact 'dc' object  
    try {  
        for(File f:folder.listFiles()) {  
            reader = new BufferedReader(new FileReader(f));  
            dc.getContacts().put(f.getName().split("\\.")[0],reader.readLine());  
        }  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
  
    // the menu and the action methods  
    do {  
        System.out.println("1. Rechercher un numéro de téléphone.\n2. Ajouter un nouveau contact.\n3. Supprimer un contact.\n4. Changer le numéro de téléphone d’un contact.\n5. Quitter ce programme.");  
        choice = scanner.nextInt();  
        switch(choice) {  
            case 1:  
                System.out.println("do you want to find who ?");  
                dc.find(stringScanner.nextLine());  
                break;  
            case 2:  
                System.out.println("name of person : ");  
                String newAddedPerson = stringScanner.nextLine();  
                System.out.println("number of person : ");  
                String numberOfPerson = stringScanner.nextLine();  
                dc.addContact(folder, newAddedPerson, numberOfPerson);  
                dc.getContacts().put(newAddedPerson,numberOfPerson);  
                break;  
            case 3:  
                System.out.println("name of person : ");  
                String newDeletedPerson = stringScanner.nextLine();  
                dc.deleteContact(new File(folder,newDeletedPerson + ".txt"));  
                dc.getContacts().remove(newDeletedPerson);  
                break;  
            case 4:  
                System.out.println("name of person : ");  
                String updatedFile = stringScanner.nextLine();  
                System.out.println("number of person : ");  
                String newNumber = stringScanner.nextLine();  
                dc.updateContact(new File(folder,updatedFile + ".txt"), newNumber);  
                dc.getContacts().replace(updatedFile,newNumber);  
                break;  
        }  
    } while(choice!=5);  
}
```
## Ex 3
- in this exercise we dive into the generic class with a great example of business layer Interface `IMetier`.
- we create the `Product` and `Client` classes and implement `Serializable` which will allow the class to be saved in `.dat` files.
```java
public class Product implements Serializable {  
    private String name;  
    private String brand;  
    private double price;  
    private String description;  
    private int stock;
    ...
}

public class Client implements Serializable {  
    private String firstName;  
    private String lastName;  
    private String adress;  
    private String phoneNumber;  
    private String email;
    ...
}
```
- we create `IMetier` interface as generic interface so we can eventually use it with `Product` and `Client`.
```java
public interface IMetier<T> {  
    public T add(T o);  
    public List<T> getAll();  
    public T findByNom(String nom);  
    public void delete(String nom);  
    public void saveAll();
    ...
}
```
- we implement the methods of `IMetier` Interface in `MetierProductImpl` class, this class is a helper to manipulate our objects and files.
```java
public class MetierClientImpl implements IMetier<Client>{  
    private List<Client> clients;  
    private File file;
    
    @Override  
	public Client add(Client o) {  
	    ...
	}  
	  
	@Override  
	public List<Client> getAll() {  
	    ...  
	}  
	  
	@Override  
	public Client findByNom(String nom) {  
	    ...
	}  
	  
	@Override  
	public void delete(String nom) {  
	    ...
	}  
	  
	@Override  
	public void saveAll() {  
	    ...
	}
}
```
- in `saveAll()` method we save the object using `ObjectOutputStream` `FileOutputStream` classes and `writeObject` method
```java
@Override
public void saveAll() {  
    FileOutputStream fos;  
    ObjectOutputStream oos;  
    try {  
        fos = new FileOutputStream(file, false);  
        oos = new ObjectOutputStream(fos);  
        oos.writeObject(clients);  
    } catch (Exception e) {  
        e.printStackTrace();  
    }  
}
```
- the same with importing data we use `ObjectInputStream` `FileInputStream` classes and `readObject` method
```java
ObjectInputStream ois;  
FileInputStream fis;  
try {  
    fis = new FileInputStream(productHelper.getFile());  
    ois = new ObjectInputStream(fis);  
    productHelper.setProducts((ArrayList<Product>)ois.readObject());  
} catch (Exception e) {  
    e.printStackTrace();  
}
```
- after creating the method we test them in main method of `Application` class
```java
public class Application {  
    public static void main(String[] args) {  
        // initializition
        MetierProduitImpl productHelper = new MetierProduitImpl(null, new File("src\\main\\java\\org\\example\\EX3\\products.dat"));  
  
        int choice = 0;  
        Scanner scanner = new Scanner(System.in);  
        Scanner stringScanner = new Scanner(System.in);  

		// importing the files from .dat file
        ObjectInputStream ois;  
        FileInputStream fis;  
        try {
            fis = new FileInputStream(productHelper.getFile());  
            ois = new ObjectInputStream(fis);  
            productHelper.setProducts((ArrayList<Product>)ois.readObject());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        do {  
            System.out.println("1. Afficher la liste des produits.\n2. Rechercher un produit par son nom.\n3. Ajouter un nouveau produit dans la liste.\n4. Supprimer un produit par nom\n5. Sauvegarder les produits.\n6. Quitter ce programme.");  
            choice = scanner.nextInt();  
            switch (choice) {  
                case 1:  
                    for(Product p:productHelper.getAll()) {  
                        System.out.println(p.getName());  
                    }  
                    break;  
                case 2:  
                    System.out.println("le nom de produit est :");  
                    String nom = stringScanner.nextLine();  
                    System.out.println(productHelper.findByNom(nom));  
                    break;  
                case 3:  
                    System.out.println("le nom de nouveau produit :");  
                    Product p = new Product();  
                    p.setName(stringScanner.nextLine());  
                    productHelper.add(p);  
                    break;  
                case 4:  
                    System.out.println("le nom de produit : ");  
                    productHelper.delete(stringScanner.nextLine());  
                    break;  
                case 5:  
                    productHelper.saveAll();  
                    break;  
            }  
        }while(choice != 6);  
    }  
}
```
- we do the same with `Client` class.
	- create `MetierClientImpl` which will implement `Imetier<Client>` generic interface.
	- define helper methods in `MetierClientImpl`.
	- create small testing console app `Application2`
- end