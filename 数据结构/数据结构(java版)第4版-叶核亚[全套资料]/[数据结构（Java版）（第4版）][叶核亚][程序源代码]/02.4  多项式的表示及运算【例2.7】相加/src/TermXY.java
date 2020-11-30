//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��15��
//��2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//��2.4.2   ��Ԫ����ʽ�ı�ʾ������

public class TermXY extends TermX                          //��Ԫ����ʽ��һ��
{
    protected int yexp;                                    //yָ��

    public TermXY(int coef, int xexp, int yexp)            //����һ��
    {
        super(coef, xexp);                                 //���츸��һ����ø���ͬ�������췽��
        this.yexp = yexp;
    }

    //���ض�Ԫ����ʽ��һ���Ӧ�ġ�ϵ��x^ָ������ʡ����ʽ�ַ�����ʡ����ʽҪ��ͬTermX�ࡣ���Ǹ���ͬ������
    public String toString()                     
    {
        String str=super.toString();                       //ִ�и���TermXͬ�����������ϵ����xָ��
        if (this.yexp>0)
            str+="y";
        if (this.yexp>1)
            str+="^"+this.yexp;
        return str;
    }   

    //��x��yָ���Ƚϴ�С���ȱȽ�xָ������xָ����ͬ���ٱȽ�yָ�������ظ���ͬ������
    public int compareTo(TermXY term)
    {
        if (this.xexp==term.xexp && this.yexp==term.yexp)  //����ָ����Ӧ���
            return 0;
        return (this.xexp<term.xexp || this.xexp==term.xexp && this.yexp<term.yexp)? -1 : 1;
    }
    
    public boolean equals(Object obj)                      //��ϵ����xָ����yָ���Ƚ���ȣ����Ǹ���ͬ������
    {
        return this==obj || obj instanceof TermXY && super.equals(obj) && this.xexp==((TermXY)obj).yexp; 
    }    

    //ϰ��2
    //�ԡ�ϵ��x^ָ������ʡ����ʽ����һԪ����ʽ��һ�
    public TermXY(String termstr)
    {
        super(termstr);
        if (termstr.charAt(0)=='+')
        	termstr=termstr.substring(1);
    	int i = termstr.indexOf('y');
        if (i==-1)
        {
            this.coef = Integer.parseInt(termstr);
            this.xexp = 0;
        }
        else if (i==0)
             {
                 this.coef = 1;
                 this.xexp = 1;
             }
             else
             {
                 String sub=termstr.substring(0,i);
                 if (sub.equals("-"))
                	 this.coef=-1;
                 else
            	     this.coef = Integer.parseInt(sub);
                 i = termstr.indexOf('^');
                 if (i==-1)
            	     this.xexp=1;
                 else
                     this.xexp = Integer.parseInt(termstr.substring(i+1));
             }
    }

    public TermXY(int coef, int exp)                       //����һ�ָ��Ĭ��ֵ
    {
        this(coef, exp, 0);
    }
    public TermXY(TermXY term)                             //�������췽��
    {
        this(term.coef, term.xexp, term.yexp);
    }
    public TermXY(TermX term, int yexp)                   //����һ��
    {
        this(term.coef, term.xexp, yexp);
    }
    public TermXY(TermX term)                              //����һ��
    {
        this(term.coef, term.xexp, 0);
    }
}
 /*   
    public double value(int x, int y)                       //��һ���ֵ
    {
        return super.value(x)*Math.pow(y, this.yexp);       //Term::value(x)ִ�л��౻���ǵ�ͬ������
    }
}*/