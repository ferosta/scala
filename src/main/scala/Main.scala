import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
//    Task_3a();
//    Task_3b();
//    Task_3c(true, true)
//    Task_3d()
//    Task_3e()
//    Task_3f()
    Task_3g()

  }

  def Task_3a(): Unit = {
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
    print("i1\t: ")
    for(i <- (Str.length-1) to 0 by -1 ) print(Str(i))
    println()
    println("i2\t: " +  (for (i <- (Str.length - 1) to 0 by -1) yield Str(i)).mkString )
    println("i3\t: " + Str.reverse)
    println("ii\t: "+ Str.toLowerCase)
    println("iii\t: "+ Str.replaceFirst("!", "") )
    println("iv\t: "+ Str.concat(" Прости, Питон :("))
  }

  def Do_Monthly_Income(Salary: Double, Prize :Double, Food_Compensation :Double) =
    ((Salary * (100+Prize)/100 + Food_Compensation ) / 12 *100).toInt*0.01


  def Task_3b() = {
    println(
      """
        *************************************************
        b. Напишите программу, которая вычисляет ежемесячный оклад сотрудника
        после вычета налогов. На вход вашей программе подается
        - значение годового дохода до вычета налогов,
        - размер премии – в процентах от годового дохода и
        - компенсация питания.""")
    val Salary :Double = StdIn.readLine("Введи значение годового дохода до вычета налогов: " ).toDouble
    val Prize :Double = StdIn.readLine("Введи размер премии – в процентах от годового дохода: " ).toDouble
    val Food_Compensation :Double = StdIn.readLine("Введи значение компенсации питания: " ).toDouble

    println(s"Оклад: $Salary")
    println(s"Премия: $Prize")
    println(s"Компенсация питания: $Food_Compensation")
//    val Monthly_Income = ((Salary * (100+Prize)/100 + Food_Compensation ) / 12 *100).toInt*0.01
    val Monthly_Income = Do_Monthly_Income (Salary, Prize, Food_Compensation)
    println(s"Ежемесячный доход сотрудника: $Salary * (100+$Prize)/100 + $Food_Compensation: " + Monthly_Income + " руб.")
  }


  def Task_3c(Read_Data_From_Keyboard: Boolean = true, Print_Task_Text : Boolean = true): List[Double] = {
    if (Print_Task_Text)  println("""
        *************************************************
        3c. Напишите программу, которая рассчитывает для каждого сотрудника
        отклонение(в процентах) от среднего значения оклада на уровень всего отдела.
        В итоговом значении должно учитываться в большую или меньшую сторону отклоняется размер оклада.
        На вход вышей программе подаются все значения, аналогичные предыдущей программе,
        а также список со значениями окладов сотрудников отдела 100, 150, 200, 80, 120, 75.
        """)
    // исходные значения окладов в отделе
    val Salaries = List[Double](100, 150, 200, 80, 120, 75)
    println( Salaries +  "\t- Оклады сотрудников.")

    // ввод значений надбавки и компенсации
    val Prize = if (!Read_Data_From_Keyboard) 10 else StdIn.readLine("Введи размер премии – в процентах от годового дохода: ").toDouble / 100.0
    val Food_Compensation = if (!Read_Data_From_Keyboard) 5 else  StdIn.readLine("Введи значение компенсации питания: ").toDouble

//    val Prize = StdIn.readLine("Введи размер премии – в процентах от годового дохода: ").toDouble / 100.0
//    val Food_Compensation = StdIn.readLine("Введи значение компенсации питания: ").toDouble
    // окладды с начислениями - ежемесячно
//    val Monthly_Incomes = Salaries.map(x => (x * (100+Prize)/100 + Food_Compensation) / 12  ).map(x => (100*x).toInt*0.01)
    val Monthly_Incomes = Salaries.map(x => Do_Monthly_Income(x, Prize, Food_Compensation))
    println( Monthly_Incomes + "\t- Ежемесячные оклады с начисленяими." )

    // средний оклад по отделу
    val Average_Income = ( Monthly_Incomes.sum / Monthly_Incomes.length *100).toInt*0.01
    println("Средний оклад по отделу: " + Average_Income)

    //отклонение от среднего
    val Average_Incomes = Monthly_Incomes.map(x => -100 + 100.0* x/Average_Income ).map(x => (100.0*x).toInt*0.01 )
    println( Average_Incomes + "\t- % отклонение от среднего." )

    Monthly_Incomes
  }

  def Task_3d():Unit={
    println(
      """
        *************************************************
        d. Попробуйте рассчитать новую зарплату сотрудника, добавив(или отняв, если сотрудник плохо себя вел)
        необходимую сумму с учетом результатов прошлого задания.
        Добавьте его зарплату в список и вычислите значение самой высокой зарплаты и самой низкой.
        """)
    // список доходов сотрудников из предыдущего задания
    val Monthly_Incomes = Task_3c(Read_Data_From_Keyboard = false, Print_Task_Text = false)
    //номер сотрудника в списке  сотрудника

    val Employee_Number = 1
    //новое значение зарплаты работника
    val New_Employee_Income :Double = 5.59
    // значения берутся из предыдущего задания
    // println( Monthly_Incomes +  "\t- исходные ежемесячные оклады сотрудников.")

    println( s"У работника #$Employee_Number меняем доход на значение $New_Employee_Income")
    // новый список с доходами: заменяем элемент в позиции N значением S один раз
    val New_Monthly_Incomes = Monthly_Incomes.patch(Employee_Number, Seq(New_Employee_Income), 1).map(x => (x*100).toInt*0.01)
    println( New_Monthly_Incomes +  "\t- обновленнй список ежемесячных доходов сотрудников.")

//    // минимальный и максимальный элемент в новом списке
    val Max_Monthly_Income = New_Monthly_Incomes.reduceLeft(_ max _)
    val Min_Monthly_Income = New_Monthly_Incomes.reduceLeft(_ min _)

    println(s"Самая высокая зарплата: $Max_Monthly_Income")
    println(s"Самая низкая зарплата: $Min_Monthly_Income")


  }

  def Task_3e(Print_Task_Text : Boolean = true) = {
    if (Print_Task_Text) println(
      """
        *************************************************
        e. Также в вашу команду пришли два специалиста с окладами 350 и 90 тысяч рублей.
        Попробуйте отсортировать список сотрудников по уровню оклада от меньшего к большему.
      """)
    // исходные значения окладов в отделе
    val Salaries = List[Double](100, 150, 200, 80, 120, 75)
    println(Salaries + "\t- исходный списко окладов сотрудников.")

    // новые сотрудники в отделе
    val New_Employers_Salaries = List[Double](350, 90)

    // добавить новых сотрудников в общий список
    val New_Salaries_List = Salaries.patch(Salaries.size, New_Employers_Salaries,0)
    println(New_Salaries_List + "- обновленный список окладов")

    // cортировка списка от меньшего к обольшему
    val New_Salaries_List_Sorted = New_Salaries_List.sorted(Ordering[Double])
    println(New_Salaries_List_Sorted + "- отсортированный список")

    New_Salaries_List_Sorted
  }

  def Task_3f(Print_Task_Text : Boolean = true) = {
    if (Print_Task_Text) println(
      """
        *************************************************
        f. Кажется, вы взяли в вашу команду еще одного сотрудника и предложили ему оклад 130 тысяч.
        Вычислите самостоятельно номер сотрудника в списке так,
        чтобы сортировка не нарушилась и добавьте его на это место.
      """)
    //исходные данные
    val Salaries_List_Sorted = Task_3e(false)
    // новые сотрудники в отделе
    val New_Employer_Salary: Double = 130

    //индекс первого элемента списка, который больше вставляемого элемента
    val Index_To_Insert = Salaries_List_Sorted.indexWhere(x => x > New_Employer_Salary)

    val New_Salaries_List_Sorted = Salaries_List_Sorted.patch(Index_To_Insert,List(New_Employer_Salary), 0)

    println(New_Salaries_List_Sorted + "- список с новым элементом по-прежнему отсортирован")

    New_Salaries_List_Sorted
  }

  def Task_3g() = {
    println(
      """
        *************************************************
        g. Попробуйте вывести номера сотрудников из полученного списка, которые попадают под категорию middle.
         На входе программе подается «вилка» зарплаты специалистов уровня middle.
      """)
    //исходные данные
    val Salaries_List_Sorted = Task_3f(false)
    println(Salaries_List_Sorted + " - Исходный список зарплат")

    // вилка зарплат сотрудников
    val Middle_Min_Salary: Double = 100
    val Middle_Max_Salary: Double = 150
    println(s"Ищем индексы в списке для сотрудников с зарплатами от $Middle_Min_Salary до $Middle_Max_Salary")

    val Middle_Indeces = Salaries_List_Sorted.indexWhere(x => (Middle_Min_Salary <= x) && (x <= Middle_Max_Salary))
    println(Middle_Indeces + "- индексы искомых сотрудников")

    val Middle_Indecies1 = Salaries_List_Sorted.zipWithIndex.collect{ case(elm,indx) if ((Middle_Min_Salary <= elm) && (elm <= Middle_Max_Salary)) => indx }
    println(Middle_Indecies1 + "- индексы искомых сотрудников")

  }


}