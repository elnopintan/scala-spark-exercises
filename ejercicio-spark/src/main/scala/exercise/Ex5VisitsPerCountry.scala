package exercise

import org.apache.spark.rdd.RDD

trait VisitsPerCountry {

  def visitsPerCountry(countryNames: Map[String, String], views: RDD[PageView], outputFile: String): Unit = ???
}
