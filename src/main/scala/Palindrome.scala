/**
 * Created by einevea on 01/07/15.
 */

case class Palindrome(str:String, index: Int){
  lazy val length = str.length
}

object Palindrome {

  def isPalindrome(str:String): Boolean ={
    !str.isEmpty && str == str.reverse
  }
}
