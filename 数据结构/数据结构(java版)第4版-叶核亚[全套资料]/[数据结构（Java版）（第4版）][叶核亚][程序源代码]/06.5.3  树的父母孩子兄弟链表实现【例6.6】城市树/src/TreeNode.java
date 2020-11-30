//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��23��
//6.5.3   ���ĸ�ĸ�����ֵ�����ʵ��
//1. ���ĸ�ĸ�����ֵ���������

public class TreeNode<T>                         //���ĸ�ĸ�����ֵ��������࣬Tָ������Ԫ������
{
    public T data;                               //������
    public TreeNode<T> parent, child, sibling;   //��ĸ����������ӽ�������ֵܽ����
    public int level;                            //�����
    
    //�����㣬�����ֱ�ָ��Ԫ�ء�����Ρ���ĸ��㡢���ӽ����ֵܽ��
    public TreeNode(T data, int level, TreeNode<T> parent, TreeNode<T> child, TreeNode<T> sibling)
    {
        this.data = data;
        this.level = level;
        this.parent = parent;
        this.child = child;
        this.sibling = sibling;
    }
    public TreeNode(T data, int level)           //����ָ��ֵ�Ͳ�ε�Ҷ�ӽ��
    {
        this(data, level, null, null, null);
    }
    public String toString()                     //���ؽ��������������ַ���
    {
        return this.data.toString();
    }    
    
    public boolean isLeaf()                      //�ж��Ƿ�Ҷ�ӽ��
    {
        return this.child==null;
    }    
}
/*
    //���������·���
    public TreeNode()
    {
        this(null, 0, null, null, null);
    }
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        return obj==this || obj instanceof TreeNode<?> && this.data.equals(((TreeNode<T>)obj).data);
    }    
*/
//@author  Yeheya��2014-7-23
