//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//4.4 �ݹ�
//3. ������ĵݹ��㷨

public class RecSinglyList_Integer 
{   
    public static void main(String args[])
    {
        Integer value[]={80,70,20,60,30,30};        //�Զ���int��װ��Integerʵ��
        RecSinglyList<Integer> list1 = new RecSinglyList<Integer>(value);
        RecSinglyList<Integer> list2 = new RecSinglyList<Integer>(list1);   //���
        System.out.println("list1="+list1.toString());
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));
        
        int key=value[value.length-1];
        System.out.println("����"+key+"�����"+list1.search(key));
        int x=value[0];
        list2.replaceAll(key, x);
        System.out.println("�滻list2������"+key+"Ϊ"+x);
        System.out.println("list1="+list1.toString());
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));
    }
}
/*
�������н�����£�
list1=RecSinglyList(80, 70, 20, 60, 30, 30)
list2=RecSinglyList(80, 70, 20, 60, 30, 30)��list1.equals(list2)? true
����30�����30
�滻list2������30Ϊ80
list1=RecSinglyList(80, 70, 20, 60, 30, 30)
list2=RecSinglyList(80, 70, 20, 60, 80, 80)��list1.equals(list2)? false
*/
//author��Yeheya��2014-9-23
