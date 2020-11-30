//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��21��
//8.5.2 ��ӳ��

//��ӳ��Ԫ���࣬�̳�KeyValue<K, V>ӳ��Ԫ���࣬K��V�ֱ�ָ���ؼ��ֺ�ֵ���������ͣ�
//�޶�K��K��ĳ�����������ʵ��Comparable<K>�ӿڣ�
//����ɱȽ϶����С���Ƚ϶����С�Ĺ����ɹؼ��ֵ�����KԼ��
public class SortedKeyValue<K extends Comparable<? super K>, V>
    extends KeyValue<K, V>  implements Comparable<SortedKeyValue<K,V>>
{
    public SortedKeyValue(K key, V value)
    {
        super(key,value);
    }    
   
    public int compareTo(SortedKeyValue<K,V> kv) //�Ƚ϶����С�����ȽϹؼ��ֵĴ�С
    {
        return this.key.compareTo(kv.key);
    }
}

