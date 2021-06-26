package logreg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        System.out.println("Odaberite opciju");
        System.out.println("1. Registracija");
        System.out.println("2. Login");
        // Nazivi varijabli uvek treba da imaju naziv vezan za program...
        int opcija = sc.nextInt();

        switch (opcija) {
            case 1:
                registracija();
                break;
            case 2:
                login();
                break;
            default:
                System.out.println("Nepoznata opcija");

        }

    }

    private static void registracija() {
        System.out.println("-----Registracija-----");
        System.out.println("Unesite username: ");
        String username = sc.next();
        System.out.println("Unesite password: ");
        String password = sc.next();
        // Sakupili smo podatke (View metoda) od korisnika.
        // Da bi registracija bila uspesna treba da kreiramo korisnika..
        User u = new User(username,password);
        DBQueries.insertUser(u);
        

    }

    private static void login() {
        System.out.println("-----Login-----");
        System.out.println("Unesite username: ");
        String username = sc.next();
        System.out.println("Unesite password: ");
        String password = sc.next();
        User u = new User(username,password);
        // User ulogovan. Pravimo metodu za proveru podataka..
        
        boolean ok = DBQueries.checkUSer(u);
        if(ok){
            System.out.println("Uspesno ste se ulogovali :-)");
         // Ako se korisnik uspesno ulogovao nastavi sa radom, prikazi kategorije, kreiraj metod...
         prikaziKategorije();
        }
        else
            System.out.println("Niste se ulogovali :-(");
        

    }

    private static void prikaziKategorije() {
        System.out.println("Izaberite kategoriju: ");
        // Kada se korisnik uloguje ArrayListom prikazujemo sve kategorije, ne znamo njihov br...
        // Koristimo unapredjenu for petlju da izlistamo kategorije i povezujemo sa DBQueries, tj bazom.
        ArrayList<Category1> kategorije;
        kategorije = DBQueries.getAllCategories();
        for(Category1 c : kategorije)
            System.out.println(c);
        // Prikazi proizvode i pitaj korisnika...
        int kat = sc.nextInt();
        prikaziProizvode(kat);
        
        
    }

    private static void prikaziProizvode(int kat) {
       ArrayList<Item> proizvodi;
       proizvodi = DBQueries.getAllItemByCategory(kat);
       for(Item i : proizvodi)
            System.out.println(i);
        System.out.println("Izaberite Item: ");
        
        int item = sc.nextInt();
       
    }

}
