package com.example.myapplication.Kotlin

fun main(array: Array<String>) {
    //first()
    //second(90)
    //third(15)
    //gugudan()
}


// 1번 문제
// List를 두개 만든다
// 첫번째 List에는 0 부터 9까지 값을 넣는다 (반복문 사용)
// 두번째 List에는 첫번째 List의 값을 하나씩 확인한후
// 짝수면 True 홀수면 False를 넣어 준다

fun first() {
    val list1 = MutableList(9, { 0 })
    val list2 = MutableList(9, { true })
    for (i in 0..8) {
        list1[i] = i + 1
    }
    println(list1)
    list1.forEachIndexed { index, value ->
        if (value % 2 == 0) list2[index] = true // 짝수
        else list2[index] = false // 홀수
    }
    println(list2)
}


// 2번 문제
// 학점을 구하자
// 80 - 90 -> A
// 70 - 79 -> B
// 60 - 69 -> C
// 나머지 F

fun second(score: Int): String {
    var result: String = "F"
    when (score) {
        in 90..100 -> {
            result = "A"
        }
        in 80..89 -> {
            result = "B"
        }
        in 80..100 -> {
            result = "C"
        }
        else -> {
            result = "F"
        }
    }
    return result
}


// 3번 문제
// 전달 받은 숫자의 각 자리 숫의 합을 구하자
// 조건 : 전달 받은 숫자는 무조건 두자리 숫자이다

fun third(number: Int): Int {
    //89 -> 8 + 9
    val a: Int = number / 10
    val b: Int = number % 10

    return a + b
}

// 4번 문제
// 구구단을 출력하자

fun gugudan(){
    for (x in 1..9){
        for (y in 1..9){
            println("$x x $y = ${x * y}")
        }
    }
}