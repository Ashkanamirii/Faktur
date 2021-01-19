import javax.swing.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-09-15
 * Time:  16:53
 * Project: Faktur
 * Copyright: MIT
 * Det här programmet kommer att skapa en faktura genom att visa order i en dialogruta till användaren för att kunna välja en produkt.
 * Därefter programmet kontrollerar vilken produkt har valts och visar en faktura i en dialogruta.
 */
public class Main {
    public static void main(String[] args) {

        Invoice inv = HelperClass.createInvoice();
        //HelperClass.createInvoiceFile(inv); //TODO: skapa text fil som innehåller fakturaunderlag
    }
}
