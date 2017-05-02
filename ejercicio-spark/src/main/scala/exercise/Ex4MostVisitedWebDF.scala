package exercise

import org.apache.spark.sql.Dataset
import org.apache.spark.sql.functions._


trait MostVisitedWebDF {

  def getMostVisitedWebAt(country: String, views: Dataset[PageView]): String = ???

  def topVisitingCountries(number: Int, views: Dataset[PageView]): Array[String] = ???
}
