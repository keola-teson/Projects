/**
 * Generates character objects for the MYC game
 * @author Keola Teson :)
 */
public class Characters
{
	/*
	 * Data Attributes
	 * ---------------
	 * 
	 * the following data attributes are character attributes for each character in the game
	 * - age
	 * - occupation
	 * - name
	 * - hobby
	 * - favorite (their favorite thing in the world (usually tied to their hobby))
	 */
	private String age;
	private String occupation;
	private String name;
	private String hobby;
	private String favorite;
	private String relationship;
	
	/**
	 * Constructor for the class to allow the class to be called in different classes
	 * @param occ
	 */
	public Characters(String charName, String charAge, String occ, String hob, String fav, String relation)
	{
		age = charAge;
		occupation = occ;
		name = charName;
		hobby = hob;
		favorite = fav;
		relationship = relation;
	}
	
	/**
	 * When called, displays the character attribuets of the character that was inputted when the class was called
	 * @return getCharacterAttributes() (currently generates a recursion erro *will be fixed*)
	 */
	public String[] getCharacterAttributes()
	{
		String[] attributes = {name, age, occupation, hobby, favorite, relationship};
		return attributes;
	}

	/**
	 * Setter for age data attribute
	 * @param age
	 */
	public void setAge(String age) {
		this.age = age;
	}

	/**
	 * Setter for occupation data attribute
	 * @return occupation
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * Setter for name data attribute
	 * @return name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setter for hobby data attribute
	 * @return hobby
	 */
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 * Setter for favorite data attribute
	 * @return favorite
	 */
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

	/**
	 * Setter for relationship data attribute
	 * @return
	 */
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	
	
}
