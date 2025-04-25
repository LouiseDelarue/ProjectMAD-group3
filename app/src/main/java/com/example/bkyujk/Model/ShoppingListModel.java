package com.example.bkyujk.Model;

public class ShoppingListModel {

    private String element;
    private int id, status;
    private String category;
    private double price;
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {return category;}

    public void setCategory(String category) { this.category = category; }

    public ShoppingListModel(int id, String element, int status, String category, double price) {
        this.id = id;
        this.element = element;
        this.status = status;
        this.category = category;
        this.price = price;
    }
    public ShoppingListModel() {
        // Constructeur vide pour l’usage en base de données
    }
}
