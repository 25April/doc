//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��9��15��
//��2.4   ���Ա��Ӧ�ã�����ʽ�ı�ʾ������
//��2.4.1   һԪ����ʽ�ı�ʾ������
//����2.7�� һԪ����ʽ�༰��ӷ����㡣

public class Polynomial_ex 
{
    public static void main(String args[])
    {
        System.out.println("//һԪ����ʽ");
        TermX aterms[]={new TermX(-7,9), new TermX(2,7), new TermX(-9,4), new TermX(1,2),
                       new TermX(-1,1), new TermX(2,0)};   //ͼ2.25A(x)����Ҫ����������
                                       //����, new TermXY(2,0,9)};
        Polynomial apoly = new Polynomial(aterms);
//        Polynomial apoly = new Polynomial("+2-x+x^2-9x^4+2x^7-7x^9");

        TermX bterms[]={new TermX(9,11), new TermX(5,10), new TermX(-3,8), new TermX(10,4),
                       new TermX(-1,2), new TermX(1,1), new TermX(-1,0)};
//        Polynomial bpoly = new Polynomial(bterms);
//        Polynomial bpoly = new Polynomial("x","2+x-x^2+4x^5");
        Polynomial bpoly = new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");//ͼ2.25B(x)
        System.out.println("A="+apoly.toString()+"\nB="+bpoly.toString());
        
        Polynomial cpoly = apoly.union(bpoly);
        System.out.println("C=A+B��C="+cpoly.toString());
        
/*        //
        apoly.add(bpoly);
        System.out.println("A+=B��A="+apoly.toString());
        System.out.println("C==A��  "+cpoly.equals(apoly));
*/        
        System.out.println("\n//��Ԫ����ʽ");
        TermXY dterms[]={new TermXY(-7,9,3), new TermXY(2,8,3), new TermXY(-9,4,1), 
                         new TermXY(1,2,2), new TermXY(-1,1,1), new TermXY(2,0,0)};        //��Ҫ����������
        Polynomial dpoly = new Polynomial(dterms);
        System.out.println("D="+dpoly.toString());

        TermXY eterms[]={new TermXY(9,11,8), new TermXY(5,10,7), new TermXY(-3,7,6), 
 		                 new TermXY(10,4,5), new TermXY(-1,2,4), new TermXY(1,1,1), new TermXY(-1,0,0)};
        Polynomial epoly = new Polynomial(eterms);
        System.out.println("E="+epoly.toString());
        
        Polynomial fpoly = dpoly.union(epoly);
        System.out.println("F=D+E: "+fpoly.toString());
        dpoly.addAll(epoly);
        System.out.println("D+=E: "+dpoly.toString());
        System.out.println("F==D��  "+fpoly.equals(dpoly));
        
        //ϰ��2
    }
}

/*
�������н�����£�ʡ��ĳЩϵ����ָ������
//һԪ����ʽ
A=+2-x+x^2-9x^4+2x^7-7x^9
B=-1+x-x^2+10x^4-3x^8+5x^10+9x^11
C=A+B��C=+1+x^4+2x^7-3x^8-7x^9+5x^10+9x^11
A+=B��A=+1+x^4+2x^7-3x^8-7x^9+5x^10+9x^11
C==A��  true


//��Ԫ����ʽ
D= +2-xy+x^2y^2-9x^4y+2x^8y^3-7x^9y^3
E= -1+xy-x^2y^4+10x^4y^5-3x^7y^6+5x^10y^7+9x^11y^8
F=D+E: +1+x^4-3x^7y^6+2x^8-7x^9+5x^10y^7+9x^11y^8
D+=E: +1+x^4y-3x^7y^6+2x^8y^3-7x^9y^3+5x^10y^7+9x^11y^8
F==D��  true


���ڸ��������������ʵ�����⣺
//һԪ����ʽ�� //new TermXY(2,0,9),
A: +2y^9-x+x^2-9x^4+2x^7-7x^9
B: -1+x-x^2+10x^4-3x^8+5x^10+9x^11
C=A+B: +1+x^4+2x^7-3x^8-7x^9+5x^10+9x^11
A+=B:  +1y^9+x^4+2x^7-3x^8-7x^9+5x^10+9x^11
C==A��  true
*/

/*
        System.out.println("//һԪ����ʽ");
        TermX aterms[]={new TermX(-7,9), new TermX(2,7), new TermX(-9,4), new TermX(1,2),
                       new TermX(-1,1), new TermXY(2,0,9)};                  //new TermXY(2,0,9), ��Ҫ����������
//      Polynomial apoly = new Polynomial(aterms);
        Polynomial apoly = new Polynomial("+2-x+x^2-9x^4+2x^7-7x^9");
        System.out.println("A: "+apoly.toString());//+"��x="+x+"��A="+apol.value(x));

        TermX bterms[]={new TermX(9,11), new TermX(5,10), new TermX(-3,8), new TermX(10,4),
                       new TermX(-1,2), new TermX(1,1), new TermX(-1,0)};
//        Polynomial bpoly = new Polynomial(bterms);
//        Polynomial bpoly = new Polynomial("x","2+x-x^2+4x^5");
      Polynomial bpoly = new Polynomial("-1+x-x^2+10x^4-3x^8+5x^10+9x^11");
//        int x=1;
        System.out.println("B: "+bpoly.toString());//+"��x="+x+"��B="+bpol.value(x));
        Polynomial cpoly = apoly.plus(bpoly);
        System.out.println("C=A+B: "+cpoly.toString());
        apoly.add(bpoly);
        System.out.println("A+=B:  "+apoly.toString());//+"��x="+x+"��A+B="+apol.value(x));
        System.out.println("C==A��  "+cpoly.equals(apoly));
*/