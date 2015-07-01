/**
 * Created by einevea on 01/07/15.
 */

case class Palindrome(str:String, index: Int){
  lazy val length = str.length
  lazy val end = index + length
}

object Palindrome {

  def isPalindrome(str:Seq[Char]): Boolean ={
    str.length > 1 && str == str.reverse
  }
}
