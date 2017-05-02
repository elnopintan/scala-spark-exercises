package exercise

import org.apache.spark.rdd.RDD

/*
  * Un Csv es un archivo con datos delimitados por un delimitador (habitualmente una coma).
  * Crea una función que, dado un RDD de lineas devuelva un RDD con los elementos separdos por el delmitador
  *
  * Necesitarás ver la documentación del RDD y la de String de Java
  *
  * http://spark.apache.org/docs/latest/api/scala/index.html#org.apache.spark.rdd.RDD
  * https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
  */

trait CsvReader {
  def readCsv(text: RDD[String], delimiter: String) : RDD[Array[String]] = text.map(_.split(delimiter))
}
