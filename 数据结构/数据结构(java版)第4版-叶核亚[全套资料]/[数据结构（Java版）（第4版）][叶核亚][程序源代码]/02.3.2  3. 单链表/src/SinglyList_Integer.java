//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//��2.3 ���Ա����ʽ�洢��ʵ��
//3. ��ͷ���ĵ�������

public class SinglyList_Integer 
{   
    public static void main(String args[])
    {
//        Integer[] values=MyArray.randomInteger(5, 100);        //����1.3
        Integer[] values={80,70,20,60,30};        //�Զ���int��װ��Integerʵ��
        SinglyList<Integer> list1 = new SinglyList<Integer>(values);
        list1.insert(0,90);                      //����insert(i,x)�����������
        list1.insert(1);                         //����insert(x)��������β���룬��int��װ��Integerʵ��
        System.out.println("list1="+list1.toString());
        
        //5. �������ǳ���������
        //��˼����2-6��
        SinglyList<Integer> list2 = new SinglyList<Integer>(list1);   //���
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));

        list2.set(0, new Integer(list1.get(0).intValue()+100));
        list2.remove(list2.size()-1);                      //ɾ�����һ��Ԫ��
        list2.remove(100);                                 //���Խ�磬ûɾ��
        System.out.print("list2="+list2.toString());
        System.out.println("��list1.equals(list2)? "+list1.equals(list2));
    }
}
/*
�������н�����£�
list1=SinglyList(90,80,70,20,60,30,1)
list2=SinglyList(90,80,70,20,60,30,1)��list1.equals(list2)? true
list2=SinglyList(190,80,70,20,60,30)��list1.equals(list2)? false
*/
//@author��Yeheya��2014-9-12