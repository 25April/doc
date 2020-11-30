//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��19��
//8.4.2  ɢ��ӳ��
//ʹ��ɢ�б���Ϊ��Ա����������

//ɢ��ӳ���࣬ʵ��Map<K, V>�ӿڣ�K��V�ֱ�ָ��Ԫ�صĹؼ��ֺ�ֵ����������
public class HashMap<K, V> implements Map<K,V>
{
    HashSet<KeyValue<K,V>> set;                            //ɢ�б�Ԫ����KeyValue<K,V>

    public HashMap(int length)                             //��������Ϊlength��ɢ��ӳ��
    {
        this.set = new HashSet<KeyValue<K,V>>(length);
    }
    public HashMap()                                       //����Ĭ��������ɢ��ӳ��
    {
        this.set = new HashSet<KeyValue<K,V>>();           //����Ĭ��������ɢ�б�
    }

    public boolean isEmpty()                               //�ж��Ƿ��
    {
        return this.set.isEmpty(); 
    }
    public int size()                                      //����Ԫ�ظ���
    {
        return this.set.size(); 
    }
    public String toString()                               //��������Ԫ�ص������ַ���
    {
        return this.set.toString(); 
    }
    
    public V get(K key)                                    //���عؼ���keyӳ���ֵ
    {
        KeyValue<K,V> find=this.set.search(new KeyValue<K,V>(key,null));  //����
        return find!=null ? find.value : null;             //���ҳɹ�������ֵ�����򷵻�null
    }
    
    public V put(K key, V value)                           //���ӳ��Ԫ��(��,ֵ)���ؼ�����ͬʱ���滻ֵ
    {
        KeyValue<K,V> kv = new KeyValue<K,V>(key,value);
        if (!this.set.add(kv))                             //���벻�ɹ�����ʾ�ؼ����ظ�
            this.set.search(kv).value = value;             //���ҹؼ����ظ�Ԫ�أ��滻ֵ
        return value;
    }
    
    public V remove(K key)                                 //ɾ���ؼ���ΪkeyԪ�أ����ر�ɾ��Ԫ�ص�ֵ
    {
        return this.set.remove(new KeyValue<K,V>(key,null)).value; 
    }

    public boolean containsKey(K key)                      //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.get(key)!=null;
    }
    
    public void clear()                                    //ɾ������Ԫ��
    {
        this.set.clear(); 
    }

    //��ʵ��10-4��
    public HashSet<K> keySet()                             //���عؼ��ּ���
    {
        HashSet<K> keyset= new HashSet<K>();
        Object[] keyvalues = this.set.toArray();           //���ɢ�б�֧�ֵ������Ͳ���Ҫʹ��������ת��
        for (int i=0; i<keyvalues.length; i++)
            keyset.add(((KeyValue<K,V>)keyvalues[i]).key);
        return keyset;
    }
    
    public Object[] values()                               //���ذ���ֵ���ϵ����飬ֵ���ظ�
    {
        Object[] values = new Object[this.size()];
        Object[] keyvalues = this.set.toArray();
        for (int i=0; i<keyvalues.length; i++)
            values[i] = ((KeyValue<?,?>)keyvalues[i]).value;
        return values;
    }
    //���ܷ���HashSet<V>����Ϊֵ�ظ���Map<K,V>��������
    //public Collection<V> values()                  //����ֵ����

    public void printAll()                           //��ɢ�б���ʽ�������Ԫ��
    {
        this.set.printAll();
    }
    
}
/*����ûʵ��
    public boolean containsValue(Object value)         //�ж��Ƿ����ָ��ֵ
    {
        return this.hashset.contains(new KeyValue<K,V>(null,(V)value));
    }//����û��������ֵ���ң���ͬ�ıȽϹ���
}*/
//@author��Yeheya��2014-10-19
