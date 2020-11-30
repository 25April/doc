//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��26�գ�JDK 8.25
//10.1  Java���Ͽ��
//����10.1��  �������ϡ�//��˼����10-1��

import java.util.*;

public class MyCollections                                 //����Լ��ϵĲ���
{
    public static void print(Collection<?> coll)           //������ϡ�toString()û�з�������
    {
        System.out.print(coll.getClass().getName()+"[");   //��������
        Iterator<?> it = coll.iterator();                  //���ص���������
        while (it.hasNext())                               //���к��Ԫ�أ�ʹ�õ���������һ������
            System.out.print(it.next().toString()+" ");    //���غ��Ԫ��
        
//����        for (Object obj : coll)                 //��Ԫѭ����obj�������coll����Ԫ�أ�����ͬ���ϵ���
//            System.out.print(obj.toString());
        
        System.out.println("]");
    }

    //��˼����10-1�ڣ�ϰ����
    public static int sum(Collection<Integer> coll)        //���ؼ���coll����Ԫ��֮��
    {
        System.out.print("sum("+coll.getClass().getName()+") = ");  //��������
        Iterator<Integer> it = coll.iterator();            //��õ���������
        int s=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
            s += value;
            System.out.print(value);
            if (it.hasNext())
                System.out.print("+");
        }           
        System.out.println("="+s);
        return s;
    }

    //��˼����10-1�ڣ�����⡿
    public static List<Integer> random(int n)              //���ش洢n����������б���Χ��0��99
    {
        List<Integer> list = new ArrayList<Integer>(n*2);
//    List<Integer> list = new LinkedList<Integer>();
        ListIterator<Integer> it = list.listIterator();    //����б����������
        for (int i=0; i<n; i++)
        {
//          System.out.println("nextIndex="+it.nextIndex());
            it.add(new Integer((int)(Math.random()*100))); //���������ͨ���б�������������Ԫ�أ������������
        }
        return list;
    }	
    
    public static TreeSet<Integer> randomSorted(int n)     //���ش洢n�����������������������
    {
        TreeSet<Integer> treeset = new TreeSet<Integer>(); //Ĭ��Ԫ�ؿɱȽ�
        System.out.print("�������");
        for (int i=0; i<n; i++)
        {
            int value = (int)(Math.random()*100);         //���������
            System.out.print(value+" ");
            treeset.add(new Integer(value));               //���������Ԫ��
        }
//        System.out.println();
        return treeset;
    }
}
//@author��Yeheya��2015-4-10
