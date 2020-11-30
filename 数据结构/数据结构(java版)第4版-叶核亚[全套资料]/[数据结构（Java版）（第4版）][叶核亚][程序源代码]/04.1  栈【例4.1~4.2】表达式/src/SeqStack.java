//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��1��
//4.1.2   ˳��ջ

//˳��ջ�࣬�����࣬ʵ��ջ�ӿڣ�T��ʾ����Ԫ�ص���������
public final class SeqStack<T> implements Stack<T>
{
    private SeqList<T> list;                               //ʹ��˳�����2�£��洢ջԪ��

    public SeqStack(int length)                            //��������Ϊlength�Ŀ�ջ
    {
        this.list = new SeqList<T>(length);                //ִ��˳����췽��
    }
    public SeqStack()                                      //����Ĭ�������Ŀ�ջ  
    {
        this(64);
    }

    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return this.list.isEmpty();
    } 

    public void push(T x)                                  //Ԫ��x��ջ���ն�������ջ
    {
        this.list.insert(x);                               //˳���β����Ԫ��x���Զ���������
    }
    
    public T peek()                                        //����ջ��Ԫ�أ�δ��ջ������ջ�շ���null
    {
        return this.list.get(list.size()-1);               //��ջ�գ�get(i)����null
//        return this.isEmpty() ? null : this.list.get(list.size()-1);
    }

    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null
    {
        return this.list.remove(list.size()-1);            //��ջ���գ�˳���βɾ��������ɾ��Ԫ��
//        return this.isEmpty() ? null : this.list.remove(list.size()-1); //��ջ���գ�˳���βɾ��������ɾ��Ԫ��
    }
    public String toString()                               //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)��
    {
        return this.getClass().getName()+" "+this.list.toString();
    }
}


//@author��Yeheya��2014-7-3

