//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��23��
//2.3.3   ˫����
//4.  ����ѭ��˫����
//��9�� 9.5.3   ˫����������㷨

//����ѭ��˫�����ࣨ���򣩣�T��T��ĳ�����������ʵ��Comparable<T>�ӿڣ��̳�ѭ��˫������
public class SortedCirDoublyList<T extends Comparable<? super T>>
    extends CirDoublyList<T>
{
    //���췽���������ͷ�����ͬ����������4��ʡ��
    public SortedCirDoublyList()                           //�����ѭ��˫����
    {
        super();                                           //Ĭ�ϵ��ø����޲������췽���������ѭ��˫������ʡ��
    }
/*    public SortedCirDoublyList(T[] values)               //���죬��ֵ����values����Ԫ�ء�ֱ�Ӳ��������㷨   //��ʵ����9-4�� 
    {
        super();
        for (int i=0; i<values.length; i++)                //ֱ�Ӳ��������㷨 
            this.insert(values[i]);                        //��ֵ����
    }*/
    public SortedCirDoublyList(SortedCirDoublyList<T> list)//����ѭ��˫�����������췽��
    {
        super(list);                                       //���ø���ͬ�����Ĺ��췽��������ʡ��
    }   
    //�ɵ�����list��������ѭ��˫��������������췽����ֱ�Ӳ��������㷨ͬ�ɵ���������������
    public SortedCirDoublyList(SinglyList<T> list)
    {
        super();                                           //�����ѭ��˫����
        for (Node<T> p=list.head.next;  p!=list.head;  p=p.next)//ֱ�Ӳ��������㷨
            this.insert(p.data);                           //��ֵ����
    }
    
    //��֧�ָ����set(int i, T x)��insert(int i, T x)���������串�ǲ��׳��쳣����4��ʡ��
    public void set(int i, T x)
    {
        throw new UnsupportedOperationException("set(int i, T x)");
    }
    public DoubleNode<T> insert(int i, T x)
    {
        throw new UnsupportedOperationException("insert(int i, T x)");
    }
    
    //��4��
    //����x��x!=null������x�����С˳�����ȷ������λ�ã������ڵ�ֵ���֮ǰ��
    //���ز����㡣O(n)�����Ǹ����insert(x)����
    public DoubleNode<T> insert(T x)
    {
        if (this.isEmpty() || x.compareTo(this.head.prev.data)>0)
            return super.insert(x);               //���ø��౻���ǵ�insert(T)���������ֵ������ͷ���֮ǰ����β���룬O(1)
        DoubleNode<T> p=this.head.next;
        while (p!=head && x.compareTo(p.data)>0)           //Ѱ�Ҳ���λ�ã�pָ��
            p = p.next;
        DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //��p���֮ǰ����ֵΪx���
        p.prev.next = q;
        p.prev = q;
        return q;                                          //���ز�����
    }

    //��4�桾ʵ��2-9��
    //˳������׸���key���Ԫ�أ����ؽ�㣬�����Ҳ��ɹ�����null��O(n)�����ǣ��ȽϹ���ͬ
    //�㷨ͬ��������
    public DoubleNode<T> search(T key) 
    {
        for (DoubleNode<T> p=this.head.next;  p!=head && key.compareTo(p.data)>=0;  p=p.next)
        {
            System.out.print(p.data+"��");
            if (key.compareTo(p.data)==0)                  //��compareTo()�ṩ�Ƚ϶����С����ȵ�����
                return p;
        }
        return null; 
    }

    public DoubleNode<T> insertDifferent(T x)              //���벻�ظ�Ԫ�أ����ز����㣻���ǣ����ܵ��ò��ҷ���
    {
        DoubleNode<T> p=this.head.next;
        while (p!=this.head && x.compareTo(p.data)>0)      //������x���Ԫ�ؽ�㣨pָ�򣩣�Ѱ�Ҳ���λ��
            p = p.next;
        if (p!=this.head && x.compareTo(p.data)==0)
            return null;                                   //�������ظ�Ԫ��
        DoubleNode<T> q = new DoubleNode<T>(x, p.prev, p); //��p���֮ǰ����ֵΪx���
        p.prev.next = q;
        p.prev = q;
        return q;                                          //���ز�����
    }
    
    //ɾ���׸���key���Ԫ�ؽ�㣬���ر�ɾ��Ԫ�أ����Ҳ��ɹ�����null��O(n)��
    //�̳У����У����õĲ��ҷ���ִ������ķ���ʵ�֣��ȽϹ���ͬ��
//    public T remove(T key)
//  public void removeALL(T key)

    //���ϵ�2��ADT
    
    //��9�� 9.5.3 ѭ��˫����������㷨
    //����������췽������ѭ��˫����list��������ѭ��˫�������������㷨 
    public SortedCirDoublyList(CirDoublyList<T> list)
    {
        super(list);                                       //���listѭ��˫����
        System.out.println("ѭ��˫����Ŀ�������");
        quickSort(head.next, head.prev);
    }    
    //һ�˿�������begin��endָ�������еĿ�ʼ������㣬�ݹ��㷨
    private void quickSort(DoubleNode<T> begin, DoubleNode<T> end)
    {
        if (begin!=end && begin!=end.next)                 //�ų��պ͵�����������
        {
            DoubleNode<T> front=begin, rear=end;
            T vot=front.data;                              //��һ��ֵ��Ϊ��׼ֵ
            while (front!=rear)                            //һ������
            {
                while (front!=rear && rear.data.compareTo(vot)>=0) //�Ӻ���ǰѰ�ҽ�Сֵ
                    rear=rear.prev;
                if (front!=rear)
                {
                    front.data = rear.data;                //��СԪ����ǰ�ƶ�
                    front=front.next;
                }
                while (front!=rear && front.data.compareTo(vot)<=0) //��ǰ���Ѱ�ҽϴ�ֵ
                    front=front.next;
                if (front!=rear)
                {
                    rear.data = front.data;                //�ϴ�Ԫ������ƶ�
                    rear=rear.prev;
                }
            }
            front.data=vot;                                //��׼ֵ��������λ��
            System.out.println(begin.data+".."+end.data+",  vot="+vot+"  "+this.toString());
            quickSort(begin, rear.prev);                   //ǰ�������������򣬵ݹ����
            quickSort(front.next, end);                    //��������������򣬵ݹ����
        }
    }

    
    //��ʵ��9-4�������鹹������ѭ��˫����ֱ��ѡ�����򣬽���Ԫ���㷨
    //n-1�ˣ�ÿ�˱���������Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ�棬��ɾ���Ͳ����㡣�㷨ͬ��������
    public SortedCirDoublyList(T[] values)                 //�����������ж�����빹������ѭ��˫����
    {
        super(values);                                     //�����鹹��ѭ��˫����β����
        System.out.println("ѭ��˫�����ֱ��ѡ������");
        for (DoubleNode<T> first=head.next;  first!=head;  first=first.next) //firstָ�������˫�����һ�����  
        {                              //n-1�ˣ�ÿ�˱���˫����Ѱ�ҵ���Сֵ��㣬�������Ԫ�ص�ǰ��
            DoubleNode<T> min=first;                        //minָ����Сֵ���
            for (DoubleNode<T> p=min.next;  p!=head;  p=p.next) //p����ѭ��˫����һ�ˣ��ҳ���Сֵ���
                if (p.data.compareTo(min.data)<0)          //�Ƚϣ�min��ס��Сֵ���
                    min = p;
            if (min!=first)                                //����min���Ԫ�ص�ǰ��
            {
                T temp = min.data;
                min.data = first.data;
                first.data = temp;
            }
//            System.out.println(this.toString());
        }
    }
    
    //��ʵ��9-4���鲢��������ѭ��˫������list�����н��鲢��this�У��ϲ�������listΪ��
    public void merge(SortedCirDoublyList<T> list)  
    {
//        System.out.println("�鲢����ѭ��˫����merge");
        DoubleNode<T> p=this.head.next;                    //p����thisѭ��˫��������Ҫ�ǵ�ǰ�����
        DoubleNode<T> q=list.head.next;                    //q����listѭ��˫����
        while (p!=this.head && q!=list.head)               //������������ѭ��˫����
            if ((p.data).compareTo(q.data)<0)              //��p���ֵС����p����ǰ��
                p = p.next;
            else                                           //���򣬽�q�����뵽p���֮ǰ
            {
                q.prev = p.prev;
                p.prev.next = q;
                p.prev = q;
                q = q.next;
                q.prev.next = p;
            }
        if (q!=list.head)                                  //��list������ʣ���㲢��thisβ
        {
            q.prev = this.head.prev;
            this.head.prev.next = q;
            list.head.prev.next=this.head;                 //ʹthis��list����������ӳ�Ϊ����
            this.head.prev = list.head.prev;
        }
        list.head.prev = list.head;                        //�ϲ�������listΪ��
        list.head.next = list.head;
    }
    //����this��list�鲢�������ѭ��˫�������򣩣����ı�this��list��һ�ι鲢�㷨
    public SortedCirDoublyList<T> mergeWith(SortedCirDoublyList<T> list)  
    {
//        System.out.println("�鲢����ѭ��˫����mergeWith");
        DoubleNode<T> p=this.head.next, q=list.head.next;  //p��q�ֱ����this��list
        SortedCirDoublyList<T> result = new SortedCirDoublyList<T>();
        DoubleNode<T> rear=result.head;                    //rearָ��result����β��׼������
        while (p!=this.head || q!=list.head)               //������������ѭ��˫����
            if (p!=this.head && (q!=list.head && (p.data).compareTo(q.data)<=0 || q==list.head))
            {                                              //����this��㣬��p���ֵС����q�ѽ���
                rear.next = new DoubleNode<T>(p.data, rear, null);
                rear = rear.next;
                p = p.next;
            }
            else if (q!=list.head && (p!=this.head && (p.data).compareTo(q.data)>0 || p==this.head))
            {                                              //���򣬸���list��㣬��q���ֵС����p�ѽ���
                rear.next = new DoubleNode<T>(q.data, rear, null);
                rear = rear.next;
                q = q.next;
            }
        result.head.prev = rear;                           //����result���ɻ���
        rear.next = result.head;
        return result;
    }
}
//@author��Yeheya��2014-8-21


