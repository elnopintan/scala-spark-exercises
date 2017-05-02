package exercise

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator

/**
  * Implementa una función que utilice un acumulador para contar cuantas de las páginas tienen 0 bytes descargados
  *
  * http://spark.apache.org/docs/latest/programming-guide.html#accumulators
  * http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.util.AccumulatorV2
  *
  */

trait CountNoDownloads {

  def countNoDownloads(views: RDD[PageView]): Long = {

    val sc = views.sparkContext
    val acc = sc.longAccumulator("NoDownloads")
    runCount(acc, views)
    acc.value
  }

  def runCount(acc: LongAccumulator, views: RDD[PageView]): Unit = ???

}
