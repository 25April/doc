//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��23��
//2.3.3   ˫����
//3. ѭ��˫����

//import java.util.Iterator;

public class CirDoublyList_ex 
{
	public static Integer[] random(int n)              //���ز���n�������������
	{
	    Integer[] elements = new Integer[n];
	    for (int i=0; i<n; i++)
	        elements[i] = (int)(Math.random()*100);   //���������
	    return elements;
	}
	
	public static void main(String args[])
	{
        Integer values[]={70,20,80,70,30,60};        //��4��ͼ2.14//�Զ���int��װ��Integerʵ��
//      Integer value[]=ObjectArray.random(5);        //����1.3
        CirDoublyList<Integer> list1 = new CirDoublyList<Integer>(values);//random(5));
        System.out.println("list1="+list1.toString());    //ͼ2.13

/*      Integer values[]={41,41,67};                   //tu2.19
        System.out.print("list1: "+list1.toString()+"��");
        list1.printPrevious();
        list1.insert(-1, -1);                              //����λ���ݴ�
        list1.insert(0, 0);
        list1.insert(6, 6);
        list1.insert(100, 100);                            //����λ���ݴ�
        list1.set(3, new Integer((int)(list1.get(3).intValue()+100)));
        System.out.println("�����: "+list1.toString());
        list1.remove(0);
	    list1.remove(3);
	    list1.remove(100);                                 //���Խ�磬ûɾ��
        System.out.println("ɾ����: "+list1.toString());
	    CirDoublyList<Integer> list2 = new CirDoublyList<Integer>(list1);//���
        System.out.println("list2: "+list2.toString());
        
        //ϰ��2
/*        SinglyLinkedList<Integer> list3 = new SinglyLinkedList<Integer>(random(9));//������
        System.out.println("list3: "+list3.toString());        
	    CirDoublyLinkedList<Integer> list4 = new CirDoublyLinkedList<Integer>(list3);//�ɵ�������ѭ��˫����
        System.out.println("list4: "+list4.toString());
        CirSinglyLinkedList<Integer> list5 = new CirSinglyLinkedList<Integer>(random(9));//ѭ��������
        System.out.println("list5: "+list5.toString());        
	    CirDoublyLinkedList<Integer> list6 = new CirDoublyLinkedList<Integer>(list5);//��ѭ����������ѭ��˫����
        System.out.println("list6: "+list6.toString());
        list6.printPrevious();

        //�����Ƚ����
		CirDoublyLinkedList<Integer> list1 = new CirDoublyLinkedList<Integer>();   //�ձ�
        System.out.println("list1: "+list1.toString());
        CirDoublyLinkedList<Integer> list2 = new CirDoublyLinkedList<Integer>();   //�ձ�
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

    	list1 = new CirDoublyLinkedList<Integer>(random(5));
        System.out.println("list1: "+list1.toString());
        list2 = new CirDoublyLinkedList<Integer>(list1);               //�������췽��
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));

        System.out.println("list1: "+list1.toString());
        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.count()-1);
        System.out.println("list2: "+list2.toString());
        System.out.println("list1.equals(list2)? "+list1.equals(list2));
*/
		
        
/*        
        //10.2   ʵ�ֵ�����
        Iterator<Integer> it = list1.iterator();      //��õ��������������
        int sum=0;
        while (it.hasNext())
        {
            int value=it.next().intValue();
        	sum += value;
    	    System.out.print(value);
        	if (it.hasNext())
        	    System.out.print("+");
        }        	
        System.out.println("="+sum);*/
    }
}
/*
�������н�����£�
list1: (91, 16, 6, 5, 74)
(74, 5, 6, 16, 91)
�����: (0, -1, 91, 116, 6, 5, 6, 74, 100)
ɾ����: (-1, 91, 116, 5, 6, 74, 100)
list2: (-1, 91, 116, 5, 6, 74, 100)
list3: (17, 66, 48, 19, 17, 33, 46, 60, 65)
list4: (17, 66, 48, 19, 17, 33, 46, 60, 65)
list5: (97, 67, 25, 31, 48, 97, 1, 58, 10)
list6: (97, 67, 25, 31, 48, 97, 1, 58, 10)
(10, 58, 1, 97, 48, 31, 25, 67, 97)

        //�����Ƚ����
list1: ()
list2: ()
list1.equals(list2)? true
list1: (21, 80, 7, 47, 44)
list2: (21, 80, 7, 47, 44)
list1.equals(list2)? true
list1: (21, 80, 7, 47, 44)
list2: (121, 80, 7, 47)
list1.equals(list2)? false
21+80+7+47+44=199

*/