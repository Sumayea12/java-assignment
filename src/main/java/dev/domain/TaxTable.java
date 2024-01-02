package dev.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "taxtable")
public class TaxTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "total_income")
    private double total_income;

    @Column(name = "tax_amount")
   private double tax_amount;

    @OneToOne
    @JoinColumn(name = "user_id")

    private User user;



    public TaxTable() {
    }

    public TaxTable(int id, double total_income, double tax_amount, User user) {
        this.id = id;
        this.total_income = total_income;
        this.tax_amount = tax_amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal_income() {
        return total_income;
    }

    public void setTotal_income(double total_income) {
        this.total_income = total_income;

    }

    public double getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(double tax_amount) {
        this.tax_amount = tax_amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
