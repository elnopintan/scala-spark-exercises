package exercise

import MiniSpark._

import scala.io.Source

object Main {

  def main(args: Array[String]): Unit = {

    val lines = Source.fromFile("pg2000.txt").getLines().toSeq
    wordCount(lines).foreach(println)

  }

  def wordCount(lines: Seq[String]) : Seq[(String, Int)] = {
    val words = lines.flatMap(_.split(" "))
    val keyValue = words.map(_ -> 1)
    keyValue.reduceByKey((a, b) => a + b)
  }
}
