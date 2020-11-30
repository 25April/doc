//ADT ���ӿ�

//ADT Tree<T>                               	          //�������������ͣ�T��ʾ���Ԫ������
public interface TTree<T>                                  //���ӿڣ�����ADT Tree�﷨
{ 
    boolean isEmpty();                                     //�ж��Ƿ����
    int level(T key);                                      //���عؼ���Ϊkey������ڵĲ��
    int size();                                            //�������Ľ����
    int height();                                          //�������ĸ߶�

    void preorder();                                       //��������ȸ������������
    void postorder();                                      //������ĺ�������������
    void levelorder();                                     //������Ĳ�α�������

    TreeNode<T> insertRoot(T x);                           //����Ԫ��x��Ϊ����㲢����
    TreeNode<T> insertChild(TreeNode<T> p, T x, int i);    //����x��Ϊp���ĵ�i����0��������
    void remove(TreeNode<T> p, int i);             	       //ɾ��p���ĵ�i����0��������
    void clear();                                          //ɾ���������н��

    TreeNode<T> search(T key);                             //���Ҳ����عؼ���Ϊkey�Ľ��
    boolean contains(T key);                               //�ж��Ƿ�����ؼ���ΪkeyԪ��
    T remove(T key);                                       //ɾ����key���Ϊ��������
}
