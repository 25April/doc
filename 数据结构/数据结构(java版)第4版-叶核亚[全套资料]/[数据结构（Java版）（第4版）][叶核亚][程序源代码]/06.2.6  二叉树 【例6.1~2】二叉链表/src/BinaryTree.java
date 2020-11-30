//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��19��
//6.2.6   �������Ķ�������ʵ��
//2.  ���ö�������洢�Ķ�����������
//��˼����6-2�� ���ڱ����Ĳ���
//����6.1��  �������Ĺ��졢���������롣

public class BinaryTree<T>                       //�������࣬��������洢��Tָ������Ԫ������ 
{
    public  BinaryNode<T> root;                  //����㣬����������ṹ

    public BinaryTree()                          //����ն�����
    {
        this.root=null;
    }
    public boolean isEmpty()                     //�ж��Ƿ�ն�����
    {
        return this.root==null;
    }

    //3. �������Ĳ�����
    public BinaryNode<T> insert(T x)             //����x��Ϊ����㣬ԭ�������Ϊx�����ӣ����ز�����
    {
        return this.root = new BinaryNode<T>(x, this.root, null);
    }
    //ע�⣺��������ΪinsertRoot(T x)����Ϊ���÷������������������า�ǡ�
    
    //����xΪparent������/�Һ��ӣ�leftChildָ�����ӣ�ȡֵΪtrue���󣩡�false���ң���
    //parent��ԭ��/�Һ��ӳ�Ϊx������/�Һ��ӣ����ز����㡣
    //��x==null�������룬����null����parent==null��Java�׳��ն����쳣��
    public BinaryNode<T> insert(BinaryNode<T> parent, T x, boolean leftChild)
    {
        if (x==null)
            return null;
        if (leftChild)                           //����xΪparent������/�Һ��ӣ����ز�����
            return parent.left=new BinaryNode<T>(x, parent.left, null);
        return parent.right=new BinaryNode<T>(x, null, parent.right);
    }    

    //4.  ������ɾ������
    //ɾ��parent���������������leftChildָ��������ȡֵΪtrue���󣩡�false���ң���
    //Java�Զ��ջر�ɾ������ռ�õĴ洢�ռ䡣
    public void remove(BinaryNode<T> parent, boolean leftChild)
    {
        if (leftChild)
            parent.left = null;                  //��parent==null��Java�׳��ն����쳣
        else  parent.right = null;
    }    
    public void clear()                                    //ɾ�������������н��
    {
        this.root = null;
    }

    //5. �������������ȵı����㷨
    public void preorder()                                 //����ȸ������������
    {
//        System.out.print("�ȸ����������������  ");
        preorder(this.root);                               //�����ȸ���������������ĵݹ鷽��
        System.out.println();
    }    
    private void preorder(BinaryNode<T> p)                 //�ȸ����������p���Ϊ�����������ݹ鷽��
    {
        if (p!=null)                                       //������������
        {
            System.out.print(p.data.toString()+" ");       //�ȷ��ʵ�ǰ���Ԫ��
            preorder(p.left);                              //���ȸ��������p�����������ݹ���ã�����Ϊ����
            preorder(p.right);                             //���ȸ��������p�����������ݹ���ã�����Ϊ�Һ���
        }
    }
    
    public String toString()                               //�����ȸ�����������������н��������ַ���
    {
        return toString(this.root);
    }
    private String toString(BinaryNode<T> p)               //�����ȸ����������pΪ�������������ַ������ݹ鷽��
    {
        if (p==null)
            return "��";                                    //������������
        return p.data.toString()+" " + toString(p.left) + toString(p.right);
    }

    public void inorder()                                  //����и������������
    {
//        System.out.print("�и����������������  ");
        inorder(this.root);
        System.out.println();
    }    
    private void inorder(BinaryNode<T> p)                  //�и����������p���Ϊ�����������ݹ鷽��
    {
        if (p!=null)
        {
            inorder(p.left);                               //�и��������p�����������ݹ����
            System.out.print(p.data.toString()+" ");
            inorder(p.right);                              //�и��������p�����������ݹ����
        }
    }

