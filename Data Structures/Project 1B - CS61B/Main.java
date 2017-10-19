public class Main {
    public static void main(String[] args) {
        Deque<Character> a = Palindrome.wordToDeque("abcdefgfedcba");
        OffByOne obo = new OffByOne();
        OffByN obt = new OffByN(2);
        a.printDeque();
        System.out.println();
        System.out.println(Palindrome.isPalindrome("abcdefgfedcba"));       //true
        System.out.println(Palindrome.isPalindrome(""));                    //true
        System.out.println(Palindrome.isPalindrome("a"));                   //true
        System.out.println(Palindrome.isPalindrome("abcdeffedcba"));        //true
        System.out.println(Palindrome.isPalindrome("abcdefghfedcba"));      //false
        System.out.println(Palindrome.isPalindrome("abcdefgfedcba", obo));  //false
        System.out.println(Palindrome.isPalindrome("", obo));               //true
        System.out.println(Palindrome.isPalindrome("a", obo));              //true
        System.out.println(Palindrome.isPalindrome("abcdeffedcba", obo));   //false
        System.out.println(Palindrome.isPalindrome("abcdefgifedcba", obo)); //false
        System.out.println(Palindrome.isPalindrome("flake", obo));          //true
        System.out.println(Palindrome.isPalindrome("aceghfdb", obo));       //true
        System.out.println(Palindrome.isPalindrome("abefhgdc", obt));       //true
        System.out.println(Palindrome.isPalindrome("abefzgdc", obt));       //false

    }
}
