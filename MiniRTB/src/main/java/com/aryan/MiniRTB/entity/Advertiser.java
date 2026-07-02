package com.aryan.MiniRTB.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "advertisers")
public class Advertiser {

    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private AdvertiserStatus status;

    public Advertiser() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public AdvertiserStatus getStatus() {
        return status;
    }
    public void setStatus(AdvertiserStatus status) {
        this.status = status;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
