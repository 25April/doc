//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��6��25��
//3.2.2   �����ַ�����
    //��˼����3-1��
    //��ʵ��3-1��MyString�����ӳ�Ա����
    //��ϰ����ʵ����3-1�����ȴ�С
//��3.3.1 Brute-Force�㷨
    //��˼����3-4��

//�����ַ����࣬�����࣬ʵ�ֿɱȽϽӿں����л��ӿ�
public final class MyString implements Comparable<MyString>, java.io.Serializable
{
    private final char[] value;                            //�ַ����飬˽�����ձ�����ֻ�ܸ�ֵһ��

    //��1�� �����ַ���
    public MyString()                                      //����մ�""��������Ϊ0
    {
        this.value = new char[0];
    }
    
    public MyString(java.lang.String s)                    //���ַ����������촮
    {
        this.value = new char[s.length()];                 //�����ַ����鲢����s���������ַ�
        for (int i=0; i<this.value.length; i++)
            this.value[i] = s.charAt(i);
    }
    
    //��value�����i��ʼ��n���ַ����촮��i��0��n��0��i+n��value.length��
    //��i��nָ�����Խ�磬�׳��ַ������Խ���쳣��
    public MyString(char[] value, int i, int n)
    {
        if (i>=0 && n>=0 && i+n<=value.length)
        {
            this.value = new char[n];                      //�����ַ����鲢���������ַ�
            for (int j=0; j<n; j++)
                this.value[j] = value[i+j];
//        java.lang.System.arraycopy(value,0,this.value,0,value.length);  //�������飬����for���
//        this.value = java.util.Arrays.copyOf(value,value.length);       //�������飬������������ռ�
        }
        else  throw new StringIndexOutOfBoundsException("i="+i+"��n="+n+"��i+n="+(i+n));
    }
    public MyString(char[] value)                          //���ַ����鹹�촮
    {
        this(value, 0, value.length);
    }
    public MyString(MyString s)                            //�������췽�������
    {
        this(s.value);
    }
    
    public int length()                                    //���ش����ȣ����ַ���������
    {
        return this.value.length;
    }
    public boolean isEmpty() 
    {
        return value.length == 0;
    }
    public java.lang.String toString() 
    {
        return new String(this.value);                     //java.lang.Stringʵ��Ϊ return this;
    }
    
    //���ص�i���ַ���0��i<length()����iԽ�磬�׳��ַ������Խ���쳣
    public char charAt(int i)
    {
        if (i>=0 && i<this.value.length)
            return this.value[i]; 
        throw new StringIndexOutOfBoundsException(i);
    }
    
    //��2�� ���Ӵ�
    //������Ŵ�begin��end-1���Ӵ���0��begin<length()��0��end��length()��begin<end��
    //�����׳��ַ������Խ���쳣
    public MyString substring(int begin, int end)
    {
        if (begin==0 && end==this.value.length) 
            return this;
        return new MyString(this.value, begin, end-begin); //���ַ����鹹�촮������begin��endԽ�罫�׳��쳣
    }
    public MyString substring(int begin)                   //������Ŵ�begin����β���Ӵ�
    {
        return substring(begin, this.value.length);
    }
    
    //��3�� ���Ӵ�
    //����this��s���������ɵĴ�����s==null������"null"
    public MyString concat(MyString s)                   
    {
        if (s==null)  
            s = new MyString("null");
        char[] buffer = new char[this.value.length+s.length()];
        int i;
        for (i=0; i<this.value.length; i++)                //���Ƶ�ǰ��
            buffer[i] = this.value[i];
        for (int j=0; j<s.value.length; j++)               //����ָ����s
            buffer[i+j] = s.value[j];
        return new MyString(buffer);                       //���ַ����鹹�촮����
    }
    
