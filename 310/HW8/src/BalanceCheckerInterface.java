
/**
 * Interface for HW 08, Balanced Checker
 * @author Dr. Lillis
 */

public interface BalanceCheckerInterface {

    /**
     * Adds a pair of matching characters. For example '(' matches with ')'
     * and '{' matches with '}'.
     * @param open An opening character
     * @param close The corresponding closing character
     * @throws DuplicateCharacterException if either character has already
     * been added.
     */
    void addPair(Character open, Character close) throws DuplicateCharacterException;

    /**
     * Checks the given string and uses the pairs of symbols previously added
     * with addPair to see if the string has balanced symbols. If the string 
     * does have balanced symbols, this method returns true, otherwise it
     * returns false. If no pairs have been added, the string is considered
     * to be balanced.
     * @param s The string to be checked for balanced symbols
     * @return true if the string s has balanced symbols, returns false otherwise
     */
    boolean isBalanced(String s);

    /**
     * Checks to see if the given character has been added as an opening 
     * character.
     * @param ch The symbol to check
     * @return true if the given character has been added as an opening 
     * character, returns false otherwise.
     */
    boolean isOpening(Character ch);

    /**
     * Checks to see if the given character has been added as a closing 
     * character.
     * @param ch The symbol to check
     * @return true if the given character has been added as a closing 
     * character, returns false otherwise.
     */
    boolean isClosing(Character ch);

    /**
     * Returns true if the two given characters are a pair of matching
     * characters that have been previously added with the addPair method.
     * The first symbol is assumed to be an opening character. The method 
     * returns true if the second character is the closing character that
     * corresponds to the first.
     * @param ch1 The first character to check
     * @param ch2 The second character to check
     * @return true if the symbols are a matching pair that has been previously
     * added with the addPair method.
     */
    boolean match(Character ch1, Character ch2);
}