import org.specs2.mutable

/**
 * Created by einevea on 02/07/15.
 */
class PalFinderSpec extends mutable.Specification{
  val palFinder = PalFinder()

  "The String " >> {
    "\"aa\" contains 1 Palindrome" >> {
      val result = palFinder.findPalindromes("aa")

      result must have size(1)
    }

    "\"aaa\" contains 3 Palindromes" >> {
      val result = palFinder.findPalindromes("aaa")

      result must have size(3)
    }

    "\"aba\" contains 1 Palindromes" >> {
      val result = palFinder.findPalindromes("aba")

      result must have size(1)
    }

    "\"caba\" contains 1 Palindromes" >> {
      val result = palFinder.findPalindromes("caba")

      result must have size(1)
    }

    "\"\" contains 0 Palindromes" >> {
      val result = palFinder.findPalindromes("")

      result must have size(0)
    }
  }


  "The List of Palindromes " >> {
    val emptyList = List()
    val aa0 = Palindrome("aa", 0)
    val aba1 = Palindrome("aba", 1)
    val aba100 = Palindrome("aba", 100)
    val masam4 = Palindrome("masam", 4)
    val amasama3 = Palindrome("amasama", 3)
    val ama3 = Palindrome("ama", 3)
    val ama7 = Palindrome("ama", 7)
    val asa5 = Palindrome("asa", 5)




    s"$emptyList " >> {
      "In Option1 " >> {
        "should return empty requesting the first 3" >> {

          val result = palFinder.getBiggestNoRep(3, emptyList)

          result must have size (0)
        }
      }

      "In Option2 " >> {
        "should return empty requesting the first 3" >> {

          val result = palFinder.getBiggestNoRepNoInline(3, emptyList)

          result must have size (0)
        }
      }
    }

    val list1 = List(aa0, aba1, aba100, masam4, asa5)
    s"$list1 " >> {
      "In Option1 " >> {
        val solution = List(masam4, aba100, asa5)
        s"should return $solution requesting the first 3" >> {

          val result:List[Palindrome] = palFinder.getBiggestNoRep(3, list1)

          result must contain(allOf(solution:_*).inOrder)
        }
      }

      "In Option2 " >> {
        val solution = List(masam4, aba100, aa0)
        s"should return $solution requesting the first 3" >> {

          val result = palFinder.getBiggestNoRepNoInline(3, list1)

          result must contain(allOf(solution:_*).inOrder)
        }
      }
    }

    val list2 = List(ama3, amasama3, ama7)
    s"$list2 " >> {
      "In Option1 " >> {
        val solution = List(amasama3, ama7)
        s"should return $solution requesting the first 3" >> {

          val result:List[Palindrome] = palFinder.getBiggestNoRep(3, list2)


          result must contain(allOf(solution:_*).inOrder)
        }
      }

      "In Option2 " >> {
        val solution = List(amasama3)
        s"should return $solution requesting the first 3" >> {

          val result = palFinder.getBiggestNoRepNoInline(3, list2)

          result must contain(allOf(solution:_*).inOrder)
        }
      }
    }
  }


}
