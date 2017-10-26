package it.reference.website.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Topic
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(length = 50, nullable = false)
   private String title;

   @Column(length = 500)
   private String description;
   private Date lastUpdate;

   @ManyToOne
   private Area area;

   @OneToMany(mappedBy = "topic")
   private List<Paragraph> paragraphs;
}