    public void postorder()                                //�����������������
    {
//        System.out.print("������������������  ");
        postorder(this.root);
        System.out.println();
    }
    private void postorder(BinaryNode<T> p)                //������������p���Ϊ�����������ݹ鷽��
    {
        if (p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data.toString()+" ");       //����ʵ�ǰ���Ԫ��
        }
    }

    //��˼����6-2�� ���ڱ����Ĳ�����ϰ����
    public int size()                                      //���ض������Ľ����
    {
        return size(root);
    }
    public int size(BinaryNode<T> p)                       //������p���Ϊ���������Ľ����
    {
        if (p==null)
            return 0;
        return 1+size(p.left)+size(p.right);
    }

    public int height()                                    //���ض������ĸ߶�
    {
        return height(root);
    }
    public int height(BinaryNode<T> p)                     //������p���Ϊ���������߶ȣ�����������
    {
        if (p==null)
            return 0;
        int lh = height(p.left);                           //�����������ĸ߶�
        int rh = height(p.right);                          //�����������ĸ߶�
        return (lh>=rh) ? lh+1 : rh+1;                     //��ǰ�����߶�Ϊ�ϸ������ĸ߶ȼ�1
    }

    //6. ���������
    //��2�� �������������ȸ����б�ʾ
    public BinaryTree(T[] prelist)                         //�Ա������������ȸ��������й��������
    {
        this.root = create(prelist);
    }
    //�Դ�i��ʼ�ı������������ȸ����У�����һ����prelist[i]Ϊ�������������ظ���㣬�ݹ鷽��
    private int i=0;
    private BinaryNode<T> create(T[] prelist)
    {
        BinaryNode<T> p = null;
        if (i<prelist.length)
        {
            T elem=prelist[i];
            i++;
            if (elem!=null)                                //����elem!="��"����ΪT��һ����String
            {
                p = new BinaryNode<T>(elem);               //����Ҷ�ӽ��
                p.left = create(prelist);                  //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
                p.right = create(prelist);                 //����p�����������ݹ���ã�ʵ�ʲ�������ʽ������ͬ
            }
        }
        return p;
    }
    //����6.1��  �������Ĺ��졢���������롣
    

    //��˼����6-3����ϰ����
    public BinaryTree(BinaryTree<T> bitree)      //�������췽�������
    {
        this.root = copy(bitree.root);
    }

    //������p�����Ӷ������������½��Ӷ������ĸ����
    private BinaryNode<T> copy(BinaryNode<T> p)
    {
        if (p==null)
            return null;
        BinaryNode<T> q = new BinaryNode<T>(p.data);
        q.left = copy(p.left);                   //�������������ݹ����
        q.right = copy(p.right);                 //�������������ݹ����
        return q;                                //���ؽ��������ĸ����
    }
    
    //7.  �������Ĺ�����ʾ
    //��1�� ������ʾ
    public void printGenList()                             //����������Ĺ�����ʾ�ַ���
    {
        System.out.print("�������Ĺ�����ʾ��");
        printGenList(this.root);
        System.out.println();
    }
    //�����p���Ϊ����һ�������Ĺ�����ʾ�ַ������ȸ�����������ݹ��㷨
    private void printGenList(BinaryNode<T> p)
    {
        if (p==null)                                       //����������
            System.out.print("��");                         //������������
        else            
        {   System.out.print(p.data.toString());           //���ʵ�ǰ���
            if (p.left!=null || p.right!=null)             //��Ҷ�ӽ�㣬������
            {
                System.out.print("(");
                printGenList(p.left);                      //���p�����������ݹ����
                System.out.print(",");
                printGenList(p.right);                     //���p�����������ݹ����
                System.out.print(")");
            }
        }
    }
    //����6.2�� �������Ĺ�����ʾ��
    //author��Yeheya��2014-7-19
    
    //8.  �������������ȱ����ķǵݹ��㷨
    public void preorderTraverse()                         //�ȸ���������������ķǵݹ��㷨
    {
        System.out.print("�ȸ�����������ǵݹ飩��  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>(); //������ջ
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                System.out.print(p.data+" ");              //���ʽ��
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                System.out.print("�� ");
                p=stack.pop();                             //pָ���ջ���
                p=p.right;                                 //����������
            }
        System.out.println();
    }    

    public void inorderTraverse()                         //�и���������������ķǵݹ��㷨
    {
        System.out.print("�и�����������ǵݹ飩��  ");
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();   //����һ����ջ
        BinaryNode<T> p = this.root;
        while (p!=null || !stack.isEmpty())                //p�ǿջ�ջ�ǿ�ʱ
            if (p!=null)
            {
                stack.push(p);                             //p�����ջ
                p=p.left;                                  //����������
            }
            else                                           //pΪ����ջ�ǿ�ʱ
            {
                p=stack.pop();                             //pָ���ջ���
                System.out.print(p.data+" ");              //���ʽ��
                p=p.right;                                 //����������
            }
        System.out.println();
    }    

    //9. �������Ĳ�α���
    public void levelorder()                               //����α���������
    {
        System.out.print("��α�����������  ");
        SeqQueue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>(); //�����ն���
//        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //�����ն���
        BinaryNode<T> p=this.root;                         //�����û�����
        while (p!=null)
        {
            System.out.print(p.data+ " ");                 //����p���
            if (p.left!=null)    
                que.add(p.left);                           //p�����ӽ�����
            if (p.right!=null)
                que.add(p.right);                          //p���Һ��ӽ�����
            p=que.poll();                                  //pָ����ӽ�㣬�����пշ���null
        }
        System.out.println();
    }

    //Ҳ�ɣ��������ӣ��㷨ͬͼ��һ�ι��������������
    public void levelorder2()                               //����α���������
    {
        System.out.print("��α�����������  ");
        SeqQueue<BinaryNode<T>> que=new SeqQueue<BinaryNode<T>>(); //�����ն���
//        LinkedQueue<BinaryNode<T>> que=new LinkedQueue<BinaryNode<T>>(); //�����ն���
        if (this.root==null)
            return;
        que.add(this.root);                                //��������
        while (!que.isEmpty())
        {
            BinaryNode<T> p=que.poll();                    //pָ����ӽ�㣬�����пշ���null
            System.out.print(p.data+ " ");                 //����p���
            if (p.left!=null)    
                que.add(p.left);                           //p�����ӽ�����
            if (p.right!=null)
                que.add(p.right);                          //p���Һ��ӽ�����
        }
        System.out.println();
    }   
    
}
