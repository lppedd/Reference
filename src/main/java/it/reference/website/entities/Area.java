package it.reference.website.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Area
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(length = 50)
   private String name;

   @OneToMany(mappedBy = "area")
   private List<Topic> topics;
}
