/**
 * Created by Ashkan Amiri
 * Date:  2020-09-15
 * Time:  15:35
 * Project: Faktur
 * Copyright: MIT
 * Klassen presentera produkten med några instanse variable och de har kapslats in i en konstroktör av klass.
 * Klassen hanterar fel värde och det är säker.
 */
public class Product {
    private int code;
    private double price;
    private String name;

    public Product(int co, String na, double pr){
        setCode(co);
        setName(na);
        setPrice(pr);
    }

    public int getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setCode(int c){
            code = c;
    }
    public void setPrice(double p){
        if(p > 0)
            price = p;
        else
            throw new IllegalArgumentException("Felaktig pris!");
    }
    public void setName(String n){
        if(n != null)
            name = n;
        else
            throw new IllegalArgumentException("Felaktig name!");
    }

    /**
     * skapa en string för att kunna skriva ut på bättre sätt
     * @return string s
     */
    public String toString(){
        String s = "Code: " + code + ". " + name + ". " + "Price: "+price;
        return s;
    }


}




