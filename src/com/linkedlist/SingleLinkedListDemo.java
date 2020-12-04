package com.linkedlist;

import java.util.Currency;
import java.util.Stack;

//定义一个HeroNode  每个HeroNode 对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public int damage;
    public HeroNode next;

    public HeroNode(int no, String name, int damage) {
        this.no = no;
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                '}';
    }
}

//定义SingleLinkedList  管理英雄
class SingleLinkedList {
    //初始化头节点  不使用
    private HeroNode head = new HeroNode(0, "", 0);

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        //由于head节点不使用  因此创建一个辅助指针temp
        HeroNode temp = head;

        //遍历链表 找最后节点
        while (true) {
            //找到最后节点
            if (temp.next == null) {
                break;
            }
            //没找到，指针下移
            temp = temp.next;
        }
        //while循环退出 temp已经指向链表最后节点
        //于是后移最后节点的指针  指向新的节点
        temp.next = heroNode;
    }

    //第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    //(如果有这个排名，则添加失败，并给出提示)
    public void addByOrder(HeroNode heroNode) {
        //由于head节点不使用  因此创建一个辅助指针temp
        //因为单链表，因为我们找的temp 是位于 添加位置 的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; //flag 标志添加的编号是否存在，默认为false

        while (true) {
            if (temp.next == null) {
                break;
            }
            //位置找到，就在temp的后面插入
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {  //希望添加的heroNode的编号已存在
                flag = true;
                break;
            }
            temp = temp.next;

        }

        //判断flag值
        if (flag) {
            //不能添加，编号已存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            //插入到链表中, temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    //修改节点信息(根据no编号修改)
    //1. 根据 newHeroNode 的 no 来修改
    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表空");
            return;
        }

        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false; //表示是否找到该节点
        while (true) {
            if (temp == null) {
                break; //已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }

        //根据flag 判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.damage = newHeroNode.damage;
        } else {
            System.out.printf("没有找到 编号 %d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    //删除节点
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }

    //显示链表
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不使用 辅助指针temp
        HeroNode temp = head.next;
        while (true) {
            //是否为链表最后节点
            if (temp == null) {
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //后移temp
            temp = temp.next;
        }
    }
}

public class SingleLinkedListDemo {
    public static void main(String[] args) {

        //创建节点
        HeroNode hanzo = new HeroNode(1, "Hanzo", 250);
        HeroNode genji = new HeroNode(2, "Genji", 30);
        HeroNode macree = new HeroNode(3, "macree", 140);
        HeroNode dva = new HeroNode(4, "D.va", 40);

        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入(方案一)
//        singleLinkedList.add(macree);
//        singleLinkedList.add(genji);
//        singleLinkedList.add(hanzo);
//        singleLinkedList.add(dva);

        //加入(方案二)
        singleLinkedList.addByOrder(macree);
        singleLinkedList.addByOrder(genji);
        singleLinkedList.addByOrder(hanzo);
        singleLinkedList.addByOrder(genji);  //重复加入
        singleLinkedList.addByOrder(dva);

        //显示
        singleLinkedList.list();

        //修改节点
        HeroNode newHeroNode = new HeroNode(3, "mercy", 20);
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表~~~~~~~~~~~~");

        //显示
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.delete(1);
        singleLinkedList.delete(4);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();

        //单链表节点个数
        System.out.println("目前有效的节点个数: " + getLength(singleLinkedList.getHead()));

        //倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println("res=" + res);

        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        System.out.println("反转单链表~~");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();

        System.out.println("测试逆序打印单链表, 没有改变链表的结构~~");
        reversePrint(singleLinkedList.getHead());
    }

    //可以利用栈这个数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;

        //遍历压入栈
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }

        //打印
        while (heroNodes.size() > 0) {
            System.out.println(heroNodes.pop());
        }
    }

    //将单链表反转
    public static void reverseList(HeroNode head) {
        if (head.next == null || getLength(head) == 1) {
            return;
        }
        HeroNode temp = head.next;
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0, "", 0);
        for (int i = 0; i <= getLength(head); i++) {
            if (temp == null) {
                break;
            }
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        //将head.next 指向 reverseHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第k个节点
    //1. 编写一个方法，接收head节点，同时接收一个index（index 表示是倒数第index个节点）
    //2. 先把链表从头到尾遍历，得到链表的总的长度 getLength
    //3. 得到size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
    //4. 如果找到了，则返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        //判断如果链表为空，返回null
        if (head.next == null) {
            return null;
        }
        //第一个遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历  size-index 位置，就是我们倒数的第K个节点
        //先做一个index的校验
        if (index <= 0 || index >= size) {
            return null;
        }
        //定义给辅助变量， for 循环定位到倒数的index
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    //方法: 获取到单链表的节点的个数

    /**
     * @param head 链表头节点
     * @return 返回有效结点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
