/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author quoch
 */
public class Product {
    private int id;
    private String name;
    private String image;
    private int size;
    private String description;
    private double price;
    private int categoryID;
    private int stock;
    private int sellID;

    public Product() {
    }

    public Product(int id, String name, String image, int size, String description, double price, int categoryID, int stock, int sellID) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.size = size;
        this.description = description;
        this.price = price;
        this.categoryID = categoryID;
        this.stock = stock;
        this.sellID = sellID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSellID() {
        return sellID;
    }

    public void setSellID(int sellID) {
        this.sellID = sellID;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", image=" + image + ", size=" + size + ", description=" + description + ", price=" + price + ", categoryID=" + categoryID + ", stock=" + stock + ", sellID=" + sellID + '}';
    }
    
    
}
