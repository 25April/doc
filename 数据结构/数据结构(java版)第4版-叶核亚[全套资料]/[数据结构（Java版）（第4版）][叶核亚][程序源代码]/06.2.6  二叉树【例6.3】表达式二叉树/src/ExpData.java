//�����ݽṹ��Java�棩����4�棩�������ߣ�Ҷ���ǣ�2014��7��19��
//6.2.6   �������Ķ�������ʵ��
//����6.3�����ʽ��������
//���ʽ��������Ԫ����

public class ExpData                                       //���ʽ��������Ԫ����
{
    int value;                                             //Ԫ��ֵ
    char oper;                                             //���ַ������//�����operator
//    String oper;                                           //�����operator

    public ExpData(int value, char oper)                   //���췽��
    {
        this.value = value;
        this.oper = oper;
    }
    public String toString()                               //���������ַ���
    {
        return this.oper==' ' ? this.value+"" : this.oper+"";
    }
    
    //����ʹ�÷���д��ͨ�õģ��Ƚϻ������ͳ�Ա����ֵ�Ƿ���ȡ�
    public boolean equals(Object obj)            //�Ƚ��������ֵ�Ƿ���ȣ�����Object���equals(obj)����
    {
        if (obj==this)
           return true;
        if (obj instanceof ExpData)
        {
            ExpData exp = (ExpData)obj;
            return this.value==exp.value && this.oper==exp.oper;
        }
        return false;
    }
}
