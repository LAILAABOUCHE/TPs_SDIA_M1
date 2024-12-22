## Objectives
- In this practical work we dived deep in JDBC and JAVAFX.
- JDBC stand for java database connectivity and it's an API for the Java programming language which defines how a client may access a database.
- JAVAFX is a software platform for creating and delivering desktop applications, as well as rich web applications that can run across a wide variety of devices.
## The Practical work
##### Class diagram
![class](https://github.com/user-attachments/assets/88bfdeff-c779-4fcc-8ee4-213e3433ffb3)
##### Entity relationship diagram
![mld](https://github.com/user-attachments/assets/4fd6024f-77df-4942-9bd0-74a0fa44b846)
##### SQL script
- After knowing everything that will need about the database we will create it with following script
```sql
create database tp5;

create table departement (
	id_depart int primary key auto_increment,
	nom varchar(250)
);

create table professeur (
	id_prof INT PRIMARY KEY AUTO_INCREMENT,
	nom varchar(250) not null,
	prenom varchar(250) not null,
	cin varchar(250) not null,
	adresse varchar(250) not null,
	email varchar(250) not null,
	telephone varchar(250) not null,
	date_recrutement date not null,
	id_depart int null,
	constraint fk_departement foreign key (id_depart) references departement(id_depart)
);
```
##### Professeur and Departement Models
- After we have created the class diagram and Entity relationship diagram and the database, now we have to implement the models that will hold the data.
```java
public class Professeur {  
    private int id_prof;  
    private String nom;
    ...
}

public class Departement {  
    private int id_depart;  
    private String nom;
    ...
}
```
##### IMetier Interface
- in this interface we have defined the methods that will manage the interactions with the database.
- we do this usually in DAO layer but for now we will let it as it is asked in the practical work
```java
public interface IMetier {  
    // gerer professeurs  
    public List<Professeur> retournerProfesseurs() throws SQLException;  
    public List<Professeur> trouverProfesseurParCin(String s) throws SQLException;  
    public boolean ajouterProfesseur(Professeur p) throws SQLException;  
    public boolean supprimerProfesseur(int idProf) throws SQLException;  
    public boolean modifierProfesseur(Professeur p) throws SQLException;  
    public boolean affecterProfesseurADepartement(int id_prof, int id_depart) throws SQLException;  
  
    // gerer departements  
    public boolean ajouterDepartement(Departement d) throws SQLException;  
    public List<Departement> retournerDepartements() throws SQLException;  
    public boolean supprimerDepartement(int id_depart) throws SQLException;  
    public boolean modifierDepartement(Departement d) throws SQLException;  
    public List<Professeur> afficherProfesseursDeDepartement(int id_depart) throws SQLException;  
}
```
##### SingletonConnexionDB class
- Singleton is a design pattern that let us instantiate a class only one time.
- we want to instantiate only one connection object so we will use it in our case.
```java
public class SingletonConnexionDB {  
    private static final String URL = "jdbc:mysql://localhost:3306/tp5";  
    private static final String USER = "root";  
    private static final String PASSWORD = "";  
    private static final Connection connection;  

    static {  
        try {  
            connection = DriverManager.getConnection(URL, USER, PASSWORD);  
        } catch (SQLException e) {  
            throw new RuntimeException(e);  
        }  
    }  
  
    public static Connection getConnection() {  
        return connection;  
    }
}
```
##### IMetierImp class
- in the class IMetierImp we have implemented the Interface, we did put the logic of all the jdbc objects like `Connection`, `Statement` or `PreparedStatement` and `ResultSet`
- for example `ajouterDepartement(Departement d)` and `retournerProfesseurs()`
```java
@Override  
public List<Professeur> retournerProfesseurs() throws SQLException {  
    List<Professeur> professeurs = new ArrayList<>();  
    ps = con.prepareStatement("select * from professeur");  
    rs = ps.executeQuery();  
    while(rs.next()) {  
        professeurs.add(new Professeur(rs.getInt("id_prof"), rs.getString("nom"), rs.getString("prenom"), rs.getString("cin"), rs.getString("adresse"), rs.getString("telephone"), rs.getString("email"), rs.getDate("date_recrutement"),new Departement(rs.getInt("id_depart"))));  
    }  
    return professeurs;  
}

@Override  
public boolean ajouterDepartement(Departement d) throws SQLException {  
    ps = con.prepareStatement("insert into departement(nom) values(?);");  
    ps.setString(1, d.getNom());  
    int result = ps.executeUpdate();  
    return result > 0;  
}
```
##### Console testing application
- after defining everything we need now it's time to test our code.
- it the following you will find the implementation of every method and class with user friendly comments
```java
public static void main(String[] args) {  
  
    try {  
        IMetier metier = new IMetierImp();  
        List<Departement> departements = metier.retournerDepartements();  
        List<Professeur> professeurs = metier.retournerProfesseurs();  
  
        System.out.println("les professeurs sont : ");  
        // afficher les professeurs  
        System.out.println(professeurs);  
  
        System.out.println("le professeur qui a le mot cle 'CIN67890' est : ");  
        // trouver un professeur par mot cle  
        System.out.println(metier.trouverProfesseurParCin("CIN67890"));  
  
        // ajouter un professeur  
        Professeur professeur4 = new Professeur(4, "Jack", "Daniel", "CIN90667",  
                "101 Pine St", "143-009-8945", "jack.daniel@example.com",  
                new Date(), departements.get(0));  
        if(metier.ajouterProfesseur(professeur4)) {  
            System.out.println("on a ajouté un nouveau professeur 4");  
        }  
  
        // supprimer un professeur  
        if(metier.supprimerProfesseur(professeurs.get(1).getId_prof())) {  
            System.out.println("on a supprimer professeur 2");  
        }  
  
        // modifier un professeur  
        professeur4.setEmail("newEmailProfesseur4@gmail.com");  
        if(metier.modifierProfesseur(professeur4)) {  
            System.out.println("on a modifier le professeur numero 4");  
        }  
  
        // affecter un professeur a un departement  
        if(metier.affecterProfesseurADepartement(professeur4.getId_prof(), 1)) {  
            System.out.println("on a affectué le professeur 4 au departement 1");  
        }  
  
        // ajouter un departement  
        Departement department4 = new Departement("Biology", new ArrayList<>());  
        if(metier.ajouterDepartement(department4)) {  
            System.out.println("on a ajouté un departement");  
        }  
  
        // afficher la liste des departement  
        System.out.println("les departement sont : ");  
        System.out.println(departements);  
  
        // supprimer un departement  
        if(metier.supprimerDepartement(4)) {  
            System.out.println("on a supprimé le departement 4");  
        }  
  
        // modifier un departement  
        department4.setNom("Computer science and machine learning");  
        if(metier.modifierDepartement(department4)) {  
            System.out.println("on a modifié le departement 4");  
        }  
  
        // afficher les professeur d'un departement  
        System.out.println("les professeurs du departement 1 sont : ");  
        System.out.println(metier.afficherProfesseursDeDepartement(1));;  
  
    } catch(Exception e) {  
        e.printStackTrace();  
    }  
}
```
##### JavaFx application
- after we have tested every functionality, we can make our application a lot better by creating user friendly interfaces that will let the user interact easily with the application.
- to add a departement you have to fill the name field and click add (ajouter).
- to update a departement you have to fill the name and the id fields and click update (modifier).
- to delete a departement you have to fill the id field and click delete (supprimer).
- to see the professors of any departemnt you have to fill the id and click show professors (afficher professeur de departement).
- you can select a departement to fill the id with it's id, this make things easier to do the actions.
![image](https://github.com/user-attachments/assets/3774b3c3-b937-4c37-8abb-216b403c18d9)
- the actions of professor window are the pretty much the same
![image](https://github.com/user-attachments/assets/eb8e800d-7e5c-4bd2-b859-f814b7fa7d3a)
