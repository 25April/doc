//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.4.1   ɢ�б�
//��������ַ����ɢ�б��࣬�������롢ɾ�������ҡ������Ȳ�����

public class HashSet<T>  //implements Set<T>           //ɢ�б��࣬��������ַ��
//extends MyAbstractSet<T> //10.2
{
    private SinglyList<T>[] table;                         //ɢ�б�ͬ��ʵ������������
    private int count = 0;                                 //Ԫ�ظ���
    private static final float LOAD_FACTOR = 0.75f;        //װ�����ӣ�Ԫ�ظ���������֮��
//    private static final float MIN_CAPACITY = 16;          //Ĭ����С��
    
    public HashSet(int length)                             //��������Ϊlength��ɢ�б�
    {
        if (length<10)                                     //Ϊ��ͼ8.12��ͼ8.14
        	length=10;                                     //������С����
    	this.table = new SinglyList[length];
        for (int i=0; i<this.table.length; i++)
            this.table[i] = new SinglyList<T>();           //����յ�����
//        this.enlarge(capacity);
    }
    public HashSet()                                       //�����ɢ�б�Ĭ������
    {
        this(16); 
    }

    //ɢ�к���������ؼ���ΪxԪ�ص�ɢ�е�ַ����x==null��Java�׳��ն����쳣
    private int hash(T x)
    {
        int key = Math.abs(x.hashCode());                  //ÿ�������hashCode()��������int
        return key % this.table.length;                    //������������������ɢ�б�����
    }
    
    public T search(T key)                       //���ز��ҵ��Ĺؼ���ΪkeyԪ�أ������Ҳ��ɹ�����null
    {
        Node<T> find = this.table[this.hash(key)].search(key); //�ڵ������в��ҹؼ���ΪkeyԪ��
        return find==null ? null : find.data;
    }
    public boolean add(T x)                                //����xԪ�أ���xԪ�عؼ����ظ����򲻲���
    {
        if (this.count>this.table.length*LOAD_FACTOR)      //��ɢ�б���������������
        {
            this.printAll();
            System.out.print("\n���"+x+"��");
            
        	SinglyList<T>[] temp = this.table;             //ɢ�б�ͬ��ʵ������������
            this.table = new SinglyList[this.table.length*2];
            for (int i=0; i<this.table.length; i++)
                this.table[i] = new SinglyList<T>(); 
            this.count=0;
            for (int i=0; i<temp.length; i++)              //����ԭ��ͬ��ʵ��������ԭ����Ԫ��
                for (Node<T> p=temp[i].head.next;  p!=null;  p=p.next)
                    this.add(p.data);
        }        
        boolean insert=this.table[this.hash(x)].insertDifferent(x)!=null;
        if (insert)                                        //������β����ؼ��ֲ��ظ�Ԫ��
            this.count++;
        return insert;
        
        //��5��??    
/*Ҳ��        T find = this.search(x);                           //����
        if (find==null)                                    //���Ҳ��ɹ�����ؼ��ֲ��ظ�Ԫ�أ�������ͷ���룬���򡣣�������ҪinsertDifferent(x)
        {
            this.table[this.hash(x)].insert(0,x);
            this.count++;
            return true;
        }
        return false;*/
        
    } 
        
    public T remove(T key)                                 //ɾ���ؼ���ΪkeyԪ�أ����ر�ɾ��Ԫ��
    {
        T x = this.table[this.hash(key)].remove(key);      //ͬ��ʵ�����ɾ��keyԪ�ؽ��
        if (x!=null)
            this.count--;
        return x;
    }

    //���·�����ʡ�ԣ���˼����8-3�������·�������ͬCollection<T>�ӿ�
    public HashSet(T[] values)                             //����ɢ�б���values�����ṩԪ�ؼ���
    {
        this((int)(values.length/HashSet.LOAD_FACTOR));    //����ָ�������Ŀ�ɢ�б�
        this.addAll(values);                               //����values��������Ԫ��
    }
    public int size()                                      //����Ԫ�ظ���
    {
        return count;
    }
    public boolean isEmpty()                               //�ж��Ƿ�Ϊ��
    {
        return this.size()==0;
    }
    
    public boolean contains(T key)                         //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=null;
    }
    public void addAll(T[] values)                         //����values��������Ԫ��
    {
        for (int i=0; i<values.length; i++)
            this.add(values[i]);                           //����Ԫ��
    }
    
    public void clear()                                    //ɾ������Ԫ��
    {
        for (int i=0; i<this.table.length; i++)            //������ͬ��ʵ�����
            this.table[i].clear();
    }
    
    public String toString()                               //����ɢ�б�����Ԫ�ص������ַ���
    {
        String str=this.getClass().getName()+"(";
        boolean first=true;
        for (int i=0; i<this.table.length; i++)            //������ͬ��ʵ�����
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next)
            {
                if (!first)
                    str += ",";
                first=false;
                str += p.data.toString();
            }
        return str+")";
    }

    public void printAll()                                 //���ɢ�б�Ĵ洢�ṹ������ASL�ɹ�
    {
        System.out.println("ɢ�б�����="+this.table.length+"��"+this.count+"��Ԫ��"+
                           "��hash(key)=key % "+this.table.length+"��"+this.toString());
        for (int i=0; i<this.table.length; i++)            //������ͬ��ʵ�����
            System.out.println("table["+i+"]="+this.table[i].toString());

        System.out.print("ASL�ɹ�=(");
        int asl=0;
        for (int i=0; i<this.table.length; i++)            //������ͬ��ʵ�����
        {
            int j=1;
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next,j++)
            {
                System.out.print((asl==0 ? "" : "+")+j);
                asl+=j;
            }
        }
        if (count==0)
            System.out.println(") = 0\n");
        else
            System.out.println(")/"+count+" ="+asl+"/"+count+" ="+((asl+0.0)/count)+"\n");
    }
    
    
    //���½̲�ûд
    //����  public T[] toArray()                              //���ذ�����������Ԫ�ص�����
    public Object[] toArray()                              //���ذ�����������Ԫ�ص�����
    {
        Object[] values = new Object[this.size()];
        int j=0;
        for (int i=0; i<this.table.length; i++)            //������ͬ��ʵ�����
            for (Node<T> p=this.table[i].head.next;  p!=null;  p=p.next)
                values[j++] = p.data;
        return values;
    }
    public void enlarge(int length)                        //ɢ�б���������Ϊcapacity
    {
        this.table = new SinglyList[length];
        for (int i=0; i<this.table.length; i++)
            this.table[i] = new SinglyList<T>();           //����յ�����
    }
}
/*
public final class Integer
{
    public int hashCode()                //����Object���з���
    {
        return value;
    }
} 
 **/    

//@author��Yeheya��2015-3-19

