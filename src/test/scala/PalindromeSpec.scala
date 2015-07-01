import org.specs2._
/**
 * Created by einevea on 01/07/15.
 */
class PalindromeSpec extends mutable.Specification{
  "A String should " >> {
    "be a palindrome if is equal to its reverse" >> {
      Palindrome.isPalindrome("hijkllkjih") must beTrue

      Palindrome.isPalindrome("defggfed") must beTrue

      Palindrome.isPalindrome("abccba") must beTrue
    }

    "not be a palindrome " >> {
      "if is not equal to its reverse" >> {
        Palindrome.isPalindrome("casa") must beFalse

        Palindrome.isPalindrome("defggfeds") must beFalse

        Palindrome.isPalindrome("abccbad") must beFalse
      }

      "if is empty" >> {
        Palindrome.isPalindrome("") must beFalse
      }
    }
  }
}
