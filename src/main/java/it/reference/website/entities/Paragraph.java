package it.reference.website.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Paragraph
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 50)
	private String title;

	@Lob
	private String text;

	@ManyToOne
	private Topic topic;

	@ManyToOne
	private Paragraph parent;

	@OneToMany(mappedBy = "parent")
	private List<Paragraph> subParagraphs;
}
