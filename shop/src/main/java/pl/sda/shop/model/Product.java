package pl.sda.shop.model;

public class Product {

    public static int ID_GENERATOR = 0;
    private int id;
    private String name;
    private String description;
    private String image;
    private int price;

    public Product() {
        this.id = ID_GENERATOR;
        ID_GENERATOR++;
    }

    public Product(String name, String description, String image, int price) {
        this.id = ID_GENERATOR;
        ID_GENERATOR++;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
