import java.io.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-09-17
 * Time:  11:27
 * Project: Faktur
 * Copyright: MIT
 */

public class CreatInvoiceFile {
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter invoice = new PrintWriter(new BufferedWriter
                (new OutputStreamWriter
                        (new FileOutputStream("Invoice.txt"))));
        var inv = new Invoice();


       //inv.contact = HelperClass.displayContactForm();
        //invoice.print(inv.contact +"\n" + inv.invoiceNr);



        invoice.close();


    }

}
