import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2020-09-15
 * Time:  20:24
 * Project: Faktur
 * Copyright: MIT
 * Det här klassen innehåller statiska metoder som använder andra klasser.
 * */
public class HelperClass {
    /**
     * metoden skapa tre produkter med förvalda värde och retunerar som en list.
     * @return productList
     */
    private static List<Product> createProdList() {
        Product product1 = new Product(123, "Bmw", 1000000);
        Product product2 = new Product(456, "Benz", 1500000);
        Product product3 = new Product(789, "Volvo", 1100000);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }
/** test kod
    private static ContactPerson createContact() {
        displayContactForm();
        ContactPerson person = new ContactPerson("Ashkan");
        person.phoneNr = "07399975153";
        person.email = "Ashkan@gmail.com";
        person.address = "Sollentuna";
        return person;
    }
 **/
    /**
     * Metoden visa en faktura och räkna prisen med moms och retunera fakturan.
     * @return invoice
     */
    public static Invoice createInvoice() {
        var inv = new Invoice();
        double totalPrice = 0;
        inv.invoiceNr = 100;

        //inv.prodList = createProdList(); TEST KOD
        //inv.contact = createContact(); TEST KOD

        inv.prodList = displayProduct(); //Anropa metod innehåller produkt order
        inv.contact = displayContactForm();//Anropa metod  innehåller kontakt person som är inmatat från användaren

        for (Product p : inv.prodList) {
            totalPrice = totalPrice + p.getPrice();
        }

        inv.priceVat = totalPrice + totalPrice * Invoice.moms / 100;
        inv.totalPrice = totalPrice;

        // faktura utskrift i terminal
        System.out.println("Invoice Number = " + inv.invoiceNr);
        System.out.println(inv.contact); // En utskrift med hjälp av to string
        System.out.println(inv.prodList); //// En utskrift med hjälp av to string
        System.out.println("Total price(Exc) = " + inv.totalPrice);
        System.out.println("Total Price(Inc VAT): " + inv.priceVat);

        //System.out.println("Email--> " + inv.contact.getEmail()); Test kod

        // Skapa flera text fält med olika attribute.
        JTextField nameField = new JTextField(10);
        nameField.setText(inv.contact.name);
        nameField.setEditable(false);

        JTextField invoiceNr = new JTextField(10);
        invoiceNr.setText(String.valueOf(inv.invoiceNr));
        invoiceNr.setEditable(false);

        JTextField priceNameField = new JTextField(10);
        priceNameField.setText(String.valueOf(inv.totalPrice));
        priceNameField.setEditable(false);

        JTextField vatNameField = new JTextField(10);
        vatNameField.setText(String.valueOf(inv.priceVat));
        vatNameField.setEditable(false);

        JTextField prodNameField = new JTextField(10);
        prodNameField.setText(String.valueOf(inv.prodList.get(0).getName()));
        prodNameField.setEditable(false);

        //Skapa panel som innehåller text fälterna.
        JPanel invPanel = new JPanel();
        invPanel.add(new JLabel("Invoice number:"));
        invPanel.add(invoiceNr);
        invPanel.add(new JLabel("Name:"));
        invPanel.add(nameField);
        invPanel.add(new JLabel("Product name:"));
        invPanel.add(prodNameField);
        invPanel.add(new JLabel("Price(Exc)"));
        invPanel.add(priceNameField);
        invPanel.add(new JLabel("Total Price(Inc VAT):"));
        invPanel.add(vatNameField);
         //skapa en dialogruta som innehåller invoice panel

        JOptionPane.showConfirmDialog(null, invPanel,
                "Invoice", JOptionPane.OK_CANCEL_OPTION);

        return inv;

    }

    /**
     * Metoden visar produkten till användaren och vill att få produkt koden av användaren.
     * Metoden hantera alla fel värde och försök igen att få rätt värde och retunera order listen.
     * @return orderList
     */
    public static List<Product> displayProduct() {
        boolean cont = true;
        String prodString = "";
        List<Product> originalListProduct = createProdList();
        List<Product> orderList = new ArrayList<Product>();

        for (Product prod : originalListProduct) {
            prodString += prod.toString() + "\n";
        }

        while (cont) {
            String in;
            in = JOptionPane.showInputDialog("What do you want to buy \n" + prodString + "Enter the code please!");

            if (in == null) {
                System.exit(0);
                return null;
            }

            try {
                Scanner input = new Scanner(in);
                int codeOfProduct = input.nextInt();


                for (Product  p : originalListProduct)
                {
                    if( p.getCode() == codeOfProduct)
                    orderList.add(p);
                }

                if (orderList.size() > 0)
                    cont = false;
                else
                    JOptionPane.showMessageDialog(null, "You entered the wrong code.");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "You entered the wrong code. Try again!");
            }
        }
        return orderList;
    }

    /**
     * Metoden visar en dialogruta för att användaren ange sina informationen och retunerar kontakt personen.
     * @return kontakt person (p)
     */
    public static ContactPerson displayContactForm() {

        JTextField nameField = new JTextField(10);
        JTextField addressField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField phoneNrField = new JTextField(10);

        JPanel personPanle = new JPanel();
        personPanle.add(new JLabel("Name: "));
        personPanle.add(nameField);

        personPanle.add(new JLabel("Address: "));
        personPanle.add(addressField);

        personPanle.add(new JLabel("phone number: "));
        personPanle.add(phoneNrField);

        personPanle.add(new JLabel("Email: "));
        personPanle.add(emailField);


        int result = JOptionPane.showConfirmDialog(null, personPanle,
                "Please Enter your information", JOptionPane.OK_CANCEL_OPTION);

        //skapa en instans av ContactPerson
        ContactPerson p = new ContactPerson(nameField.getText());

        if (result == JOptionPane.OK_OPTION) {
            p.email = emailField.getText();
            p.address = addressField.getText();
            p.phoneNr = phoneNrField.getText();

            /**********************test code******************************
             System.out.println("Name: " + nameField.getText());
             System.out.println("Email: " + emailField.getText());
             System.out.println("Address: " + addressField.getText());
             System.out.println("Phone number: " + phoneNrField.getText());
             ***************************************************************/


        }
        return p;
    }
}
