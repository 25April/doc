//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��20��
//6.3.2 ��������������
        //����

public class ThreadBinaryTree_traverse
{
    public static void main(String args[])
    {
        //ͼ6.23��ʾ�������������������ȸ�����
        String[] prelist = {"A","B","D",null,null,"E","G",null,null,null,"C","F",null,"H",null,null,"K"};
        ThreadBinaryTree<String> tbitree = new ThreadBinaryTree<String>(prelist);    //������������������
        tbitree.preorder();                                 //�ȸ��������
        tbitree.inorder();                                  //�и��������
        tbitree.inorderPrevious();                          //�и������������ǰ����
        tbitree.postorderPrevious();                        //��������������ǰ����
    }
}
/*
�������н�����£�
�ȸ������������������������  A B D E G C F H K 
�и������������������������  D B G E A F H C K 
�и����򣨷��򣩱�������������������  K C H F A E G B D 
������򣨷��򣩱�������������������  A C K F H B E G D 

*/
//@author  Yeheya��2015-2-11
    	