import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2020-09-15
 * Time:  15:30
 * Project: Faktur
 * Copyright: MIT
 * Invoice är en public klass som innehåller instans variabler och en konstant variable (moms).
 */
public class Invoice {
    int invoiceNr;
    double priceVat;
    static final int moms = 25;
    double totalPrice;
    List<Product> prodList ;
    ContactPerson contact;
}
