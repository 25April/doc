//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2015��3��21��
//8.5.1   ����������

//�����������࣬T��T��ĳ��������ʵ��Comparable<T>�ӿ�
public class BinarySortTree<T extends Comparable<? super T>>
{
    public TriNode<T> root;                                //����㣬����������ṹ

    public BinarySortTree()                                //����ն���������
    {
        this.root=null;
    }
    public BinarySortTree(T[] values)                      //�����������������values�����ṩԪ��
    {
        this();                                            //����ն���������
        this.addAll(values);                               //����values��������Ԫ��
    } 
  
    public boolean isEmpty()                               //�ж��Ƿ�ն�����
    {
        return this.root==null;
    }

    //2.  ���Ҳ���
    //���ҹؼ���ΪkeyԪ�أ������ҳɹ������ؽ�㣬���򷵻�null���ǵݹ��㷨��//��key==null��Java�׳��ն����쳣
    //�����㷨����һ���Ӹ�������·�����ǵݹ飬���Ҳ��ɹ�������·���ǴӸ���Ҷ�ӡ�
    public TriNode<T> searchNode(T key)
    {
        TriNode<T> p=this.root;
        while (p!=null && key.compareTo(p.data)!=0)
        {
//            System.out.print(p.data+"? ");       //��ʾ���Ҿ����Ľ��ֵ����ʡ��
            if (key.compareTo(p.data)<0)                   //��key��С
                p=p.left;                                  //����������
            else
                p=p.right;                                 //����������
        }
        return p!=null ? p : null;                         //�����ҳɹ������ؽ�㣬���򷵻�null
    }
    public T search(T key)                                 //���ҹؼ���ΪkeyԪ�أ������ҳɹ�������Ԫ�أ����򷵻�null
    {
        TriNode<T> find = this.searchNode(key);
        return find!=null ? find.data : null;
    }
    
    //3.  �������
    //����Ԫ��x��㣬������ؼ����ظ�Ԫ�غͿն��󣬷��ز������״̬��//��x==null��Java�׳��ն����쳣
    public boolean add(T x)
    {
        if (this.root==null)
            this.root=new TriNode<T>(x);                   //���������
        else                                               //��x���뵽��rootΪ���Ķ�����������
        {
            TriNode<T> p=this.root, parent=null;
            while (p!=null)                                //����ȷ������λ��
            {
                if (x.compareTo(p.data)==0)
                    return false;                          //���ҳɹ���������ؼ����ظ���Ԫ��
                parent = p;
                if (x.compareTo(p.data)<0)
                    p=p.left;
                else  p=p.right;
            }
            if (x.compareTo(parent.data)<0)                //����xҶ�ӽ����Ϊparent����/�Һ���
                parent.left = new TriNode<T>(x, parent, null, null);
            else parent.right = new TriNode<T>(x, parent, null, null); 
        }
        return true;
    }
    //˼���⣺�ܷ�ֱ�ӵ��ò����㷨ȷ������λ�ã�Ϊʲô��
    
    //4.  �и������������
    //�����и�����������������н��������ַ����������������ǵݹ��㷨
    public String toString()
    {
        String str="["; 
        TriNode<T> p = this.first(this.root);              //Ѱ�ҵ�һ�����ʽ�㣬��Сֵ
        while (p!=null)
        {
            str += p.data.toString()+" ";
            p = this.next(p);                              //����p���и������µĺ�̽��
        }
        //Ҳ��
//        for (TriNode<T> p=this.first(this.root); p!=null; p=this.next(p)) //�и������������
//            str += p.data.toString()+" ";      
        return str+"]";
    }

    public void inorder()                                  //���и����������������������н��Ԫ�أ��ǵݹ��㷨
    {
        System.out.print("["); 
        TriNode<T> p = this.first(this.root);              //Ѱ�ҵ�һ�����ʽ�㣬��Сֵ
        while (p!=null)
        {
            System.out.print(p.data.toString()+" ");
            p = this.next(p);                              //����p���и������µ�ǰ�����
        }
        System.out.println("]");
    }

    //����pΪ���������У������и������µ�һ�����ʽ�㣬���Ǹ�������ߵ������㣬��Сֵ
    public TriNode<T> first(TriNode<T> p)
    {
        if (p!=null)
            while (p.left!=null)
                p = p.left;
        return p;
    }
    
    public TriNode<T> next(TriNode<T> p)                   //����p���и������µĺ�̽��
    {
        if (p!=null)
        {
            if (p.right!=null)                             //��p���Һ��ӣ�
                return this.first(p.right);                //��p�ĺ��������������һ�����ʽ��
            while (p.parent!=null)                         //��pû���Һ��ӣ�����Ѱ��ĳ�����Ƚ��
            {
                if (p.parent.left==p)                      //��p���丸ĸ�����ӣ���p�ĺ�����丸ĸ
                    return p.parent;
                p=p.parent;
            }
        }
        return null;
    }

    //��˼����8-4��
    //�и�������������������򣩣�������н��Ԫ�ء�
    //�����㷨���и����������һ�����ʽ�㣨���ֵ����ʼ�����ε���ǰ������ٷ��ʡ�
    public void inorderPrevious()
    {
        System.out.print("["); 
        for (TriNode<T> p=this.last(this.root);  p!=null;  p=this.previous(p)) 
            System.out.print(p.data.toString()+" ");
        System.out.println("]");
    }
    //����pΪ���������У������и����������һ�����ʽ�㣬���Ǹ������ұߵ������㣬���ֵ
    public TriNode<T> last(TriNode<T> p)
    {
        if (p != null)
            while (p.right != null)
                p = p.right;
        return p;
    }
    public TriNode<T> previous(TriNode<T> p)               //����p���и������µ�ǰ�����
    {
        if (p != null)
        {
            if (p.left!=null)                              //��p�����ӣ���p��ǰ���������������һ�����ʽ��
                return this.last(p.left);
            while (p.parent!=null)                         //��pû�����ӣ�����Ѱ��ĳ�����Ƚ��
            {
                if (p.parent.right==p)                     //��p���丸ĸ���Һ��ӣ���p��ǰ�����丸ĸ
                    return p.parent;
                p=p.parent;
            }
        }
        return null;
    }
    
