package awilchermod5csc201;

public class WordSeparator {

	private String original; // The original string
	private String formatted; // The formatted output string

	// constructor
	public WordSeparator() {

	}

	public WordSeparator(String s) {
		this.original = s;
	}

	// methods
	public String toString() {
		return this.formatted;
	}

	public void separate() {
		StringBuilder s = new StringBuilder(this.original);
		//loop backwards
		for (int i = original.length() - 2; i > 0; i--) {
			char c = this.original.charAt(i);
			char last = original.charAt(original.length() - 1);
			char n = this.original.charAt(i - 1);
			//is the letter upper case
			if (Character.isUpperCase(c)) {
				//is the next character punctuation?
				if (!Character.isLetterOrDigit(n)) {
					s.replace(i, i + 1, " " + c);
				} 
				//is the letter an I
				else if (c == 'I') {
					//was the last letter capital as well
					if (Character.isUpperCase(last)) {
						s.replace(i, i + 1, " " + Character.toLowerCase(c));
					} else {
						s.replace(i, i + 1, " I");
					}
				} else {
					s.replace(i, i + 1, " " + Character.toLowerCase(c));
				}
				//set last letter
				last = c;
			}

		}
		this.formatted = s.toString();

	}

	// getters and setters
	public void setOriginal(String s) {
		this.original = s;
	}

	public String getOriginal() {
		return this.original;
	}

	public void setFormat(String f) {
		this.formatted = f;
	}

	public String getFormat() {
		return this.formatted;
	}
}
