package com.example.myapplication.Kotlin

//04. function
//선언
// fun 함수명 (변수명: 타입, 변수명: 타입 ) : 반환형 타입{
//      함수내용
//  return 반환값
//}

fun plus(first: Int, second: Int): Int{
    val result: Int = first + second
    return result
}

fun main(array: Array<String>){
    val result = plus(5,10)
    println(result)

    //인수를 명시적으로 전달
    val result2 = plus(first = 10, second = 20)
    println(result2)
    val result3 = plus(second = 20, first = 10)
    println(result3)

    
}