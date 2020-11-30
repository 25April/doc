//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��11��
//4.2.5   ���ȶ���

//���ȶ����ࣨ������򣩣������࣬ʵ�ֶ��нӿڡ�ʹ������ѭ��˫����洢����Ԫ�أ�Ԫ�ذ����ȼ���������
public final class PriorityQueue<T extends Comparable<? super T>>  implements Queue<T> 
{
    private SortedCirDoublyList<T> list;         //ʹ������ѭ��˫����洢���ȶ���Ԫ��
    private boolean asc;                         //ascָ������true������false��
    
    public PriorityQueue(boolean asc)            //����ն��У�ascָ������true������false��
    {
        this.list = new SortedCirDoublyList<T>();
        this.asc = asc;
    }
    public PriorityQueue()                       //����ն��У�Ĭ������
    {
        this(true); 
    }
    public boolean isEmpty()                     //�ж϶����Ƿ�գ����շ���true
    {
        return this.list.isEmpty();
    }

    public boolean add(T x)                      //Ԫ��x��ӣ��ն��������
    {
        return this.list.insert(x)!=null;        //����ѭ��˫����ֵ����
    } 

    public T peek()                              //���ض�ͷԪ�أ�û��ɾ���������пգ��򷵻�null
    {
        return this.asc ? this.list.get(0) : this.list.head.prev.data;
                   //�������ȶ��е�����������ԣ�����ʱ�����ض�ͷԪ�أ�����ʱ�����ض�βԪ��
    } 

    public T poll()                              //���ӣ����ض�ͷԪ�أ������пշ���null
    {
        return this.asc ? this.list.remove(0) : this.list.removeLast();
                   //�������ȶ��е�����������ԣ�����ʱ�����ض�ͷԪ�أ�ɾ����ͷ��㣻����ʱ�����ض�βԪ�أ�ɾ����β���
    } 

    public String toString()                     //���ض�������Ԫ�ص������ַ���
    {
        return this.getClass().getName()+" "+
               (this.asc ? this.list.toString() : this.list.toPreviousString());
    }
}



//@author��Yeheya��2014-7-11
