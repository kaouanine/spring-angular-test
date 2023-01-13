package lu.atozdigital.api.dto;

import lu.atozdigital.api.entites.Articles;
import lu.atozdigital.api.entites.Orders;


import java.util.Date;
import java.util.List;

public class OrderDTO {

    private Long id;
    private String reference;
    private Date date;
    private List<Articles> articles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Articles> getArticle() {
        return articles;
    }

    public void setArticle(List<Articles> article) {
        this.articles = article;
    }
}
