package main

import (
	"fmt"
	"strconv"
)

// superDigit calculates the super digit of the given string n repeated k times
func superDigit(n string, k int32) int32 {
	// Calculate the initial sum of the digits in the string n
	var initialSum int64 = 0
	for _, digit := range n {
		initialSum += int64(digit - '0')
	}

	// Multiply the initial sum by k to get the total sum
	totalSum := initialSum * int64(k)

	// Reduce the total sum to a single digit
	return reduceToSingleDigit(totalSum)
}

// reduceToSingleDigit repeatedly sums the digits of a number until a single digit is obtained
func reduceToSingleDigit(num int64) int32 {
	for num >= 10 {
		num = digitSum(num)
	}
	return int32(num)
}

// digitSum calculates the sum of the digits of a number
func digitSum(num int64) int64 {
	var sum int64 = 0
	for num > 0 {
		sum += num % 10
		num /= 10
	}
	return sum
}

func main() {
	fmt.Println(superDigit("148", 3)) // Output: 3
	fmt.Println(superDigit("9875", 4)) // Output: 8
	fmt.Println(superDigit("123", 3)) // Output: 9
}
