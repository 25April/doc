//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��6��
//5.3   �����
//5.3.3   �����˫����ʾ��ʵ��
//�����˫����ʾ�Ľ����

public class GenNode<T>                                    //�����˫����ʾ�Ľ���࣬Tָ������Ԫ������
{
    public T data;                                         //������
    public GenList<T> child;                               //��ַ��ָ���ӱ�
    public GenNode<T> next;                                //��ַ��ָ���̽��

    //�����㣬dataָ��Ԫ�أ�childָ���ӱ�nextָ���̽��
    public GenNode(T data, GenList<T> child, GenNode<T> next) 
    {
        this.data = data;
        this.child = child;
        this.next = next;
    }
    public GenNode(T data)
    {
        this(data, null, null);
    }
    public GenNode()
    {
        this(null, null, null);
    }
}
//author��Yeheya��2014-7-17
