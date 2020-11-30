//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//4.4 �ݹ�
//3. ������ĵݹ��㷨
//��˼����4-6��
//������û��rearβָ��

public class RecSinglyList<T> extends Object               //�������࣬TΪ����Ԫ�����ͣ���4��
{
    public Node<T> head;                                   //ͷָ�룬ָ�������ͷ���

    //��1�����췽��
    public RecSinglyList()                                 //���췽��������յ�����
    {
        this.head = new Node<T>();                         //����ͷ��㣬data��nextֵ��Ϊnull
    }
    
    //���ܼ���������values����Ԫ�ع��쵥����
    //�����������values���鳤��Ϊ0������յ�������valuesΪ�ն���Java���׳��ն����쳣��
    //�㷨�����β���롣�ݹ��㷨
    public RecSinglyList(T[] values)
    {
        this();                                  //�����յ�����ֻ��ͷ���
        this.head.next = create(values,0);
    }

    private Node<T> create(T[] values, int i)    //���ش�value�����i��Ԫ�ؿ�ʼ������ӵ����������ص�i����㡣 �ݹ��㷨
    {
        Node<T> p=null;
        if (i<values.length)                     //�ݹ�ִ�����������ڵ�i��Ԫ��
        {
            p = new Node<T>(values[i], null);    //������i�����
            p.next = create(values, i+1);        //�ݹ���ã��ݹ�ͨʽ�������ӵ�i+1��Ԫ�ؿ�ʼ���ӵ�������Ϊp�ĺ��
        }
        return p;
    } 

    //���ܼ����������ص���������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������
    //������������ձ��ء�()��
    //�ݹ��㷨��
    public String toString()
    {
        return this.getClass().getName()+"("+ this.toString(this.head.next) +")";
    }
    private String toString(Node<T> p)           //���ش�p��㿪ʼ���ӵ����������ַ������ݹ鷽��
    {
         if (p==null)                            //�ݹ�����������յ������ؿմ� 
             return "";
         String str=p.data.toString();
         if (p.next!=null) 
             str+=", "; 
         return str+toString(p.next);            //�ݹ���ã��ݹ�ͨʽ�����Ӵ�p��̿�ʼ���ӱ�
    }

    //��˼����4-6��  
    public int size()                            //���ص�������
    {
        return size(this.head.next);
    }
    public int size(Node<T> p)                   //���ش�p��㿪ʼ�ĵ������ȣ��ݹ鷽��
    {
        if (p==null)                             //�ݹ�����������յ�����ĳ���Ϊ0
            return 0;
        return 1+size(p.next);                   //�ݹ���ã��ݹ�ͨʽ����ǰ������Ϊ1�����ϴ�p��̿�ʼ���ӱ���
    }

    //���ܼ������������׸���key���Ԫ�أ������Ҳ��ɹ�����null��
    //�����������keyΪ�ն���Java���׳��ն����쳣��
    //�㷨��˳����ң��ݹ��㷨��
    //˳������׸��ؼ���ΪkeyԪ�أ������״γ��ֵ�Ԫ�أ������Ҳ��ɹ�����null
    public T search(T key)
    {
        return search(this.head.next, key);
    }
    private T search(Node<T> p, T key)           //�ڴ�p��ʼ���ӵ�������˳�������key���Ԫ�أ��ݹ鷽��
    {
        if (p==null)
            return null;
        if (key.equals(p.data))                  //ִ��T���equals(Object)����������ʱ��̬
            return p.data;
        return search(p.next, key);
    }    

    //���ܼ���������������key��ȵ�Ԫ���滻Ϊx��
    //�����������keyΪ�ն���Java���׳��ն����쳣����x�ն��󣬲��滻���׳��ն����쳣��
    //�㷨��˳����ң��ݹ��㷨��
    public void replaceAll(T key, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        replaceAll(this.head.next, key, x);
    }
    private void replaceAll(Node<T> p, T key, T x)    //����p��ʼ���ӵ������У���������key��ȵ�Ԫ���滻Ϊx���ݹ鷽��
    {
        if (p!=null)
        {
            if (p.data.equals(key))
                p.data = x;
            replaceAll(p.next, key, x);
        }
    }
    
    public boolean equals(Object obj)            //�Ƚ�this��obj���õĵ������Ƿ���ȣ�����Object���equals(obj)����
    {
        if (obj == this)
            return true;
        if (obj instanceof RecSinglyList<?>)    
            return equals(this.head.next, ((RecSinglyList<T>)obj).head.next);
        return false;
    }
    private boolean equals(Node<T> p, Node<T> q) //�ȽϷֱ��p��q���������ӵ������Ƿ���ȣ��ݹ鷽��
    {
        return p==null && q==null || 
               p!=null && q!=null && p.data.equals(q.data) && equals(p.next, q.next);
    }

    //���ܼ������������������췽�����������������������list�е�����Ԫ���Ҵ�����ͬ    
    public RecSinglyList(RecSinglyList<T> list)
    {
        this();
        this.head.next = copy(list.head.next);
    }
    private Node<T> copy(Node<T> p)              //���ƴ�p��㿪ʼ���ӵ����������������ӵ�������׽�㡣�ݹ鷽��
    {
        Node<T> q=null;
        if (p!=null)                             //�ݹ�ִ������ 
        {
            q = new Node<T>(p.data, null);       //������p���ֵͬ�Ľ��
            q.next = copy(p.next);               //�ݹ���ã����ƴ�p��̿�ʼ���ӱ���Ϊq�ĺ�� 
        }
        return q;
    }
}
//author��Yeheya��2015-10-14
