package com_08.hibernate5.criteria;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "productname")
    private String productName;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "refrigerationrequired")
    private String refrigerationRequired;;
    
    @Column(name = "hazmat")
    private String hazmat;
    
    @Column(name = "fragile")
    private boolean fragile;
    
    @Column(name = "volume")
    private int volume;
    
    @Column(name = "weight")
    private int weight;
    
    @Column(name = "stateOfMatter")
    private String stateOfMatter;
    
    
    @Column(name = "cost")
    private int cost;
 
    
    public Product() {
    }

    public Product( String productName, String category, String refrigerationRequired, String hazmat,
	    boolean fragile, int volume, int weight, String stateOfMatter, int cost) {
	super();
	
	this.productName = productName;
	this.category = category;
	this.refrigerationRequired = refrigerationRequired;
	this.hazmat = hazmat;
	this.fragile = fragile;
	this.volume = volume;
	this.weight = weight;
	this.stateOfMatter = stateOfMatter;
	this.cost = cost;
    }

    @Override
    public String toString() {
	return "Product [id=" + id + ", productName=" + productName + ", category=" + category
		+ ", refrigerationRequired=" + refrigerationRequired + ", hazmat=" + hazmat + ", fragile=" + fragile
		+ ", volume=" + volume + ", weight=" + weight + ", stateOfMatter=" + stateOfMatter + ", cost=" + cost
		+ "]";
    }

    
    
}
