//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��20��
//6.3.2 ��������������
//1.  ����������������

public class ThreadBinaryTree<T>                 //���������������࣬Tָ������Ԫ������
{
    public ThreadNode<T> root;                   //�����

    public ThreadBinaryTree()                    //�������������������
    {
        this.root = null;
    }

    public boolean isEmpty()                     //�ж��Ƿ�ն�����
    {
        return this.root==null;
    }

    public ThreadBinaryTree(T[] prelist)    //�Ա������������ȸ����й�����������������
    {
        this.root = create(prelist);             //�Ա������������ȸ��������й��������������ʡ��
        inorderThread(this.root);                  //����������������
    }
    private int i=0;
    private ThreadNode<T> create(T[] prelist)    //�Ա������������ȸ��������й�����prelist[i]Ϊ�������������ظ����
    {
        ThreadNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i++];
            if (elem!=null)
            {
                p = new ThreadNode<T>(elem);
                p.left = create(prelist);
                p.right = create(prelist);
            }
        }
        return p;
    }
    
    //2.  ����������������
    private ThreadNode<T> front=null;            //frontָ��p���и������µ�ǰ�����
    private void inorderThread(ThreadNode<T> p)    //������������p���Ϊ��������
    {
        if (p!=null)
        {
            inorderThread(p.left);                 //����������p��������
            if (p.left==null)                    //��p��������Ϊ��
            {
                p.ltag=true;                     //�������������
                p.left=front;                    //����p.leftΪָ��ǰ��front������
            }
            if (p.right==null)                   //��p��������Ϊ��
                p.rtag=true;                     //�������������
            if (front!=null && front.rtag) 
                front.right=p;                   //����ǰ��front.rightΪָ����p������
            front=p;                             //front�ǵõ�ǰp������p��һ�����ʽ���ǰ��
            inorderThread(p.right);                //����������p��������
        }
    }

    //3.  �и����������������������
    //��1�� �������и������µĺ�̽��
    public ThreadNode<T> inNext(ThreadNode<T> p) //����p���и������µĺ�̽��
    {
        if (p.rtag)                              //��������ǣ���p.rightָ��p�ĺ�̽��
            return p.right;
        p=p.right;                               //����p��������
        while (!p.ltag)                          //�ҵ�����ߵĺ�����
            p=p.left;
        return p;
    }
    
    //��4��ʡ�ԣ�ϰ����
    public void inorder()                        //�и�������������������������ǵݹ��㷨
    {
        System.out.print("�и������������������������  ");
        ThreadNode<T> p=this.root;
        while (p!=null && !p.ltag)               //Ѱ�Ҹ�������ߵĺ����㣬����һ�����ʽ��
            p=p.left; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p = this.inNext(p);                  //����p���и������µĺ�̽��
        }
        System.out.println();
    }    

    //��˼����6-5��
    public ThreadNode<T> inPrev(ThreadNode<T> p) //����p���и������µ�ǰ�����
    {
        if (p.ltag)                              //��������ǣ���p.leftָ��p��ǰ�����
            return p.left;
        p=p.left;                                //����p��������
        while (!p.rtag)                          //�ҵ����ұߵ�������
            p=p.right;
        return p;
    }
    public void inorderPrevious()                //�и�������������������������ǵݹ��㷨
    {
        System.out.print("�и����򣨷��򣩱�������������������  ");
        ThreadNode<T> p=this.root;
        while (p!=null && !p.rtag)               //Ѱ�Ҹ������ұߵĺ�����
            p=p.right; 
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p=inPrev(p);                         //����p���и������µ�ǰ�����
        } 
        System.out.println();
    }    
    
    //5.  �ȸ����������������������
    public ThreadNode<T> preNext(ThreadNode<T> p)//����p���ȸ������µĺ�̽��
    {
        if (!p.ltag)                             //��p�����ӣ���p��������p�ĺ��
            return p.left;
        while (p.rtag && p.right!=null)          //����p�����p��Զ�������ȵ��Һ���
            p=p.right;                           //�������������ϣ�Ѱ�ҵ���Զ��������
        return p.right;                          //���ȵ��Һ����Ǻ��
    }
    
    //��˼����6-6��
    public void preorder()                       //�ȸ�������������������������ǵݹ��㷨
    {
        System.out.print("�ȸ������������������������  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=preNext(p))  //����p���ȸ������µĺ�̽��
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
    
    //��˼����6-6��
    public ThreadNode<T> postPrev(ThreadNode<T> p)//����p�ں�������µ�ǰ�����
    {
        if(!p.rtag)                              //��p���Һ��ӣ���p���Һ�����p��ǰ�����
            return p.right;
        while (p.ltag && p.left!=null)           //����p��ǰ�������ֵܻ�����Զ�������ȵ�����
            p=p.left;                            //Ѱ����Զ��������
        return p.left;                           //���ȵ�������ǰ��
    }
    public void postorderPrevious()              //���������������������������ǵݹ��㷨
    {
        System.out.print("������򣨷��򣩱�������������������  ");
        for (ThreadNode<T> p=this.root;  p!=null;  p=postPrev(p))  //����p�ں�������µ�ǰ�����
            System.out.print(p.data.toString()+" ");
        System.out.println();
    }
  //@author  Yeheya��2014-7-20
    
}

//@author  Yeheya��2014-7-20
