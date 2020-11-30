//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��8��14��
//8.3 �ֿ����
//����8.1�� �жϸ����ַ����Ƿ�ΪJava�ؼ��֡�

public class HashSet_KeyWords  
{
    //�ؼ��ֱ�
    private static String[] keywords={"abstract","assert","boolean","break","byte","case","catch",
        "char","class","continue","default","do","double","else","extends","false","final","finally",
        "float","for","if","implements","import","instanceof","int","interface","long","native","new",
        "null","package","private","protected","public","return","short","static","super","switch",
        "synchronized","this","throw","throws","transient","true","try","void","volatile","while"};

    static HashSet<String> hashset;                        //ɢ�б�
    static                                                 //��̬��ʼ��������������
    {
        hashset = new HashSet<String>(keywords);           //����ɢ�б���values�����ṩԪ��
//        System.out.print("ɢ�б�\n"+hashset.toString());        
    	hashset.printAll();
    }

    public static boolean isKeyword(String str)            //�ж�str�Ƿ�ΪJava�ؼ���
    {
       return  hashset.contains(str);
    }
        
    public static void main(String[] args) 
    {                                            //Ĭ�����Ƚ��о�̬��ʼ��������������
    	String[] str={"and","final","length", "while","x"};
        for (int i=0; i<str.length; i++)
           System.out.println(str[i]+(isKeyword(str[i])?"":"��")+"�ǹؼ���");
    }
}

/*
�������н�����£�
ɢ�б�����=65��49��Ԫ�أ�hash(key)=key % 65��HashSet(long,false,transient,class,try,true,native,abstract,new,assert,static,super,do,finally,byte,break,case,null,package,switch,private,synchronized,throws,char,continue,float,throw,short,instanceof,int,if,return,catch,protected,final,for,public,import,else,double,void,volatile,while,boolean,default,implements,interface,this,extends)
table[0]=()
table[1]=()
table[2]=(long)
table[3]=(false)
table[4]=()
table[5]=()
table[6]=()
table[7]=()
table[8]=(transient)
table[9]=(class)
table[10]=()
table[11]=()
table[12]=()
table[13]=()
table[14]=()
table[15]=()
table[16]=(try)
table[17]=()
table[18]=(true)
table[19]=(native)
table[20]=(abstract,new)
table[21]=()
table[22]=()
table[23]=(assert,static)
table[24]=(super)
table[25]=()
table[26]=(do,finally)
table[27]=()
table[28]=()
table[29]=()
table[30]=()
table[31]=(byte)
table[32]=(break,case)
table[33]=(null,package,switch)
table[34]=()
table[35]=()
table[36]=(private,synchronized)
table[37]=(throws)
table[38]=()
table[39]=(char,continue,float,throw)
table[40]=(short)
table[41]=(instanceof,int)
table[42]=(if)
table[43]=()
table[44]=(return)
table[45]=(catch,protected)
table[46]=()
table[47]=(final,for,public)
table[48]=()
table[49]=(import)
table[50]=(else)
table[51]=(double)
table[52]=()
table[53]=()
table[54]=(void)
table[55]=()
table[56]=(volatile)
table[57]=(while)
table[58]=()
table[59]=()
table[60]=(boolean,default,implements,interface,this)
table[61]=()
table[62]=()
table[63]=()
table[64]=(extends)
ASL�ɹ�=(1+1+1+1+1+1+1+1+2+1+2+1+1+2+1+1+2+1+2+3+1+2+1+1+2+3+4+1+1+2+1+1+1+2+1+2+3+1+1+1+1+1+1+1+2+3+4+5+1)/49 =78/49 =1.5918367346938775

and���ǹؼ���
final�ǹؼ���
length���ǹؼ���
while�ǹؼ���
x���ǹؼ���



*/

