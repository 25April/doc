//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��24��
//10.2.2  ���ڵ������Ĳ���
//1.  ���󼯺���

import java.util.*;                                 //Java�������ӿ�

//���󼯺��࣬ʵ��Iterable<T>�ɵ����ӿڣ�Ϊ���м����ṩ������ʽ�ı����㷨
public abstract class MyAbstractCollection<T> implements java.lang.Iterable<T> 
//public abstract class MyAbstractCollection<T> implements java.util.Collection<T> 
{
    public abstract Iterator<T> iterator();                //��õ��������󣬳��󷽷�

    public String toString()                     //���ؼ�������Ԫ�ص��ַ�����������ʽΪ��(,)��
    {
//        String str=this.getClass().getName()+"(";          //��������
        String str="(";
        Iterator<T> it = this.iterator();                  //it��һ������������
        while (it.hasNext())                               //���к��Ԫ��
        {
            str += it.next().toString();                   //��Ӻ��Ԫ���ַ���
            if (it.hasNext())
                str += ",";
        } 
        return str+")";
    }
    //��������Ԫѭ�����޷��ж��Ƿ����һ��
    
    public boolean remove(Object key)            //ɾ���״γ��ֵĹؼ���ΪkeyԪ��
    {
        Iterator<T> it = this.iterator();
        while (it.hasNext())
            if (key.equals(it.next()))
            {
                it.remove();                     //ɾ����������ʾ�ļ��ϵ�ǰԪ��
                return true;
            }
        return false;       
    }
    //��������Ԫѭ�����޷�����ɾ������

    public abstract boolean add(T x);            //����Ԫ��x�����󷽷�
    
    //���c������Ԫ�أ����ϲ����㡣���޸ģ�����true��    //ʹ�õ��������㷨ͬ MyAbstractSet<T>
/*    public boolean addAll(Collection<? extends T> c) //�㷨��ȷ�����ڵ�����
    {
        boolean modify=false;
        Iterator<?> it = c.iterator();           //����������
        while (it.hasNext())                     //������Ԫ��
            modify = this.add((T)it.next());     //add(x)����ʱ��̬���ɸ�����ʵ��
        return modify;
    }*/

    public boolean addAll(Collection<? extends T> c) //�㷨��ȷ��������Ԫѭ��
    {
        boolean modify=false;
        for (T obj : c)                          //��Ԫѭ����obj�������c�����е�Ԫ��
            modify = this.add(obj);              //add(x)����ʱ��̬���ɸ�����ʵ��
        return modify;
    }
    
    //��˼����10-5��
    //�жϼ����Ƿ�����ؼ���ΪkeyԪ�أ�����������true����key==null
/*    public boolean contains(Object key)      //�㷨��ȷ�����ڵ�����
    {
        Iterator<T> it = this.iterator();
        while (it.hasNext())
            if (key.equals(it.next()))
                return true;
        return false;
    }*/
    //��Ԫѭ�������������飬��ʵ�ֵ���������
    public boolean contains(Object key)          //�㷨��ȷ��������Ԫѭ��
    {
        for (T obj : this)                       //��Ԫѭ����obj�������this��ǰ�����е�Ԫ��
            if (key.equals(obj))
                return true;
        return false;
    }
    
    //�ж��Ƿ����c������Ԫ�أ��ж�c�Ƿ��Ӽ�
/*    public boolean containsAll(Collection<?> c)//�㷨��ȷ�����ڵ�����
    {
        Iterator<?> it = c.iterator();
        while (it.hasNext())
            if (!this.contains(it.next()))
                return false;
        return true;
    }*/
    
    public boolean containsAll(Collection<?> c)  //�㷨��ȷ��������Ԫѭ��
    {
        for (Object obj : c)                     //��Ԫѭ����obj�������c�����е�Ԫ��
            if (!this.contains(obj))
                return false;
        return true;
    }
    
    public abstract int size();                  //���ؼ���Ԫ�ظ��������󷽷�

    public Object[] toArray()                    //���ذ�����ǰ����������Ԫ�ص�����
    {
        Object[] temp = new Object[this.size()];
        Iterator<T> it = this.iterator();        //����������
        int i=0; 
        while (it.hasNext())                     //������Ԫ��
            temp[i++]=it.next();
        return temp;
    }

    public abstract boolean isEmpty();           //�жϼ����Ƿ�գ����󷽷�
    public abstract void clear();                //ɾ����ǰ���ϵ�����Ԫ��
//    <E> E[] toArray(E[] a);                 //����E�������飬����aָ�����ص���������

        //���·��������������㣬��������һ������
    public abstract boolean equals(Object obj);            //�Ƚ����������Ƿ����
    public abstract boolean removeAll(Collection<?> c);    //ɾ����ЩҲ�����ڼ���c�е�Ԫ�أ����ϲ�����
    public abstract boolean retainAll(Collection<?> c);    //��������ЩҲ�����ڼ���c�е�Ԫ��
}
//@author��Yeheya��2014-10-25
