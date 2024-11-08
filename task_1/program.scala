import scala.io.StdIn.readLine
import scala.util.Random

object Task {
  val CNT_ELEMS = 1000; // кол-во генерируемых значений
  
	def main(args: Array[String]): Unit = {
	  // считываем значение от пользователя, которое далее используется для решения задачи
	  print("Enter your value: ")
	  val value = readLine().toInt
	  
	  // создаём список уникальных значений из CNT_ELEMS сгенерированных
	  val unique_vals = (1 to CNT_ELEMS).map(_ => Random.nextInt(value))
	    .toSet
	    .toList
	 
	 unique_vals.map(num => s"Number: $num").foreach(println)
	 
	  val sum = for {
	    i <- unique_vals
	    j <- unique_vals if i < j
	  } yield i + j
	  
	  // выводим результат работы программы
	  println(s"The sum of all pairs of unique numbers is less than the given $value: ${sum.sum}")
	}
}
