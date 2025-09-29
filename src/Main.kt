fun main() {
    println("=== КОНВЕРТЕР В ДВОИЧНУЮ СИСТЕМУ ===")

    println("Введите натуральное число:")
    val input = readLine()

    if (input.isNullOrEmpty()) {
        println("Ошибка: Вы не ввели число")
        return
    }

    val number = input.toIntOrNull()

    if (number == null) {
        println("Ошибка: '$input' не является числом")
        return
    }

    if (number < 0) {
        println("Ошибка: Введите натуральное число (больше или равно 0)")
        return
    }

    val binaryResult = convertToBinary(number)

    println("\nРезультат преобразования:")
    println("Десятичное: $number")
    println("Двоичное:  $binaryResult")

    val systemCheck = Integer.toBinaryString(number)
    println("Проверка:   $systemCheck (встроенная функция)")
}


fun convertToBinary(number: Int): String {
    if (number == 0) {
        return "0"
    }

    var currentNumber = number
    val binaryDigits = StringBuilder()

    while (currentNumber > 0) {
        val remainder = currentNumber % 2
        binaryDigits.append(remainder)
        currentNumber /= 2
    }

    return binaryDigits.reverse().toString()
}

fun convertToBinaryWithSteps(number: Int): String {
    println("\n--- ПРОЦЕСС ПРЕОБРАЗОВАНИЯ ---")

    if (number == 0) {
        println("0 ÷ 2 = 0, остаток 0")
        return "0"
    }

    var currentNumber = number
    val steps = StringBuilder()
    val binaryDigits = StringBuilder()

    while (currentNumber > 0) {
        val remainder = currentNumber % 2
        val division = currentNumber / 2

        steps.append("$currentNumber ÷ 2 = $division, остаток $remainder\n")
        binaryDigits.append(remainder)

        currentNumber = division
    }

    println(steps.toString())
    val result = binaryDigits.reverse().toString()
    println("Цифры в обратном порядке: ${binaryDigits.toString()}")
    println("Перевернутый результат: $result")

    return result
}