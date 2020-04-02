# The Double Linked List Data Structure

In computer science, a doubly linked list is a linked data structure that consists of a set of sequentially linked 
records called nodes. Each node contains three fields: two link fields (references to the previous and to the next node 
in the sequence of nodes) and one data field. The beginning and ending nodes' previous and next links, respectively, 
point to some kind of terminator, typically a sentinel node or null, to facilitate traversal of the list. 
If there is only one sentinel node, then the list is circularly linked via the sentinel node. It can be conceptualized 
as two singly linked lists formed from the same data items, but in opposite sequential orders.

## Characteristics

- Each item in the list has next and previous fields
- The list has a head and a tail

## Operation and time complexity

Insert at head, Insert at tail, Delete from head, Delete from tail: O(1)
Insert between nodes, Remove between nodes: O(1) time complexity, but have to find a node first, so it's actually O(n)