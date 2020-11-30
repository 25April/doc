//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��6��
//5.3   �����
//5.3.3   �����˫����ʾ��ʵ��

//û�б���
public class GenList<T>                                    //˫����ʾ�Ĺ�����࣬û�б���
{
    public GenNode<T> head;                                //ͷָ�룬ָ�����ã�ͷ���

    public GenList()                                       //����չ����
    {
        this.head = new GenNode<T>();                      //����ͷ��㣬3����ֵ��Ϊnull
    }

    //����������atoms�����ṩԭ�ӳ�ֵ��������������Ԫ�ش�����ͬ������β���빹�죬�㷨ͬ������
    public GenList(T[] atoms)
    {
        this();                                            //�����չ����ֻ��ͷ���
        GenNode<T> rear=this.head;
        for (int i=0; i<atoms.length; i++)
        {
            rear.next=new GenNode<T>(atoms[i]);            //β����
            rear = rear.next; 
        }
    }

    public boolean isEmpty()                               //�жϹ�����Ƿ��
    {
        return head.next==null;
    }

    public String toString()                               //���ع��������Ԫ�ص������ַ���
    {
        return this.toString("");
    }
    //���ع��������Ԫ��ֵ��Ӧ���ַ�������ʽΪ��(,)�������������㷨���ݹ鷽��
    public String toString(String str) 
    {
        str+="(";
        for (GenNode<T> p=this.head.next;  p!=null;  p=p.next) 
        {
            if (p.child==null)
                str += p.data.toString();
            else
                str += p.child.toString();                 //�ݹ���ã������ӱ�����ӱ������ַ���
            if (p.next!=null) 
                str += ",";
        }
        return str+")";                                    //�ձ���()
    }

    public int size()                                      //���ع�����ȣ��㷨ͬ������
    {
        int i=0; 
        for (GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            i++;
        return i;
    }
    
    public int depth()                                     //���ع������ȣ��ݹ鷽��
    {
        int max=1;
        for (GenNode<T> p=this.head.next;  p!=null;  p=p.next)
            if (p.child!=null)
            {
                int d=p.child.depth();                     //�ݹ���ã������ӱ����
                if (max<=d)                                //��ס����ӱ����
                    max=d+1;                               //��ǰ��������Ϊ�ӱ���ȼ�1
            }
        return max;
    }
    
    public GenNode<T> insert(int i, T x)                   //����ԭ��x��Ϊ��i��Ԫ�أ��㷨ͬ������
    {
        if (x==null)
            throw new NullPointerException("x==null");     //���ܲ���ն����׳��ն����쳣
        GenNode<T> front=this.head;                        //frontָ��ͷ���
        for (int j=0;  front.next!=null && j<i;  j++)      //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next; 
        front.next=new GenNode<T>(x, null, front.next);    //��front֮�����ֵΪx���
        return front.next;                                 //���ز�����
    }
    public GenNode<T> insert(T x)                          //�ڹ����������ԭ�ӽ�㣬�㷨ͬ������
    {
        return insert(Integer.MAX_VALUE, x);
    }
    
    public GenNode<T> insert(int i, GenList<T> glist)      //�����ӱ���Ϊ��i��Ԫ�أ��㷨ͬ�����������
    {
        if (glist==null)
            throw new NullPointerException("x==null");     //���ܲ���ն����׳��ն����쳣
        GenNode<T> front=this.head;                        //frontָ��ͷ���
        for (int j=0;  front.next!=null && j<i;  j++)      //Ѱ�ҵ�i-1�������һ����㣨frontָ��
            front = front.next; 
        front.next=new GenNode<T>(null, glist, front.next);//��front֮������㣬��ֵ��childָ��glist
        return front.next;                                 //���ز�����
    }    
    public GenNode<T> insert(GenList<T> glist)             //�ڹ�����������ӱ�
    {
        return insert(Integer.MAX_VALUE, glist);
    }
    
    public void remove(int i)                              //ɾ����i��Ԫ��
    {}
   
//    void removeAll();                                    //ɾ�����������Ԫ��
    
}
//@author��Yeheya��2014-10-6

