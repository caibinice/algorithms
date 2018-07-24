# algorithms
some algorithm demo and exercise  
一些算法基础的练习和查缺补漏  
## 1.二叉树的实现-遍历-求深度-堆排序
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


