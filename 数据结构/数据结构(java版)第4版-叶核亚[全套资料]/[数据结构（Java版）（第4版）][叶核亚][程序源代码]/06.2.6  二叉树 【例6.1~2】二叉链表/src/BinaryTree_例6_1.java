//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��12��
//6.2.6   �������Ķ�������ʵ��
//����6.1��  �������Ĺ��졢���������롣 

public class BinaryTree_��6_1 
{
    public static void main(String args[])
    {                                                           //ͼ6.15��ʾ�������������������ȸ���������
        String[] prelist = {"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree = new BinaryTree<String>(prelist);
        System.out.println("�ȸ����������������  "+bitree.toString());  //����������
        System.out.print("�и����������������  ");  bitree.inorder();
        System.out.print("������������������  ");  bitree.postorder();
        bitree.levelorder();                               //��α���������
        
        bitree.insert(bitree.root.left, "X", true);        //����X�����ΪB�������ӣ�ͼ6.11��a��
        bitree.insert(bitree.root.right, "Y", false);      //����Y�����ΪC�����Һ��ӣ�ͼ6.11��b��
        bitree.insert("Z");                                //�����
        bitree.preorderTraverse();                         //����ȸ�����������У����������������ǵݹ��㷨
        bitree.inorderTraverse();                          //����и�����������У��ǵݹ��㷨
        bitree.postorder();                                //�����������������
        bitree.levelorder();                               //��α���������
    }
}
/*
�������н�����£�
�ȸ����������������  A B D ��G �ġġ�C E �ġ�F H �ġġ�
�и����������������  D G B A E C H F 
������������������  G D B E H F C A 
��α�����������  A B C D E F G H 
�ȸ�����������ǵݹ飩��  Z A B X D �� G �� �� �� �� C E �� �� Y �� F H �� �� �� 
�и�����������ǵݹ飩��  D G X B A E C Y H F Z 
G D X B E H F Y C A Z 
��α�����������  Z A B C X E Y D F G H 



*/


//@author��Yeheya��2015-3-20