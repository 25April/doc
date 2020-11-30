//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��19��
//8.4.2  ɢ��ӳ��
//��2�� ӳ��ӿ�

public interface Map<K, V>                       //ӳ��ӿڣ�K��V�ֱ�ָ��ӳ��Ԫ�صĹؼ��ֺ�ֵ����������
{
    public abstract boolean isEmpty();           //�ж��Ƿ��
    public abstract int size();                  //����Ԫ�ظ���
    public abstract String toString();           //��������Ԫ�ص������ַ���
    public abstract V get(K key);                //���عؼ���keyӳ���ֵ
    public abstract V put(K key, V value);       //���ӳ��Ԫ��(��,ֵ)���ؼ�����ͬʱ���滻ֵ    
    public abstract V remove(K key);             //ɾ���ؼ���ΪkeyԪ�أ����ر�ɾ��Ԫ�ص�ֵ
    public abstract boolean containsKey(K key);  //�ж��Ƿ�����ؼ���ΪkeyԪ��
    public abstract void clear();                //ɾ������Ԫ��
    public abstract Object[] values();           //���ذ���ֵ���ϵ����飬ֵ���ظ�
}
/*ûʵ�����£�java.util.Map<K,V>����
    public boolean containsValue(Object value)         //�ж��Ƿ����ָ��ֵ
    //����û��������ֵ���ң���ͬ�ıȽϹ����Ҳ�Ψһ
*/
//@author��Yeheya��2014-10-23