    public boolean contains(T key)                         //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.searchNode(key)!=null;
    }
    public void addAll(T[] values)                         //����values��������Ԫ��
    {
        for (int i=0; i<values.length; i++)
            this.add(values[i]);                           //����Ԫ��
    }
    public void clear()                                    //ɾ������Ԫ��
    {
        this.root=null;                                    //Java�Զ��ͷŲ��ٱ�ʹ�õĴ洢��Ԫ
    }

    public int size()                                      //����Ԫ�ظ���
    {
        return 0;//??this.set.size(); 
    }
    //����8.4��  ʹ�ö�����������ʾ��������򼯺ϡ�
    
    //6.  ɾ������
    //ɾ���ؼ���Ϊkey��㣬���ر�ɾ��Ԫ�أ���û�ҵ���ɾ��������null��//�ǵݹ��㷨����key==null��Java�׳��ն����쳣
    public T remove(T key)    
    {
        TriNode<T> p = this.searchNode(key);               //���ҹؼ���ΪkeyԪ�أ������ҳɹ������ؽ�㣬���򷵻�null
        if (p!=null && p.left!=null && p.right!=null)      //�ҵ���ɾ�����p����p��2�Ƚ��
        {
            TriNode<T> insucc = this.first(p.right);       //Ѱ��p���и������µĺ�̽��insucc
            T temp = p.data;                               //������ɾ��Ԫ�أ���Ϊ����ֵ
            p.data = insucc.data;                          //�Ժ�̽��ֵ�滻p���ֵ
            insucc.data = temp;
            p = insucc;                                    //ת��Ϊɾ��insucc��ɾ��1��0�Ƚ��
        }
        
        if (p!=null && p==this.root)                       //p��1�Ȼ�Ҷ�ӽ�㣬ɾ������㣬p.parent==null
        {
            if (this.root.left!=null)
                this.root = p.left;                        //��p�����Ӷ�����Ϊ�µĸ����
            else
                this.root = p.right;                       //��p���Һ��Ӷ�����Ϊ�µĸ����
            if (this.root!=null)
                this.root.parent = null;
            return p.data;                                 //���ر�ɾ�������Ԫ��
        }
        
        if (p!=null && p==p.parent.left)                   //p��1�Ȼ�Ҷ�ӽ�㣬p�Ǹ�ĸ������
            if (p.left!=null)
            {
                p.parent.left = p.left;                    //��p�����Ӷ���
                p.left.parent = p.parent;                  //p�����ӵ�parent��ָ��p�ĸ�ĸ
            }
            else
            {
               p.parent.left = p.right;                    //��p���Һ��Ӷ���
                if (p.right!=null)
                    p.right.parent = p.parent;
            }
        
        if (p!=null && p==p.parent.right)                  //p��1�Ȼ�Ҷ�ӽ�㣬p�Ǹ�ĸ���Һ���
            if (p.left!=null)
            {
                p.parent.right = p.left;                   //��p�����Ӷ���
                p.left.parent = p.parent;
            }
            else
            {
               p.parent.right = p.right;                  //��p���Һ��Ӷ���
                if (p.right!=null)
                    p.right.parent = p.parent;
            }
        return p!=null ? p.data : null;
    }
    public T removeRoot()                                 //ɾ������㣬����ԭ�����Ԫ��
    {
        return this.remove(this.root.data);
    }
    
    //��ʵ����8-2��
    public void printASL()                                 //���ƽ�����ҳ���ASL�����ҳɹ��������㹫ʽ���������Ĳ�α����㷨
    {
        System.out.print("ASL�ɹ�=(");
//        SeqQueue<TriNode<T>> que=new SeqQueue<TriNode<T>>();  //�����ն���
        LinkedQueue<TriNode<T>> que=new LinkedQueue<TriNode<T>>();
        int asl=0, n=0, count=0, level=1;
        for (TriNode<T> p=this.root;  p!=null;  p=que.poll())   //����α����������������û�����
        {
            if (level(p)==level)                           //��p�����Ϊ��ǰ��Σ������
                 n++;                                      //��ǰ��Ľ�����
            else
            {
                System.out.print((asl==0 ? "" : "+")+level+"*"+n);//�����һ��ļ��㹫ʽ
                asl+=level*n;
                count+=n;                                  //�������Ľ�����
                level++;                                   //��һ��
                n=1;
            }
            if (p.left!=null)    
                que.add(p.left);                           //p�����ӽ�����
            if (p.right!=null)
                que.add(p.right);                          //p���Һ��ӽ�����
        }
        if (count==0)
            System.out.println(") = 0");
        else
        {
            System.out.print("+"+level+"*"+n);             //���һ��
            asl+=level*n;
            count+=n;
            System.out.println(")/"+count+" ="+asl+"/"+count+" ="+((asl+0.0)/count));
        }
    }   
    
    //����p������ڵĲ�Σ�������Ĳ��Ϊ1����������δ���ҵ�x����0
    private int level(TriNode<T> p)
    { 
        int level = 0;
        while (p!=null)
        {   level++;
            p=p.parent;
        }
        return level;
    }
}
//@author��Yeheya��2015-3-20
  
