//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��23��
//4.1.1   ջ������������

//    ADT Stack<T>                            //ջ�����������ͣ�T��ʾ����Ԫ�ص���������
public interface Stack<T>                        //ջ�ӿڣ�����ջ�����������ͣ�T��ʾ����Ԫ�ص���������
{
    public abstract boolean isEmpty();           //�ж�ջ�Ƿ��
    public abstract void push(T x);              //Ԫ��x��ջ
    public abstract T peek();                    //����ջ��Ԫ�أ�δ��ջ
    public abstract T pop();                     //��ջ������ջ��Ԫ��
}
//@author��Yeheya��2014-10-23