//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��7�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.2  ˳���
//5.  ˳����ǳ���������
//����2.2��  ˳����ǳ�����������
//��1��˳����ǳ����
//ͼ2.6  ˳����ǳ�����������

public class SeqList_copy_String 
{
    public static void main(String[] args) 
    {
        String[] values={"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);
        SeqList<String> listb = new SeqList<String>(lista);//ִ�п������췽��
        
        System.out.println("ͼ2.6��a����lista="+lista.toString()+"��listb="+listb.toString());
        lista.remove(0);                                   //ǳ����ʱ���д�ͼ2.6��b��
        System.out.println("ͼ2.6��b����lista="+lista.toString()+"��listb=");
        System.out.println(listb.toString());        
    }    
}

/*
�������н�����£�
ͼ2.6��a����lista=SeqList(A, B, C, D, E) ��listb=SeqList(A, B, C, D, E) 
ͼ2.6��b����lista=SeqList(B, C, D, E) ��listb=
Exception in thread "main" java.lang.NullPointerException
    at SeqList.toString(SeqList.java:78)
    at SeqList_copy.main(SeqList_copy.java:19)
*/


//@author��Yeheya��2014-9-7