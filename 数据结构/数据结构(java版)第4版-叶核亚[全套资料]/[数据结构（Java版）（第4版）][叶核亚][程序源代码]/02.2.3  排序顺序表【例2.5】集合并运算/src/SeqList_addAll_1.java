//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��15��
//��2.2.3  ����˳���
//����2.5��  ʹ�����Ա��ʾ���ϣ�ʵ�ּ������㡣
//��1�� ���������Ա��ʾ���ϵ�����

public class SeqList_addAll_1 
{
    public static void main(String args[])
    {
        //����SeqList<String>�ϲ�����β��� 
        String[] stra={"E","D"}, strb={"C","B","A"};        
        SeqList<String> lista = new SeqList<String>(stra);        
        SeqList<String> listb = new SeqList<String>(strb);           
        lista.addAll(listb);                               //����SeqList<String>�ϲ�����β��� 
        System.out.println("lista="+lista.toString()+"��listb="+listb.toString());

        //����SortedSeqList<String>�ϲ����������� 
        lista = new SortedSeqList<String>(stra);           //���������������ʵ��     
        listb = new SortedSeqList<String>(strb);           
        lista.addAll(listb);                               //����SortedSeqList<String>�ϲ����������� 
        System.out.println("lista="+lista.toString()+"��listb="+listb.toString());
    }
}
/*
�������н�����£�  
lista=(E, D, C, B, A) ��listb=(C, B, A)                     //�ϲ�����β��� 
lista=(A, B, C, D, E) ��listb=(A, B, C)                     //��������
*/