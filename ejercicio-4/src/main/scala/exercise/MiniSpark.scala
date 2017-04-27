package exercise

import scala.reflect.ClassTag


object MiniSpark {

  implicit class Reducer[K, V](self: Seq[(K, V)]) {

    def reduceByKey (f: (V, V) => V): Seq[(K, V)] = ???
  }

}
