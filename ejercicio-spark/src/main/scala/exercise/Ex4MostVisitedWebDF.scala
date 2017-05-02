package exercise

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.functions._

/* Procesa el RDD para responder a las preguntas.
   En la primera se pide cual es la página de wikimedia más visitada de un país dado su country code
   En la segunda se busca cuales son los países que más visitas hacen a wikimedia

   La documentación que puede hacer falta es:
   http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Dataset
   http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.Column
   http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.sql.functions$
 */

trait MostVisitedWebDF {

  def getMostVisitedWebAt(country: String, views: Dataset[PageView]): String = {
    val spark = views.sparkSession
    import spark.implicits._
    ???
  }

  def topVisitingCountries(number: Int, views: Dataset[PageView]): Array[String] = {
    val spark = views.sparkSession
    import spark.implicits._
    ???
  }
}
