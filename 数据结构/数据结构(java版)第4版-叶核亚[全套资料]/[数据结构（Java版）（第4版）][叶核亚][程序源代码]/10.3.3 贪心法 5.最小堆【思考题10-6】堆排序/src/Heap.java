//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��27��
//10.3   �㷨��Ʋ���
//10.3.3   ̰�ķ�
//4.  ��С/���

import java.util.Comparator;                     //�Ƚ����ӿ�

//���࣬������С/��ѡ�ʹ��˳���洢��Ԫ�أ�Tָ��Ԫ�����͡�
//֧�����ֱȽ϶����С��ʽ��ÿ����ֻ��ʹ��һ�ַ�ʽ��
//��ָ��Comparator<T>�Ƚ�����
//��δָ���Ƚ�����Ĭ��T extends java.lang.Comparable<? super T>����T��T��ĳ��������ʵ��Comparable<T>�ӿ�
//������Java�׳�����ǿ��ת���쳣
public class Heap<T>
{
    private boolean minheap;                               //ָ����С�ѻ���������
    private SeqList<T> heap;                               //��Ԫ��˳���
    private final Comparator<? super T> comp;              //�Ƚ��������ձ���
    
    public Heap(boolean minheap, Comparator<? super T> comp)  //����նѣ�minָ����С/��ѣ�compָ���Ƚ���
    {
        this.minheap = minheap;
        this.heap = new SeqList<T>();                       //����˳���Ĭ������
        this.comp = comp;   
    } 
    
    public Heap(boolean minheap)                           //����նѣ�minָ����С/��ѣ��Ƚ���Ϊ�ն���
    {
        this(minheap, null);
    }
    public Heap()                                          //������С�ѣ��նѣ��Ƚ���Ϊ�ն���
    {
        this(true, null);
    }
    public Heap(boolean minheap, T[] values, Comparator<? super T> comp) //����ѣ�value�����ṩԪ��
    {
        this(minheap, comp);
        for (int i=0; i<values.length; i++)
            this.insert(values[i]);                        //�Ѳ���Ԫ��
    }

    public boolean isEmpty()                               //�ж��Ƿ�նѣ����շ���true
    {
        return this.heap.isEmpty();
    }
    public int size()                                      //���ض�Ԫ�ظ���
    {
        return this.heap.size();
    }
    public String toString()                               //���ض�Ԫ�������ַ�������ʽΪ��(,)��
    {
        return this.heap.toString();
    }
    
    public void insert(T x)                                //��x���뵽���У����ܲ���null
    {
        this.heap.insert(x);                               //��˳���β���룬˳����Զ����������ݣ����ܲ���null
        for (int i=this.heap.size()/2-1; i>0; i=(i-1)/2)   //���¶��ϵ������Ӷ�����Ϊ��
            sift(i);                                       //����iΪ����������������С/���
        sift(0);                                           //�����ѵĸ�ֵ������ѭ������i==0ʱ��i=(i-1)/2���i=0������ѭ��
        System.out.println("����"+x+"����"+(minheap ? "С":"��")+"�ѣ�"+this.toString());
    }
    
    //����parentΪ����������������С/��ѣ���T�ǿɱȽϴ�С�ģ����ɱȽ���comp�Ƚ�T�����С��
    //˽�з�����ֻ���롢ɾ��ʱ���ã�ȷ��parent�ڷ�Χ��
    //���9�¶�������sift(,parent,,)�������㷨��ͬ
    private void sift(int parent)
    {
        int end=this.size()-1;                             //�����е��ұ߽�
        int child = 2*parent+1;                            //childΪ������parent��������
        T value = this.heap.get(parent);                   //��ø�parent��Ԫ��ֵ
        while (child<=end)                                 //�ؽ�С/��ֵ���ӽ������ɸѡ
        {
            int comp=0;                                    //��¼�Ƚ϶���Ľ��ֵ
            if (child<end)
            {
                T left=this.heap.get(child), right=this.heap.get(child+1); //���Һ��ӽ��ֵ
                if (this.comp==null)
                    comp = ((Comparable<T>)left).compareTo(right); //Ĭ��T����ɱȽϴ�С������Java�׳�����ǿ��ת���쳣
                else comp = this.comp.compare(left, right);//��comp�Ƚ����Ƚ�T�����С
                if (this.minheap ? comp>0 : comp<0)        //����С�ѣ����С������ȴ�
                    child++;                               //childΪ���Һ��ӵĽ�С/����
            }
            if (this.comp==null)                           //������뺢�ӽ��ֵ�Ƚϣ�Ѱ��ԭ��ֵvalue������λ��
                comp = ((Comparable<T>)value).compareTo(this.heap.get(child));
            else  comp = this.comp.compare(value, this.heap.get(child));
            if (this.minheap ? comp>0 : comp<0)            //����ĸ����뺢�ӽ��ֵ�����϶�����
            {
                this.heap.set(parent,this.heap.get(child));//�򽫺��ӽ���е�ֵ��С/��������
                parent = child;                            //parent��child����һ��
                child = 2*parent+1;
            }
            else break;
        }
        this.heap.set(parent,value);                       //����ǰ������ԭ��ֵvalue����������λ��
    }
   
    public T removeRoot()                                  //������С/��ֵ��ɾ����Ԫ�ز�����Ϊ��С/���
    {
        if (this.isEmpty())
            return null;
        T x = (T)this.heap.get(0);                         //��öѸ����Ԫ��
        this.heap.set(0, this.heap.get(this.heap.size()-1));  //�����λ��Ԫ���Ƶ�������ɾ����Ԫ��
        this.heap.remove(this.heap.size()-1);              //˳���βɾ���������Զ���1
        if (this.heap.size()>1)
            sift(0);                                       //���������ֵ���ѵĺ���λ��
        System.out.println("ɾ��"+x+"����"+(minheap ? "С":"��")+"�ѣ�"+this.toString());
        return x;
    }    
}
 
//@author��Yeheya��2014-8-28