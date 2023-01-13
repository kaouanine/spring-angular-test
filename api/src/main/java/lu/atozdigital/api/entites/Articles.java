package lu.atozdigital.api.entites;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Articles {
      @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    private String name;
    private int price;
    private String picture;
    public Articles() {
    }

    public Articles(String picture) {
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String pivture) {
        this.picture = pivture;
    }
}
