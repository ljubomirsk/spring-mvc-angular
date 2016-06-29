package mk.ukim.finki.wp.model;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    public Pizza(){}

    public Long getId(){
        return id;
    }
    public String getType(){
        return type;
    }
    public void setId(Long id){ this.id = id; }
    public void setType(String type){ this.type = type; }
}
