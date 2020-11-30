//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��3��
//4.2.2  ˳��ѭ������

//˳��ѭ�������࣬�����࣬ʵ�ֶ��нӿڣ�T��ʾ����Ԫ�ص���������
public final class SeqQueue<T>  implements Queue<T>
{
    private Object element[];                              //�洢��������Ԫ�ص�����
    private int front, rear;                               //front��rear�ֱ�Ϊ����ͷβ�±�

    public SeqQueue(int length)                            //��������Ϊlength�Ŀն���
    {
        if (length<64)
        	length=64;                                     //���ö�������������Сֵ
        this.element = new Object[length];
        this.front = this.rear = 0;                        //���ÿն���
    }
    public SeqQueue()                                      //����Ĭ�������Ŀն���
    {
        this(64);
    }

    public boolean isEmpty()                                 //�ж϶����Ƿ�գ����շ���true
    {
        return this.front==this.rear;
    } 

    public boolean add(T x)                                //Ԫ��x��ӣ��ն��������
    {
        if (x==null)
            return false;
//            throw new NullPointerException("x==null");     //�׳��ն����쳣
        if (this.front==(this.rear+1)%this.element.length) //��������������������
        {
            Object[] temp = this.element;         
            this.element = new Object[temp.length*2];      //��������һ���������������
            int j=0;
            for (int i=this.front;  i!=this.rear;  i=(i+1) % temp.length) //���ն���Ԫ�ش���������Ԫ��
                this.element[j++] = temp[i];
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = x;
        this.rear = (this.rear+1) % this.element.length;
    	return true;
    } 

    public T peek()                                       //���ض�ͷԪ�أ�û��ɾ���������пգ��򷵻�null
    {
        return this.isEmpty() ? null : (T)this.element[this.front];
    }
    
    public T poll()                                        //���ӣ����ض�ͷԪ�أ������пշ���null 
    {
        if (this.isEmpty()) 
            return null;
        T temp = (T)this.element[this.front];
        this.front = (this.front+1) % this.element.length;
        return temp;
    }

    public String toString()                               //���ض�������Ԫ�ص������ַ�������ʽΪ��(,)�������ն���Ԫ�ش���
    {
        StringBuffer strbuf = new StringBuffer(this.getClass().getName()+"(");
        for (int i=this.front;  i!=this.rear;  i=(i+1)%this.element.length)
            strbuf.append(this.element[i].toString()+","); //���ն���Ԫ�ش���������Ԫ��
        strbuf.setCharAt(strbuf.length()-1, ')');          //�����������һ���ַ�','��Ϊ')'
        return new String(strbuf);                         //��StringBuffer������String����
    }
}
//@author��Yeheya��2014-9-23