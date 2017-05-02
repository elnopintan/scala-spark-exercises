package exercise

import org.apache.spark.rdd.RDD


/*
  *  Convierte el array de String en la case class PageView
  *  Los campos del csv son 4 :
  *    <pais>.<proyecto>
  *    <pagina>
  *    <visitas>
  *    <trafico en bytes>
  *
  *    Para resolver este ejercicio se necesita conocer la documentación de String, la de Array y la de WrappedArray
  *
  *    http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD
  *    https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
  *    https://www.scala-lang.org/api/2.11.8/index.html#scala.collection.mutable.WrappedArray
  *
  *
  *    Es posible resolverlo usando pattern matching
  *
  */

trait PageViewReader {

  def readPageView(fields: RDD[Array[String]]): RDD[PageView] = ???
}
