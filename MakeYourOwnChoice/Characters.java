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
	private int age;
	private String occupation;
	private String name;
	private String hobby;
	private String favorite;
	
	/**
	 * Constructor for the class to allow the class to be called in different classes
	 * @param occ
	 */
	public Characters(String occ)
	{
		//sets the occupation String object to the occ String parameter
		this.occupation = occ;
	}
	
	/**
	 * When called, displays the character attribuets of the character that was inputted when the class was called
	 * @return getCharacterAttributes() (currently generates a recursion erro *will be fixed*)
	 */
	public String[] getCharacterAttributes()
	{
		/*
		 * This switch statement ties the value given to the occupation variable when the class was being called to a method.
		 * Makes it so when this class gets called, what gets returned is the value that is returned in the methods it ties the occupation object to.
		 */
		switch (occupation.toLowerCase())
		{
			//case 1: if the string "partner" is given to occupation, call partnerAttributes()
			case "partner":
				return partnerAttributes();
				
			//case 2: if the string "captain" is given to occupation, call captainAttributes()
			case "captain":
				return captainAttributes();
			
			//case 3: if the string "roommate" is given to occupation, call roommateAttributes()
			case "roommate":
				return roommateAttributes();
			
			//case 4: if the string "barista" is given to occupation, call baristaAttributes()
			case "barista":
				return baristaAttributes();
			
			//case 5: if the string "forensics" is given to occupation, call forensicsAttributes()
			case "forensics":
				return forensicsAttributes();
			
			//case 6: if the string "murderer" is given to occupation, call murdererAttributes()
			case "murderer":
				return murdererAttributes();
			
			//case 7: if the string "bum" is given to occupation, call bumAttributes()
			case "bum":
				return bumAttributes();
			
			//default: if the string that gets given to occupation isn't any of the cases, generate an error bc this is temporary
			default:
				return getCharacterAttributes();
		}
	}
	
	
	/**
	 * This method generates attributes to the partner character
	 * @return attributes string[]
	 */
	public String[] partnerAttributes()
	{	
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 27;
		name = "Harry Freeman";
		occupation = "Detective";
		hobby = "Photography";
		favorite = "Sunsets";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the captain character
	 * @return attributes string[]
	 */
	public String[] captainAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 50;
		name = "Steven Anders";
		occupation = "Police Captain";
		hobby = "Fishing";
		favorite = "Beaches";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the roommate character
	 * @return attributes string[]
	 */
	public String[] roommateAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 22;
		name = "Wallice West";
		occupation = "Unemployed";
		hobby = "Collecting";
		favorite = "Mint condition Miku figure";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the barista character
	 * @return attributes string[]
	 */
	public String[] baristaAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 24;
		name = "Ruby Hesser";
		occupation = "Barista";
		hobby = "Dancing";
		favorite = "Cats";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the forensics character
	 * @return attributes string[]
	 */
	public String[] forensicsAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 31;
		name = "Alex Payne";
		occupation = "Forensic Scientist";
		hobby = "Gardening";
		favorite = "Begonia";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the murderer character
	 * @return attributes string[]
	 */
	public String[] murdererAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		String age = "Unknown";
		name = "Unknown";
		occupation = "Unknown";
		hobby = "Unknown";
		favorite = "Unknown";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
	
	/**
	 * This method generates attributes to the bum character
	 * @return attributes string[]
	 */
	public String[] bumAttributes()
	{
		/*
		 * gives a value to:
		 * - age
		 * - name
		 * - occupation
		 * - hobby
		 * - avorite
		 */
		age = 25;
		name = "Keola Teson";
		occupation = "Bum";
		hobby = "Exploring";
		favorite = "Ruby Hesser";
		
		//creates a string array
		String[] attributes = new String[5];
		
		/*
		 * adds those character attributes to the array
		 */
		attributes[0] = "" + age;
		attributes[1] = name;
		attributes[2] = occupation;
		attributes[3] = hobby;
		attributes[4] = favorite;
		
		//returns the string array
		return attributes;
	}
}
