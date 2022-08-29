// Question #1
fun getFirstItemStartingWithMContainingR(items: List<String>): String? {
    return items.firstOrNull { item: String -> item[0] == 'M' && item.contains('r') }
}

// Question #2
fun getOnlyItemStartingWithMContainingR(items: List<String>) : String?{
    var count = 0
    var firstOccurrenceIndex = -1
    for (index in items.indices){
        val item = items[index]
        if(item.first() == 'M' && item.contains('r')) {
            count++
            if(count == 1) firstOccurrenceIndex = index
        }
    }
    return if(count == 1) items[firstOccurrenceIndex] else null
}

// Question #3
fun doesOneElementHaveLengthGECount(items: List<String>, count: Int): Boolean {
    val index = items.indexOfFirst { item: String -> item.length >= count }
    return index != -1
}

// Question #4
fun doElementsHaveLengthGECount(items: List<String>, count: Int): Boolean {
    for (item in items) {
        if (item.length < count) return false
    }
    return true
}

// Question #5
fun getItemsBeforeItemStartingWithMContainingA(items: List<String>): List<String> {
    val index = items.indexOfFirst { item: String -> item[0] == 'M' && item.contains('a') }
    return if (index == -1) emptyList() else items.slice(IntRange(0, index - 1))
}

// Question #6
fun getItemsStartingFromItemWithLengthEqualCount(items: List<String>, count: Int): List<String> {
    val index = items.indexOfFirst { item: String -> item.length == count }
    return if (index == -1) emptyList() else items.slice(IntRange(index, items.lastIndex))
}

// Question #7
fun getItemLengths(items: List<String>): List<Int> =
    List(items.size, init = { index: Int -> items[index].length })

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