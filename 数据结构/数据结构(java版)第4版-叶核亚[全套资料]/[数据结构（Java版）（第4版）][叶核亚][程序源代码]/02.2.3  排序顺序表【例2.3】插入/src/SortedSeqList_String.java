//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��19�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.3 ����˳���

public class SortedSeqList_String 
{
    public static void main(String args[])
    {
        //2.2.3  ����˳���
        String values[]={"F","C","B","A","D","E"};
        SortedSeqList<String> lista = new SortedSeqList<String>(values);
        SortedSeqList<String> listb = new SortedSeqList<String>(lista);  //ִ�п������췽��
        lista.insert("A");                       //��ֵ���룬����
//        lista.insert(0,"G");                   //����insert(int i, T x)���׳� UnsupportedOperationException
        listb.remove(0);                         //����remove(int i)���̳�
        System.out.println("����˳���lista: "+lista.toString()+"\n����˳���listb: "+listb.toString()+//ִ�������toString()
                           "��lista.equals(listb)? "+lista.equals(listb));//����ִ�м̳и����equals()
        String key1 = "F";
        System.out.println("  lista˳����� "+key1+", "+((lista.search(key1)==-1)?"��":"")+"�ɹ�");//ִ�����า�ǵķ���
   }
}
/*
�������н�����¡�
����˳���lista: (A, A, B, C, D, E, F) 
����˳���listb: (B, C, D, E, F) ��lista.equals(listb)? false
SortedSeqList.indexOf(key,start)��A��A��B��C��D��E��F��  lista˳����� F, �ɹ�

*/

/*
��������������:����
�������������£�
        SinglyLinkedList<Object> list3 = new SinglyLinkedList<Object>();
//        SortedSinglyLinkedList<Object> list4 = new SortedSinglyLinkedList<Object>();
                                         //�����Object�಻����ΪE��ʵ�ʲ�����û��ʵ��ʵ��Comparable<E>�ӿ�
        SortedSinglyLinkedList<Integer> list4 = new SortedSinglyLinkedList<Integer>();
//        list4.insert(new Object());     //������������Ͳ�ƥ��
*/
