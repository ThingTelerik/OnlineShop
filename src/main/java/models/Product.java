package models;

public class Product {
    private int id;
    private Brand brand;
    private String model;
    private String description;
    private float price;
    private int quantity;
    private Category category;

    public Product() {
    }

    public Product(int id, Brand brand, String model, String description, float price, int quantity, Category category) {
      setId(id);
      setBrand(brand);
      setModel(model);
      setDescription(description);
      setPrice(price);
      setQuantity(quantity);
      setCategory(category);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
