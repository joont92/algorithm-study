package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
// https://leetcode.com/problems/merge-two-sorted-lists/
class MergedTwoSortedList {
    fun mergeTwoLists(p_list1: ListNode?, p_list2: ListNode?): ListNode? {
        when {
            p_list1 == null && p_list2 == null -> return null
            p_list1 == null -> return p_list2
            p_list2 == null -> return p_list1
        }

        var list1 = p_list1
        var list2 = p_list2

        val result: ListNode
        if (list1!!.`val` < list2!!.`val`) {
            result = ListNode(list1.`val`)
            list1 = list1.next
        } else {
            result = ListNode(list2.`val`)
            list2 = list2.next
        }

        var temp = result
        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                temp.next = ListNode(list1.`val`)
                list1 = list1.next
            } else {
                temp.next = ListNode(list2.`val`)
                list2 = list2.next
            }
            temp = temp.next!!
        }

        if (list1 == null) {
            while (list2 != null) {
                temp.next = ListNode(list2.`val`)
                list2 = list2.next
                temp = temp.next!!
            }
        } else {
            while (list1 != null) {
                temp.next = ListNode(list1.`val`)
                list1 = list1.next
                temp = temp.next!!
            }
        }

        return result
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val fn = MergedTwoSortedList()
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(1, 2, 4), listNodeBuilder(1, 3, 4)))
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(), listNodeBuilder()))
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(1, 2, 3), listNodeBuilder()))
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(), listNodeBuilder(2, 3, 4)))
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(1, 1, 1), listNodeBuilder(1, 1, 1)))
    listNodeToString(fn.mergeTwoLists(listNodeBuilder(-10, -5, 0), listNodeBuilder(-30, -10, 5)))
}

fun listNodeBuilder(vararg numbers: Int): ListNode? {
    if (numbers.isEmpty()) return null

    val result = ListNode(numbers[0])
    var temp = result
    for (i in 1 until numbers.size) {
        temp.next = ListNode(numbers[i])
        temp = temp.next!!
    }

    return result
}

fun listNodeToString(p_listNode: ListNode?) {
    var listNode = p_listNode

    while (listNode != null) {
        print(listNode.`val`.toString())
        listNode = listNode.next
    }
    println()
}