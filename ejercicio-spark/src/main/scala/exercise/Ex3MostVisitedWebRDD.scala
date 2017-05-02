package exercise

import org.apache.spark.rdd.RDD


/* Procesa el RDD para responder a las preguntas.
   En la primera se pide cual es la página de wikimedia más visitada de un país dado su country code
   En la segunda se busca cuales son los países que más visitas hacen a wikimedia

   La documentación que puede hacer falta es:
   http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD
   http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.PairRDDFunctions
 */

trait MostVisitedWebRDD {

  def getMostVisitedWebAt(country: String, views: RDD[PageView]): String =
    views.filter(_.countryCode == country).sortBy(_.visits, false).map(_.page).first

  def topVisitingCountries(number: Int, views: RDD[PageView]): Array[String] =
    views.map(view => (view.countryCode, view.visits)).reduceByKey(_ + _).sortBy(_._2, false).map(_._1).take(number)
}

