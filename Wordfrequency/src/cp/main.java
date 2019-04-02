package cp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main {
	public static ArrayList<Word> sum=new ArrayList<Word>();
	public static ArrayList<Word> sum1=new ArrayList<Word>();
//	HashMap<String,int> sum=new HashMap<String, int>();
	static int sumnud=0;
	static int sumnu=0;
	static int pxb=0;
	public static void main(String args[])
	{
		System.out.println("�������ļ���");
		Scanner sc=new Scanner(System.in);
		String FileName;
		String word;
		
		String []words;
		
		FileName=sc.nextLine();
		System.out.println("���ڴ������ݣ����Եȣ�");
		File file=new File(FileName);
		try {
			if(file.exists()) {
			file.createNewFile();
			}
			Scanner fl=new Scanner(file);
			while(fl.hasNext())
			{	
				word=fl.nextLine();
				words=word.split("\"|,|!|\\?|��|��|\\.|��|`|\\(|\\)|-|��|��|��|&|\\'|:|;|\n|\\,| ");
				for(int i=0;i<words.length;i++)
				{
					add(words[i]);
					sumnu++;
				}
			}
			fl.close();
//			for(Word s : sum )
//			{
//				System.out.println(s.getWord()+":"+s.getNumber());
//				System.out.println(s.getNumber());
//			}
//			ps();
			System.out.println("��ͬ�Ĵ��ܼ�"+sumnud+"��");
			System.out.println("���ܼƹ��У������������ţ�"+sumnu+"��");
			px();
			System.out.println("���ݴ������");
//			int x=sc.nextInt();
//			pxs(x);
		}catch (IOException e) {
			// TODO Auto-generated catch block
//			System.out.println("sss");
			e.printStackTrace();
		}
		int r=0;
		while(true)
		{
			System.out.println("-------------------------");
			System.out.println("1��ָ�����ʴ�Ƶͳ�ƹ���");
			System.out.println("2����Ƶ��ͳ�ƹ���");
			System.out.println("3��������result.txt");
			System.out.println("4���˳�");
			System.out.println("------------------------");
			r=sc.nextInt();
			if(r==4)break;
			xz(r);
		}
		System.out.println("�����������");
		
		
	}

	public static void xz(int r)
	{
		switch(r)
		{
		case 1:
			sr();
			break;
		case 2:
			pxs();
			break;
		case 3:
			ps();
			break;
		default:
			System.out.println("������������������");
		}
	}
	public static void add(String word) 
	{
		if(word.length()!=0) {
			int i=0;
			for(Word s : sum )
			{
				if(s.getWord().equals(word))
				{
					i=1;
					s.setNumber();
				}
			}
			if(i==0)
			{
				Word w=new Word(word);
				sum.add(w);
				sum1.add(w);
				sumnud++;
			}
		}else sumnu--;
	}
	
	
	public static void ps()
	{
		Collections.sort(sum, new  SortByWord());
		File file=new File("result.txt");
		try {
			if(file.exists()) {
				file.createNewFile();
				}
			FileWriter fop = new FileWriter(file.getAbsoluteFile());
			for(Word s : sum )
			{
				fop.write(s.getWord()+":"+s.getNumber()+"\n");
			}
			fop.close();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("д�����");
	}
	public static void px()
	{
		if(pxb==0)
		{
			Collections.sort(sum1, new SortByNumber());
			pxb=1;
		}
	}
	public static void pxs()
	{
		System.out.println("������Ҫ�鿴�ĵ�����");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		
		for(Word s : sum1)
		{
			System.out.println(s.getWord()+":"+s.getNumber());
			x--;
			if(x==0)break;
		}
	}
	
	public static void sc(String e,int max)
	{
		double num=0;
		int bz=0;
		if(e.length()!=0)
		{
			for(Word s : sum1)
			{
				if(s.getWord().equals(e))
				{
					System.out.printf("%-12s-%,5d|",e,s.getNumber());
					num=(double)(s.getNumber())/max*80;
					for(int i=0;i<num;i++)
						System.out.print("*");
					System.out.println();
					bz=1;
				}
			}
			if(bz==0)System.out.printf("%-12s-%,5d|����δ�ҵ�\n",e,0);
		}
	}
	
	public static int GetMax(String []num)
	{
		int max=0;
		for(int i=0;i<num.length;i++)
		{
			for(Word s : sum1)
			{
				if(s.getWord().equals(num[i]))
				{
					if(s.getNumber()>max)
						max=s.getNumber();
				}
			}
		}
		return max;
	}
	
	public static void sr()
	{
		String []md;
		int max=0;
		Scanner sz=new Scanner(System.in);
		System.out.println("������Ҫͳ�Ƶĵ����Կո���Ϊ�ָ���");
		String z=sz.nextLine();
		md=z.split(" |  ");
		max=GetMax(md);
		for(int i=0;i<md.length;i++)
		{
			sc(md[i],max);
		}
	}
}


class SortByWord implements Comparator {
    public int compare(Object o1, Object o2) {
     Word s1 = (Word) o1;
     Word s2 = (Word) o2;
     return s1.getWord().compareTo(s2.getWord());
    }
}

class SortByNumber implements Comparator {
    public int compare(Object o1, Object o2) {
     Word s1 = (Word) o1;
     Word s2 = (Word) o2;
     if(s1.getNumber() == s2.getNumber())
    	 return 0;
     if(s1.getNumber() > s2.getNumber()) 
    	 return -1;
     return 1;
    }
}
