//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19��
//9.5.2   ������������㷨

public class SortedSinglyList_selectsort 
{
    public static void main(String args[])
    {
        //�ɵ�����list������������ֱ��ѡ������
//        Integer[] value1=ObjectArray.random(5);        //����1.3
        Integer[] value={26,66,97,11,19,49,38};        //ͼ9.14
        SinglyList<Integer> list1 = new SinglyList<Integer>(value);
        SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(list1);
        System.out.println("������list1: "+list1.toString());        
        System.out.println("��������slist1: "+slist1.toString());    
    }
}
/*
�������н�����£�    
 //��9�£��ɵ�����list������������ѡ������       //ͼ9.14
(11,66,97,26,19,49,38)
(11,19,97,26,66,49,38)
(11,19,26,97,66,49,38)
(11,19,26,38,66,49,97)
(11,19,26,38,49,66,97)
(11,19,26,38,49,66,97)
������list1: (26,66,97,11,19,49,38)
��������slist1: (11,19,26,38,49,66,97)

*/
//@author��Yeheya��2014-8-19
