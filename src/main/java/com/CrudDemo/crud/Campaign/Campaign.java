package com.CrudDemo.crud.Campaign;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String keywords;

    private BigDecimal bidAmount;

    private BigDecimal campaignFound;

    private boolean status;

    private String town;

    private int radius;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(BigDecimal bidAmount) {
        this.bidAmount = bidAmount;
    }

    public BigDecimal getCampaignFound() {
        return campaignFound;
    }

    public void setCampaignFound(BigDecimal campaignFound) {
        this.campaignFound = campaignFound;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Campaign(String name, String keywords, BigDecimal bidAmount, BigDecimal campaignFound, boolean status, String town, int radius) {
        this.name = name;
        this.keywords = keywords;
        this.bidAmount = bidAmount;
        this.campaignFound = campaignFound;
        this.status = status;
        this.town = town;
        this.radius = radius;
    }

    public Campaign() {
    }
}
