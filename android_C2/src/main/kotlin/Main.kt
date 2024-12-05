fun main() {
    print("Please enter first number: ")
    val num1 = readLine()!!.toInt()
    print("please enter operation: + , - , / , * ")
    val operation = readLine()!!
    print("Please enter second number: ")
    val num2 = readLine()!!.toInt()

    val result = when (operation) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "/" -> num1 / num2
        "*"-> num1 * num2
        else -> "N/A"
    }
    print(result)

}