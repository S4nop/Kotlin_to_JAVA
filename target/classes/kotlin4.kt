package kot.hi;

import kotlin.ranges.*;
import kotlin.ran.*;

fun main() {
    val items = listOf("apple", "banana", "kiwifruit")
for (index in items.indices) {
    println("item at $index is ${items[index]}")
}
}