package org.lessons.java.shop.inheritance;

import java.util.Arrays;
import java.util.Scanner;

public class ShoppingCart {

    public static void main(String[] args) {

        System.out.println("Benvenuto nella creazione del tuo Carrello\n");
        Scanner scan = new Scanner(System.in);

        Product[] cart = new Product[0];
        int cartLenght;
        boolean f = true;
        int choise = 0;
        int subChoise = 0;
        double price;

        while (f) {

            choise = menuChoise();

            switch (choise) {

                case 1: {
                    System.out.println("Aggiunta del nuovo prodotto al carrello\n");
                    do {
                        System.out.println("Inserisci il tipo di prodotto:\n"
                                + "-1 Prodotto Generico\n"
                                + "-2 Tv\n"
                                + "-3 Smartphone\n"
                                + "-4 Cuffie\n");
                        subChoise = scan.nextInt();
                        if (subChoise > 0 && subChoise < 5) {
                            f = false;
                        } else {
                            System.out.println("Proddo inserito non valido, Riprova.\n");
                        }
                    } while (f);
                    switch (subChoise) {
                        case 1:
                            Product p1 = newProdutct();
                            cart = insertNewProduct(cart, p1);
                            break;
                        case 2:
                            Tv t1 = newTv();
                            cart = insertNewProduct(cart, t1);
                            break;
                        case 3:
                            Smartphone s1 = newSmartphone();
                            cart = insertNewProduct(cart, s1);
                            break;
                        case 4:
                            Headphones h1 = newHeadphones();
                            cart = insertNewProduct(cart, h1);
                            break;
                    }
                    System.out.println(
                            "\n Prodotto aggiunto al Carrello, vuoi stamprare le sue informazioni?\n Inserisci 1 per farlo.");
                    int printChoise = scan.nextInt();

                    if (printChoise == 1) {
                        cartLenght = cart.length;
                        System.out.println(cart[cartLenght - 1].toString());
                    }
                    break;
                }
                case 2: {
                    if (cart.length == 0) {
                        System.out.println("Non hai prodotti nel carrello, prima aggiungine almeno 1");
                        break;
                    }
                    System.out.println("Stampa dell'intero Carrello di prodotti\n");
                    getCart(cart);
                    break;
                }
                case 3: {
                    if (cart.length == 0) {
                        System.out.println("Non hai prodotti nel carrello, prima aggiungine almeno 1");
                        break;
                    }
                    System.out.println("Stampa dell'informazione completa di un prodotto specifico\n"
                            + "Scegli un prodotto inserendo il numero corrispondente");
                    f = true;
                    do {
                        getCart(cart);
                        int productChoise = scan.nextInt();
                        if (productChoise >= 0 || productChoise < cart.length) {
                            f = false;
                            System.out.println(cart[productChoise - 1].toString());
                        } else {
                            System.out.println("Il numero inserito non corrisponde a nessun prodotto, Riprova.");
                        }
                    } while (f);
                }
                case 4: {
                    if (cart.length == 0) {
                        System.out.println("Non hai prodotti nel carrello, prima aggiungine almeno 1");
                        break;
                    }
                    System.out.println("Stampa delle informazioni di tutti i prodotti.");
                    getCartCompleteInformation(cart);
                    break;
                }
                case 5: {
                    if (cart.length == 0) {
                        System.out.println("Non hai prodotti nel carrello, prima aggiungine almeno 1");
                        break;
                    }
                    System.out.println("Stampa del totale da pagare:");
                    price = getCartPrice(cart);
                    System.out.println("L'importo totale del tuo carrello comprensivo di iva è :\n" + price);
                }
            }
            f = true;
            if (choise == 9) {
                System.out.println("Grazie per aver utilizzato il nostro Software, Arrivederci");
                f = false;
            } else {
                System.out.println(
                        "Vuoi effettuare altre operazioni? Inserisci 1 per SI o Qualsiasi altro numero per NO");
                int repeatChoise = scan.nextInt();
                if (repeatChoise != 1) {
                    f = false;
                }
            }

        }
    }

