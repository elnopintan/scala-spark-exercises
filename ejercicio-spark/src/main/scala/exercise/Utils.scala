package exercise

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Dataset, SparkSession}


object Utils extends
    CsvReader with
    PageViewReader with
    MostVisitedWebRDD with
    MostVisitedWebDF with
    VisitsPerCountry with
    CountNoDownloads
{

  def createViewsDF(spark: SparkSession, views: RDD[PageView]): Dataset[PageView] = {
    import spark.implicits._
    views.toDS
  }
}
