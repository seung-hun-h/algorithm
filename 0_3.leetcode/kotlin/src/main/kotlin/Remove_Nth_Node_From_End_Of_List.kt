class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val start = ListNode(0)
    var slow: ListNode? = start
    var fast: ListNode? = start
    start.next = head

    for (i in 0..n) {
        fast = fast?.next
    }

    while (fast != null) {
        fast = fast.next
        slow = slow?.next
    }

    slow?.next = slow?.next?.next

    return start.next
}
