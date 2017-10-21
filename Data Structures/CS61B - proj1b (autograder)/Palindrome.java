public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> wordDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    public static boolean isPalindrome(String word) {
        int lastIndex = word.length() - 1;
        int i = 0;
        while (i < lastIndex) {
            if (word.charAt(i++) != word.charAt(lastIndex--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        int lastIndex = word.length() - 1;
        int i = 0;
        while (i < lastIndex) {
            if (!cc.equalChars(word.charAt(i++), word.charAt(lastIndex--))) {
                return false;
            }
        }
        return true;
    }
}
