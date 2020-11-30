//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��23��
//6.5.3   ���ĸ�ĸ�����ֵ�����ʵ��
//��4�����������в������

public class Tree<T>                             //���࣬���ĸ�ĸ�����ֵ����洢�ṹ��Tָ������Ԫ������
{
    public TreeNode<T> root;                     //����㣬���ĸ�ĸ�����ֵ�����������

    public Tree()                                //�������
    {
        this.root=null;         
    }
    public boolean isEmpty()                     //�ж��Ƿ����
    {
        return this.root==null;
    }
    
    //3. ���ĺ������ʾ��
    public String toString()                     //�������ĺ������ʾ�ַ��������ȸ����������
    {
        return "���ĺ������ʾ�� \n "+toString(root,"");
    }
    //�ȸ����������pΪ����������tabָ�������������������ĺ������ʾ�ַ������ݹ��㷨
    private String toString(TreeNode<T> p, String tab)
    {
        if (p==null)
            return "";
        return tab+p.data.toString()+"\n" + toString(p.child,tab+"\t") + toString(p.sibling,tab);//�ݹ����
    }
    //����6.6��   �����ĺ������ʾ����һ�ó�������ɭ�֣���
   
    
    //���µ�4��̲�δ����
    //�����ȸ��ͺ����������㷨
    public void preorder()                                 //��������ȸ�����������У��㷨ͬ������
    {
        System.out.print("�����ȸ�����������У�  ");   
        preorder(root);
        System.out.println();   
    }    
    private void preorder(TreeNode<T> p)                   //�ȸ����������pΪ�����������ݹ��㷨
    {
        if (p!=null)
        {
            System.out.print(p.data+" ");
            preorder(p.child);                             //�ݹ����
            preorder(p.sibling);
        }
    }
    public void postorder()                                //������ĺ�������������
    {
        System.out.print("���ĺ������������У�  ");   
        postorder(root);
        System.out.println();   
    }
    private void postorder(TreeNode<T> p)                  //������������pΪ�����������ݹ��㷨���㷨ͬ���������и��������
    {
        if (p!=null)
        {
            postorder(p.child);
            System.out.print(p.data+" ");
            postorder(p.sibling);
        }
    }

    public int size()                                      //�������Ľ��������㷨ͬ������
    {
        return size(root);
    }
    public int size(TreeNode<T> p)                         //������p���Ϊ���������Ľ�����
    {
        if (p==null)
            return 0;
        return 1+size(p.child)+size(p.sibling);
    }
    
    public Tree(Tree<T> tree)                              //�������췽�����㷨ͬ��������洢�Ķ�����
    {   this.root = copy(tree.root, null);
    }
    //�����������p����������parent�Ǹ��������ĸ�ĸ��㣬�����½������ĸ����
    public TreeNode<T> copy(TreeNode<T> p, TreeNode<T> parent)
    {
        if (p==null)
            return null;
        TreeNode<T> q = new TreeNode<T>(p.data, p.level, parent, null, null);
        q.child = copy(p.child, q);                        //���ƺ����������ݹ����
        q.sibling = copy(p.sibling, q);                    //�����ֵ��������ݹ����
        return q;                                          //���ؽ��������ĸ����
    }
    
    public TreeNode<T> insertRoot(T x)                     //����Ԫ��x��Ϊ����㣬ԭ�������Ϊ�亢�ӽ�㣬���ز�����
    {
        this.root = new TreeNode<T>(x, 1, null, this.root, null);
        if (this.root.child!=null)
        {
            this.root.child.parent = this.root;
            setLevel(this.root.child, this.root.level+1);  //������this.root.childΪ�����������н����
        }
        return this.root;
    }
    
    protected void setLevel(TreeNode<T> p, int level)      //������p���Ϊ�����������н����
    {
        if (p!=null)
        {
            p.level = level;
            setLevel(p.child, level+1);                    //�ݹ����
            setLevel(p.sibling, level);                    //�ݹ����
        }
    }
    
    public void clear()                                    //ɾ���������н��
    {
        this.root = null;
    }
}
//@author  Yeheya��2015-3-7
