package src.project01am.day08;

import java.util.Date;

public class Product {

    protected Long id;
    protected String prodName;
    protected String prodDesc;
    protected String prodCat;
    protected Float price;
    protected Date createdDate;

    public Product(Long id,String name, String description,String cat, Float price,Date date){
        this.id = id;
        this.prodName = name;
        this.prodDesc = description;
        this.prodCat = cat;
        this.price = price;
        this.createdDate = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public String getProdCat() {
        return prodCat;
    }

    public void setProdCat(String prodCat) {
        this.prodCat = prodCat;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return String.format(
            "Entity: Product%n" + // Use %n for platform-independent line breaks
            "Attributes:%n" +
            "ID: %d%n" +         // Assuming id is a float, format to 2 decimal places
            "Name: %s%n" +         // Name of the product
            "Description: %s%n" +  // Description of the product
            "Category: %s%n" +     // Category of the product
            "Price: %.2f%n" +      // Assuming price is a float, format to 2 decimal places
            "Created Date: %s",     // Assuming createdDate is a String representation of the date
            this.id,
            this.prodName,
            this.prodDesc,
            this.prodCat,
            this.price,
            this.createdDate
        );
    }
    
}
