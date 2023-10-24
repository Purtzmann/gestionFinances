package com.purtzman.gestionFinance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Transaction {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String description;
   private Double amount;
   private Date date;
   private String type;

   @ManyToOne
   @JoinColumn(name = "category_id")
   private Category category;

   public Transaction() {
   }

   public Transaction(Long id, String description, Double amount, Date date, String type) {
      this.id = id;
      this.description = description;
      this.amount = amount;
      this.date = date;
      this.type = type;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Double getAmount() {
      return amount;
   }

   public void setAmount(Double amount) {
      this.amount = amount;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   @Override
   public String toString() {
      return "Transaction [id=" + id + ", description=" + description + ", amount=" + amount + ", date=" + date
            + ", type=" + type + "]";
   }

}
