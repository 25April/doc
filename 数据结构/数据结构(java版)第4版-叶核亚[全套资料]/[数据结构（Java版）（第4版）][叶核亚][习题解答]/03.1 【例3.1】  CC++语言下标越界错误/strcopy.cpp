//�����ݽṹ��C++�棩����3�棩�� ���ߣ�Ҷ����
//����3.1�� C/C++���Ե�string.h��strcpy()��strcat()���������±�Խ�����

#include <iostream>
using namespace std;
#include <string.h>

int main()
{
    char src[]="abcdefghijlkmn", dest[3]="", *p;
    p = strcpy(dest, src);                            //VC++ 2008���뾯��:��strcpy��������ȫ��
    cout<<"src=\""<<src<<"\", dest=\""<<dest<<"\", p=\""<<p<<"\""<<endl;

    system("pause");
    return 0;
          //֮�������д�
}

/*
�������� ��



*/
