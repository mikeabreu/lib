
public class ItemType {

	private String line;
	
	protected ItemType() {line = null;}
	
	protected ItemType(String line) {this.line = line;}
	
	// Setters
	protected void setLine(String line) {this.line = line;}
	
	// Getters
	public String toString() {return line;}
}
