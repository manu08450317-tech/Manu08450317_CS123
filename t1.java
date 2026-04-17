Q1. Write a Java Program for Checking if a given string is null or contains only whitespace
using user defined function isNullOrEmpty().
public class StringBuildingFunctions {
// 1. Function to check if a string is empty or null
public static boolean isNullOrEmpty(String str) {
return str == null || str.trim().isEmpty();
}
