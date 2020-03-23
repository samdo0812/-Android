package com.example.myapplication.Kotlin

//01. variable -> 변수
//상자

//변수 선언하는 방법
//var / val 변수 = 값
//variable 내 마음대로 넣을 수 있는 상자
//value 한번 넣으면 바꿀 수 없는 상자

var num = 10
var hello = "hello"
var point = 3.4

var fix = 20


fun main(args:Array<String>){
    println(num)
    println(hello)
    println(point)
    println(fix)

    num = 100
    hello = "Good Bye "
    point = 10.4

    println(num)
    println(hello)
    println(point)
    println(fix)

    fix = 500

}