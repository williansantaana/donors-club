package pt.donors.club.donors_club.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "adposts")
public class AdPost implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ad_id")
  private int id;

  @Column(name = "ad_title")
  private String title;

  @Column(name = "ad_description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "ad_subcategory_id")
  private Subcategory category;

  @Column(name = "ad_pub_date")
  private LocalDate publicationDate;

  @Column(name = "ad_active")
  private boolean active;

  @ManyToOne
  @JoinColumn(name = "ad_owner_id")
  @JsonIgnoreProperties({"ads"})
  private User owner;

  public AdPost() {
  }

  public AdPost(int id, String title, String description, Subcategory category, User owner) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.category = category;
    publicationDate = LocalDate.now();
    active = true;
    this.owner = owner;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Subcategory getCategory() {
    return category;
  }

  public void setCategory(Subcategory category) {
    this.category = category;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public boolean isActive() {
    return active;
  }

  public void deactivate() {
    active = false;
  }

  public User getOwner() {
    return owner;
  }
}