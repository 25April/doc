//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��1��
//4.1.3   ��ʽջ

//��ʽջ�࣬�����࣬ʵ��ջ�ӿڣ�T��ʾ����Ԫ�ص���������
public final class LinkedStack<T> implements Stack<T>
{
    private SinglyList<T> list;                            //ʹ�õ�������2�£��洢ջԪ��
    
    public LinkedStack()                                   //�����ջ
    {
        this.list = new SinglyList<T>();                   //����յ�����
    }

    public boolean isEmpty()                               //�ж�ջ�Ƿ�գ����շ���true
    {
        return this.list.isEmpty();
    }
    public void push(T x)                                  //Ԫ��x��ջ���ն�������ջ
    {
        this.list.insert(0, x);                            //������ͷ����Ԫ��x
    } 
    
    public T peek()                                        //����ջ��Ԫ�أ�δ��ջ������ջ�շ���null
    {
        return this.list.get(0);
    }
    public T pop()                                         //��ջ������ջ��Ԫ�أ���ջ�շ���null
    {
        return this.list.remove(0);                        //��ջ���գ�������ͷɾ��������ɾ��Ԫ��
    }
    
    public String toString()                               //����ջ����Ԫ�ص������ַ�������ʽΪ��(,)��
    {
        return this.getClass().getName()+" "+this.list.toString();
    }
}
//@author��Yeheya��2014-7-3

