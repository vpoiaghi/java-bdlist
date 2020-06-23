package utils;

public abstract class StringUtils {

	private static final String MAJ_CHARS[] = {
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
			"", "", "", "", "", "", "", "", " ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", 
			"-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", 
			"@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", 
			"T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "A", "B", "C", "D", "E", "F", "G",
			"H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "{",
			"|", "}", "~", "", "€", "", "‚", "ƒ", "„", "…", "†", "‡", "ˆ", "‰", "S", "‹", "OE", "", "Z", "",
			"", "‘", "’", "\"", "\"", "•", "–", "—", "˜", "™", "š", "›", "OE", "", "Z", "Y", " ", "¡", "C",
			"£", "¤", "Y", "¦", "§", "¨", "©", "A", "«", "¬", "­", "®", "¯", "°", "±", "²", "³", "´", "µ",
			"¶", "·", "¸", "¹", "º", "»", "¼", "½", "¾", "¿", "A", "A", "A", "A", "A", "A", "AE", "C", "E", "E",
			"E", "E", "I", "I", "I", "I", "D", "N", "O", "O", "O", "O", "O", "×", "O", "U", "U", "U", "U", "Y",
			"Þ", "ß", "A", "A", "A", "A", "A", "A", "AE", "C", "E", "E", "E", "E", "I", "I", "I", "I", "O", "N",
			"O", "O", "O", "O", "O", "÷", "ø", "U", "U", "U", "U", "Y", "þ", "Y"};
	
    public static String toSearchString(final String value) {

    	String result = null;

    	if (value != null) {
    		StringBuilder sb = new StringBuilder();

    		for (char c : value.toCharArray()) {
    			
    			try {
    				sb.append(MAJ_CHARS[(int) c]);
    			} catch(ArrayIndexOutOfBoundsException e) {
    				
    				if ((int) c == 339) {
    					sb.append("Œ");
    				} else {
        				LogUtils.warn("Error caractère ascii value : " + value + ", caractère : " + c + ", ascii : " + (int) c);    					
    				}
    				
       			}
    		}

    		result = sb.toString();
    	}

    	return result;
    }
	
}
