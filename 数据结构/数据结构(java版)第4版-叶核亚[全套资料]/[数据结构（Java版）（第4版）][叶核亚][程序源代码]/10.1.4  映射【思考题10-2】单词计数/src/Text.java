//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��28��
//10.1 ���Ͽ��
//10.1.4  ӳ��
//��˼����10-2�� �ֱ�ʹ��java.util�е�ɢ��ӳ�����ӳ�䣬ʵ����8.3����8.5��ͳ���ı��и����ʵĳ��ִ�����
//�㷨ͬ��ʵ����8-5��

import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Text                                //�ı�������
{
    //ͳ��text�и��ַ��ĳ��ִ���������Map<K,V>ӳ������ַ���Ϊ�ؼ���K��ͳ�ƴ�����ΪֵV
	//�㷨ͬ��8.3����8.5
    public static Map<String, Integer> charCount(String text) 
    {
        Map<String, Integer> map = new HashMap<String, Integer>();//�����ӿڶ���map������ʵ�ָýӿڵ����ʵ��
//        Map<?,?> map = new HashMap<String, Integer>();//�����ӿڶ���map������ʵ�ָýӿڵ����ʵ��
        //ɢ�б�Ĭ������16������û���ã�table=null��װ������Ϊ0.75
//        Map<String, Integer> map = new TreeMap<String, Integer>(); //Ĭ��Kʵ��Comparable<K>�ӿ�
        for (int i=0; i<text.length(); i++)                //����ַ����Ҽ���
        {
            String key = text.substring(i,i+1);            //�ַ���Ϊ�ؼ���
            Integer value = map.get(key);                  //���ָ���ַ�ӳ���ֵ
            int count = value==null ? 0 : value.intValue();//ת����int����
            map.put(key, new Integer(count+1));            //���Ӽ������ؼ�����ͬʱ���滻Ԫ��
        }
        return map;
    }	

    //����text��ͳ�Ƴ��ĸ����ʼ�����ִ����洢��ɢ�б��С��㷨ͬ��charCount(String text) 
    public static Map<String, Integer> wordCount(String[] words) 
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
//        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (int i=0; i<words.length; i++)
        {
            Integer iobj = (Integer)map.get(words[i]);
            int count = iobj==null ? 0 : iobj.intValue();
            map.put(words[i], new Integer(count+1));
        }
        return map;
    }

    //����text��ͳ�Ƴ��ĸ����ʼ�����ִ����洢��ɢ�б��С��㷨ͬ��charCount(String text) 
    public static Map<String, Integer> wordCount(String text)
    {
        Map<String, Integer> map = new HashMap<String, Integer>();
//        Map<String, Integer> map = new TreeMap<String, Integer>(); //Ĭ��Kʵ��Comparable<K>�ӿ�
        int i=0; 
        while (i<text.length())                //������ʲ��Ҽ���
        {
            int end = text.indexOf(' ',i);
            if (end==-1)
                end=text.length();
        	String key = text.substring(i,end);            //�ַ���Ϊ�ؼ���
            Integer value = map.get(key);                  //���ָ���ַ�ӳ���ֵ
            int count = value==null ? 0 : value.intValue();//ת����int����
            map.put(key, new Integer(count+1));            //���Ӽ������ؼ�����ͬʱ���滻Ԫ��
            i=end+1;
        }
        return map;
//        System.out.println("���ʼ�����ִ�����"+set.toString());
    }
}
