//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��29��
//10.3   �㷨��Ʋ���
//10.3.3   ̰�ķ�
//5.  Kruskal�㷨ʵ��
//��1�� �ߵıȽ�����

//��Ԫ��ıȽ����࣬��ֵ�Ƚ�T�����С��ͼ�ıߵıȽ����࣬��Ȩֵ�Ƚ�T�����С
public class TripleComparator implements java.util.Comparator<Triple>
{
    public int compare(Triple t1, Triple t2)     //�Ƚ�T������Ⱥʹ�С
    { 
        return (int)(t1.value - t2.value);       //��Ԫ�鰴ֵ�Ƚϣ�ͼ�ı߰�Ȩֵ�Ƚ�
    }
}
//@author��Yeheya��2014-8-29

