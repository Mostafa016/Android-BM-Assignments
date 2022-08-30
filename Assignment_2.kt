// Question #1
fun getFirstItemStartingWithMContainingR(items: List<String>): String? =
     items.firstOrNull { item: String -> item[0] == 'M' && item.contains('r') }

// Question #2
fun getOnlyItemStartingWithMContainingR(items: List<String>) : String? =
     items.singleOrNull { it.first() == 'M' && it.contains('r') }


// Question #3
fun doesOneElementHaveLengthGECount(items: List<String>, count: Int): Boolean =
     items.any { it.length >= count }


// Question #4
fun doElementsHaveLengthGECount(items: List<String>, count: Int): Boolean =
    items.all { it.length >= count  }


// Question #5
fun getItemsBeforeItemStartingWithMContainingA(items: List<String>): List<String> =
     items.takeWhile { !(it[0] == 'M' && it.contains('a')) }


// Question #6
fun getItemsStartingFromItemWithLengthEqualCount(items: List<String>, count: Int): List<String> =
     items.dropWhile { it.length != count }

// Question #7
fun getItemLengths(items: List<String>): List<Int> =
    items.map { it.length }

fun main() {
    var items: List<String>
    // Question #1
    println("Question #1:")
    items = listOf("Maze", "Mr.", "More")
    println(getFirstItemStartingWithMContainingR(items))
    // Question #2
    println("Question #2:")
    items = listOf("Mr.", "Maze")
    println(getOnlyItemStartingWithMContainingR(items))
    items = listOf("Mr.", "More")
    println(getOnlyItemStartingWithMContainingR(items))
    // Question #3
    println("Question #3:")
    items = listOf("a", "abc")
    println(doesOneElementHaveLengthGECount(items, count = 3))
    // Question #4
    println("Question #4:")
    items = listOf("a", "abc")
    println(doElementsHaveLengthGECount(items, count = 3))
    // Question #5
    println("Question #5:")
    items = listOf("a", "Ma", "M")
    println(getItemsBeforeItemStartingWithMContainingA(items))
    // Question #6
    println("Question #6:")
    items = listOf("a", "abc", "ab")
    println(getItemsStartingFromItemWithLengthEqualCount(items, count = 3))
    // Question #7
    println("Question #7:")
    items = listOf("a", "abc", "ab")
    println(getItemLengths(items))
}