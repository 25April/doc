//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��19��
//8.4.2  ɢ��ӳ��
//��1�� ӳ��Ԫ����

public class KeyValue<K, V>                      //ӳ��Ԫ���࣬K��V�ֱ�ָ���ؼ��ֺ�ֵ����������
{
    final K key;                                 //�ؼ��֣����ձ�����ֻ�ܸ�ֵһ�� 
    V value;                                     //ֵ
    
    public KeyValue(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
    public String toString()                     //���������ַ�������ʽΪ��(�ؼ���,ֵ)��
    {
        return "("+this.key+","+this.value+")";
    }
    public final int hashCode()                  //����ɢ���룬����Object��ķ��������շ��������ܱ�����
    {
        return this.key.hashCode();              //���Թؼ��ֵ�ɢ������Ϊ�����ɢ���룬Ψһ������
    }
    public boolean equals(Object obj)            //�Ƚ϶����Ƿ���ȣ����ȽϹؼ��֣�����Object��ķ���
    {
        return obj==this ||
               obj instanceof KeyValue<?,?> && this.key.equals(((KeyValue<K,V>)obj).key);
    }
}
/*
java.util.HashMap<K, V>���ڲ��ࣺ

static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    public final int hashCode() {
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }

    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}*/

//@author��Yeheya��2014-8-16
