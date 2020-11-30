//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��22�գ�JDK 8.11
//��2.1   ���Ա������������

//ADT List<T>                                    //���Ա�����������ͣ�T��ʾ����Ԫ�ص���������
public interface List<T> 
{
    boolean isEmpty();                           //�ж����Ա��Ƿ�Ϊ�գ����շ���true
    int size();                                  //�������Ա�Ԫ�ظ��������ȣ�
    T get(int i);                                //���ص�i��Ԫ��
    void set(int i, T x);                        //���õ�i��Ԫ��Ϊx
    String toString();                           //�������Ա�����Ԫ�ص������ַ���

    int insert(int i, T x);                      //����x��Ϊ��i��Ԫ�أ�x!=null
    int insert(T x);                             //�����Ա�������xԪ�أ�����x���
    T remove(int i);                             //ɾ����i��Ԫ�أ����ر�ɾ��Ԫ��
    void clear();                                //ɾ�����Ա�����Ԫ��
    int search(T key);                           //�����״γ��ֵ���key���Ԫ�أ�����Ԫ�����i
    boolean contains(T key);                     //�ж��Ƿ�����ؼ���ΪkeyԪ��
    T remove(T key);                             //ɾ���״γ��ֵ���key���Ԫ�أ����ر�ɾ��Ԫ��
    boolean equals(Object obj);                  //�Ƚ��������Ա�����Ԫ���Ƿ��Ӧ���
}

//����    public abstract boolean add(T x);                      //����Ԫ��x�������ӣ�����true
//�������ã��Ĳ���

//@author��Yeheya��2014-10-26