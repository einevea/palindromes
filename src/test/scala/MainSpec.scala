import org.specs2.mutable

/**
 * Created by einevea on 02/07/15.
 */
class MainSpec extends mutable.Specification{

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
