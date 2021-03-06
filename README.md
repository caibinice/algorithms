# algorithms
some algorithm demo and exercise based on JAVA  
一些算法基础的练习和查缺补漏(主要使用JAVA实现)  
## 1.二叉树
### a.基本概念
*树(tree)*  
定义：树t是一个非空的有限元素的集合，其中一个元素为根，余下的元素组成t的子树。  
在画一棵树时，每个元素都代表一个节点。树根在上面，其子树画在下面。  

*二叉树(binary tree)*  
定义：二叉树t是有限个元素的集合（可以为空）。当二叉树非空时，其中有一个称为根的元素，余下的元素（如果有的话）被组成2个二叉树，分别称为t的左子树和右子树。  
二叉树和树的根本区别是：  
二叉树可以为空，树不能为空；
二叉树中每个元素都恰好有两棵子树（其中一个或两个可能为空），而树中每个元素可以有若干子树；
在二叉树中每个元素的子树都是有序的，也就是说，可以用左、右子树来区别，而树的子树间是无序的。  
  
*二叉查找树(binary search tree)*  
二叉查找树（英语：Binary Search Tree），也称为二叉搜索树、有序二叉树(ordered binary tree)或排序二叉树（sorted binary tree），是指一棵空树或者具有下列性质的二叉树：
* 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
* 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
* 任意节点的左、右子树也分别为二叉查找树；
* 没有键值相等的节点。
* 二叉查找树相比于其他数据结构的优势在于查找、插入的时间复杂度较低。为 O(log n)。
* 二叉查找树是基础性数据结构，用于构建更为抽象的数据结构，如集合、multiset、关联数组等。  

本章实现了二叉查找树的前序、中序、后序遍历，插入、删除、搜索、寻找最大/最小节点，以及打印和销毁。  
## 2.使用枚举型构造单例模式  

在所有的单例实现方式中，枚举是一种在代码写法上最简单的方式，之所以代码十分简洁，是因为Java给我们提供了enum关键字，我们便可以很方便的声明一个枚举类型，而不需要关心其初始化过程中的线程安全问题，因为枚举类在被虚拟机加载的时候会保证线程安全的被初始化。  
很多人会对枚举法实现的单例模式很不理解。这里需要深入理解的是两个点：  
枚举类实现其实省略了private类型的构造函数。  
枚举类的域(field)其实是相应的enum类型的一个实例对象  

## 3.一些leetcode练习题
两个非空链表相加：AddTwoListNodeNumber.java  
判断回文数;翻转整数：ReverseNumber.java  
删除数组重复元素：DeleteRepeatInArray.java  
找出数组中的和：FindSum.java  
罗马数字转整数;整数转罗马数字：RomanToInt.java  
字符串数组中的最长公共前缀：LongestCommonPrefix.java  
不含重复字符的最长子串长度:LongestCommonSubstr.java  
合并两个有序链表：MergeTwoSortedListNode.java  
二进制中数字1的最长间距：BinaryGap.java  
实现C语言strStr()函数:MyStrStr.java  
盛最多水的容器:MaxArea.java  

后续习题只区分和增加题目类型，不再列举java解答
  
## 4.栈(Stack)
### a.基本概念
实现了Minimum Stack，存储了最小值的栈  



