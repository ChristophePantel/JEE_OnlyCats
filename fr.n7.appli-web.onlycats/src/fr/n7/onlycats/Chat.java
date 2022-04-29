/**
 * 
 */
package fr.n7.onlycats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author cpantel
 *
 */
@Entity
public class Chat {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int idChat;
	
	String descriptionChat;
	
	// Tags : Liste de tags
	
	// Contenu multimédia

	FilPosts filPostsChat;
	
}
