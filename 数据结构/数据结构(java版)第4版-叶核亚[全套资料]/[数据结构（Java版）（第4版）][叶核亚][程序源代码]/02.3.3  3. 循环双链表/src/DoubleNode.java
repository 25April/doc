//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��21��
//2.3.3   ˫����
//1. ˫������

public class DoubleNode<T>                       //˫�������࣬Tָ������Ԫ������
{
    public T data;                               //�����򣬴洢����Ԫ��
    public DoubleNode<T> prev, next;             //��ַ��prevָ��ǰ����㣬nextָ���̽��

    //�����㣬dataָ��Ԫ�أ�prevָ��ǰ����㣬nextָ���̽��
    public DoubleNode(T data, DoubleNode<T> prev, DoubleNode<T> next)
    {
        this.data = data;                        //T�������ø�ֵ
        this.prev = prev;                        //DoubleNode<T>�������ø�ֵ
        this.next = next;
    }
    public DoubleNode(T data)
    {
        this(data, null, null);
    }
    public DoubleNode()
    {
        this(null, null, null);
    }
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }    
}
//@author��Yeheya��2014-10-9
