package com.linkedlist;

//定义一个HeroNode2  每个HeroNode 对象就是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public int damage;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, int damage) {
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

class DoubleLinkedList {

    private final HeroNode2 head = new HeroNode2(0, "", 0);

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历
    public void list() {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //头节点不使用 辅助指针temp
        HeroNode2 temp = head.next;
        while (temp != null) {
            //是否为链表最后节点
            //输出节点信息
            System.out.println(temp);
            //后移temp
            temp = temp.next;
        }
    }

    // 添加到最后
    public void add(HeroNode2 heroNode) {
        //由于head节点不使用  因此创建一个辅助指针temp
        HeroNode2 temp = head;

        //遍历链表 找最后节点
        while (temp.next != null) {
            //找到最后节点
            //没找到，指针下移
            temp = temp.next;
        }
        //while循环退出 temp已经指向链表最后节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void addByOrder(HeroNode2 heroNode) {
        //由于head节点不使用  因此创建一个辅助指针temp
        //因为单链表，因为我们找的temp 是位于 添加位置 的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            if (temp.next != null)
                temp.next.pre = heroNode;

            temp.next = heroNode;
            heroNode.pre = temp;

        }

    }

    // 修改
    public void update(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表空");
            return;
        }

        //找到需要修改的节点
        HeroNode2 temp = head.next;
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

    // 删除
    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表空 无法删除");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;

            if (temp.next != null)
                temp.next.pre = temp.pre;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
        }
    }


}


public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("测试双向链表");

        HeroNode2 hanzo = new HeroNode2(1, "Hanzo", 250);
        HeroNode2 genji = new HeroNode2(2, "Genji", 30);
        HeroNode2 macree = new HeroNode2(3, "macree", 140);
        HeroNode2 dva = new HeroNode2(4, "D.va", 40);

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.addByOrder(dva);
        doubleLinkedList.addByOrder(hanzo);
        doubleLinkedList.addByOrder(macree);
        doubleLinkedList.addByOrder(genji);
        // 遍历(显示)
        doubleLinkedList.list();

        System.out.println("=============================================================");

        // 修改
        HeroNode2 mercy = new HeroNode2(2, "mercy", 25);
        doubleLinkedList.update(mercy);
        // 显示
        System.out.println("修改后的链表情况");
        doubleLinkedList.list();

        System.out.println("=============================================================");

        // 删除
        doubleLinkedList.delete(4);
        System.out.println("删除后的链表情况");
        // 显示
        doubleLinkedList.list();

    }
}
