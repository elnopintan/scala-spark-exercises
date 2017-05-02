package exercise

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator

trait CountNoVisits {

  def countNoVisits(views: RDD[PageView]): Long = {

    val sc = views.sparkContext
    val acc = sc.longAccumulator("NoVisits")
    runCount(acc, views)
    acc.value
  }

  def runCount(acc: LongAccumulator, views: RDD[PageView]): Unit = ???

}
