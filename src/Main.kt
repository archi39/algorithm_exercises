import java.util.*

/**
 * Точка входа в приложение
 *
 * @author EY.Samarin
 */

fun main() {
    //Запускаем
    //val grokaemAlgoritmi = GrokaemAlgoritmi()

    //showConsoleInput()
}

/**
 * Тестирование консольного ввода через класс сканер
 */
fun showConsoleInput() {
    val input = Scanner(System.`in`)
    System.out.print("Введите число: ")
    val x = input.nextInt()
    System.out.print("Введите второе число: ")
    val y = input.nextInt()
    System.out.println("X+Y=${x+y}")
    input.close()
}

