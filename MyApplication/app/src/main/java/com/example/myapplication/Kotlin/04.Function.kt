package com.example.myapplication.Kotlin

//04. function
//선언
// fun 함수명 (변수명: 타입, 변수명: 타입 ) : 반환형 타입{
//      함수내용
//  return 반환값
//}

fun plus(first: Int, second: Int): Int {
    val result: Int = first + second
    return result
}

//default 값을 갖는 함
fun plusFive(first: Int, second: Int = 5): Int {
    val result: Int = first + second
    return result
}

//반환값이 없는 함수, Unit 생략가
fun printPlus(first: Int, second: Int): Unit {
    val result: Int = first + second
    println(result)
}

fun printPlusTwo(first: Int, second: Int) {
    val result: Int = first + second
    println(result)
}

//간단하게 함수선언
fun printShort(first: Int, second: Int) = first + second

//가변인자 함수
fun plusMany(vararg numbers: Int){
    for(number in numbers){
        println(number)
    }
}

fun main(array: Array<String>) {
    val result = plus(5, 10)
    println(result)

    //인수를 명시적으로 전달
    val result2 = plus(first = 10, second = 20)
    println(result2)
    val result3 = plus(second = 20, first = 10)
    println(result3)

    println()
    val result4 = plusFive(10, 20)
    println(result4)
    val result5 = plusFive(10)
    println(result5)

    println()
    printPlus(10, 20)

    val result6 = printShort(50, 50)
    println(result6)

    println()
    plusMany(1,2,3)
    plusMany(100)
}