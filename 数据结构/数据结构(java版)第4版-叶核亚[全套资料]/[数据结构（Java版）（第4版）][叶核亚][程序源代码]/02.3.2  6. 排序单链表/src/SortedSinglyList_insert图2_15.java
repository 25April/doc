//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19��
//2.3 ���Ա����ʽ�洢��ʵ��
//6.  ��������
//ͼ2.15 ������������

public class SortedSinglyList_insertͼ2_15 
{   
    public static void main(String args[])
    {
        //{41,5,67,41,97,1,26,19}   //��3��
        Integer value[]={70,20,80,70,30,60};        //��4��ͼ2.15//�Զ���int��װ��Integerʵ��
//        Integer value[]=ObjectArray.random(5);        //����1.3
        SortedSinglyList<Integer> list1 = new SortedSinglyList<Integer>(value);
        System.out.println("list1="+list1.toString());    //ͼ2.15
/*        
          //�����Ƚ����
        SinglyList<Integer> list2 = new SinglyList<Integer>(list1);   //���
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));

        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.count()-1);                     //ɾ�����һ��Ԫ��
        list2.remove(100);                                 //���Խ�磬ûɾ��
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));*/
    }
}
    /*
      SortedSinglyList<Integer> slist1 = new SortedSinglyList<Integer>(list1);  //���������������ʵ�����ɵ���������������
      slist1.insert(1);                        //�������������෽������������ֵ���룬����
      System.out.println("slist1="+slist1.toString());//����̳�toString()
//      slist1.insert(0,90);                      //����������룬�׳��쳣
      
      Integer key = 55;                        //�Զ���int��װ��Integerʵ��
      int find = slist1.indexOf(key);          //����ʱ��̬��ִ�����า�ǵķ���
      System.out.println("slist1˳����� "+key+"�� "+((find==-1)?"��":"")+"�ɹ�");
      
      list1.remove(1);                         //����remove(int i)
      key = 1;                                 //�Զ���int��װ��Integerʵ��
      list1.remove(key);                      //����remove(T key)
      System.out.println("list1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��list1="+list1.toString());
      slist1.remove(1);                         //����remove(int i)���̳�
      slist1.remove(key);                      //����remove(T key)���̳У����е������า�ǵ�indexOf(key)������ʱ��̬
      System.out.println("slist1 ɾ����"+1+"��Ԫ�أ�ɾ��Ԫ��"+key+"��slist1="+slist1.toString());
      
      
      //5. ���͵Ķ�̬����������Ǹ������
      SinglyList<Integer> list2 = new SinglyList<Integer>(slist1); //����������������������쵥����
      System.out.println("list2="+list2.toString());
      SortedSinglyList<Integer> slist2 = new SortedSinglyList<Integer>(slist1); //�����������
      System.out.println("slist2="+slist2.toString());
      
      //equals()���̳У������Ӿ��ɱ�
/*        System.out.println("list1.equals(slist1)�� "+list1.equals(slist1));  //����equals(��)
//      System.out.println("slist1.equals(list1)�� "+slist1.equals(list1));  //����equals(��)
//      System.out.println("slist1.equals(slist2)�� "+slist1.equals(slist2));//����equals(��)

      //void add(list)
//      list2.add(list1);
//      System.out.println("����list2.add(list1)��list2="+list2.toString());        
      slist2.add(slist1);                           //��������������������list����Ԫ����ӵ���ǰ���������
      System.out.println("����slist2.add(slist1)��slist2="+slist2.toString());

      //SinglyList<T> add(list)
//      System.out.println("����list2.add(list1)="+(list2.add(list1)).toString());        
//      System.out.println("����slist2.add(slist1)="+(slist2.add(slist1)).toString());//��Ȼ��SeqList<T>

/*        
      SinglyList<Integer> list3 = new SortedSinglyList<Integer>(list1);  //���������������ʵ�����ɵ���������������
      System.out.println("������list4: "+list4.toString());
      System.out.println("slist2.equals(list4)�� "+slist2.equals(list4));//����ִ�м̳и����equals()
      System.out.println("list4.equals(slist2)�� "+list4.equals(slist2));//����ִ�м̳и����equals()
      
      
      
      
/*     


      //��9��
//      SortedSinglyList<Integer> list5 = new SortedSinglyList<Integer>(list1);  //�������췽��
//      System.out.println("list5: "+list5.toString());
/*        list3.merge(list5);                           //�鲢������������
      System.out.println("�鲢��list3: "+list3.toString());
      System.out.println("list5: "+list5.toString());
    
      SortedSinglyList<Integer> list6 = list3.mergeWith(list5);      //�鲢������������
      System.out.println("�鲢��list3: "+list3.toString());
      System.out.println("list5: "+list5.toString());
      System.out.println("list6: "+list6.toString());
 }
}
/*
�������н�����£�    ��2��
������list1: (90, 80, 70, 10, 60, 30, 50)           //������β����50
��������slist2: (10, 30, 50, 50, 60, 70, 80, 90)    //��������ֵ����50
SortedSinglyList.indexOf(55,0)��10��30��50��50��slist2˳����� 55�� ���ɹ�



      //��9�£���
list1: (74, 51, 48, 47, 64) 
list3: (40, 47, 67, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 
�鲢��list3: (40, 47, 47, 48, 51, 64, 67, 74, 74, 94, 99) 
list5: (47, 48, 51, 64, 74) 

list1: (53, 48, 92, 41, 1) 
list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
�鲢��list3: (48, 57, 60, 67, 81, 98) 
list5: (1, 41, 48, 53, 92) 
list6: (1, 41, 48, 48, 53, 57, 60, 67, 81, 92, 98) 
}
*/

/*
��������������:����
�������������£�
      SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//      SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                       //�����Object�಻����ΪE��ʵ�ʲ�����û��ʵ��ʵ��Comparable<E>�ӿ�
      SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//      list4.insert(new Object());     //������������Ͳ�ƥ��


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
        System.out.println("="+sum);
    }
}

/*
�������н�����£�    
lista: (A, F, B, E, C, D)
lista: (F, B, e, D)

        //�����Ƚ����
list1: ()
list2: ()
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (44, 10, 11, 20, 72)
list1.equals(list2)? true
list1: (44, 10, 11, 20, 72)
list2: (144, 10, 11, 20)
list1.equals(list2)? false
44+10+11+20+72=157


*/
