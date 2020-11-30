//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��12��
//��2.3 ���Ա����ʽ�洢��ʵ��
//3. ��ͷ���ĵ�������
//����2.5����������ת��

public class SinglyList_reverse 
{
    //���췴��������values�����ṩԪ�ء�����ֵ����ǰ�������Ͳ���T��
    //����ͷ���룬������Ԫ�ش���������Ԫ�ش����෴
    public static <T> SinglyList<T> createReverse(T[] values)
    {
        SinglyList<T> list = new SinglyList<T>();          //�����յ�����ֻ��ͷ���
        for (int i=0; i<values.length; i++)
            list.head.next = new Node<T>(values[i], list.head.next);//ͷ����
        return list;                                       //���ص������������
    }
    
    //����������ת�����ͷ���������ֵ����ǰ�������Ͳ���T
    public static <T> void reverse(SinglyList<T> list)
    {
        Node<T> p=list.head.next, front=null;              //head��������Ϊpublic 
        while (p!=null)
        {
            Node<T> succ = p.next;                         //succ��p���ĺ�̽��
            p.next = front;                                //ʹp.nextָ��p����ǰ�����
            front = p;
            p = succ;                                      //p�����̽��
        }
        list.head.next = front;                  //����ͷ���ĵ�ַ��ָ��ԭ����������һ�����
    }
  
    public static void main(String args[])
    {
        String[] values={"A","B","C","D","E","F"};
        SinglyList<String> lista = new SinglyList<String>(values);
        System.out.print("lista = "+lista.toString());
        reverse(lista);
        System.out.println("����ת�� "+lista.toString());
        
        SinglyList<String> listb = createReverse(values);
        System.out.print("listb = "+listb.toString());
        System.out.println("��lista.equals(listb)? "+lista.equals(listb));        
    }
}
/*
�������н�����£�    
list1 = SinglyList(A,B,C,D,E,F)����ת�� SinglyList(F,E,D,C,B,A)
list2 = SinglyList(F,E,D,C,B,A)��list1.equals(list2)? true

*/
//@author��Yeheya��2014-9-12
    