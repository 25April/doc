//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��19��
//6.2.6   �������Ķ�������ʵ��
//7.  �������Ĺ�����ʾ
//����6.2�� �������Ĺ�����ʾ�� 

public class BinaryTree_��6_2
{    
    public static void main(String args[])
    {
        String genlist;// = "AA(BB(DD(^,G),^),C(E,F(H,^)))";  //ͼ6.18��ʾ�������Ĺ�����ʾ
//        genlist = "";//"A(B,C)";
        genlist = "A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))";
        
        BinaryTree<String> bitree = BinaryTrees.createByGenList(genlist);               
        bitree.printGenList();                             //����������Ĺ�����ʾ�ַ��� 
        //ϰ��6
//        System.out.println("�Ƿ���ȫ��������  "+bitree.isCompleteBinaryTree());  
        
        
    }
}
/*
�������н�����£�
�������Ĺ�����ʾ��AA(BB(DD(^,G),^),C(E,F(H,^)))
�Ƿ���ȫ��������  false

�������Ĺ�����ʾ��A(B,C)
�Ƿ���ȫ��������  true

�������Ĺ�����ʾ����
�Ƿ���ȫ��������  true

�������Ĺ�����ʾ��A(B,C(D(F,G(J,^)),E(H(K,L),I(^,M))))
�Ƿ���ȫ��������  false

*/

//@author��Yeheya��2014-10-7
