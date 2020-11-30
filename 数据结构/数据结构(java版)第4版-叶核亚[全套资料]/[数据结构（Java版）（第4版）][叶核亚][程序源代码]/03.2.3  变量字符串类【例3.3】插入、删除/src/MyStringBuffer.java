//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��27��
//3.2.3   �����ַ�����
    //��˼����3-3��
    //��ʵ��3-10��    

//�����ַ����࣬�����࣬ʵ�����л��ӿ�
public final class MyStringBuffer implements java.io.Serializable
{
    private char[] value;                                  //�ַ����飬˽�г�Ա����
    private int n;                                         //������
    
    //1.  ��������ַ���
    public MyStringBuffer(int capacity)                    //��������Ϊcapacity�Ŀմ�
    {
        this.value = new char[capacity];
        this.n = 0;
    }    
    public MyStringBuffer()                                //��Ĭ����������մ�
    {
        this(16);
    }
    public MyStringBuffer(String s)                        //���ַ����������촮
    {
        this(s.length()+16);
        this.n = s.length();
        for (int i=0; i<this.n; i++)                       //����s�������ַ�
            this.value[i] = s.charAt(i);
    }
    
    public int length()                                    //�����ַ�������
    {
         return this.n;                                    //����value.length����������
    }
    public int capacity()                                  //�����ַ���������
    {
        return this.value.length;
    }

    public synchronized char charAt(int i)                 //���ص�i���ַ���0��i<length()
    {
        if (i>=0 && i<this.n)
            return this.value[i];
        throw new StringIndexOutOfBoundsException(i);
    }
    public void setCharAt(int i, char ch)                  //���õ�i���ַ�Ϊch��0��i<length()
    {
        if (i>=0 && i<this.n)
            this.value[i] = ch;
        else throw new StringIndexOutOfBoundsException(i);
    }
    
    public synchronized String toString()  
    {
        return new String(this.value, 0, this.n);          //��value�����0��n�ַ�����String��
    }
    
    public synchronized void setLength(int n)              //���ô�����Ϊn���������������㣬������
    {
        if (n>0)
        {
            if (n > this.value.length)                     //������ռ䲻�㣬������
            {
                char[] temp = this.value;
                this.value = new char[n*2];                //���������ַ�����ռ�
                for (int i=0; i<temp.length; i++)          //���ƴ�
                this.value[i] = temp[i];
            }
            for (int i=this.n; i<this.value.length; i++)   //���鲹�ո�
                this.value[i] = ' ';
            this.n = n;                                    //�ı䴮���ȣ������̣���ӳ����Ѳ��ո�
        }
        else throw new NegativeArraySizeException("n="+n); //�׳������鳤���쳣
    }
    
    
    //2.  ���봮
    //�ڵ�i���ַ�������s����0��i<length()����i���Խ�磬�׳��ַ������Խ���쳣����s==null������"null"
    public synchronized MyStringBuffer insert(int i, String s)
    {
        if (this.n==0 && i==0 || this.n>0 && i>=0 && i<this.n)
        {
            if (s==null)  
                s = "null";
            char[] temp=this.value;
            if (this.value.length < this.n+s.length())     //������ռ䲻�㣬������
            {   this.value = new char[(this.value.length+s.length())*2]; //���������ַ�����ռ�
                for (int j=0; j<i; j++)                    //���Ƶ�ǰ��ǰi-1���ַ�
                    this.value[j] = temp[j];
            }
            for (int j=this.n-1; j>=i; j--)                //��i��ʼ����β���Ӵ�����ƶ�������Ӻ���ǰ
                this.value[j+s.length()] = temp[j];
            for (int j=0; j<s.length(); j++)               //����s��
                this.value[i+j] = s.charAt(j);
            this.n += s.length();
            return this;
        }
        else throw new StringIndexOutOfBoundsException("i="+i);  //�׳��ַ������Խ���쳣
    }

    public synchronized MyStringBuffer insert(int i, boolean b)  //��i���������ֵת���ɵĴ�
    {
        return this.insert(i, b ? "true" : "false");
    }
    public synchronized MyStringBuffer append(String s)    //���s��
    {
        return this.insert(this.n, s);
    }

    //3.  ɾ���Ӵ�
    //ɾ����begin��end-1���Ӵ���0��begin<length()��end��0��begin��end��
    //��end��length()��ɾ������β����beginԽ�磬��begin>end�׳��ַ������Խ���쳣
    public synchronized MyStringBuffer delete(int begin, int end)
    {
        if (begin>=0 && begin<this.n && end>=0 && begin<=end)
        {
            if (end>this.n)                                //end�����ݴ�
                end=this.n;
            for(int i=0; i<this.n-end; i++)                //��end��ʼ����β���Ӵ���ǰ�ƶ�
                this.value[begin+i] = this.value[end+i];
            this.n -= end-begin;
            return this;
        }
        else throw new StringIndexOutOfBoundsException("begin="+begin+"��end="+end+"��end-begin="+(end-begin));
    }
    //����3.3��  StringBuffer���Ĳ��롢ɾ��������
    //@author��Yeheya��2014-9-30    
    
    //��˼����3-3��
    //����begin��end-1���Ӵ��滻Ϊs�������У�Ч�ʽϵ�
    MyStringBuffer replace(int begin, int end, String s)
    {
        this.delete(begin, end);
        this.insert(begin, s);
        return this;
    }    
    
    //��ʵ��3-10��    
//  public MyStringBuffer deleteCharAt(int i)                //ɾ����i���ַ���������ʡ��
    public MyStringBuffer reverse()                        //��this����ת������
    {
        for (int i=0; i<this.n/2; i++)
        {
   	        char temp = value[i];
   	        value[i] = value[this.n-i-1];
            value[this.n-i-1] = temp;
        }
        return this;
    }
}
//@author��Yeheya��2014-10-3        
/*    //��˼����3-3��
//����begin��end-1���Ӵ��滻Ϊs����ÿ�ַ�һ���ƶ���λ��Ч�ʽϸߣ���
MyStringBuffer replace(int begin, int end, String s)
{
    if (begin>=0 && begin<this.n && end>=0 && begin<=end)
    {
        if (end>this.n)                                //end�����ݴ�
            end=this.n;
        for(int i=0; i<this.n-end; i++)                //��end��ʼ����β���Ӵ���ǰ�ƶ�
            this.value[begin+i] = this.value[end+i];

        this.n -= end-begin;
        return this;
    }
    else throw new StringIndexOutOfBoundsException("begin="+begin+"��end="+end+"��end-begin="+(end-begin));

    System.arraycopy(value, end, value, begin + n, n - end);
    s.getChars(value, begin);
    n = newCount;
    return this;

    char temp[]=this.value;
    if (this.value.length-this.n < s.length() - (end - begin))     //����ǰ��������ռ䲻�㣬����������
    {
        this.value = new char[this.value.length+s.length()*2]; //���������ַ�����ռ�
        for (int j=0; j<i; j++)                        //���Ƶ�ǰ��ǰi-1���ַ�
            this.value[j] = temp[j];
    }
    for (int j=this.n-1; j>=i; j--)
        this.value[s.length()+j] = temp[j];          //��i��ʼ����ƶ�n���ַ�
    for (int j=0; j<s.length(); j++)                 //�����ַ���s
        this.value[i+j] = s.charAt(j);
    this.n += s.length();
    return this;
}*/
//@author��Yeheya��2015-1-31        

