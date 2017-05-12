### Ejercicio de Spark

En este espacio de trabajo hay una serie de ejercicios de Spark. 
Cada ejercicio tendrá una parte no implementada que deberá realizarse para terminar cado ejercicio

Para compilar los ejercicios ejecuta

```bash
  sbt package
```

Ese comando generará un .jar con los binarios del ejercicio.

Para probar el ejercicio es necesario tener descargado Spark

http://spark.apache.org/downloads.html

Los archivos que se van a utilizar para el ejercicios son

[country-codes.csv](country-codes.csv)

que contiene un csv que asocia códigos de pais a los nombres de paises y 

https://dumps.wikimedia.org/other/pageviews/2017/2017-04/pageviews-20170405-000000.gz

Que tiene las visitias a las páginas de wikimedia del día 5 de abril de 20117 a las 00:00


Una vez descomprimido se ejecutar una consola de Spark usando el siguiente comando en el directorio `bin` de donde se 
 haya descomprimido Spark

```bash
 spark-shell.<sh o cmd> --jars <path del proyecto>/target/scala-2.11/ejercicio-spark_2.11-1.0.jar
```

Una vez abierta la consola de scala se puede ejecutar:

```scala
scala> import exercise.Utils._
```
Esto importará todas las funciones de los ejercicios

```scala
scala> val text = sc.textFile("<path de pageview>/pageviews-20170405-000000.gz")
```

Esto generará el RDD que debe utilizarse como argumento del primer ejercicio


Una vez terminados todos los ejercicios, se puede ejecuar spark-submit para validar el ejercicio


```bash 
  spark-submit <path del proyecto>/target/scala-2.11/ejercicio-spark_2.11-1.0.jar <csv wikimedia> <coutry-codes.csv>
```

