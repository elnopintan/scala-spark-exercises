package exercise

import org.apache.spark.rdd.RDD

/*
  * Ejecuta un proceso que calcule el número de visitas por país y almacene el resultado en un archivo delmitado con el
  * siguiente formato:
  * <nombre de pais>|<visitas>
  *
  * El argumento countryNames es un mapa que asocia códigos de país a sus nombres de país.
  * Si el código de país no se encontrara en el mapa se debe dejar el código de país en su defecto.
  * El mapa de códigos debe distribuirse como Broadcast:
  *
  * http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.broadcast.Broadcast
  *
  */

trait VisitsPerCountry {

  def visitsPerCountry(countryNames: Map[String, String], views: RDD[PageView], outputFile: String): Unit = {
    val sc = views.sparkContext
    val bCountries = sc.broadcast(countryNames)
    views.map(view => (view.countryCode, view.visits)).reduceByKey(_ + _).map {
      case (countryCode, visits) => s"${bCountries.value.getOrElse(countryCode, countryCode)}|$visits"
    }.saveAsTextFile(outputFile)
  }
}
