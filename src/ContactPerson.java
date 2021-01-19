/**
 * Created by Ashkan Amiri
 * Date:  2020-09-15
 * Time:  15:34
 * Project: Faktur
 * Copyright: MIT
 * Peresentera kontakt person med 4 instans variabler med en konstroktör.
 */
public class ContactPerson {
    //instans variabler
    String name;
    String address;
    String email;
    String phoneNr;

    /**
     * kontakt person måste ha ett namn
     * @param na persons namn
     */
    public ContactPerson(String na){
        this.name = na;
    }

    /**
     *skapa en string för att kunna skriva ut på bättre sätt
     * @return string
     */
    @Override
    public String toString() {
        return "ContactPerson{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                '}';
    }
}
