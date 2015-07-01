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

      "if has size one" >> {
        Palindrome.isPalindrome("a") must beFalse
      }

    }
  }

  "The String " >> {
    "aa contains 1 Palindrome" >> {
      val result = Main.findPalindromes("aa")

      result must have size(1)
    }

    "aaa contains 3 Palindromes" >> {
      val result = Main.findPalindromes("aaa")

      result must have size(3)
    }

    "aba contains 1 Palindromes" >> {
      val result = Main.findPalindromes("aba")

      result must have size(1)
    }

    "caba contains 1 Palindromes" >> {
      val result = Main.findPalindromes("caba")

      result must have size(1)
    }
  }
}
