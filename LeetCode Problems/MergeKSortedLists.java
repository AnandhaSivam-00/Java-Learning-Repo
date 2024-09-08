// You are presented with K sorted linked lists, each comprising N elements. 
// Your assignment is to develop an algorithm capable of merging all these 
// linked lists while preserving their sorted order. 
// Devise a solution that efficiently handles the merging of K 
// sorted linked lists, showcasing your ability to maintain the overall 
// sorted order in the merged linked list. Additionally, provide a 
// well-documented example illustrating the input and output of your algorithm.

// Example:
Input: K = 3, N =  4
list1 = 1->3->5->7->NULL
list2 = 2->4->6->8->NULL
list3 = 0->9->10->11->NULL
Output: 0->1->2->3->4->5->6->7->8->9->10->11

Merged lists in a sorted order where every element is greater than the previous element.

Input: K = 3, N =  3

list1 = 1->3->7->NULL
list2 = 2->4->8->NULL
list3 = 9->10->11->NULL
Output: 1->2->3->4->7->8->9->10->11

Merged lists in a sorted order where every element is greater than the previous element.


  import java.util.*;