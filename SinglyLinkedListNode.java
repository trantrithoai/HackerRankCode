static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    // Create a dummy node to act as the starting point of the merged list
    SinglyLinkedListNode dummyNode = new SinglyLinkedListNode(0);
    // 'current' points to the last node in the merged list
    SinglyLinkedListNode current = dummyNode;

    // Traverse both lists until we reach the end of one of them
    while (head1 != null && head2 != null) {
        if (head1.data <= head2.data) {
            current.next = head1;
            head1 = head1.next;
        } else {
            current.next = head2;
            head2 = head2.next;
        }
        current = current.next;
    }

    // Attach the remaining part of the list which is not null
    if (head1 != null) {
        current.next = head1;
    } else {
        current.next = head2;
    }

    // Return the merged list, starting from the next node of the dummy node
    return dummyNode.next;
}
