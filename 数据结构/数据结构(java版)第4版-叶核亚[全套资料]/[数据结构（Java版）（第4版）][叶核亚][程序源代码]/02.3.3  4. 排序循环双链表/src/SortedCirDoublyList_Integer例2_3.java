//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19��
//2.2  ���Ա��˳��洢��ʵ��
//2.3.2   ������
//6.  ��������
//����2.3��  ˳���������˳���Ĳ��������//ͬSortedSeqList_Integer 

public class SortedCirDoublyList_Integer��2_3 
{
    public static void main(String args[])
    {
        Integer[] value={70,20,80,30,60};        //�Զ���int��װ��Integerʵ��
        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(value);
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(list1);  //���������������ʵ������˳���������˳���
        list1.insert(0,10);                      //���ø����insert(int i, T x)��ָ��λ�ò���
        list1.insert(50);                        //���ø���insert(T x)��ѭ��˫����β���룬��int��װ��Integerʵ��
        slist1.insert(50);                        //�������������෽��������ѭ��˫����ֵ���룬����
        System.out.print("list1="); list1.print();
        System.out.print("slist1="); slist1.print();
//        slist1.insert(0,90);                      //����ѭ��˫������룬�׳��쳣
        
        //��3�� ����ѭ��˫����Ĳ��Һ�ɾ������
        Integer key = 55;                        //�Զ���int��װ��Integerʵ��
        DoubleNode<Integer> find = slist1.search(key);    //����ʱ��̬��ִ�����า�ǵķ���
        System.out.println("slist1˳����� "+key+"�� "+((find==null)?"��":"")+"�ɹ�");
        
        list1.remove(1);                         //����remove(int i)
        key = 1;                                 //�Զ���int��װ��Integerʵ��
        list1.remove(key);                      //����remove(T key)
        System.out.print("list1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��list1="); list1.print();
        slist1.remove(1);                         //����remove(int i)���̳�
        slist1.remove(key);                      //����remove(T key)���̳У����е������า�ǵ�search(key)������ʱ��̬
        System.out.print("slist1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��slist1="); slist1.print();
        
        //5. ���͵Ķ�̬����������Ǹ������
        //��1�� ��������Ǹ�����󣬸�ֵ����
        CirDoublyList<Integer> list2 = new CirDoublyList<Integer>(slist1); //����������������������쵥����
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(slist1); //�����������
        System.out.print("list2="); list2.print();
        System.out.print("slist2="); slist2.print();

        //equals()���̳У������Ӿ��ɱ�
        System.out.println("list1.equals(slist1)�� "+list1.equals(slist1));  //����equals(��)
        System.out.println("slist1.equals(list1)�� "+slist1.equals(list1));  //����equals(��)
        System.out.println("slist1.equals(slist2)�� "+slist1.equals(slist2));//����equals(��)
        
    }
}
/*

list1=(10,70,20,80,30,60,50)��(50,60,30,80,20,70,10)
slist1=(20,30,50,60,70,80)��(80,70,60,50,30,20)
20��30��50��slist1˳����� 55�� ���ɹ�
list1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��list1=(10,20,80,30,60,50)��(50,60,30,80,20,10)
slist1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��slist1=(20,50,60,70,80)��(80,70,60,50,20)
list2=(20,50,60,70,80)��(80,70,60,50,20)
slist2=(20,50,60,70,80)��(80,70,60,50,20)
list1.equals(slist1)�� false
slist1.equals(list1)�� false
slist1.equals(slist2)�� true





*/
//@author��Yeheya��2014-8-20


/*
��������������:
�������������£�
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //�����Object�಻����ΪE��ʵ�ʲ�����û��ʵ��ʵ��Comparable<E>�ӿ�
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //������������Ͳ�ƥ��
*/