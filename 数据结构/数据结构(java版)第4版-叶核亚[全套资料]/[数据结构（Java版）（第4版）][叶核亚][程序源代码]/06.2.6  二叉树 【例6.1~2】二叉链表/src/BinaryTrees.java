//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��19��
//6.2.6   �������Ķ�������ʵ��
//7.  �������Ĺ�����ʾ
//����6.2�� �������Ĺ�����ʾ�� 

public class BinaryTrees                                   //Ϊ�ض����������Ӿ�̬����
{    
    private static int i=0;
    //�����Թ�����ʾ�ַ���genlist����Ķ�����
    public static BinaryTree<String> createByGenList(String genlist)
    {
        BinaryTree<String> bitree = new BinaryTree<String>();
        i=0;
        if (genlist.length()>0)
            bitree.root = create(genlist);                 //����������������ֵ��genlist[0]
        return bitree;
    }    
   
    //�Դ�i��ʼ�Ĺ�����ʾ�ַ�������һ����genlist[i]Ϊ�������������ظ���㣬�ݹ��㷨
    private static BinaryNode<String> create(String genlist)
    {
        BinaryNode<String> p = null;
        char ch=genlist.charAt(i);
        if (ch=='��')
        {   i++;                                           //����'��'
            return null;
        }
        int end=i;
        while (end<genlist.length() && ch!='(' && ch!=',' && ch!=')')
        {                                                  //һ��Ԫ��ռ����ַ�����(��,��)�ָ�
            end++;
            ch=genlist.charAt(end);
        }
        String str = genlist.substring(i,end);             //��ô�i��end-1���Ӵ������
        i=end;
        p = new BinaryNode<String>(str);                   //����Ҷ�ӽ��
        if (genlist.charAt(i)=='(')
        {
            i++;                                           //����'('
            p.left = create(genlist);                      //�������������ݹ����
            i++;                                           //����','
            p.right = create(genlist);                     //�������������ݹ����
            i++;                                           //����')'
        }
        return p;                                          //�մ�����null
    }    
}


//@author��Yeheya��2014-10-7
