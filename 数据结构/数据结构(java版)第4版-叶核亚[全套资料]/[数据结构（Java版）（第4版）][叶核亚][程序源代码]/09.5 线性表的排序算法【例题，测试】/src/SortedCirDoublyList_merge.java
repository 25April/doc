//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��20��
//��9�� 9.5.3   ˫����������㷨
//ͼ9.17 ѭ��˫����Ĺ鲢�����㷨
//4-0�����1

public class SortedCirDoublyList_merge 
{
    public static void main(String[] args) 
    {
//        Integer[] value1={15,21,36,53}, value2={11,36,47,76,99}; //ͼ9.17
        Integer[] value1={26,37,61,81}, value2={18,53,75,86,90};   //4-0�����1
        SortedCirDoublyList<Integer> slist1 = new SortedCirDoublyList<Integer>(value1);
        SortedCirDoublyList<Integer> slist2 = new SortedCirDoublyList<Integer>(value2);
        System.out.println("slist1= "+slist1.toString());        
        System.out.println("slist2= "+slist2.toString());    
        slist1.merge(slist2);                              //�鲢��������ѭ��˫����
        System.out.println("�鲢��slist2.merge(slist1)");        
        System.out.print("slist1=");  slist1.print();
        System.out.print("slist2=");  slist2.print();

/*        Integer[] value3=Array1.randomInteger(5, 100);        //����1.4
        Integer[] value4=Array1.randomInteger(5, 100);
        SortedCirDoublyList<Integer> slist3 = new SortedCirDoublyList<Integer>(value3);
        SortedCirDoublyList<Integer> slist4 = new SortedCirDoublyList<Integer>(value4);
        System.out.println("\nslist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        SortedCirDoublyList<Integer> slist5 = slist3.mergeWith(slist4);      //�鲢��������˳���
        System.out.println("�鲢��slist5 = slist3.mergeWith(slist4) ");
        System.out.println("slist3="+slist3.toString());
        System.out.println("slist4="+slist4.toString());
        System.out.print("slist5=");  slist5.print();*/
    }
}

/* 
�������н�����£�    
      //ͼ9.17
slist1= SortedCirDoublyList(15,21,36,53)
slist2= SortedCirDoublyList(11,36,47,76,99)
�鲢��slist2.merge(slist1)
slist1=(11,15,21,36,36,47,53,76,99)��(99,76,53,47,36,36,21,15,11)
slist2=()��()

   //4-0�����1
slist1= SortedCirDoublyList(26,37,61,81)
slist2= SortedCirDoublyList(18,53,75,86,90)
�鲢��slist2.merge(slist1)
slist1=(18,26,37,53,61,75,81,86,90)��(90,86,81,75,61,53,37,26,18)
slist2=()��()

slist3=SortedCirDoublyList(1,1,29,53,66)
slist4=SortedCirDoublyList(0,9,36,38,42)
�鲢��slist5 = slist3.mergeWith(slist4) 
slist3=SortedCirDoublyList(1,1,29,53,66)
slist4=SortedCirDoublyList(0,9,36,38,42)
slist5=(0,1,1,9,29,36,38,42,53,66)��(66,53,42,38,36,29,9,1,1,0)
*/


//@author��Yeheya��2014-8-22



