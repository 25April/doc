//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��10��28��
//10.1 ���Ͽ��
//10.1.4  ӳ��
//��˼����10-2�� �ֱ�ʹ��java.util�е�ɢ��ӳ�����ӳ�䣬ʵ����8.3����8.5��ͳ���ı��и����ʵĳ��ִ�����

import java.util.*;
public class Text_ex 
{
	public static void main(String[] args) 
	{
/*
		//      String text="AAAABBBCDDBBAAA";                     //��6.4����
//      String text="CDAAAABBBDBBAAA";                     //��6.4���ݣ�ɢ�б�û���
        String text="class HashSet";                       //ͼ8.12���ݣ�ͬC++��3�棩
//        String text="public class";                        //��3��ͼ8.12����
        Map<String, Integer> map = Text.charCount(text); //ͳ��text�и��ַ��ĳ��ִ���
        System.out.println("text=\""+text+"\"");
        System.out.println("map="+map.getClass().getName()+map.toString()+"��map.size()="+map.size());            
        System.out.println("map.keySet()="+map.keySet());  //���عؼ��ּ���Set<K>
        System.out.println("map.values()="+map.values());
*/
    
//      String[] words ={"and", "begin", "case", "if", "and","public","class","char","count"};
//      Map<String, Integer> map = Text.wordCount(words);                //ͳ��text�и��ַ��ĳ��ִ���

      String wordtext="public class and begin case if and public class char count public class";
      Map<String, Integer> map = Text.wordCount(wordtext);                //ͳ��text�и��ַ��ĳ��ִ���
      System.out.println("map="+map.getClass().getName()+map.toString()+"��map.size()="+map.size());            
      System.out.println("map.keySet()="+map.keySet());  //���عؼ��ּ���Set<K>
      System.out.println("map.values()="+map.values());
		
	}

}
/*
�������н�����£�
text="CDAAAABBBDBBAAA"
map=java.util.HashMap{A=7, B=5, C=1, D=2}
map.keySet()=[A, B, C, D]
map.values()=[7, 5, 1, 2]

text="class HashSet"
map=java.util.HashMap{ =1, a=2, c=1, s=3, S=1, t=1, e=1, H=1, h=1, l=1}
map.keySet()=[ , a, c, s, S, t, e, H, h, l]
map.values()=[1, 2, 1, 3, 1, 1, 1, 1, 1, 1]


map=java.util.HashMap{public=3, and=2, char=1, count=1, class=3, begin=1, if=1, case=1}��map.size()=8
map.keySet()=[public, and, char, count, class, begin, if, case]
map.values()=[3, 2, 1, 1, 3, 1, 1, 1]

 */
/*
map��{and=2, begin=1, case=1, if=1}
map.keySet()��[and, begin, case, if]
map.values()��[2, 1, 1, 1]

�ؼ�����ͬʱ�滻�����߶�:
map��{A=1}��map.size()=1
map��{A=2}��map.size()=1
map��{A=3}��map.size()=1
map��{A=4}��map.size()=1
map��{A=4, B=1}��map.size()=2
map��{A=4, B=2}��map.size()=2
map��{A=4, B=3}��map.size()=2
map��{A=4, B=3, C=1}��map.size()=3
map��{A=4, B=3, C=1, D=1}��map.size()=4
map��{A=4, B=3, C=1, D=2}��map.size()=4
map��{A=4, B=4, C=1, D=2}��map.size()=4
map��{A=4, B=5, C=1, D=2}��map.size()=4
map��{A=5, B=5, C=1, D=2}��map.size()=4
map��{A=6, B=5, C=1, D=2}��map.size()=4
map��{A=7, B=5, C=1, D=2}��map.size()=4
map��{A=7, B=5, C=1, D=2}
map.keySet()��[A, B, C, D]
map.values()��[7, 5, 1, 2]
map��{and=2, begin=1, case=1, if=1}
map.keySet()��[and, begin, case, if]
map.values()��[2, 1, 1, 1]


java.util.HashMap{D=2, A=7, B=5, C=1}
map.keySet()��[D, A, B, C]
map.values()��[2, 7, 5, 1]
Huffman���Ľ������:(2,4,-1,-1)��(7,6,-1,-1)��(5,5,-1,-1)��(1,4,-1,-1)��(3,5,3,0)��(8,6,4,2)��(15,-1,1,5)��
Huffman���룺 D��101��A��0��B��11��C��100��
��AAAABBBCDDBBAAAѹ��Ϊ00001111111001011011111000��26λ
��00001111111001011011111000����ΪAAAABBBCDDBBAAA


java.util.TreeMap{A=7, B=5, C=1, D=2}
Huffman���Ľ������:(7,6,-1,-1)��(5,5,-1,-1)��(1,4,-1,-1)��(2,4,-1,-1)��(3,5,2,3)��(8,6,4,1)��(15,-1,0,5)��
Huffman���룺 A��0��B��11��C��100��D��101��
��AAAABBBCDDBBAAAѹ��Ϊ00001111111001011011111000��26λ
��00001111111001011011111000����ΪAAAABBBCDDBBAAA


//@author��Yeheya��2014-8-25
/*
�������н�����£�
AAAABBBCDDBBAAA
�ַ�������ִ�����((A,7))
((B,5))
((C,1))
((D,2))

public class
�ַ�������ִ�����((l,2))
((a,1))
((b,1))
((c,2))
((p,1))
((s,2))
(( ,1))
((u,1),(i,1))

public class CharCount
�ַ�������ִ�����((n,1))
((C,2),(o,1))
((p,1))
((r,1))
((s,2))
((t,1))
((u,2))
((a,2))
((b,1),( ,2))
((c,2))
((h,1))
((i,1))
((l,2))


public class HashMap_CharWeight
�ַ�������ִ�����((l,2))
((p,1))
(( ,2))
((r,1),(W,1))
((s,3))
((t,1))
((u,1))
((C,1))
((a,3))
((b,1))
((c,2),(H,1))
((e,1))
((g,1))
((h,3))
((i,2))


 */
//@author��Yeheya��2014-8-15
