import scala.io
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    zadanie3a();
    zadanie3b();
    zadanie3c();
  }

  def zadanie3a(): Unit = {
    println(
      """
      ******************************************************
      3a.    Напишите программу, которая:
      i.   выводит фразу «Hello, Scala!» справа налево
      ii.  переводит всю фразу в нижний регистр
      iii. удаляет символ!
      iv.  добавляет в конец фразы «and goodbye python!»
      """)

    val StrEn = "Hi, Scala!"
    val StrRu = "Привет, Скала!"
    val Str = StrEn + " *** " + StrRu 
    
    println("0\t: " + Str)
    print("i1\t: ");
    for(i <- (Str.length-1) to 0 by -1 ) print(Str(i));
    println()
    println("i2\t: " +  (for (i <- (Str.length - 1) to 0 by -1) yield Str(i)).mkString )
    println("i3\t: " + Str.reverse)
    println("ii\t: "+ Str.toLowerCase)
    println("iii\t: "+ Str.replaceFirst("!", "") )
    println("iv\t: "+ Str.concat(" Прости, Питон :("))
  }

  def zadanie3b(): Unit = {
    println(
      """
        *************************************************
        b. Напишите программу, которая вычисляет ежемесячный оклад сотрудника
        после вычета налогов. На вход вашей программе подается
        - значение годового дохода до вычета налогов,
        - размер премии – в процентах от годового дохода и
        - компенсация питания.""")
    val dokhod = StdIn.readLine("Введи значение годового дохода до вычета налогов: " )
    val premia = StdIn.readLine("Введи размер премии – в процентах от годового дохода: " )
    val kompns = StdIn.readLine("Введи значение компенсации питания: " )

    println(s"dokhod: $dokhod")
    println(s"premia: $premia")
    println(s"kompns: $kompns")
    val rez = 0.01 * math.floor(100 * (dokhod.toDouble * (100+premia.toDouble)/100 + kompns.toDouble ) / 12 )
    println(s"Ежемесячный оклад сотрудника: $dokhod * (100+$premia)/100 + $kompns: " + rez + " руб.")

  }

  def zadanie3c(): Unit = {
    println(
      """
        *************************************************
        3c. Напишите программу, которая рассчитывает для каждого сотрудника
        отклонение(в процентах) от среднего значения оклада на уровень всего отдела.
        В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
        На вход вышей программе подаются все значения, аналогичные предыдущей программе,
        а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
        """)
    val Oklads = List[Double](100, 150, 200, 80, 120, 75)
    //
    val Premia = StdIn.readLine("Введи размер премии – в процентах от годового дохода: ").toDouble / 100.0
    val Kompns = StdIn.readLine("Введи значение компенсации питания: ").toDouble

    val Dokhods = Oklads.map(x => 0.01 * math.floor(100 * (x.toDouble * (100+Premia.toDouble)/100 + Kompns.toDouble ) / 12 )  )
    // подаются все значения, аналогичные предыдущей программе

    println("Результат: " + Dokhods)

  }
}