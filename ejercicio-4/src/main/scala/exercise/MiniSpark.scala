package exercise

object MiniSpark {

  implicit class Reducer[K, V](self: Seq[(K, V)]) {

    def reduceByKey (f: (V, V) => V): Seq[(K, V)] = {
    def each(m : Map[K,V], value: (K, V)) = {
      val (k, v) = value
      val maybeValue = m.get(k)
      val sumValue = maybeValue match {
        case None => v
        case Some(another) => f(another, v)
      }
      m + (k -> sumValue)
    }
      self.foldLeft(Map[K,V]())(each).toSeq
      }
    }
  }

