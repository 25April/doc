//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��3��
//3.2.2  �����ַ�����
//����3.2�� �����ࡣ
//��1������MyInteger��
//��˼����3-2��

public class MyInteger implements Comparable<MyInteger>
{
    public static final int MIN_VALUE = 0x80000000;        //��Сֵ������-2147483648
    public static final int MAX_VALUE = 0x7fffffff;        //���ֵ������2147483647
    private final int value;                               //˽�����ձ������洢��������ֵһ��

    public MyInteger(int value)                            //��int����value������������
    {
        this.value = value;
    }    
    //��ʮ���������ַ���s�����������󡣹��췽��ֻ֧��ʮ���ƣ�s���������š�
    public MyInteger(String s) throws NumberFormatException
    {
        this.value = this.parseInt(s, 10);
    }

    public int intValue()                                  //��������ֵ
    {
        return this.value;
    }

    public String toString()                               //���ص�ǰ������ʮ�����ַ���������Object�෽��
    {
        return this.value+"";                              //��+���Զ�������ת��Ϊʮ���������ַ���
    }
    
    public boolean equals(Object obj)                      //�Ƚ϶����Ƿ���ȡ�����Object�෽��
    {
        return obj instanceof Integer && this.value==((Integer)obj).intValue();
    }
    
    public int compareTo(MyInteger iobj)                   //�Ƚ���������ֵ��С������-1��0��1
    {
        return this.value<iobj.value? -1 : (this.value==iobj.value ? 0 : 1);
    }
    
    
    //��2�� �������ַ���ת��Ϊ����
    public static int parseInt(String s) throws NumberFormatException    //����s��ʮ����ת��Ϊ����
    {
        return MyInteger.parseInt(s,10);
    }
    
    //����s��radix����ת��Ϊ������sָ��������radix����ԭ���ַ��������������ţ�
    //2��radix��16��Ĭ��ʮ���ơ������ܽ�sת�������������׳���ֵ��ʽ�쳣
    public static int parseInt(String s, int radix) throws NumberFormatException
    {
        if (s==null) 
            throw new NumberFormatException("null");
        if (radix<2 || radix>16)
            throw new NumberFormatException("radix="+radix+"�����Ƴ���2��16��Χ��");
        int value=0, i=0;
        int sign = s.charAt(0)=='-' ? -1 : 1;              //����λ����ס��������� 
        if (s.charAt(0)=='+' || s.charAt(0)=='-')          //��������λ
            if (s.length()==1)                             //ֻ��"+"��"-"
                throw new NumberFormatException("\""+s+"\"");
            else i++;                                      //i��ס��ǰ�ַ����
        while (i<s.length())                               //����޷��ŵ���������ֵ
        {
            char ch=s.charAt(i++);
            if (ch>='0' && ch-'0'<radix)                   //��2��radix��10ʱ��radix����Ҫʶ��0��radix-1����
                value = value*radix+ch-'0';                //value��ס��ǰ��õ�����ֵ
            else             //��11��radix��16ʱ��radix���ƻ�Ҫʶ���'a'/'A'��ʼ��radix-10����ĸ��ʾ������ֵ
                if (radix>10 && radix<=16 && ch>='a' && ch-'a'<radix-10)
                    value = value*radix+ch-'a'+10;
                else
                    if (radix>10 && radix<=16 && ch>='A' && ch-'A'<radix-10)
                        value = value*radix+ch-'A'+10;
                    else throw new NumberFormatException(radix+"������������ʶ��"+ch);
        }
        return value*sign;                                 //�����з��ŵ�����ֵ
    }

    //��3��������ת��Ϊradix�����ַ���
    //���²���
    public static String toHexString(int value)            //��������value��ʮ�����Ʋ����ַ���������λ����
    {
        char[] buffer = new char[8];                       //һ��int��8��ʮ������λ
        for (int i=buffer.length-1; i>=0; i--)             //ѭ��ִ��8�Σ���λ��0
        {
            int bit = value & 15;                          //���ʮ�����Ƶĸ�λ
            buffer[i]=(char)(bit<=9 ? bit+'0' : bit+'a'-10);   //��0��9��10��15ת��Ϊ'0'��'9'��'a'��'f'
            value>>>=4;                                    //����4λ����λ���0����value����16
        }
        return new String(buffer);                         //�������ַ����鹹����ַ���
    }
    //���¡�˼����3-2�� MyInteger���������¾�̬��Ա������
    public static String toBinaryString(int value)         //��������value�Ķ����Ʋ����ַ���������λ����
    {
        char[] buffer = new char[32];                      //һ��int��32��������λ
        for (int i=buffer.length-1; i>=0; i--)             //ѭ��ִ��32�Σ���λ��0
        {
            buffer[i]=(char)((value & 1)+'0');             //��ø�λ�ַ��������顣&��������ȼ�����+
            value>>>=1;                                    //value����һλ����λ��0��䣬��value����2
        }
        return new String(buffer);                         //�������ַ����鹹����ַ���
    }
    public static String toOctalString(int value)          //��������value�İ˽��Ʋ����ַ���������λ����
    {
        char[] buffer = new char[32/3+1];                  //һ��int��11���˽���λ
        for (int i=buffer.length-1; i>=0; i--)             //ѭ��ִ��11�Σ���λ��0
        {
            buffer[i] = (char)((value & 7)+'0');           //��ø�λ�ַ��������顣&��������ȼ�����+
            value>>>=3;                                    //����3λ����λ��0��䣬��value����8
        }
        return new String(buffer);                         //�������ַ����鹹����ַ���
    }

    //ϰ����
    //��������value��radix����ԭ���ַ������з��ţ���λ��0��radixȡֵΪ2��4��8��10��16��������λ���㣨��radixȡ�෨��
    public static String toString(int value, int radix)
    {
        if (radix==10) 
            return value+"";
        if (radix==2 || radix==4 || radix==8 || radix==16)
        {
            int mask, n=0;                                 //mask���radix���Ƶ��������
            for (mask=radix-1; mask>0; mask>>>=1) 
                n++;                                       //n���mask�Ķ�����λ������2��n�η���radix
            mask=radix-1;

            char[] buffer = new char[(int)(32.0/n+0.5+1)]; //�洢һ��int��ʾΪradix���Ƶĸ�λ������
            buffer[0]= '+';                                //����λ
            if (value<0)
            {
                buffer[0]='-';                             //����
                if (value != MyInteger.MIN_VALUE)
                    value=-value;                          //������MyInteger.MIN_VALUE
            }

            //��radixȡ�෨����������buffer�ַ����飨���򣩣���MyInteger.MIN_VALUEΪ�޷���
            for (int i=buffer.length-1; i>0; i--)
            {
                int bit = value & mask;                    //���radix���Ƶĸ�λ����
                buffer[i]=(char)(bit<=9 ? bit+'0' : bit+'a'-10); //��0��9��10��15ת��Ϊ'0'��'9'��'a'��'f'
                value>>>=n;                                //����nλ����λ��0����value����radix
            }
            return new String(buffer);                     //�������ַ����鹹����ַ���
        }
        throw new IllegalArgumentException("radix����ֵ"+radix+"��ʾ�Ľ�����Ч��"); //��Ч�����쳣
    }   
}
//@author��Yeheya��2015-2-28

