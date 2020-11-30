//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��18�գ�JDK 8.11
//��1.1.3   ���������������������
//��ʵ��1-1��  �����ࡣ

public class Complex
{
    private double real,imag;                              //ʵ�����鲿
//    public double real,imag;
    public Complex(double real, double imag)               //���췽��
    {
        this.real = real;
        this.imag = imag;
    }
    public Complex(double real)                            //���췽������
    {
        this(real,0);
    }
    public Complex()
    {
        this(0,0);
    }
    public Complex(Complex c)                              //�������췽�������ƶ���
    {
        this(c.real,c.imag);                               //c==nullʱ���׳��ն����쳣����ͬ
    }
    
    //��public double real,imag;������4��������ʡ��
    public double getReal()     
    {
        return this.real;
    }
    public void setReal(double real)
    {
        this.real = real;
    }
    public double getImag()
    {
        return this.imag;
    }
    public void setImag(double imag)
    {
        this.imag = imag;
    }
    
    public String toString()                               //������ַ���������
    {                                                      //����Object���toString()����
        return "("+this.real+"+"+this.imag+"i)";
    }
    
    public void add(Complex c)                             //����������ӣ��ı䵱ǰ����
    {
        this.real += c.real;
        this.imag += c.imag;
    }
    
    public static Complex add(Complex c1, Complex c2)      //��������������Ӻ�Ķ������أ���̬����
    {
        return new Complex(c1.real+c2.real, c1.imag+c2.imag);
    }
    
    public void subtract(Complex c)                        //��������������ı䵱ǰ����
    {
        this.real -= c.real;
        this.imag -= c.imag;
    }
    
    public static Complex subtract(Complex c1, Complex c2) //�����������������Ķ������أ���̬����
    {
        return new Complex(c1.real-c2.real, c1.imag-c2.imag);
    }
    
    public boolean equals(Object obj)                      //�Ƚ����������Ƿ����
    {                                                      //����Object���equals(obj)����
        if (this==obj)
            return true;
        if (obj instanceof Complex)
        {
            Complex c=(Complex)obj;
            return this.real==c.real && this.imag==c.imag;
        }
        return false;
    } 
}

class Complex__ex
{
    public static void main(String args[])
    {
        Complex c1 = new Complex(1,2);
        Complex c2 = new Complex(3,5);
        Complex c3 = Complex.add(c1,c2);                   //�����´�������
        System.out.println(c1+" + "+c2+" = "+c3);

        c1.add(c2);
        System.out.println("c1="+c1);
        System.out.println("c1==c3? "+(c1==c3));
        System.out.println("c1.equals(c3)? "+c1.equals(c3));
    } 
}

/*
�������н�����£�
(1.0+2.0i) + (3.0+5.0i) = (4.0+7.0i)
c1=(4.0+7.0i)
c1==c3? false
c1.equals(c3)? true

*/
