//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2014��12��26��
//��ϰ����ϰ2-11��

//1��DLinkNode<T>�����������£���Ϊnext����ΪNode<T>��������DLinkNode<T>��
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred;                    //prevָ��ǰ�����
    
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
        super(data, next);                       //�����������next����ΪNode<T>�����ṹ����
//        this.data = data;
//        this.next = next;                        //�����this.next����ΪNode<T>�����ṹ����
        this.pred = pred;
    }
    public DLinkNode()
    {
//        super();                          //��������next����ΪNode<T>�����ṹ���ԣ���û��prev��
        this(null, null, null);
    }
}
/*
2�����﷨��DLinkNode<T>�����������£���˫�������뵥�����㣬�������������а�����ϵ�ĸ��
public class DLinkNode<T> extends Node<T> 
{
    public DLinkNode<T> pred, next;              //prevָ��ǰ����㣬nextָ���̽��
    public DLinkNode(T data, DLinkNode<T> pred, DLinkNode<T> next)
    {
//        super(data, next);                     //��������next����ΪNode<T>�����ṹ����
      super(data, null);                         //��
//        this.data = data;
        this.next = next;                        //�ԣ�this.next����super.next������ΪNode<T>��
        this.pred = pred;
    }
    public DLinkNode()
    {
        this(null, null, null);
    }
}*/
