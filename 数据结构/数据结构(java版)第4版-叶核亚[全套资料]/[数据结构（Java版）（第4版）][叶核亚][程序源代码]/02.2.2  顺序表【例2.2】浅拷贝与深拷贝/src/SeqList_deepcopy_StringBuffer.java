//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��7�գ�JDK 8.11
//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.2  ˳���
//5.  ˳����ǳ���������
//����2.2��  ˳����ǳ�����������
//��2�� ˳�������
//ͼ2.7��a����b��  ˳�������
//ͼ2.7��c�������ɣ���ΪStringBufferû�п������췽��

public class SeqList_deepcopy_StringBuffer 
{
    public static void main(String args[])
    {
        //ͼ2.7��a��˳�������
        int n=5;
        SeqList<StringBuffer> lista = new SeqList<StringBuffer>(n-1);  //ִ�й��췽��
        for (int i=0; i<n; i++)
            lista.insert(new StringBuffer((char)('A'+i)+""));          //β���룬����

        SeqList<StringBuffer> listb = new SeqList<StringBuffer>(lista);//ִ�п������췽����ͼ2.7��a��
        System.out.println("ͼ2.7��a����lista="+lista.toString()+"��listb="+listb.toString()+
                           "��lista.equals(listb)? "+lista.equals(listb));
        
        //ͼ2.7��b��  ˳�������
        lista.insert(new StringBuffer("F"));               //β���룬ͼ2.7��b����û��Ӱ��listb
        lista.remove(10);                                  //���Խ�磬ûɾ��
        listb.remove(listb.size()-1);                      //βɾ����ͼ2.7��b����û��Ӱ��lista
        StringBuffer strbuf = lista.get(0);                //�������õĶ���
        strbuf.setCharAt(0, 'X');                          //�޸�Ԫ�أ�ͼ2.7��b����Ӱ��listb
        System.out.println("ͼ2.7��b����lista="+lista.toString()+"��listb="+listb.toString()+
                           "��lista.equals(listb)? "+lista.equals(listb));        
    }
}

/*
�������н�����£�    
ͼ2.7��a����lista=SeqList(A, B, C, D, E) ��listb=SeqList(A, B, C, D, E) ��lista.equals(listb)? true
ͼ2.7��b����lista=SeqList(X, B, C, D, E, F) ��listb=SeqList(X, B, C, D) ��lista.equals(listb)? false

*/

/*    //(3)��ȿ���,����,StringBufferû�п������췽��
public static SeqList<StringBuffer> copy(SeqList<StringBuffer> list)//������췽�������������list
{
    SeqList<StringBuffer> result = new SeqList<StringBuffer>(list);//������췽����
    for (int i=0; i<list.count(); i++)          //����list��������Ԫ�أ�O(n)
        result.set(i, new StringBuffer(list.get(i)));             //�������ø�ֵ��û�д����¶���
    return result; 
}
*/  

//@author��Yeheya��2014-9-7