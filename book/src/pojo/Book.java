package pojo;

public class Book {
    private Integer id;
    private String name;
    private String author;
    private double price;
    private Integer sales;
    private Integer stock;
    private String img_path="static/img/default.jpg";

    public Book(Integer id, String name, String author, double price, Integer sales, Integer stock, String img_path) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.img_path = img_path;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public Integer getSales() {
        return sales;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
