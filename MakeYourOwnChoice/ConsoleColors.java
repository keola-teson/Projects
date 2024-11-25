
/**
 * Enum to make styling the console easier.
 * @author Bharath Kalyan S (based on their code)
 * @author Keola Teson :)
 */
public enum ConsoleColors
{
	// Resetting Text
    RESET("\033[0m"),				// NORMAL
    
    // Text Formatting
    ITALICS("\033[3m"),				// ITALICS
    BOLD("\033[1m"),				// BOLD
    
    // Character Colors
	PARTNER("\033[38;5;42m"),		// GREEN
	CAPTAIN("\033[38;5;87m"),		// LIGHT BLUE
	ROOMMATE("\033[38;5;11m"),		// YELLOW
	BARISTA("\033[38;5;219m"),		// PINK
	FORENSICS("\033[38;5;9m"),		// SALMON
	MURDERER("\033[0;91m"),			// RED
	BUM("\033[0;100m");				// Black Background

    private final String code;
	
    ConsoleColors(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
