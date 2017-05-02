package exercise

import org.apache.spark.rdd.RDD


/* Procesa el RDD para responder a las preguntas
 */

trait MostVisitedWebRDD {

  def getMostVisitedWebAt(country: String, views: RDD[PageView]): String = ???

  def topVisitingCountries(number: Int, views: RDD[PageView]): Array[String] = ???
}

