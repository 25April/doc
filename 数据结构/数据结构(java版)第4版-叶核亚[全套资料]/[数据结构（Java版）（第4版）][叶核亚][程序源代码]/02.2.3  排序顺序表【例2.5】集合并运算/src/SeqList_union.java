//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2015��1��30��
//��2.2.3  ����˳���
//����2.5��  ʹ�����Ա��ʾ���ϣ�ʵ�ּ������㡣
//��1�� ���������Ա��ʾ���ϵ�����
        //��ʵ��2.1��  ��˼����2-4��SeqList<T>���������·���������SortedSeqList<T>�Ƿ���ã�Ϊʲô��
        //��������ֵ��������
public class SeqList_union 
{
    public static void main(String args[])
    { 
        Integer[] values1={10,30,50,70,90}, values2={20,40,60,80};
        SeqList<Integer> list1=new SeqList<Integer>(values1);        //˳���
        SeqList<Integer> list2=new SeqList<Integer>(values2);
        System.out.println("list1="+list1.toString()+"��list2="+list2.toString());        
        System.out.println("list1.union(list2)="+list1.union(list2));//˳���ϲ����ӣ�β����
        
        list1 = new SortedSeqList<Integer>(values1);                 //���������������ʵ��
        list2 = new SortedSeqList<Integer>(values2);
        System.out.println("\nlist1="+list1.toString()+"��list2="+list2.toString());        
        System.out.println("list1.union(list2)="+list1.union(list2));//��Ȼִ��˳���ϲ����ӣ�β���룿��[��]���أ�����ʱȷ��

        SortedSeqList<Integer> slist1 = new SortedSeqList<Integer>(values1);
        SortedSeqList<Integer> slist2 = new SortedSeqList<Integer>(values2);
        System.out.println("\nslist1="+slist1.toString()+"��slist2="+slist2.toString());        
        System.out.println("slist1.union(slist2)="+slist1.union(slist2));//����ִ��˳���ϲ�����������

    }
}
/*
�������н�����£�  
list1=SeqList(10, 30, 50, 70, 90) ��list2=SeqList(20, 40, 60, 80) 
list1.union(list2)=SeqList(10, 30, 50, 70, 90, 20, 40, 60, 80)                 //�ϲ�����β��� 

list1=SortedSeqList(10, 30, 50, 70, 90) ��list2=SortedSeqList(20, 40, 60, 80) 
list1.union(list2)=SeqList(10, 30, 50, 70, 90, 20, 40, 60, 80)                 //�ϲ�����β��� 

slist1=SortedSeqList(10, 30, 50, 70, 90) ��slist2=SortedSeqList(20, 40, 60, 80) 
slist1.union(slist2)=SortedSeqList(10, 20, 30, 40, 50, 60, 70, 80, 90)         //��������

*/