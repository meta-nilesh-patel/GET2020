package question2;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Nilesh Patel
 * CountCharacter class count the unique character in a string
 */
public class CountCharacter {
	private static HashMap<String, Integer> cache = new HashMap<>();

	public static long numberOfUniqueCharacter(String input) {
		try {
			if (input == null) {
				throw new Exception("String cant be null");
			}
			if(cache.containsKey(input)){
				return cache.get(input);
			}
			HashSet<Character> uniqueCharacters = new HashSet<Character>();
			for (int index = 0; index < input.length(); index++) {
				uniqueCharacters.add(input.charAt(index));
			}
			cache.put(input, uniqueCharacters.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cache.get(input);
	}

}
