//�����ݽṹ��Java�棩����4�棩ϰ���𡷣����ߣ�Ҷ���ǣ�2015��3��20��
//8.5.1   ����������
//��ϰ������8.1���ж�һ�ö������Ƿ�Ϊ���������������������㷨    
//�㷨��ȷ

public class BinaryTree_isSorted 
{
    private static BinaryNode<?> bfront;
//  private static BinaryNode<T> front=null;         //���У�static������֧�ַ���<T>
    
    //�ж�һ�ö������Ƿ�Ϊ������������T����ʵ��Comparable<? super T>�ӿ�
    public static<T extends Comparable<? super T>> boolean isSorted(BinaryTree<T> bitree)
    {
        bfront=null;
        return isSorted(bitree.root);
    }
    
    //�ж���pΪ���������Ƿ�Ϊ������������bfront����p���и����������µ�ǰ����㡣
    //���и��������һ�ö�����������Ԫ�ذ�������������һ�ö�����������
    //��������洢�Ķ��������и���������ǵݹ��㷨��
    private static<T extends Comparable<? super T>> boolean isSorted(BinaryNode<T> p)
    {
        if (p==null)
            return true;    
        if (!isSorted(p.left))                              //�ж�p��������
            return false;    
        if (bfront!=null && p.data.compareTo((T)bfront.data)<0) 
        {
            System.out.println("front.data="+bfront.data+"��p.data="+p.data);//����м�������ʡ��
            return false;
        }
        bfront=p;
        return isSorted(p.right);                          //�ж�p��������
    }

    //���ö������������������㷨�������ڶ�������洢�Ķ��������ݹ��㷨
    private static TriNode<?> sfront;
    //�ж�һ�ö������Ƿ�Ϊ������������T����ʵ��Comparable<? super T>�ӿ�
    public static<T extends Comparable<? super T>> boolean isSorted(BinarySortTree<T> bstree)
    {
        sfront=null;
        return isSorted(bstree.root);
    }
    
    //�ж���pΪ���������Ƿ�Ϊ������������sfront����p���и����������µ�ǰ����㡣
    //���и��������һ�ö�����������Ԫ�ذ�������������һ�ö������������ݹ��㷨��
    private static<T extends Comparable<? super T>> boolean isSorted(TriNode<T> p)
    {
        if (p==null)
            return true;    
        if (!isSorted(p.left))                             //�ж�p��������
            return false;    
        if (sfront!=null && p.data.compareTo((T)sfront.data)<0) 
            return false;
        sfront=p;
        return isSorted(p.right);                          //�ж�p��������
    }
    
    //���ö������������������㷨����������������洢�Ķ����������и������������ǵݹ��㷨��
    //�ж�һ�ö������Ƿ�Ϊ������������T����ʵ��Comparable<? super T>�ӿ�
    //���и��������һ�ö�����������Ԫ�ذ�������������һ�ö������������ݹ��㷨��
    public static<T extends Comparable<? super T>> boolean isSorted2(BinarySortTree<T> bstree)
    {
        TriNode<?> front=null;                             //front����p���и����������µ�ǰ�����
        for (TriNode<T> p=bstree.first(bstree.root);  p!=null;  p=bstree.next(p)) 
        {
            if (front!=null && p.data.compareTo((T)front.data)<0) 
            {
                System.out.println("front.data="+front.data+"��p.data="+p.data);//����м�������ʡ��
                return false;
            }
            front=p;
        }
        return true;    
    }

    public static void main(String args[])
    {
        //��ϰ������8.1��ϰͼ8.5�����������������ȸ�����
        Integer[] prelist={6,3,1,null,4,2,null,null,5,null,null,null,8,7,null,9};
        BinaryTree<Integer> bitree = new BinaryTree<Integer>(prelist);
        System.out.print("��ϰ������8.1��ϰͼ8.5���и���������������� ");
        bitree.inorder();
        System.out.println("�Ƕ����������� "+isSorted(bitree));

        //����ȫ���������ԣ�����������У���ȫ�������Ĳ�����У�������ȫ������
        Integer[] values=Array1.randomInteger(10,100);            //��1.4
/*        System.out.print("\n��������У� ");
        Array1.print(values);
        bitree = new CompleteBinaryTree<Integer>(values);
        bitree.levelorder();
        System.out.print("�и����������ȫ�������� ");
        bitree.inorder();
        System.out.println("�Ƕ����������� "+isSorted(bitree));*/
        
        //�ö������������ԣ�����������й���
        System.out.print("\n��������У� ");
        Array1.print(values);
        BinarySortTree<Integer> bstree = new BinarySortTree<Integer>(values);
        System.out.print("�и���������������� ");
        bstree.inorder();
        System.out.println("��������洢���ݹ��㷨���Ƕ����������� "+isSorted(bstree));
        System.out.println("��������洢�������㷨���Ƕ����������� "+isSorted2(bstree));
    }
}
/*
�������н�����£�
��ϰ������8.1��ϰͼ8.5���и���������������� 1 2 4 5 3 6 7 9 8 
front.data=5��p.data=3
�Ƕ����������� false

��������У�  80 41 96 80 71 53 29 6 4 18
��α�����������  80 41 96 80 71 53 29 6 4 18 
�и����������ȫ�������� 6 80 4 41 18 71 80 53 96 29 
front.data=80��p.data=4
�Ƕ����������� false

��������У�  80 41 96 80 71 53 29 6 4 18
�и���������������� [4 6 18 29 41 53 71 80 96 ]
��������洢���ݹ��㷨���Ƕ����������� true
��������洢�������㷨���Ƕ����������� true


��������У�  33 76 62 1 61 93 48 40 61 35
��α�����������  33 76 62 1 61 93 48 40 61 35 
�и����������ȫ�������� 40 1 61 76 35 61 33 93 62 48 
front.data=40��p.data=1
�Ƕ����������� false

��������У�  33 76 62 1 61 93 48 40 61 35
�и���������������� [1 33 35 40 48 61 62 76 93 ]
�Ƕ����������� true
*/
//author��Yeheya��2015-3-21
