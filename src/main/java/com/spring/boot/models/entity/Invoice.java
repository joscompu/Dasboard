package com.spring.boot.models.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String observation;

    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;


    public Invoice(){
        this.items = new ArrayList<InvoiceItem>();
    }


    @PrePersist
    public void prePersist(){
        createAt = new Date();
    }

    public void addItemInvoice(InvoiceItem item){
        this.items.add(item);
    }

    public Double getTotalInvoice(){
        Double total = 0.0;
        int size = items.size();

        for (int i=0; i<size; i++){
            total += items.get(i).calculateSubTotalItemInvoice();
        }

        return total;
    }
}
