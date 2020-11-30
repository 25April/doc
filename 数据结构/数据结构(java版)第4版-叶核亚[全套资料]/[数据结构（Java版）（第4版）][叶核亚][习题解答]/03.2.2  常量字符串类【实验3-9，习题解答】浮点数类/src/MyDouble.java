//�����ݽṹ��Java�棩����4�棩ϰ������ʵ��ָ���������ߣ�Ҷ���ǣ�2015��2��5��
//3.2.2   �����ַ�����
//��ʵ��3-9��ϰ���� �������ࡣ

public final class MyDouble implements Comparable<MyDouble>//�������࣬������
{
    private final double value;                            //���ձ������洢������

    public MyDouble(double value)                          //��doubleֵ���측��������
    {
        this.value = value;
    }    
    
    public MyDouble(String s) throws NumberFormatException //���ַ���s���측��������s����������
    {
        this.value = this.parseDouble(s);
    }

    public double doubleValue()                            //���ظ�����ֵ
    {
        return this.value;
    }

    public String toString()                               //���ظ�����ֵ���ַ���������Object�෽��
    {
        return this.value+"";                              //��+���Զ���������ת��Ϊ�ַ���
    }
    
    public int compareTo(MyDouble dobj)                    //�Ƚ���������ֵ��С������-1��0��1
    {
        return this.value<dobj.value? -1 : (this.value==dobj.value ? 0 : 1);
    }
    
    //����ʵ���ַ���s��ʾ�ĸ��������﷨ͼ���̲�ͼ3.21��a�������������к����������ʵ��
    public static double parseDouble(String s) throws NumberFormatException 
    {
        int i=0, sign=s.charAt(0)=='-' ? -1 : 1;           //sign��ס����λ
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //��������λ
            i++;
        double value=0, power=0.1;//10.0E0;                //power��ʾ����Ϊ10����//�ܹ�����������������
        while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')//�����������ֵ
            value = value*10+s.charAt(i++)-'0';
        if (i<s.length() && s.charAt(i)=='.')              //����С����
        {   i++;
            while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')//���С������ֵ
            {   value += (s.charAt(i)-'0')*power;
                i++;
                power*=0.1;
            }
        }
        value *=sign;
        
        if (i<s.length() && (s.charAt(i)=='E' || s.charAt(i)=='e'))  //�������
        {   i++;
            power = (s.charAt(i)=='-') ? 0.1 :10;          //����ķ���λ����ָ����������������
            if (s.charAt(i)=='+' || s.charAt(i)=='-')
                i++;
            int exp=0;
            while (i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
                exp = exp*10+s.charAt(i++)-'0';            //���ָ���ľ���ֵ
            for (int j=0; j<exp; j++)
                value*=power;
        }
        return value; 
    } 
    
    //����ʵ���ַ���s��ʾ�ĸ��������﷨ͼ���̲�ͼ3.21��b�������������������к����������ʵ��
    public static double toDouble(String s)
    {
        int dot=s.indexOf('.'), e=s.indexOf('E');          //Ѱ��С�����E
        if (e==-1)
            e=s.indexOf('e');
        if (dot==-1 && e==-1)
            return MyInteger.parseInt(s);                  //s��û��С���ͽ��룬��������

        int i=0, sign=s.charAt(0)=='-' ? -1 : 1;           //sign��ס����λ
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //��������λ
            i++;
        
        double value=0, power=0.1;                         //power��ʾ��Ϊ10���ݣ���ֵΪ����
        if (dot!=-1)                                       //s����С������
        {   value=MyInteger.parseInt(s.substring(i,dot));  //�������������ֵ
            dot++;                                         //����С����
            while (dot<s.length() && s.charAt(dot)>='0' && s.charAt(dot)<='9')  //���С������ֵ
            {
                value += (s.charAt(dot)-'0')*power;
                dot++;
                power*=0.1;
            }
        }
        value *=sign;
        
        if (e!=-1)                                         //�������
        {   if (dot==-1)                                   //s��û��С������
                value=MyInteger.parseInt(s.substring(0,e));//�����������ֵ
            e++;
            power = (s.charAt(e)=='-') ? 0.1 :10;          //����ķ���λ����ָ��������������
            if (s.charAt(e)=='+' || s.charAt(e)=='-')
                e++;
            int exp=MyInteger.parseInt(s.substring(e));    //���ָ�����ֵ�������ֵ
            for (int j=0; j<exp; j++)
                value*=power;
        }
        return value;
    }
}
//@author��Yeheya��2015-2-5