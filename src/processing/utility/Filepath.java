package processing.utility;

/**
*
* @author Ahmed Zaheer Dadarkar
*/

// This class corresponds to the filepath
public class Filepath {
	private String filepath; // Filepath String
	
	// Construct using String
	public Filepath(String filepath) {
		this.filepath = filepath;
	}
	
	// Convert to String
	public String toString() {
		return filepath;
	}
}