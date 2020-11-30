//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��22�գ�JDK 8.11
//��1.1.3   ���������������������
//����1.1��  ���ϵı�ʾ��ʵ�֡�

//ADT Set<T>                                               //���ϳ�����������
public interface Set<T>                                    //���Ͻӿ�
{
 // ���ݣ������е�����Ԫ�أ�����Ԫ�ص���������ΪT
 // ������
    public abstract boolean isEmpty();                     //�жϼ����Ƿ�Ϊ��
    public abstract int size();                            //����Ԫ�ظ���
    public abstract T search(T key);                       //���ز��ҵ��Ĺؼ���ΪkeyԪ��
    public abstract boolean contains(T key);               //�ж��Ƿ�����ؼ���ΪkeyԪ��
    public abstract boolean add(T x);                      //����Ԫ��x�������ӣ�����true
    public abstract T remove(T key);                       //ɾ���ؼ���ΪkeyԪ�أ����ر�ɾ��Ԫ��
    public abstract void clear();                          //ɾ������Ԫ��
    public abstract String toString();                     //���ؼ�������Ԫ�ص������ַ���
    public abstract boolean equals(Object obj);            //�Ƚ�this��obj���ü����Ƿ����
    public abstract Object[] toArray();                    //���ذ�����������Ԫ�ص�����
    
    //���·��������������㣬��������һ������
    public abstract boolean containsAll(Set<?> set);       //�ж��Ƿ����set������Ԫ�أ��Ƿ��Ӽ���
    public abstract boolean addAll(Set<? extends T> set);  //���set������Ԫ�أ����ϲ����㡣���޸ģ�����true
    public abstract boolean removeAll(Set<?> set);         //ɾ��Ҳ������set��Ԫ�أ����ϲ�
    public abstract boolean retainAll(Set<?> set);         //��������ЩҲ������set��Ԫ�أ����ϲ�
}
//@author��Yeheya��2014-10-16
//�޷�ʵ�֣���    <E> E[] toArray(E[] a);                      //����E�������飬����aָ�����ص���������
