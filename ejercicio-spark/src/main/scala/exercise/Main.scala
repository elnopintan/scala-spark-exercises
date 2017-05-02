package exercise

import Utils._
import org.apache.spark.sql.SparkSession

import scala.io.Source

object Main extends App {

  if (args.length == 2) {

    val file = args(0)
    val countryFile = args(1)

    val sparkSession = SparkSession.builder().appName("Spark-scala-exercises").getOrCreate()
    val sc = sparkSession.sparkContext

    println(s"Running exercises over file $file")
    val text = sc.textFile(file)
    val data = readCsv(text, " ")
    val views = readPageView(data)
    val mostViewedRDD = getMostVisitedWebAt("es", views)
    println(s"The most viewed page in Spain is $mostViewedRDD")
    val topTenRDD = topVisitingCountries(10, views)
    println("Top ten countries visiting Wikimedia")
    topTenRDD.foreach(println)
    val viewsDF = createViewsDF(sparkSession, views)
    val mostViewedDF = getMostVisitedWebAt("es", viewsDF)
    println(s"The most viewed page in Spain is $mostViewedRDD")
    val topTenDF = topVisitingCountries(10, viewsDF)
    println("Top ten countries visiting Wikimedia")
    topTenRDD.foreach(println)
    val codeMap = Source.fromFile(countryFile).getLines
      .map(_.toLowerCase.split(",").take(2)).map {
      case Array(name, code) => (code, name)
    }.toMap
    println("writing to visits file")
    visitsPerCountry(codeMap, views, "visits.csv")
    val count = countNoDownloads(views)
    println(s"There are $count that weren't visited today")
  } else {
    println("Usage: The process needs 2 arguments. <pageview file> and <country code file>")
  }
}
