//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��20��
//��9�� 9.5.3 ѭ��˫����������㷨
//ѭ��˫����Ŀ��������㷨��ֱ�Ӳ�������ֱ��ѡ������

public class SortedCirDoublyList_sort 
{
    public static void main(String args[])
    {
        //��ѭ��˫����������ѭ��˫�������������㷨 
        Integer[] value1={37,82,16,93,25,70};          //ͼ9.15
        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(value1);
        System.out.print("list1= "); list1.print();        
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(list1);
        System.out.print("slist1= "); slist1.print(); 

        //�ɵ�����������ѭ��˫����ֱ�Ӳ�������
        Integer[] value2=Array1.randomInteger(5, 100);        //����1.4
        SinglyList<Integer> list2 = new SinglyList<Integer>(value2);
        System.out.println("\nlist2= "+list2.toString());        
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(list2);
        System.out.print("slist2= "); slist2.print(); 

        //�����鹹������ѭ��˫����ֱ��ѡ������
        Integer[] value3=Array1.randomInteger(5, 100);        //����1.4
        System.out.print("\n�ؼ������У�");  Array1.print(value3);
        SortedCirDoublyList<Integer> slist3 = new SortedCirDoublyList<Integer>(value3);
        System.out.print("slist3= "); slist3.print(); 
 
    }
}
/*
�������н�����£�    
 //��9�£���ѭ��˫����������ѭ��˫�������������㷨      ͼ9.15
list1= (37,82,16,93,25,70)��(70,25,93,16,82,37)
ѭ��˫����Ŀ�������
25..70,  vot=37  SortedCirDoublyList(25,16,37,93,82,70)
16..25,  vot=25  SortedCirDoublyList(16,25,37,93,82,70)
70..93,  vot=93  SortedCirDoublyList(16,25,37,70,82,93)
70..82,  vot=70  SortedCirDoublyList(16,25,37,70,82,93)
slist1= (16,25,37,70,82,93)��(93,82,70,37,25,16)

list2= SinglyList(58,67,54,52,29)
ѭ��˫�����ֱ�Ӳ�������
SortedCirDoublyList(58)��p=58
SortedCirDoublyList(58,67)��p=67
SortedCirDoublyList(54,58,67)��p=54
SortedCirDoublyList(52,54,58,67)��p=52
SortedCirDoublyList(29,52,54,58,67)��p=29
slist2= (29,52,54,58,67)��(67,58,54,52,29)

list2= SinglyList(39,8,53,11,79)
ѭ��˫�����ֱ�Ӳ�������
SortedCirDoublyList(39)��p=39
SortedCirDoublyList(8,39)��p=8
SortedCirDoublyList(8,39,53)��p=53
SortedCirDoublyList(8,11,39,53)��p=11
SortedCirDoublyList(8,11,39,53,79)��p=79
slist2= SortedCirDoublyList(8,11,39,53,79)

�ؼ������У� 71 90 80 71 55
ѭ��˫�����ֱ��ѡ������
slist3= (55,71,71,80,90)��(90,80,71,71,55)

�ؼ������У� 11 71 62 4 8
ѭ��˫�����ֱ��ѡ������
SortedCirDoublyList(4,71,62,11,8)
SortedCirDoublyList(4,8,62,11,71)
SortedCirDoublyList(4,8,11,62,71)
SortedCirDoublyList(4,8,11,62,71)
SortedCirDoublyList(4,8,11,62,71)
slist3= SortedCirDoublyList(4,8,11,62,71)


list1= CirDoublyList(45,75,16,80,14,87,14,36,58)����������
36..58,  vot=45  SortedCirDoublyList(36,14,16,14,45,87,80,75,58)
14..36,  vot=36  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
14..16,  vot=14  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
14..16,  vot=14  SortedCirDoublyList(14,14,16,36,45,87,80,75,58)
58..87,  vot=87  SortedCirDoublyList(14,14,16,36,45,58,80,75,87)
58..75,  vot=58  SortedCirDoublyList(14,14,16,36,45,58,80,75,87)
75..80,  vot=80  SortedCirDoublyList(14,14,16,36,45,58,75,80,87)
slist1= SortedCirDoublyList(14,14,16,36,45,58,75,80,87)


*/
//@author��Yeheya��2014-8-20
