object Main {
  def main(args: Array[String]): Unit = {
    zadanie3a();
    zadanie3b();
    zadanie3c();
  }

  def zadanie3a(): Unit = {
    println(
      """
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
      """b.     Напишите программу, которая вычисляет ежемесячный оклад сотрудника
        после вычета налогов. На вход вашей программе подается значение годового
        дохода до вычета налогов, размер премии – в процентах от годового дохода
        и компенсация питания.""")

  }

  def zadanie3c(): Unit = {
    val Lst = List[Double](100.2,20.4,30.1,50.4,47.5)

    println(Lst.sum / Lst.length)

  }
}