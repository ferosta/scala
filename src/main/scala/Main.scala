object Main {

  def zadanie01(): Unit = println("""
      i.   выводит фразу «Hello, Scala!» справа налево
      ii.  переводит всю фразу в нижний регистр
      iii. удаляет символ!
      iv.  добавляет в конец фразы «and goodbye python!»
      """)

  def main(args: Array[String]): Unit = {
    zadanie01()
    
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
}