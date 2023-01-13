package lu.atozdigital.api.entites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {

    @Id   @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;
    @Column(unique=true)

    private String reference;
    private Date date;
    //@OneToMany(targetEntity = Articles.class,cascade = CascadeType.REMOVE,fetch=FetchType.EAGER)
   // @JoinColumn(name = "order_id",referencedColumnName = "id")
    @ManyToMany(targetEntity = Articles.class,fetch=FetchType.EAGER)
    @JoinColumn(name = "order_Article",referencedColumnName = "id")
    private List<Articles> articles;

    public Orders() {
    }

    public Orders(Long id, String reference, Date date, List<Articles> article) {
        this.id = id;
        this.reference = reference;
        this.date = date;
        this.articles = article;
    }

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
