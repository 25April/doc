//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��3��20��
//8.5.1   ����������
//��ϰ������8.1���ж�һ�ö������Ƿ�Ϊ���������������������㷨    

public class BinaryTree_isSorted_error 
{
    //�ж�һ�ö������Ƿ�Ϊ������������T����ʵ��Comparable<? super T>�ӿ�
    public static<T extends Comparable<? super T>> boolean isSorted(BinaryTree<T> bitree)
    {
        return isSorted(bitree.root);
    }
    //�ж���pΪ���������Ƿ�Ϊ�������������ݹ鷽�����ȸ��������
    //�㷨���ݶ������������壬�д�
    private static<T extends Comparable<? super T>> boolean isSorted(BinaryNode<T> p)
    {
        if (p==null)
            return true;
        if ((p.left==null || p.left!=null && p.data.compareTo(p.left.data)>0) &&
            (p.right==null || p.right!=null && p.data.compareTo(p.right.data)<0))
            return isSorted(p.left) && isSorted(p.right);
        return false;
    }
  
    public static void main(String args[])
    {
        Integer[] prelist={6,3,1,null,4,2,null,null,5,null,null,null,8,7,null,9}; //�������������ȸ�����
        BinaryTree<Integer> bitree = new BinaryTree<Integer>(prelist);
        bitree.inorder();
        System.out.println("�Ƕ����������� "+isSorted(bitree));
     }
}
/*
�������н�����£�
�и����������������  1 2 4 5 3 6 7 9 8 
�Ƕ����������� true                                               //�������
*/    
//author��Yeheya��2015-3-21
