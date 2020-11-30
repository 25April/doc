//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��23��
//6.5.3   ���ĸ�ĸ�����ֵ�����ʵ��
//3.  ���ĺ������ʾ��

public class Trees
{
    //�Ժ������ʾ��������prelist����洢����ɭ�֣��ĺ������ʾ�ַ�������
    //�ǵݹ��㷨����������ӷ�ʽ��û�е��÷��ء������㷽��
    public static Tree<String> create(String[] prelist)
    {
        Tree<String> tree = new Tree<String>();            //��������
        if (prelist.length==0)
            return tree;                                   //���ؿ���
        tree.root = new TreeNode<String>(prelist[0],1);    //��������㣬���Ϊ1
        TreeNode<String> p = tree.root;
        for (int i=1; i<prelist.length; i++)     //��prelist[i]������Ϊɭ�������һ�����������һ������
        {
            int n=0;
            while (n<prelist[i].length() && prelist[i].charAt(n)=='\t')
                n++;                             //ͳ��prelist[i]����'\t'ǰ׺����
            
            String str = prelist[i].substring(n);//���Ԫ�أ�ȥ��prelist[i]��������'\t'ǰ׺
            if (n==p.level)                      //prelist[i]��p��һ��'\t'ǰ׺��������Ϊp�ĵ�0������
            {
                p.child = new TreeNode<String>(str, p.level+1, p, null, null);
                p = p.child;
            }
            else
            {
                while (n<p.level-1)              //prelist[i]��p��'\t'�٣�p����Ѱ�Ҳ���λ��
                    p = p.parent;
                p.sibling = new TreeNode<String>(str, p.level, p.parent, null, null);//ͬ�㣬������Ϊp�����¸��ֵ�
                p = p.sibling;
            }
        }
        return tree;
    }    
}
//@author  Yeheya��2015-3-6


