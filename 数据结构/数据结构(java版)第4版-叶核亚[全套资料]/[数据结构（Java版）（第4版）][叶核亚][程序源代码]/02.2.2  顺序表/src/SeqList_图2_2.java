//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��21�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.2 ˳���

public class SeqList_ͼ2_2 
{
    public static void main(String args[])
    {
        //ͼ2.2
        String values[]={"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);    //lista����˳���ʵ����Ԫ����String����
        SeqList<Integer> list1 = new SeqList<Integer>();        //list1���ÿ�˳���Ԫ����Integer����
        System.out.println("lista��"+lista.toString());
        System.out.println("list1��"+list1.toString());

        list1.insert(null);                                 //�׳��ն����쳣������ֹͣ����
        System.out.println("list1��"+list1.toString());
        
        
//        for (String obj : lista)          //�﷨��������Ԫѭ������ΪSeqList<T>��û��ʵ�ֵ�����              
   }
}
/*
�������н�����£�    
lista��SeqList5(A, B, C, D, E) 
list1��SeqList5() 
Exception in thread "main" java.lang.NullPointerException: x==null
    at SeqList.insert(SeqList.java:89)
    at SeqList.insert(SeqList.java:106)
    at SeqList_String.main(SeqList_String.java:10)

*/
//@author��Yeheya��2014-9-7