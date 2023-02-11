package jianzhioffer;

import it_Base.IListNode;

import java.util.HashMap;
import java.util.Map;

public class it_35_复杂链表的复制 {

    public IListNode copyRandomList(IListNode head) {
        if (head==null)return null;
        IListNode cur=head;
        Map<IListNode,IListNode> map=new HashMap<>();
        while (cur!=null){
            map.put(cur,new IListNode(cur.val));
            cur=cur.next;
        }

        //开始复制
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);

    }
}
