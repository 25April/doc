//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��24��
//10.2.2   ���ڵ������Ĳ���
//2.  �����б���

import java.util.Iterator;                                 //Java�������ӿ�

//�����б��࣬�̳�MyAbstractCollection<T>�࣬Ϊ���Ա��ṩ���ڵ������ı����㷨
//����ʹ���б����������������Ϊ������ĸ���
public abstract class MyAbstractList<T>  extends MyAbstractCollection<T> 
{
    public boolean equals(Object obj)                      //�Ƚ��������϶����Ƿ����
    {
        if (obj == this)
            return true;
        if (!(obj instanceof MyAbstractList<?>))
            return false;
        java.util.Iterator<T> it1 = this.iterator();
        java.util.Iterator<T> it2 = ((MyAbstractList<T>)obj).iterator();
        while (it1.hasNext() && it2.hasNext()) 
            if (!(it1.next().equals(it2.next())))          //�Ƚϼ���Ԫ�أ����������ļ�����û��null����
                return false;
        return !it1.hasNext() && !it2.hasNext();           //�����ռ���Ҳ���
    }
}
//��˼����10-5��
/*    //ɾ����i��Ԫ�أ����ر�ɾ��Ԫ�ء�ʹ�õ�������//�����㷨����
    public T remove(int i)
    {
        Iterator<T> it = this.iterator();        //��õ���������
        T value=null;
        int j=0;
        for (j=-1; j<i && it.hasNext(); j++)
            value = it.next();
        if (j==i)
            it.remove();       //�˾䲻�У����������SeqList��remove(i)���໥����
        return value;
    }*/

//@author��Yeheya��2014-8-24
