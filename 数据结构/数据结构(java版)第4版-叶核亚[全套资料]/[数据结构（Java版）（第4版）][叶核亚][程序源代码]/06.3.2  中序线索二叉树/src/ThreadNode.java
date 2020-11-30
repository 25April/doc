//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��20��
//6.3   ����������

public class ThreadNode<T>                       //�����������Ķ����������࣬Tָ������Ԫ������
{
    public T data;                               //����Ԫ��
    public ThreadNode<T> left, right;            //�ֱ�ָ�����Һ��ӽ��
    public boolean ltag, rtag;                   //�ֱ��ʾ����������ǣ�false��ʾ���ӣ�true��ʾ����

    //�����㣬����������ָ��Ԫ�ء����ӽ�㼰��������ǡ��Һ��ӽ�㼰���������
    public ThreadNode(T data, ThreadNode<T> left, boolean ltag, ThreadNode<T> right, boolean rtag)
    {
        this.data = data;
        this.left = left;
        this.ltag = ltag;
        this.right = right;
        this.rtag = rtag;
    }
    //����ֵΪdata��㣬Ĭ������Һ��ӽ��Ϊ�գ�������־Ϊfalse
    public ThreadNode(T data)
    {
        this(data, null, false, null, false);
    }
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }
    //�����õ�??
    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return !this.ltag && !this.rtag;         
    }
}


// @author  Yeheya��2014-7-20

/*    //���������·���
    public ThreadNode()
    {
        this(null, null, 0, null, 0);
    }
    
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof ThreadNode && this.data.equals(((ThreadNode<T>)obj).data);
    }    
}
*/

