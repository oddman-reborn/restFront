package com.monir.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {


    private Integer id;
    private String name;
    private String email;
    private String password;

   public User() {
   }

   public User(String name, String email, String password) {
      this.name = name;
      this.email = email;
      this.password = password;
   }
  
   @Id @GeneratedValue(strategy=IDENTITY)
   @Column(name="id", unique=true, nullable=false)
   public Integer getId() {
       return this.id;
   }
   
   public void setId(Integer id) {
       this.id = id;
   }

   
   @Column(name="name", length=100)
   public String getName() {
       return this.name;
   }
   
   public void setName(String name) {
       this.name = name;
   }

   
   @Column(name="email", length=100)
   public String getEmail() {
       return this.email;
   }
   
   public void setEmail(String email) {
       this.email = email;
   }

   
   @Column(name="password", length=100)
   public String getPassword() {
       return this.password;
   }
   
   public void setPassword(String password) {
       this.password = password;
   }



}
