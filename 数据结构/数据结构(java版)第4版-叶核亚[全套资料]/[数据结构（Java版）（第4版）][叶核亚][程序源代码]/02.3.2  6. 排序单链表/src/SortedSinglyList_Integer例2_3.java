//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19��
//2.2  ���Ա��˳��洢��ʵ��
//2.3.2   ������
//6.  ��������
//����2.3��  ˳���������˳���Ĳ��������//ͬSortedSeqList_Integer 

public class SortedSinglyList_Integer��2_3 
{
    public static void main(String args[])
    {
//      Integer[] values=MyArray.randomInteger(5, 100);        //����1.3
        Integer[] values={70,20,80,30,60};        //�Զ���int��װ��Integerʵ��
        SinglyList<Integer> list1 = new SinglyList<Integer>(values);
        SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(list1);  //���������������ʵ�����ɵ���������������
        list1.insert(0,10);                      //���ø���insert(int i, T x)��ָ��λ�ò���
        list1.insert(50);                        //����insert(T x)��������β���룬��int��װ��Integerʵ��
        slist1.insert(50);                        //�������������෽������������ֵ���룬����
        System.out.println("list1="+list1.toString());
        System.out.println("slist1="+slist1.toString());//����̳�toString()
//        slist1.insert(0,90);                      //����������룬�׳��쳣
        
        //��3�� ��������Ĳ��Һ�ɾ������
        Integer key = 55;                        //�Զ���int��װ��Integerʵ��
        Node<Integer> find = slist1.search(key);    //����ʱ��̬��ִ�����า�ǵķ���
        System.out.println("slist1˳����� "+key+"�� "+((find==null)?"��":"")+"�ɹ�");
        
        list1.remove(1);                         //����remove(int i)
        key = 1;                                 //�Զ���int��װ��Integerʵ��
        list1.remove(key);                      //����remove(T key)
        System.out.println("list1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��list1="+list1.toString());
        slist1.remove(1);                         //����remove(int i)���̳�
        slist1.remove(key);                      //����remove(T key)���̳У����е������า�ǵ�search(key)������ʱ��̬
        System.out.println("slist1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��slist1="+slist1.toString());
        
        
        //5. ���͵Ķ�̬����������Ǹ������
        //��1�� ��������Ǹ�����󣬸�ֵ����
        SinglyList<Integer> list2 = new SinglyList<Integer>(slist1); //����������������������쵥����
        System.out.println("list2="+list2.toString());
        SortedSinglyList<Integer> slist2 = new SortedSinglyList<Integer>(slist1); //�����������
        System.out.println("slist2="+slist2.toString());

        //equals()���̳У������Ӿ��ɱ�
        System.out.println("list1.equals(slist1)�� "+list1.equals(slist1));  //����equals(��)
        System.out.println("slist1.equals(list1)�� "+slist1.equals(list1));  //����equals(��)
        System.out.println("slist1.equals(slist2)�� "+slist1.equals(slist2));//����equals(��)        
    }
}
/*
�������н�����£�
SortedSinglyList(20,70,80,30,60)
SortedSinglyList(20,30,80,70,60)
SortedSinglyList(20,30,60,70,80)
SortedSinglyList(20,30,60,70,80)
list1=SinglyList(10,70,20,80,30,60,50)
slist1=SortedSinglyList(20,30,50,60,70,80)
slist1˳����� 55�� ���ɹ�
list1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��list1=SinglyList(10,20,80,30,60,50)
slist1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��slist1=SortedSinglyList(20,50,60,70,80)
list2=SinglyList(20,50,60,70,80)
slist2=SortedSinglyList(20,50,60,70,80)
list1.equals(slist1)�� false
slist1.equals(list1)�� false
slist1.equals(slist2)�� true
*/
//@author��Yeheya��2014-8-19


