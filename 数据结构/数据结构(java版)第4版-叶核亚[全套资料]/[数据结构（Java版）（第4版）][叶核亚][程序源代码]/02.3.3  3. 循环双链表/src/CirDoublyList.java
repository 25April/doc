//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��23��
//2.3.3   ˫����
//3. ѭ��˫����

//ѭ��˫�����࣬ʵ��ADT List<T>�����ķ�����T��ʾ����Ԫ�ص���������
public class CirDoublyList<T>
{
    public DoubleNode<T> head;                             //ͷָ��

    public CirDoublyList()                                 //�����ѭ��˫����
    {
        this.head = new DoubleNode<T>();                   //����ͷ��㣬3����ֵ��Ϊnull
        this.head.prev = this.head;
        this.head.next = this.head;
    }
    public boolean isEmpty()                               //�ж�ѭ��˫�����Ƿ��
    {
        return this.head.next==this.head;
    }

    //����x��Ϊ��i��Ԫ�أ����ز����㡣��x==null���׳��ն����쳣��
    //�����i��ȡ�ݴ��ʩ����i<0������x����ǰ����i>n������x�����O(n)
    public DoubleNode<T> insert(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        DoubleNode<T> front=this.head;      
        for (int j=0; front.next!=this.head && j<i; j++)   //Ѱ�ҵ�i-1���������һ����frontָ��
            front = front.next; 
        //������front֮�����x��㣬����ͷ���루i��0�����м�/β���루i>0��
        DoubleNode<T> q=new DoubleNode<T>(x, front, front.next);
        front.next.prev = q;
        front.next = q;
        return q;                                          //���ز�����
    }
    public DoubleNode<T> insert(T x)             //β����xԪ�أ�����x��㡣�㷨��ͷ���֮ǰ���룬O(1)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        DoubleNode<T> q = new DoubleNode<T>(x, head.prev, head); 
        head.prev.next = q;                                //��ͷ���֮ǰ���룬�൱��β����
        head.prev = q;
        return q;
    }
    
    //���¡�˼����2-8������Ա�����Ĺ���ͬ��������4��̲�ʡ��    
    public CirDoublyList(T[] values)                       //����ѭ��˫������values�����ṩԪ�أ�β����
    {
        this();                                            //������ѭ��˫����ֻ��ͷ���
        DoubleNode<T> rear=this.head;
        for (int i=0; i<values.length; i++)
        {
            rear.next=new DoubleNode<T>(values[i], rear, this.head);   //β����
            rear = rear.next; 
        }
        this.head.prev = rear;
    }
    
    public CirDoublyList(CirDoublyList<T> list)            	//������췽��������ѭ��˫����
    {
        this();                                          	//������ѭ��˫����ֻ��ͷ���
        DoubleNode<T> rear = this.head;
        for (DoubleNode<T> p=list.head.next;  p!=list.head;  p=p.next)
        {
        	rear.next = new DoubleNode<T>(p.data, rear, this.head);
            rear = rear.next; 
        }
        this.head.prev = rear;
    }

    
    //��˼����2-�����½̲�ûд
    public T get(int i)                            //���ص�i��Ԫ�أ�0��i<���ȡ���iԽ�磬����null��O(n)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        return (i>=0 && p!=null) ? p.data : null;          //��pָ���i����㣬������Ԫ��ֵ
    }
    
    //���õ�i��Ԫ��Ϊx��0��i<���ȡ���iԽ�磬�׳����Խ���쳣����x==null���׳��ն����쳣��O(n)
    public void set(int i, T x)
    {
        if (x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=null && j<i; j++)
            p = p.next;
        if (i>=0 && p!=null)
            p.data = x;                                    //pָ���i�����
        else throw new IndexOutOfBoundsException(i+"");    //�׳����Խ���쳣
    }
    
    public int size()                                      //����ѭ��˫������
    {
        int i=0; 
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)//ѭ�������뵥����ͬ
            i++;
        return i;
    }   
    
    public String toString()           //����ѭ��˫��������Ԫ�ص������ַ�����ѭ��˫��������㷨��O(n)
    {
        String str=this.getClass().getName()+"(";          //��������
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            str += p.data.toString();
            if (p.next!=this.head) 
                str += ",";
        }
        return str+")";                                    //�ձ���()
    }
    
    //����Ϊѭ��˫�������ӵĳ�Ա����
    //����ѭ��˫��������Ԫ�ص������ַ�����Ԫ�ش���Ӻ���ǰ����O(n)�����裬���ȶ�����
    public String toPreviousString()
    {
        String str=this.getClass().getName()+"(";          //��������
        for (DoubleNode<T> p=this.head.prev; p!=this.head;  p=p.prev)
        {
            str += p.data.toString();
            if (p.prev!=this.head) 
                str += ",";
        }
        return str+")";                                    //�ձ���()
    }    
    public void print()                                    //���˫��
    {
        System.out.print("(");
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
        {
            System.out.print(p.data.toString());
            if (p.next!=this.head) 
                System.out.print(",");
        }
        System.out.print(")��(");
        for (DoubleNode<T> p=this.head.prev; p!=this.head;  p=p.prev)
        {
            System.out.print(p.data.toString());
            if (p.prev!=this.head) 
                System.out.print(",");
        }
        System.out.println(")");
    }
    
    //ɾ����i��Ԫ�أ����ر�ɾ��Ԫ�أ�0��i<n����iԽ�磬��ɾ��������null��O(n)
    public T remove(int i)
    {
        DoubleNode<T> p=this.head.next;
        for (int j=0; p!=head && j<i; j++)                 //����Ѱ�ҵ�i����㣨pָ��
            p = p.next;
        if (p!=head && i>=0)
        {
            p.prev.next = p.next;                          //ɾ��p��㣬��JVM�Ժ��ͷ�
            p.next.prev = p.prev;
            return p.data;                                 //����p���Ԫ��
        }
        return null;                                       //��i<0��i>��ʱ
//        throw new IndexOutOfBoundsException(i+"");         //�׳����Խ���쳣
    }
    public void clear()                                    //ɾ��ѭ��˫��������Ԫ��
    {
        this.head.prev = head;
        this.head.next = head;
    }

    //ɾ�����һ��Ԫ�أ����ر�ɾ��Ԫ�ء�������գ�����null��
    //�㷨ɾ��ͷ����ǰ����㣬O(1)�����裬���ȶ�����
    public T removeLast()
    {
        DoubleNode<T> p=this.head.prev;                    //pָ��ͷ����ǰ����㣬��ɾ��
        if (p!=head)
        {
            p.prev.next = this.head;                       //ɾ��p��㣬��JVM�Ժ��ͷ�
            this.head.prev = p.prev;
            return p.data;                                 //����p���Ԫ��
        }
        return null;                                       //��i<0��i>��ʱ
//        throw new IndexOutOfBoundsException(i+"");         //�׳����Խ���쳣
    }
    
    
    //˳������״γ��ֵ���key���Ԫ�أ����ؽ�㣬�����Ҳ��ɹ�����null���㷨ͬ������
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=this.head;  p=p.next)
            if (key.equals(p.data))
                return p;
        return null;
    }
    public DoubleNode<T> insertDifferent(T x)             //���벻�ظ�Ԫ�ء����Ҳ��ɹ�ʱβ����
    {
    	return null;//??
    }
    
    //ɾ���׸���key���Ԫ�ؽ�㣬���ر�ɾ��Ԫ�أ����Ҳ��ɹ�����null��O(n)��
    //�㷨���ò��ҷ������������಻��Ҫ���ǣ�search(key)��������ʱ��̬
    public T remove(T key)
    {
        DoubleNode<T> find=search(key);                    //˳����ң����ؽ��
        if (find!=null)
        {
            find.prev.next = find.next;                    //ɾ��find����Լ�
            find.next.prev = find.prev;
            return find.data;
        }
        return null;
    }

    //�Ƚ�����ѭ��˫�����Ƿ���ȣ�����Object���equals(obj)�������㷨ͬ������
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;
        if (!(obj instanceof CirDoublyList<?>))
            return false;
        DoubleNode<T> p=this.head.next;
        CirDoublyList<T> list = (CirDoublyList<T>)obj;
        DoubleNode<T> q=list.head.next;
        while (p!=head && q!=list.head && p.data.equals(q.data))
        {
            p=p.next;
            q=q.next;
        }
        return p==head && q==list.head;
    }    
    //����ʵ��ADT List<T>

    
    //��ϰ������2.2��
    //����4�������ṩ��������ѭ��˫����ʽ
    public DoubleNode<T> first()                           //����ѭ��˫�����һ����㣨��ͷ��㣩��O(1)
    {
        return (head.next==head) ? null : head.next;
    }
    public DoubleNode<T> next(DoubleNode<T> p)             //����p�ĺ�̽�㣬O(1)
    {
        return (head.next==head || p==null || p==head || p==head.prev) ? null : p.next;
    }
    public DoubleNode<T> previous(DoubleNode<T> p)         //����p��ǰ����㣬O(1)
    {
        return (head.next==head || p==null || p==head || p==head.next) ? null : p.prev;
    }
    public DoubleNode<T> last()                            //����ѭ��˫�������һ����㣬O(1)
    {
        return (head.prev==head) ? null : head.prev;
    }
    
    //��ϰ������2.3���������
    //��thisѭ��˫����֮�󣬺ϲ�����list�����н�㣬������listΪ��
    public void addAll(CirDoublyList<T> list) 
    {
        DoubleNode<T> rear=head.prev; 
        rear.next = list.head.next;
        list.head.next.prev = rear;
        rear=list.head.prev;
        rear.next = this.head;
        this.head.prev = rear;
        list.head.prev = list.head; 
        list.head.next = list.head; 
    }    
}