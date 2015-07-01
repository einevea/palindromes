import scala.annotation.tailrec

/**
 * Created by einevea on 01/07/15.
 */
object Main {

  def findPalindromes(str:String): List[Palindrome] = {

    @tailrec
    def findPalindromesRec(fullStr:String, str:String, index:Int, acumulator:List[Palindrome]): List[Palindrome] ={
      str match {
        case _ if str.isEmpty && fullStr.isEmpty => acumulator

        case _ if str.isEmpty && !fullStr.isEmpty => {
          val newFullStr = fullStr.substring(1)
          findPalindromesRec(newFullStr, newFullStr, index+1, acumulator)
        }

        case _ if Palindrome.isPalindrome(str)=> {
          val newAcumulator = Palindrome(str, index) :: acumulator

          findPalindromesRec(fullStr, str.substring(0, str.length-1), index, newAcumulator)
        }

        case _ => {
          findPalindromesRec(fullStr, str.substring(0, str.length-1), index, acumulator)
        }
      }
    }

    findPalindromesRec(str, str, 0, List())
  }

  def getBiggestNoRep(palindromes: List[Palindrome]) : Seq[(String,Palindrome)] = {

    val filtered = palindromes map (t => t.str -> t) toMap

    filtered.toSeq.sortBy(-_._2.length)
  }

  def getBiggestNoRep(i: Int, palindromes: List[Palindrome]): List[Palindrome] = {
    val sorted = getBiggestNoRep(palindromes)

    sorted.take(i).map(f => f._2).toList
  }

  def getBiggestNoRep2(i: Int, palindromes: List[Palindrome]): List[Palindrome] = {
    val sorted = getBiggestNoRep(palindromes)

    @tailrec
    def removeInlinePalindromes(count:Int, currentPalindromes:Seq[(String,Palindrome)], accumulator: List[Palindrome]): List[Palindrome] ={
      if(count == i){
          accumulator
      } else {
        currentPalindromes match {
          case x:Seq[(String,Palindrome)] if !x.isEmpty => {
            val palindrome = x.head._2
            val newPalindromeList = x.tail.filter(p => !(p._2.index >= palindrome.index &&  p._2.end <= (palindrome.end)))
            removeInlinePalindromes(count+1, newPalindromeList, palindrome :: accumulator)
          }
          case _ => accumulator
        }

      }

    }

    removeInlinePalindromes(0, sorted, List())
  }

  def main(args: Array[String]):Unit = {
    args foreach(seq => {
      val palindromes = findPalindromes(seq)

      println("\nOption 1")
       getBiggestNoRep(3, palindromes) foreach(p => {
         println(s"Text: ${p.str}, Index: ${p.index}, Length: ${p.length}")
       })

      println("\nOption 2:")
      getBiggestNoRep2(3, palindromes).reverse.foreach(p => {
        println(s"Text: ${p.str}, Index: ${p.index}, Length: ${p.length}")
      })
    })
  }

}
