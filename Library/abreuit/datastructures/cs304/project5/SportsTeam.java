package abreuit.datastructures.cs304.project5;
import java.io.Serializable;

public class SportsTeam implements Comparable<SportsTeam>, Serializable {

	private static final long serialVersionUID = 5725504304455069740L;
	private String name;

	public SportsTeam() {
		name = "no team name";
	}

	public SportsTeam(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\n" + name;
	}

	@Override
	public int compareTo(SportsTeam team) 
	// 	Returns 0 if the two elements are the same name.
	// 	Returns 1 if the name being compared to is alphabetically 
	// 		higher than this name (A < B), such that A.compareTo(B), B
	// 		is greater than A.
	//	Returns -1 if the name being compared to is alphabetically 
	// 		lower than this name (A < B), such that A.compareTo(B), A
	// 		is less than B.
	{
		if (this.name.equalsIgnoreCase(team.getName())) {
			return 0;
		} else {
			for (int i = 0; i < name.length(); i++) {
				if (this.name.charAt(i) == team.getName().charAt(i))
					continue;
				else if (this.name.charAt(i) > team.getName().charAt(i))
					return 1;
				else if (this.name.charAt(i) < team.getName().charAt(i))
					return -1;
					
			}
			return -1;
		}
	}
}
