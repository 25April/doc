//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��21��
//8.5.2 ��ӳ��

//��ӳ���࣬ʵ��Map<K, V>�ӿڣ�K��V�ֱ�ָ���ؼ��ֺ�ֵ���������ͣ�
//K��K��ĳ��������ʵ��Comparable<K>�ӿ�
public class TreeMap<K extends Comparable<? super K>, V>  implements Map<K,V>
{
    BinarySortTree<SortedKeyValue<K,V>> set;               //������������ʾ��������򼯺�

    public TreeMap()                                       //�������ӳ��
    {
        this.set = new BinarySortTree<SortedKeyValue<K,V>>();//����ն���������
    }

    public V get(K key)                                    //���عؼ���keyӳ���ֵ
    {
        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,null);
        SortedKeyValue<K,V> find=this.set.search(kv);      //����
        return find!=null ? find.value : null;             //���ҳɹ�������ֵ�����򷵻�null
    }
    public V put(K key, V value)                           //���ӳ��Ԫ�أ��ؼ�����ͬʱ���滻ֵ
    {
        SortedKeyValue<K,V> kv = new SortedKeyValue<K,V>(key,value);
        if (!this.set.add(kv))                             //���벻�ɹ�����ʾ�ؼ����ظ�
            this.set.search(kv).value = value;             //���ҹؼ����ظ�Ԫ�أ��滻ֵ
        return value;
    }
  
    //���·�����ʡ�ԣ���ʵ��8-7��
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
  
    public boolean containsKey(K key)                      //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.get(key)!=null;
    }
  
    public V remove(K key)                                 //ɾ���ؼ���ΪkeyԪ�أ����ر�ɾ��Ԫ�ص�ֵ
    {
        return this.set.remove(new SortedKeyValue<K,V>(key,null)).value; 
    }
    public void clear()                                    //ɾ������Ԫ��
    {
        this.set.clear(); 
    }
    public void printAll()                           //��ɢ�б���ʽ�������Ԫ��
    {
    	System.out.println(this.set.toString());
        this.set.printASL();
    }

    public BinarySortTree<K> keySet()                      //���عؼ��ּ���
    {
        return null;
    }
    int i=0;
    public Object[] values()                               //���ذ���ֵ���ϵ����飬ֵ���ظ�
    {
        Object[] value = new Object[this.size()];
        i=0;
        values(value, this.set.root);
        return value;
    }
    //�и����������pΪ�����������ݹ��㷨���ذ���ֵ���ϵ����飬ֵ���ظ�
    private void values(Object[] value, TriNode<SortedKeyValue<K,V>> p)
    {
        if (p!=null)
        {
            value[i++] = p.data.value;
            values(value,p.left);
            values(value,p.right);
        }
    }
}

    /*����ûʵ��
    public BinarySortTree<K> keySet()                   //���عؼ��ּ���
    {
        BinarySortTree<K> keyset= new BinarySortTree<K>();
      Object[] keyvalues = this.hashset.toArray();  //���ɢ�б�֧�ֵ������Ͳ���Ҫʹ��������ת��
      for (int i=0; i<keyvalues.length; i++)
          keyset.add(((KeyValue<K,V>)keyvalues[i]).key);
      return keyset;
  }
  
  public boolean containsValue(Object value)         //�ж��Ƿ����ָ��ֵ
  //����û��������ֵ���ң���ͬ�ıȽϹ���
}*/
//@author��Yeheya��2014-10-23
