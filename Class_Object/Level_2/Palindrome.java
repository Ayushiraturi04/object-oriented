package Level_2;

// PalindromeChecker class to check if a string is a palindrome
class PalindromeChecker {
    private String text;

    // Constructor to initialize the text
    public PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false; // Not a palindrome
            }
            left++;
            right--;
        }
        return true; // It's a palindrome
    }

    // Method to display the result
    public void displayResult() {
        if (isPalindrome()) {
            System.out.println("\"" + text + "\" is a palindrome.");
        } else {
            System.out.println("\"" + text + "\" is NOT a palindrome.");
        }
    }
}

// Main class to execute the program
public class Palindrome {
    public static void main(String[] args) {
        // Predefined test cases
        PalindromeChecker checker1 = new PalindromeChecker("nitin");
        PalindromeChecker checker2 = new PalindromeChecker("ayushi");
        PalindromeChecker checker3 = new PalindromeChecker("madam");

        // Displaying results
        checker1.displayResult();
        checker2.displayResult();
        checker3.displayResult();
    }
}
