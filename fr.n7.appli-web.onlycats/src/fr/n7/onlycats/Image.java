package fr.n7.onlycats;

import javax.persistence.Entity;

/**
 * @author cpantel
 *
 */
@Entity
public class Image extends Contenu {
	
	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
