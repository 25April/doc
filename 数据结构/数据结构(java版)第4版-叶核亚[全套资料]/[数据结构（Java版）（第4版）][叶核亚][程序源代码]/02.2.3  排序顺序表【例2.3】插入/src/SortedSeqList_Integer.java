//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.3  ����˳���
//3. ��̬ԭ�����า�Ǹ����Ա����
//����2.3��  ˳���������˳���Ĳ��������

public class SortedSeqList_Integer 
{
    public static void main(String args[])
    {
        //3. ��̬ԭ�����า�Ǹ����Ա����
        //��1�� ����˳���Ĳ������
        //��2�� ����ʱ��̬
//        Integer values[]=MyArray.randomInteger(5, 100);     //����1.4
        Integer[] values={70,20,80,30,60};                 //Java�Զ���int��װ��Integerʵ��
        SeqList<Integer> list1=new SeqList<Integer>(values);//˳���
        SortedSeqList<Integer> slist1=new SortedSeqList<Integer>(list1);  //���������������ʵ������˳���������˳���
                                                           //slist1��list1��Ԫ�����͸�ֵ����
        list1.insert(0,10);                                //����insert(i,x)��˳������
        list1.insert(50);                                  //���������ø��෽����˳���β���룬��int��װ��Integerʵ��
        slist1.insert(50);                                 //�������������෽��������˳���ֵ���룬����
        System.out.println("list1="+list1.toString());
        System.out.println("slist1="+slist1.toString());   //����̳�toString()
//        slist1.insert(0,90);                             //����˳�����룬�׳��쳣
        
        //��3�� ����˳���Ĳ��Һ�ɾ������
        Integer key = 55;                        //�Զ���int��װ��Integerʵ��
        int find = slist1.search(key);           //����ʱ��̬��ִ�����า�ǵķ���
        System.out.println("slist1˳����� "+key+"�� "+((find==-1)?"��":"")+"�ɹ�");
        
        list1.remove(1);                         //����remove(int i)
        key = 1;                                 //�Զ���int��װ��Integerʵ��
        list1.remove(key);                      //����remove(T key)
        System.out.println("list1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��list1="+list1.toString());
        slist1.remove(1);                         //����remove(int i)���̳�
        slist1.remove(key);                      //����remove(T key)���̳У����е������า�ǵ�search(key)������ʱ��̬
        System.out.println("slist1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��slist1="+slist1.toString());
        
        
        //5. ���͵Ķ�̬����������Ǹ������
        //��1�� ��������Ǹ�����󣬸�ֵ����
        SeqList<Integer> list2 = new SeqList<Integer>(slist1); //˳��������������˳�����˳���
        System.out.println("list2="+list2.toString());
        SortedSeqList<Integer> slist2 = new SortedSeqList<Integer>(slist1); //����˳������
        System.out.println("slist2="+slist2.toString());

        //equals()���̳У������Ӿ��ɱ�
        System.out.println("list1.equals(slist1)�� "+list1.equals(slist1));  //����equals(��)
        System.out.println("slist1.equals(list1)�� "+slist1.equals(list1));  //����equals(��)
        System.out.println("slist1.equals(slist2)�� "+slist1.equals(slist2));//����equals(��)
    }
}
/*
����������н�����¡�
list1=(10, 70, 20, 80, 30, 60, 50) 
slist1=(20, 30, 50, 60, 70, 80) 
20��30��50��slist1˳����� 55�� ���ɹ�
list1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��list1=(10, 20, 80, 30, 60, 50) 
slist1 ɾ����1��Ԫ�أ�ɾ��Ԫ��1��slist1=(20, 50, 60, 70, 80) 
list2=(20, 50, 60, 70, 80) 
slist2=(20, 50, 60, 70, 80) 
list1.equals(slist1)�� false
slist1.equals(list1)�� false
slist1.equals(slist2)�� true
*/
//@author��Yeheya��2015-1-30
