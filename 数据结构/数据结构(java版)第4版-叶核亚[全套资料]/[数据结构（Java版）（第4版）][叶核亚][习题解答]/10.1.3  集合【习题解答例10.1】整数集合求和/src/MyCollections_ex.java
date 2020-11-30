//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��24�գ�JDK 7.60
//10.1.3   Java���Ͽ��
import java.util.*;

public class MyCollections_ex 
{
    public static void main(String args[])
    {
        int n=8;
        List<Integer> list = MyCollections.random(n);     	//���������
        list.add(list.get(list.size()-1));                  //������һ��Ԫ�أ������ؼ�����ͬԪ��
        System.out.println("��������� list="+list.toString());
        MyCollections.sum(list);                        	//ArrayList<Integer>��Collection<Integer>������

        TreeSet<Integer> treeset = new TreeSet<Integer>(list);     //���б���list���������ϣ����򡢻���
        System.out.print("�������������� treeset="+treeset.toString()+"��");
        System.out.println("treeset.comparator()="+treeset.comparator()); //null
        MyCollections.sum(treeset);                      //TreeSet<Integer>��Collection<Integer>������
    	
        treeset = MyCollections.randomSorted(n);
        System.out.println("���������������� treeset="+treeset.toString());
        MyCollections.sum(treeset);                      //TreeSet<Integer>��Collection<Integer>������
    }
}
/*
�������н�����£� 
��������� list=[87, 73, 37, 62, 95, 18, 42, 86, 86]
sum(java.util.ArrayList) = 87+73+37+62+95+18+42+86+86=586
�������������� treeset=[18, 37, 42, 62, 73, 86, 87, 95]��treeset.comparator()=null
sum(java.util.TreeSet) = 18+37+42+62+73+86+87+95=500
�������97 53 41 95 24 17 43 6 ���������������� treeset=[6, 17, 24, 41, 43, 53, 95, 97]
sum(java.util.TreeSet) = 6+17+24+41+43+53+95+97=376


*/
//@author��Yeheya��2015-4-10

