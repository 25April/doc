//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��24�գ�JDK 7.60
//10.1.3   Java���Ͽ��

import java.util.*;

public class List_ex 
{
    public static void sum(List<Integer> list)
    {
    	ListIterator<Integer> it = list.listIterator();      //����б����������
        System.out.print("nextIndex="+it.nextIndex()+"��");   //0
        int sum=0, value=0;
        while (it.hasNext())
        {
            value = it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);//)+"��nextIndex="+it.nextIndex());-1
//        it.next();                    //�׳�java.util.NoSuchElementException
        
        sum=0;
        System.out.print("nextIndex="+it.previousIndex()+"��");
        while (it.hasPrevious())                           //���������б����������
        {
            value=it.previous().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasPrevious())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum+"��nextIndex="+it.previousIndex());
//        it.previous();                    //�׳�java.util.NoSuchElementException
    }
	
    //ɾ��list<T>�ĵ�i��Ԫ�أ����ر�ɾ��Ԫ�ء�ʹ�õ�����
    public static <T> T remove(List<T> list, int i)
    {
        Iterator<T> it = list.iterator();        //��õ���������
        T value=null;
        int j=0;
        for (j=-1; j<i && it.hasNext(); j++)
            value = it.next();
        if (j==i)
            it.remove();                         //ɾ����i��Ԫ��
        return value;
    }
    
	public static void main(String args[])
    {
    	List<Integer> list1;// = new ArrayList();             //�ձ�
//        System.out.println("list1="+list1.toString()+"��");
//    	sum(list1);

    	int n=10;
    	list1 = MyCollections.random(n);
        System.out.println("list1="+list1.toString()+"��");
    	sum(list1);
        System.out.println("ɾ��"+remove(list1,0)+"��"+list1.toString());
        System.out.println("ɾ��"+remove(list1,n-2)+"��"+list1.toString());
        System.out.println("ɾ��"+remove(list1,1)+"��"+list1.toString());
    	
/*    	List<Integer> list2 = new LinkedList(list1);    	//���������??
        System.out.println("list2:"+list1.toString()+"��");
    	ListIterator<Integer> lit = list2.listIterator();  //����б����������
        System.out.print("nextIndex="+lit.nextIndex()+"��");
    	Integer value = lit.next();
    	lit.remove();                                       //ɾ����һ��Ԫ��
                                //����ִ��it.next();�����׳�java.lang.IllegalStateException�쳣
        System.out.println("ɾ��"+value+"��list2:"+list2.toString()+"�� ");
        System.out.print("nextIndex="+lit.nextIndex()+"��");
    	value = lit.next();
        lit.remove();                                       //ɾ����һ��Ԫ��
        System.out.println("ɾ��"+value+"��list2:"+list2.toString());
    	sum(list2);                              //ͬʱ������������
       
        System.out.print("nextIndex="+lit.nextIndex()+"��");
//        lit.previous();
        lit.add(value);                                    //�����һ��Ԫ��
                         //����ִ��it.previous();�����׳�java.lang.IllegalStateException�쳣
        System.out.println("����"+value+"��list2:"+list2.toString());

        System.out.print("nextIndex="+lit.nextIndex()+"��");
        value = new Integer(100);
        lit.next();                               //�����ɾ�������nextȷ������Ԫ��
        lit.set(value);          //�����ϵ�ǰԪ���滻Ϊx����ǰԪ�����δ�ı�
        System.out.println("�滻"+value+"��list2:"+list2.toString());
        value = new Integer(200);
    	lit.set(value);                    //���������滻
        System.out.println("�滻"+value+"��list2:"+list2.toString());*/
    }
}
/*
�������н�����£�    
list1:[]��
nextIndex=0��=0��nextIndex=0
nextIndex=-1��=0��nextIndex=-1
list1:[83, 37, 48, 21, 36, 7, 81, 45, 27, 59]��
nextIndex=0��83+37+48+21+36+7+81+45+27+59=444��nextIndex=10
nextIndex=9��59+27+45+81+7+36+21+48+37+83=444��nextIndex=-1
list2:[83, 37, 48, 21, 36, 7, 81, 45, 27, 59]��
nextIndex=0��ɾ��83��list2:[37, 48, 21, 36, 7, 81, 45, 27, 59]�� 
nextIndex=0��ɾ��37��list2:[48, 21, 36, 7, 81, 45, 27, 59]
nextIndex=0��48+21+36+7+81+45+27+59=324��nextIndex=8
nextIndex=7��59+27+45+81+7+36+21+48=324��nextIndex=-1
nextIndex=0������37��list2:[37, 48, 21, 36, 7, 81, 45, 27, 59]
nextIndex=1���滻100��list2:[37, 100, 21, 36, 7, 81, 45, 27, 59]
�滻200��list2:[37, 200, 21, 36, 7, 81, 45, 27, 59]

*/
