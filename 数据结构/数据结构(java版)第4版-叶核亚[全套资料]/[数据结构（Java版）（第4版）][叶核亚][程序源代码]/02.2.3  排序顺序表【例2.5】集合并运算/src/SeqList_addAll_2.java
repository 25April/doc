//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��15��
//��2.2.3  ����˳���
//����2.5��  ʹ�����Ա��ʾ���ϣ�ʵ�ּ������㡣

//���ͼ���̳����������ۣ�����������������������
//SeqList<T>������·�����������ʾ��������֧��T�������ࡣ
//  public SeqList(SeqList<? extends T> list)      //�����Ԫ������֧��T��������
//  public void addAll(SeqList<? extends T> list)  //���ϲ�

public class SeqList_addAll_2 
{
    public static void main(String args[])
    {
        //��2�� ���͵ļ̳���
        Object[] objs={"A", "B", 10, new Integer(20)};   //���������������ʵ�������͵Ķ�̬��
        SeqList<Object> listobj1 = new SeqList<Object>(objs);//T���Ͱ���������ʵ��      
        String str[]={"C","D","E"};        
        SeqList<String> lists = new SeqList<String>(str);        
        SeqList<Object> listobj2 = new SeqList<Object>(lists);
                      //SeqList<Object>���������SeqList<String>����������������SeqList<? extends T>
        listobj1.addAll(lists);                      //SeqList<Object>��SeqList<String>�ϲ�
        System.out.println("listobj1="+listobj1.toString()+"��listobj2="+listobj2.toString()+
                         "��lists="+lists.toString());
       
        //����
        Integer[] values=Array1.randomInteger(3, 100);     //����1.4
        SeqList<Integer> listi = new SeqList<Integer>(values);
        listobj1.addAll(listi);                      //SeqList<Object>��SeqList<Integer>�ϲ�
        System.out.println("listobj1="+listobj1.toString());       
        
        //��⡰?��ͨ���
        SeqList<? extends Object> list1 = new SeqList<Object>(); //�﷨��ȷ��listԪ����Object��ĳ������
        SeqList<?> list2 = listobj1;//new SeqList<Object>();          //�﷨��ȷ��Ϊ�Ͼ��д
        System.out.println("list1="+list1.toString());     //listֻ�ܵ���Object�����ķ����������า�ǣ�����ʱ��̬
        System.out.println("list2="+list2.toString());
//      list1.insert("B");                                 //���ܵ������������ķ���

        //���ͼ���̳����������ۣ�SeqList<? extends T>��Ϊ�����ķ���ֵ����??
//ֻ������      SeqList<T> subList(int begin, int end)
        int begin=2, end=5;
//        SeqList<Object> listsub1 = listobj1.subList(begin,end);   //�﷨��ȷ
//        System.out.println("listobj1.subList("+begin+","+end+")="+listsub1.toString());

        
//�������      SeqList<T> subList(int begin, int end)
//������      SeqList<? extends T> subList(int begin, int end)         

        SeqList<?> listsub2 = listobj1.subList(begin,end);
                        //�﷨��ȷ��Ԫ������ΪObject����ΪSeqList��������Ԫ������ΪObject�����н��ͬ��
        System.out.println("listobj2.subList("+begin+","+end+")="+listsub2.toString());

//�������      SeqList<? extends T> subList(int begin, int end)         
//        SeqList<Object> listsub3=listobj1.subList(begin,end); //�﷨�����ܽ���ת��������
//        SeqList<String> listsub4=listobj2.subList(begin,end); //�﷨��
    }
}
/*
�������н�����£�  
listobj1=(A, B, 10, 20, C, D, E) ��listobj2=(C, D, E) ��lists=(C, D, E) 
listobj1=(A, B, 10, 20, C, D, E, 76, 70, 88) 


��1�� SeqList<? extends T>������Ϊ����ֵ����
SeqList<T>���������·���������ֵ����ΪSeqList<T>��Ԫ��������T��

SeqList<T> subList(int begin, int end)              //���ش�begin��end��ɵ��ӱ� 

���·��������ķ���ֵ����ΪSeqList<? extends T>��ϣ������SeqList��Ԫ��������T��ĳ�����࣬����������Ϊ����ȷ��?��T���ĸ����ࡣ

SeqList<? extends T> subList(int begin, int end)        //���������ȷ��?��T���ĸ�����



*/
//@author��Yeheya��2014-10-15