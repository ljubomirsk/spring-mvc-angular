package mk.ukim.finki.wp.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String clientName;
    private String clientAddress;
    private boolean approved = false;
    @ManyToOne
    private Pizza pizza;

    public Order(){}
    public Long getOrderId(){ return orderId; }
    public String getClientName(){
        return clientName;
    }
    public String getClientAddress(){
        return clientAddress;
    }
    public Pizza getPizza(){return pizza;}
    public boolean getApproved(){return approved;}
    public void setOrderId(Long id){ orderId = id; }
    public void setClientName(String name){ clientName = name; }
    public void setClientAddress(String address){ clientAddress = address; }
    public void setPizza(Pizza p){ pizza = p; }
    public void setApproved(boolean a){approved = a;}
}