    static int menuChoise() {
        int choise = 0;
        Scanner scan = new Scanner(System.in);
        boolean condition = true;
        do {

            System.out.println("Scegli una delle seguenti opzioni:"
                    + "\nInserisci il numero corrispondente\n"
                    + "\n-1 Aggiungi un nuovo Prodotto\n"
                    + "-2 Stampa l'intero Carrello\n"
                    + "-3 Ottieni informazioni complete per un singolo prodotto\n"
                    + "-4 Ottieni infomrazioni complete di tutti i prodotti nel carrello\n"
                    + "-5 Stampa l'importo totale del carrello\n"
                    + "-9 Per chiudere il Programma\n");

            choise = scan.nextInt();
            if (choise == 9) {
                condition = false;
            } else if (choise > 0 && choise < 6) {
                condition = false;
            } else {
                System.out.println("\n Il numero " + choise
                        + " non corrisponde a nessuna funzione, scegliere correttamente un'opzione valida\n");
            }
        }

        while (condition);
        return choise;

    }

    private static Product[] growCart(Product[] ShoppingCart) {
        int c = ShoppingCart.length + 1;
        ShoppingCart = Arrays.copyOf(ShoppingCart, c);
        return ShoppingCart;
    }

    static Product[] insertNewProduct(Product[] ShoppingCart, Product product) {
        ShoppingCart = growCart(ShoppingCart);
        int c = ShoppingCart.length - 1;
        ShoppingCart[c] = product;
        return ShoppingCart;
    }

    static void getCart(Product[] ShoppingCart) {
        for (int i = 0; i < ShoppingCart.length; i++) {
            System.out.println("Prodotto N." + (i + 1) + " " + ShoppingCart[i].getName());
        }
    }

    static void getCartCompleteInformation(Product[] ShoppingCart) {
        for (int i = 0; i < ShoppingCart.length; i++) {
            System.out.println("Prodotto N." + (i + 1) + "\n" + ShoppingCart[i].toString() + "\n\n");
        }
    }

    static double getCartPrice(Product[] ShoppingCart) {
        double price = 0;
        for (int i = 0; i < ShoppingCart.length; i++) {
            price = price + ShoppingCart[i].getCompletePrice();
        }
        return price;
    }

    private static Product newProdutct() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il nome del prodotto");
        String name = scan.nextLine();

        System.out.println("Inserisci la marca del prodotto");
        String brand = scan.nextLine();

        System.out.println("Inserisci il prezzo del prodotto");
        Double price = scan.nextDouble();

        Product p1 = new Product(0, name, brand, price, 1.22);
        return p1;
    }

    private static Tv newTv() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il nome della Tv");
        String name = scan.nextLine();

        System.out.println("Inserisci la marca della Tv");
        String brand = scan.nextLine();

        System.out.println("Inserisci i pollici della Tv");
        int inch = scan.nextInt();

        System.out.println("Inserisci:\n 1- Se la Tv è Smart\n 2- Se la tv non è Smart ");
        int choise = scan.nextInt();
        boolean smart = false;
        if (choise == 1) {
            smart = true;
        }

        System.out.println("Inserisci il prezzo della Tv");
        Double price = scan.nextDouble();

        Tv p1 = new Tv(inch, smart, 0, name, brand, price, 1.22);

        return p1;
    }

    private static Smartphone newSmartphone() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il modello del telefono");
        String name = scan.nextLine();

        System.out.println("Inserisci la marca del telefono");
        String brand = scan.nextLine();

        System.out.println("Inserisci la capacità del telefono in GB");
        int storage = scan.nextInt();

        System.out.println("Inserisci il prezzo del telefono");
        Double price = scan.nextDouble();

        Smartphone p1 = new Smartphone(0, storage, 0, name, brand, price, 1.22);

        return p1;
    }

    private static Headphones newHeadphones() {

        Scanner scan = new Scanner(System.in);

        System.out.println("Inserisci il nome delle cuffie");
        String name = scan.nextLine();

        System.out.println("Inserisci la marca delle cuffie");
        String brand = scan.nextLine();

        System.out.println("Inserisci il colore delle cuffie");
        String color = scan.nextLine();

        System.out.println("Inserisci:\n 1- Se le cuffie sono Wireless\n 2- Se le cuffie non sono Wireless");
        int choise = scan.nextInt();
        boolean wireless = false;
        if (choise == 1) {
            wireless = true;
        }

        System.out.println("Inserisci il prezzo del prodotto");
        Double price = scan.nextDouble();

        Headphones p1 = new Headphones(color, wireless, 0, name, brand, price, 1.22);

        return p1;
    }

}
