import scala.annotation.tailrec

/**
 * Created by einevea on 01/07/15.
 */
object Main {

  def main(args: Array[String]):Unit = {
    val palFinder = PalFinder()
    args foreach(seq => {
      val palindromes = palFinder.findPalindromes(seq)

      println("\nOption 1")
       palFinder.getBiggestNoRep(3, palindromes) foreach(p => {
         println(s"Text: ${p.str}, Index: ${p.index}, Length: ${p.length}")
       })

      println("\nOption 2:")
     palFinder.getBiggestNoRepNoInline(3, palindromes).foreach(p => {
        println(s"Text: ${p.str}, Index: ${p.index}, Length: ${p.length}")
      })
    })
  }

}
