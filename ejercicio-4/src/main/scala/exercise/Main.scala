package exercise

import MiniSpark._

import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val lines = Source.fromFile("pg2000.txt").getLines().toSeq
    wordCount(lines).foreach(println)

  }

  def wordCount(lines: Seq[String]) : Seq[(String, Int)] = ???
}
