//
// Created by sxj on 2019/10/4.
//
#include <stdlib.h>
#include <stdio.h>
jstring Java_com.example.mybaseapp_HomeFragment_getHello(JNIEnv *env, jobject thiz){
return (*env)-> NewStringUTF(env,"hello world from c");
}