    //��˼����3-1��
    public MyString trim()                                 //����ɾ�����пո����ַ���
    {
        char temp[]=new char[this.value.length];
        int j=0;
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]!=' ')
                temp[j++]=this.value[i];
        return new MyString(temp,0,j);                     //��temp�����д�0��ʼ��j���ַ����촮����
    }
    
    //��4�� �Ƚϴ����
    //��4��̲�ʡ�Է����壬�μ�д
    //�Ƚ�this��obj���õĴ��Ƿ���ȣ�����Object���equals(obj)����
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (obj instanceof MyString)
        {   MyString s=(MyString)obj;
            if (this.value.length == s.value.length)
            {   for (int i=0; i<this.value.length; i++)
                    if (this.value[i]!=s.value[i])
                        return false;
                return true;
            }
        }
        return false;
    }    

    //��5�� �Ƚϴ���С
    //�Ƚ�this��str���Ĵ�С���������߲�ֵ��ʵ��Comparable�ӿ�
    public int compareTo(MyString s)
    {
        for (int i=0; i<this.value.length && i<s.value.length; i++)
            if (this.value[i]!=s.value[i])
                return this.value[i] - s.value[i];       //����������һ����ͬ�ַ��Ĳ�ֵ
        return this.value.length - s.value.length;       //ǰ׺�Ӵ��������������ȵĲ�ֵ
    }
    //@author��Yeheya��2014-10-1    

    //3.3   ����ģʽƥ��
    //3.3.1  Brute-Force�㷨
    //1.  Brute-Force�㷨������ʵ��
    
    //���ص�ǰ����Ŀ�괮�����׸���ģʽ��patternƥ����Ӵ���ţ�ƥ��ʧ��ʱ����-1
    public int indexOf(MyString pattern)
    {
        return this.indexOf(pattern, 0);
    }
    
    //���ص�ǰ����Ŀ�괮����begin��ʼ�׸���ģʽ��patternƥ����Ӵ���ţ���ƥ��ʧ�ܷ���-1��
    //0��begin<this.length()����begin�ݴ���begin<0����0��ʼ����begin���Խ�磬���Ҳ��ɹ���
    //��pattern==null���׳��ն����쳣��
    public int indexOf(MyString pattern, int begin)
    {
        int n=this.length(), m=pattern.length();
        if (begin<0)                                       //��begin�ݴ���begin<0����0��ʼ
            begin = 0;
        if (n==0 || n<m || begin>=n)                       //��Ŀ�괮�ա��϶̻�beginԽ�磬����Ƚ�
            return -1;
        int i=begin, j=0;                                  //i��j�ֱ�ΪĿ�괮��ģʽ����ǰ�ַ��±�
        int count=0;                                       //���رȽϴ���
        while (i<n && j<m)
        {
            count++;
            if (this.charAt(i)==pattern.charAt(j))         //����ǰ���ַ���ȣ�������ȽϺ����ַ�
            {
                System.out.print("t"+i+"=p"+j+"��");
                i++;
                j++;
            }
            else                                           //����i��j���ݣ������´�ƥ��
            {
                System.out.println("t"+i+"!=p"+j+"��");
                i=i-j+1;                                   //Ŀ�괮�±�i���˻ص��¸�ƥ���Ӵ����
                j=0;                                       //ģʽ���±�j���˻ص�0
                if (i>n-m)                                 //��Ŀ�괮ʣ���Ӵ��ĳ���<m�����ٱȽ�
                    break;
            }
        }
        System.out.println("\tBF.count="+count);
        if (j==m)                                          //ƥ��ɹ�
            return i-j;                                    //����ƥ����Ӵ����
        return -1;                                         //ƥ��ʧ��ʱ����-1
    }

    
    //3.3.2   ģʽƥ��Ӧ��
    //��˼����3-4��
    //���ؽ�this��Ŀ�괮�����׸���patternƥ����Ӵ��滻��str���ַ���
    public MyString replaceFirst(MyString pattern, MyString str)
    {
        int i=this.indexOf(pattern,0);                     //����ƥ���Ӵ�����ţ���0��ʼ����  
        if (i==-1)
            return this;                                   //ƥ��ʧ��ʱ���ص�ǰ��
        return this.substring(0,i).concat(str).concat(this.substring(i+pattern.length()));//����3����
    }

    //���ؽ�this��Ŀ�괮����������patternƥ����Ӵ�ȫ���滻��s���ַ���
    public MyString replaceAll(MyString pattern, MyString s)
    {
        MyString temp = new MyString(this);                //�������췽�������Ƶ�ǰ��
        int i=this.indexOf(pattern,0);
        while (i!=-1)
        {
            temp = temp.substring(0,i).concat(s).concat(temp.substring(i+pattern.length()));
            i=temp.indexOf(pattern, i+s.length());      //����һ���ַ���ʼ�ٴβ���ƥ���Ӵ�
//            i=temp.indexOf(pattern, i+1);                  	//��˼����3-4��ʵ����3-13���Ĵ�
        }
        return temp;
    } 
    //@author��Yeheya��2014-10-4
   
    
    //�����ݽṹ��Java�棩����4�棩����⡷�����ߣ�Ҷ���ǣ�2015��2��5�գ�JDK 8.25
    //���¡�ʵ��3-1��MyString�����ӳ�Ա����
    public int indexOf(char ch)                            //����ch�ַ���this�����״γ��ֵ����
    {
        return indexOf(ch,0);
    }    
    public int indexOf(char ch, int begin)                 //����ch��begin��ʼ�״γ��ֵ����
    {
        if (begin<0)                                       //����ݴ�
            begin = 0;
        for (int i=begin; i<this.value.length; i++)
            if (this.value[i]==ch)
                return i;
        return -1;
    }    
    
    public MyString toLowerCase()                          //�����еĴ�д��ĸȫ��ת���ɶ�Ӧ��Сд��ĸ
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='A' && this.value[i]<='Z')  //��д��ĸ
                temp[i]=(char)(this.value[i]+'a'-'A');     //ת���ɶ�ӦСд��ĸ
        return new MyString(temp);
    }
    
    public MyString toUpperCase()                          //�����е�Сд��ĸȫ��ת���ɶ�Ӧ�Ĵ�д��ĸ
    {
        char temp[]=new char[this.value.length];
        for (int i=0; i<this.value.length; i++)
            if (this.value[i]>='a' && this.value[i]<='z')  //Сд��ĸ
                temp[i]=(char)(this.value[i]-('a'-'A'));   //ת���ɶ�Ӧ��д��ĸ
        return new MyString(temp); 
    }    
    
    public char[] toCharArray()                            //�����ַ�����
    {
        char[] temp = new char[this.value.length];
        for (int i=0; i<temp.length; i++)                  //��������
        	temp[i] = this.value[i];
        return temp;
    }
    
    public boolean startsWith(MyString prefix)             //�ж�prefix�Ƿ�ǰ׺�Ӵ�
    {
/*        if (this.value.length<prefix.value.length)
            return false;
        for (int i=0; i<prefix.value.length; i++)
            if (this.value[i]!=prefix.value[i])
                return false;
        return true;*/
        return this.indexOf(prefix)==0;//??û��
    }
    public boolean endsWith(MyString suffix)               //�ж�suffix�Ƿ��׺�Ӵ�
    {
/*        int j=suffix.value.length-1;
        for (int i=this.value.length-1; i>=0 && j>=0; i--,j--)
            if (this.value[i]!=suffix.value[j])
                return false;
        return j==-1;*/
        return this.indexOf(suffix)==this.length()-suffix.length();//??û��
    }
    
    public boolean equalsIgnoreCase(MyString str)          //�Ƚ�this����str���Ƿ���ȣ�������ĸ��Сд
    {
        if (this==str)
            return true;
        if (this.value.length==str.value.length)
        {
            for (int i=0; i<this.value.length; i++)
            {
                int c1=this.value[i];
                if (c1>='a' && c1<='z') 
                    c1 -= 'a'-'A';
                int c2=str.value[i];
                if (c2>='a' && c2<='z') 
                    c2 -= 'a'-'A';
                if (c1!=c2)                          
                return false;
            }
            return true;
        }
        return false;
    }    
    
    //��ϰ����ʵ����3-1��
    public int compareToIgnoreCase(MyString str)           //�Ƚ���������С��������ĸ��Сд
    {
        for (int i=0; i<this.value.length && i<str.value.length; i++)
        {
            int c1=this.value[i], c2=str.value[i];
            if (c1>='a' && c1<='z') 
                c1 -= 'a'-'A';
            if (c2>='a' && c2<='z') 
                c2 -= 'a'-'A';
            if (c1!=c2)
                return this.value[i]-str.value[i];
        }
        return this.value.length-str.value.length;
    }
}

    //����
    /*    public String(StringBuffer buffer) {
            synchronized(buffer) {
                this.value = Arrays.copyOf(buffer.getValue(), buffer.length());
            }
      */  

/*
ϰ��3 δ���
public MyString replace(char old, char newc)      	//����������old�ַ��滻Ϊnewc�ַ�
public int lastIndexOf(char ch)                   	//����ch��this���������ֵ����
public int lastIndexOf(char ch, int begin)           	//����ch��begin��ʼ�����ֵ����
public int lastIndexOf(String pattern)             	//����pattern���ƥ��λ�õ����
public int lastIndexOf(String pattern, int begin)
              //����ģʽ��pattern��this���д�begin��ʼ���������һ��ƥ��λ�õ����
 * */


//@author��Yeheya��2015-2-5
